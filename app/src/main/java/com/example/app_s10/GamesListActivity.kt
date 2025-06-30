package com.example.app_s10

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_s10.databinding.ActivityGamesListBinding
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class GamesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesListBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var gamesAdapter: GameAdapter
    private val gamesList = mutableListOf<Game>()
    private val filteredGamesList = mutableListOf<Game>()
    private val allGenres = mutableSetOf<String>()
    private var selectedGenres = mutableSetOf<String>()
    private var minRatingFilter: Float? = null
    private var maxRatingFilter: Float? = null
    private var currentSearchQuery = ""
    private var isInitialLoad = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        setupRecyclerView()
        setupButtons()
        setupSearchBar()
        setupRatingFilters()
        loadGames()
    }

    private fun setupRecyclerView() {
        gamesAdapter = GameAdapter(filteredGamesList) { game ->
            showContextMenu(game)
        }
        binding.rvGames.apply {
            layoutManager = LinearLayoutManager(this@GamesListActivity)
            adapter = gamesAdapter
        }
    }

    private fun setupButtons() {
        binding.fabAddGame.setOnClickListener {
            startActivity(Intent(this, AddGameActivity::class.java))
        }

        binding.btnAddFirstGame.setOnClickListener {
            startActivity(Intent(this, AddGameActivity::class.java))
        }

        binding.btnClearRatingFilters.setOnClickListener {
            clearRatingFilters()
        }
    }

    private fun setupSearchBar() {
        val searchView = binding.searchBar
        searchView.isIconified = false

        // Estilización
        val searchPlate = searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)
        searchPlate?.setBackgroundColor(Color.TRANSPARENT)

        val searchIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        searchIcon?.setColorFilter(ContextCompat.getColor(this, R.color.gaming_neon_green))

        val closeIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        closeIcon?.setColorFilter(ContextCompat.getColor(this, R.color.gaming_neon_green))

        val searchText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchText?.setTextColor(ContextCompat.getColor(this, R.color.gaming_text_primary))
        searchText?.setHintTextColor(ContextCompat.getColor(this, R.color.gaming_text_secondary))

        // Listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false

            override fun onQueryTextChange(newText: String?): Boolean {
                currentSearchQuery = newText?.trim()?.lowercase() ?: ""
                filterGames()
                return true
            }
        })
    }

    private fun setupRatingFilters() {
        val minRatingTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                minRatingFilter = s?.toString()?.toFloatOrNull()?.coerceIn(0f, 5f)
                updateRatingRangeHint()
                filterGames()
            }
        }

        val maxRatingTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                maxRatingFilter = s?.toString()?.toFloatOrNull()?.coerceIn(0f, 5f)
                updateRatingRangeHint()
                filterGames()
            }
        }

        binding.etMinRating.addTextChangedListener(minRatingTextWatcher)
        binding.etMaxRating.addTextChangedListener(maxRatingTextWatcher)
    }

    private fun updateRatingRangeHint() {
        val min = minRatingFilter ?: 0f
        val max = maxRatingFilter ?: 5f
        binding.tvRatingRangeHint.text = "Rango: ${"%.1f".format(min)} - ${"%.1f".format(max)}"
    }

    private fun clearRatingFilters() {
        binding.etMinRating.text?.clear()
        binding.etMaxRating.text?.clear()
        minRatingFilter = null
        maxRatingFilter = null
        updateRatingRangeHint()
        filterGames()
    }

    private fun showContextMenu(game: Game) {
        AlertDialog.Builder(this)
            .setTitle(game.title)
            .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                when (which) {
                    0 -> editGame(game)
                    1 -> deleteGame(game)
                }
            }
            .show()
    }

    private fun editGame(game: Game) {
        Intent(this, AddGameActivity::class.java).apply {
            putExtra("EDIT_MODE", true)
            putExtra("GAME_ID", game.id)
            putExtra("GAME_TITLE", game.title)
            putExtra("GAME_GENRE", game.genre)
            putExtra("GAME_RATING", game.rating)
            putExtra("GAME_PLATFORM", game.platform)
            putExtra("GAME_DESCRIPTION", game.description)
            putExtra("GAME_RELEASE_YEAR", game.releaseYear)
            putExtra("GAME_COMPLETED", game.completed)
            startActivity(this)
        }
    }

    private fun deleteGame(game: Game) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar juego")
            .setMessage("¿Estás seguro de eliminar ${game.title}?")
            .setPositiveButton("Eliminar") { _, _ ->
                performDelete(game)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun performDelete(game: Game) {
        val userId = auth.currentUser?.uid ?: return
        database.child("games").child(userId).child(game.id).removeValue()
            .addOnSuccessListener {
                Snackbar.make(binding.root, "${game.title} eliminado", Snackbar.LENGTH_LONG).show()
            }
            .addOnFailureListener {
                Snackbar.make(binding.root, "Error al eliminar", Snackbar.LENGTH_LONG).show()
            }
    }

    private fun loadGames() {
        val userId = auth.currentUser?.uid ?: return

        binding.progressBar.visibility = View.VISIBLE

        database.child("games").child(userId)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    gamesList.clear()
                    allGenres.clear()

                    for (gameSnapshot in snapshot.children) {
                        val game = gameSnapshot.getValue(Game::class.java)
                        game?.let {
                            gamesList.add(it)
                            allGenres.add(it.genre)
                        }
                    }

                    updateGenreChips()
                    filterGames()

                    if (isInitialLoad) {
                        showRatingStats()
                        isInitialLoad = false
                    }

                    binding.progressBar.visibility = View.GONE
                    updateEmptyState()
                }

                override fun onCancelled(error: DatabaseError) {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, "Error al cargar juegos: ${error.message}", Snackbar.LENGTH_LONG).show()
                }
            })
    }

    private fun showRatingStats() {
        if (gamesList.isNotEmpty()) {
            val averageRating = gamesList.map { it.rating }.average()
            val maxRating = gamesList.maxByOrNull { it.rating }?.rating ?: 0f
            val minRating = gamesList.minByOrNull { it.rating }?.rating ?: 0f

            Snackbar.make(binding.root,
                "Rating promedio: ${"%.1f".format(averageRating)} (Min: $minRating, Max: $maxRating)",
                Snackbar.LENGTH_LONG).show()
        }
    }

    private fun updateGenreChips() {
        binding.chipGroup.removeAllViews()

        // Chip "Todos"
        val allChip = Chip(this).apply {
            text = "Todos"
            isCheckable = true
            isChecked = selectedGenres.isEmpty()
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedGenres.clear()
                    filterGames()
                }
            }
        }
        binding.chipGroup.addView(allChip)

        // Chips por género
        allGenres.sorted().forEach { genre ->
            val chip = Chip(this).apply {
                text = genre
                isCheckable = true
                isChecked = selectedGenres.contains(genre)
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        selectedGenres.add(genre)
                        allChip.isChecked = false
                    } else {
                        selectedGenres.remove(genre)
                        if (selectedGenres.isEmpty()) allChip.isChecked = true
                    }
                    filterGames()
                }
            }
            binding.chipGroup.addView(chip)
        }

        // Chip para limpiar filtros de rating
        val clearRatingChip = Chip(this).apply {
            text = "Limpiar rating"
            isCheckable = false
            setOnClickListener { clearRatingFilters() }
        }
        binding.chipGroup.addView(clearRatingChip)
    }

    private fun filterGames() {
        filteredGamesList.clear()

        val filtered = gamesList.filter { game ->
            // Filtro por búsqueda
            val matchesSearch = currentSearchQuery.isEmpty() ||
                    game.title.lowercase().contains(currentSearchQuery) ||
                    game.genre.lowercase().contains(currentSearchQuery)

            // Filtro por género
            val matchesGenre = selectedGenres.isEmpty() || selectedGenres.contains(game.genre)

            // Filtro por rating
            val matchesRating = when {
                minRatingFilter != null && maxRatingFilter != null ->
                    game.rating in minRatingFilter!!..maxRatingFilter!!
                minRatingFilter != null -> game.rating >= minRatingFilter!!
                maxRatingFilter != null -> game.rating <= maxRatingFilter!!
                else -> true
            }

            matchesSearch && matchesGenre && matchesRating
        }

        filteredGamesList.addAll(filtered.sortedBy { it.title })
        gamesAdapter.notifyDataSetChanged()
        updateEmptyState()
    }

    private fun updateEmptyState() {
        if (filteredGamesList.isEmpty()) {
            binding.rvGames.visibility = View.GONE
            binding.emptyState.visibility = View.VISIBLE

            val message = when {
                currentSearchQuery.isNotEmpty() -> "No se encontraron juegos para '$currentSearchQuery'"
                selectedGenres.isNotEmpty() -> "No hay juegos en los géneros seleccionados"
                minRatingFilter != null || maxRatingFilter != null -> "No hay juegos en el rango de rating"
                else -> "No hay juegos registrados"
            }

            binding.tvEmptyStateMessage.text = message
            binding.btnAddFirstGame.visibility = if (gamesList.isEmpty()) View.VISIBLE else View.GONE
        } else {
            binding.rvGames.visibility = View.VISIBLE
            binding.emptyState.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.games_list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.action_refresh -> {
                loadGames()
                true
            }
            R.id.action_stats -> {
                showRatingStats()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}