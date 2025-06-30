package com.example.app_s10

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddGameActivity : AppCompatActivity() {

    private var isEditMode = false
    private var gameId: String? = null

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        // Configurar el Toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        // Inicializar Firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        isEditMode = intent.getBooleanExtra("EDIT_MODE", false)
        if (isEditMode) {
            supportActionBar?.title = "Editar Juego"
            gameId = intent.getStringExtra("GAME_ID")
            findViewById<TextInputEditText>(R.id.etGameTitle).setText(intent.getStringExtra("GAME_TITLE"))
            findViewById<TextInputEditText>(R.id.etGameGenre).setText(intent.getStringExtra("GAME_GENRE"))
            findViewById<RatingBar>(R.id.ratingBar).rating = intent.getFloatExtra("GAME_RATING", 0f)
        }

        setupViews()
    }

    private fun setupViews() {
        val etTitle = findViewById<TextInputEditText>(R.id.etGameTitle)
        val etGenre = findViewById<TextInputEditText>(R.id.etGameGenre)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val btnSave = findViewById<Button>(R.id.btnSaveGame)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val genre = etGenre.text.toString().trim()
            val rating = ratingBar.rating

            if (validateInput(title, genre)) {
                saveGame(title, genre, rating)
            }
        }
    }

    private fun validateInput(title: String, genre: String): Boolean {
        if (title.isEmpty()) {
            showError("El título es obligatorio")
            return false
        }
        if (genre.isEmpty()) {
            showError("El género es obligatorio")
            return false
        }
        return true
    }

    private fun saveGame(title: String, genre: String, rating: Float) {
        val userId = auth.currentUser?.uid ?: return
        val gameRef = if (isEditMode) {
            database.child("games").child(userId).child(gameId!!)
        } else {
            database.child("games").child(userId).push()
        }

        val game = Game(
            id = gameRef.key ?: return,
            title = title,
            genre = genre,
            rating = rating,
            userId = userId
        )

        gameRef.setValue(game)
            .addOnSuccessListener {
                val message = if (isEditMode) "¡Juego actualizado!" else "¡Juego guardado!"
                showSuccess(message)
                finish()
            }
            .addOnFailureListener { exception ->
                showError("Error: ${exception.message}")
            }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}