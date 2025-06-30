<p align="center"><a href="https://www.uns.edu.pe" target="_blank"><img src="https://upload.wikimedia.org/wikipedia/commons/1/1a/Universidad_Nacional_del_Santa_Logo.png" width="250" alt="UNS Logo"></a></p>

<p align="center">
  <a href="https://www.android.com" target="_blank"><img src="https://img.shields.io/badge/Android-3BBC84?style=for-the-badge&logo=android&logoColor=white" alt="Android"></a>
  <a href="https://kotlinlang.org" target="_blank"><img src="https://img.shields.io/badge/Kotlin-7F52DD?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin"></a>
  <a href="https://firebase.google.com" target="_blank"><img src="https://img.shields.io/badge/Firebase-f55425?style=for-the-badge&logo=firebase&logoColor=white" alt="Firebase"></a>
</p>

# 🎮 GameVault - Firebase Authentication Android

Una aplicación Android moderna con **Firebase Authentication** y tema gaming completo.

## 🗂️ Consigna

[https://github.com/GxJohan/app_zone_app](https://github.com/GxJohan/app_zone_app/blob/main/README.md)

## 🔀 Rama original

[https://github.com/josevasquezramos/app_zone_app/tree/tarea-feature](https://github.com/josevasquezramos/app_zone_app/tree/tarea-feature)

## 📝 Desarrollo de la actividad

### Autenticación completa

La aplicación incluye un sistema completo de autenticación con Firebase. Los usuarios pueden registrarse con su correo y contraseña, recibiendo un email de verificación para activar su cuenta. También hay opción de entrar como invitado sin registro. El login valida los datos y muestra mensajes claros si hay errores, como contraseña incorrecta o correo no registrado. Al cerrar sesión, se eliminan los datos temporales y se redirige al login.

<img src="https://github.com/user-attachments/assets/f3d62d0b-6682-46f3-87c1-1d8b56d96cc9" width="250" alt="Captura 1" />
<img src="https://github.com/user-attachments/assets/6ccc1189-42ca-4c52-9d57-cef435cef3c9" width="250" alt="Captura 2" />
<img src="https://github.com/user-attachments/assets/c7744545-b629-4e09-892d-eda94823d667" width="250" alt="Captura 3" />
<img src="https://github.com/user-attachments/assets/0eba4591-7096-4771-8642-6ad7be159fd2" width="250" alt="Captura 4" />
<img src="https://github.com/user-attachments/assets/fc73f511-e5d5-4059-90ba-7830d5a8ec25" width="250" alt="Captura 5" />
<img src="https://github.com/user-attachments/assets/6d4253d2-89db-4479-a176-a45f36ddd6a3" width="250" alt="Captura 6" />
<img src="https://github.com/user-attachments/assets/a449e3a6-4c24-4350-bba9-ebfcafb6cd36" width="250" alt="Captura 7" />
<img src="https://github.com/user-attachments/assets/e33b81c2-e6cc-41c1-aa29-c0eb5f446512" width="250" alt="Captura 8" />

### Gestión de juegos

Sistema CRUD completo para administrar una colección personal de videojuegos:

#### Listado y registro

Permite administrar una lista personal de videojuegos. Los usuarios pueden agregar nuevos juegos ingresando título, género y calificación. La lista se actualiza automáticamente y muestra los juegos en tarjetas con diseño atractivo.

<img src="https://github.com/user-attachments/assets/35dc6c35-3679-4bc5-8757-4e3e3501e17f" width="250" alt="Captura 9" />
<img src="https://github.com/user-attachments/assets/1a600480-a766-44fc-b439-c542ecaf253f" width="250" alt="Captura 10" />

#### Búsqueda y Filtros

Hay opciones para buscar por nombre y filtrar por género o rating.

<img src="https://github.com/user-attachments/assets/a562c94d-ef8f-4230-821a-f2cd03f08228" width="250" alt="Captura 11" />
<img src="https://github.com/user-attachments/assets/0b494f4d-4d26-4fac-a365-fd6776c054aa" width="250" alt="Captura 12" />
<img src="https://github.com/user-attachments/assets/7109fd31-5be7-40ab-a82e-30b122adc52c" width="250" alt="Captura 13" />

#### Edición

Para modificar un juego, basta con mantener presionado el item en la lista y seleccionar "Editar". Se abre un formulario con los datos actuales que se pueden modificar.

<img src="https://github.com/user-attachments/assets/3bab1437-44c5-4563-ad17-ceefb3629b73" width="250" alt="Captura 14" />
<img src="https://github.com/user-attachments/assets/79d69cce-f6cc-4c1a-b908-b4417e140bf6" width="250" alt="Captura 15" />
<img src="https://github.com/user-attachments/assets/e6c13e23-406d-4ba6-a65c-717945e7f157" width="250" alt="Captura 16" />

#### Eliminación

Para borrar, se usa el mismo menú contextual, pero el sistema pide confirmación para evitar eliminaciones accidentales. Solo el dueño del juego puede editarlo o borrarlo.

<img src="https://github.com/user-attachments/assets/4110075a-a2d8-458a-801c-a56706319851" width="250" alt="Captura 17" />
<img src="https://github.com/user-attachments/assets/86b7fb97-0d10-4779-bc56-025db3572233" width="250" alt="Captura 18" />

### Recuperación de cuenta

Si un usuario olvida su contraseña, puede solicitar un restablecimiento ingresando su correo registrado. Recibirá un enlace seguro para crear una nueva contraseña. El sistema valida que cumpla los requisitos mínimos y, al confirmar, lo redirige al login para que ingrese con sus nuevas credenciales.

<img src="https://github.com/user-attachments/assets/0803b3e9-c12a-4578-9d1e-abe1413ef685" width="250" alt="Captura 19" />
<img src="https://github.com/user-attachments/assets/6738906c-70aa-4135-93e4-84562df34f76" width="250" alt="Captura 20" />
<img src="https://github.com/user-attachments/assets/56cef51a-2e48-4a4c-8ae5-af5d0a588962" width="250" alt="Captura 21" />
<img src="https://github.com/user-attachments/assets/97f737e4-7403-4c62-9457-86adad7d789e" width="250" alt="Captura 22" />
<img src="https://github.com/user-attachments/assets/ca574657-09da-422c-9d98-375825d5d051" width="250" alt="Captura 23" />

### Estadísticas básicas

La app muestra un resumen sencillo de la colección, incluyendo el rating promedio y la mejor y peor calificado. Estos datos aparecen en un mensaje emergente (toast) y se actualizan automáticamente al agregar o modificar juegos.

<img src="https://github.com/user-attachments/assets/9aafeb70-478e-4004-9cd3-4fa02dc6857b" width="250" alt="Captura 24" />
<img src="https://github.com/user-attachments/assets/624765b7-4165-47ff-a468-3c283a4d7bb2" width="250" alt="Captura 25" />

## 📱 Características

### 🔐 **Autenticación Completa**
- ✅ Login/Registro con email y contraseña
- ✅ Login anónimo (modo invitado)
- ✅ Recuperación de contraseña
- ✅ Verificación de email
- ✅ Validaciones y manejo de errores
- ✅ Logout seguro

### 🎮 **Gestión de Juegos (Firebase Realtime Database)**
- 🎲 Registro de juegos con detalles (título, género, rating)
- 📜 Lista en tiempo real con RecyclerView y sincronización automática
- ✏️ Edición de juegos (solo para el usuario creador)
- 🗑️ Eliminación de juegos (solo para el usuario creador)
- 🔍 Filtros avanzados (por género, rating)
- 🔥 Reglas de seguridad (privacidad: cada usuario solo ve/edita sus juegos)
- 📱 Formularios validados con feedback claro
- 📊 Estadísticas básicas

### 🎨 **Tema Gaming**
- 🌈 Paleta de colores neón (púrpura, cyan, verde)
- 🎮 Iconos gaming personalizados
- 🌙 Modo oscuro con gradientes
- ✨ Efectos visuales atractivos
- 🎯 Interfaz completamente en español

### 🏗️ **Arquitectura**
- 📱 Material Design 3
- 🏛️ MVVM pattern ready
- 🔧 Kotlin moderno
- 💻 Firebase SDK actualizado

## 🚀 Instalación y Configuración

### 1️⃣ **Clonar el Proyecto**

```bash
# 1. Clonar el repositorio
git clone https://github.com/josevasquezramos/app_zone_app.git

# 2. Entrar al directorio del repositorio
cd app_zone_app

# 3. Cambiarse a la rama feature
git checkout tarea-feature

# Si Git te muestra un mensaje como:
# error: pathspec 'tarea-feature' did not match any file(s) known to git
# Significa que la rama no está disponible localmente.
# En ese caso, primero debes hacer un fetch
git fetch origin
git checkout tarea-feature
```

### 2️⃣ **Configurar Firebase**

#### **Crear Proyecto Firebase:**
1. Ve a [Firebase Console](https://console.firebase.google.com/)
2. Haz clic en "Crear un proyecto"
3. Ingresa el nombre: `GameVault` (o el que prefieras)
4. Habilita Google Analytics (opcional)
5. Crea el proyecto

#### **Agregar App Android:**
1. En la consola de Firebase, haz clic en "Agregar app" → Android
2. **Nombre del paquete:** `com.example.app_s10`
3. **Nombre de la app:** `GameVault`
4. **Certificado SHA-1:** (opcional por ahora)
5. Descarga el archivo `google-services.json`

#### **Reemplazar archivo de configuración:**
```bash
# Reemplaza el archivo placeholder con tu archivo real
cp ruta/a/tu/google-services.json app/google-services.json
```

### 3️⃣ **Habilitar Authentication**

1. En [Firebase Console](https://console.firebase.google.com/), ve a **Authentication**
2. Haz clic en **Sign-in method**
3. Habilita estos proveedores:
   - 📧 **Correo electrónico/contraseña**
   - 🎭 **Anónimo** (opcional, para modo invitado)

### 4️⃣ **Configurar Firebase Realtime Database**

#### Habilitar Realtime Database

1. Ve a [Firebase Console](https://console.firebase.google.com/)
2. Selecciona tu proyecto **GameVault**
3. En el menú lateral, haz clic en **Realtime Database**
4. Haz clic en **Crear base de datos**
5. Selecciona **Comenzar en modo de prueba** (para desarrollo)
6. Escoge tu región (recomendado: us-central1)

#### Configurar Reglas de Seguridad

```json
{
  "rules": {
    "games": {
      "$uid": {
        ".read": "$uid === auth.uid",
        ".write": "$uid === auth.uid"
      }
    }
  }
}
```

### 5️⃣ **Abrir en Android Studio**

```bash
# Abre Android Studio
# File → Open → Selecciona la carpeta app_s10
# Espera a que Gradle sincronice
```

### 6️⃣ **Ejecutar la App**

1. Conecta tu dispositivo Android o inicia un emulador
2. Haz clic en **Run** ▶️
3. ¡La app se instalará y abrirá!

## 📁 Estructura del Proyecto

```
app_s10/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/app_s10/
│   │   │   ├── LoginActivity.kt             # 🔐 Pantalla de login
│   │   │   ├── MainActivity.kt              # 🏠 Dashboard principal
│   │   │   ├── AddGameActivity.kt           # ➕ Añadir y Editar juegos
│   │   │   ├── Game.kt                      # 🎮 Modelo de datos
│   │   │   ├── GameAdapter.kt               # 🔄 Adaptador RecyclerView  
│   │   │   └── GamesListActivity.kt         # 📜 Lista de juegos
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_login.xml       # 🎨 UI Login
│   │   │   │   ├── activity_main.xml        # 🎨 UI Dashboard
│   │   │   │   ├── activity_add_game.xml    # ➕ Formulario juego
│   │   │   │   ├── activity_games_list.xml  # 📜 Lista juegos
│   │   │   │   └── item_game.xml            # 🃏 Item individual
│   │   │   ├── menu/
│   │   │   │   ├── games_list_menu.xml      # 🔄 Menú principal
│   │   │   │   └── search_menu.xml          # 🔍 Menú búsqueda
│   │   │   ├── values/
│   │   │   │   ├── colors.xml               # 🌈 Colores gaming
│   │   │   │   └── strings.xml              # 🇪🇸 Textos en español
│   │   │   └── drawable/                    # 🎮 Iconos y fondos
│   │   └── AndroidManifest.xml              # ⚙️ Configuración app
│   ├── google-services.json                 # 🔥 Config Firebase
│   └── build.gradle.kts                     # 📦 Dependencias
└── README.md                                # 📖 Documentación
```

### 📚 **Recursos de Apoyo**

- **[Firebase Realtime Database Docs](https://firebase.google.com/docs/database/android/start)**
- **[RecyclerView Tutorial](https://developer.android.com/develop/ui/views/layout/recyclerview)**
- **[Material Design Components](https://material.io/develop/android)**

## 🛠️ Personalización

### **Cambiar Colores**
Edita `app/src/main/res/values/colors.xml`:
```xml
<color name="gaming_purple">#TU_COLOR</color>
<color name="gaming_cyan">#TU_COLOR</color>
```

### **Cambiar Textos**
Edita `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Tu App Name</string>
<string name="login_title">Tu Título</string>
```

## 🔧 Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Kotlin** | 2.0.21 | Lenguaje principal |
| **Android Gradle Plugin** | 8.9.2 | Build system |
| **Firebase BOM** | 33.7.0 | Gestión de versiones Firebase |
| **Firebase Auth** | Latest | Autenticación |
| **Firebase Realtime Database** | Latest | Base de datos |
| **Material Design** | 1.12.0 | Componentes UI |
| **ConstraintLayout** | 2.2.1 | Layouts responsive |

## 🚨 Solución de Problemas

### **Error: "google-services.json not found"**
```bash
# Asegúrate de que el archivo esté en la ubicación correcta
ls app/google-services.json
# Si no existe, descárgalo desde Firebase Console
```

### **Error: "Default FirebaseApp is not initialized"**
- Verifica que `google-services.json` sea válido
- Asegúrate de que el package name coincida: `com.example.app_s10`
- Limpia y reconstruye el proyecto: Build → Clean Project

### **Error de autenticación**
- Verifica que Email/Password esté habilitado en Firebase Console
- Revisa la conexión a internet
- Verifica las reglas de seguridad de Firebase

### **Problemas de compilación**
```bash
# Limpia el proyecto
./gradlew clean

# Reconstruye
./gradlew build
```

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ve el archivo [LICENSE](LICENSE) para más detalles.

## 👨‍💻 Autor

**josevasquezramos**
- GitHub: [@josevasquezramos](https://github.com/josevasquezramos)
- Proyecto: [app_zone_app](https://github.com/josevasquezramos/app_zone_app/tree/tarea-feature)

## 🌟 ¿Te gustó el proyecto?

¡Dale una ⭐ al repositorio si te sirvió! Ayuda a otros developers a encontrarlo.

## 📚 Recursos Adicionales

- [📖 Documentación Firebase Auth](https://firebase.google.com/docs/auth/android/start)
- [🎨 Material Design Guidelines](https://material.io/design)
- [📱 Android Developer Guide](https://developer.android.com/guide)
- [🔥 Firebase Console](https://console.firebase.google.com/)

---

### 🎮 **¡Happy Gaming & Coding!** 🎮

> Desarrollado con ❤️ para la comunidad de developers Android
