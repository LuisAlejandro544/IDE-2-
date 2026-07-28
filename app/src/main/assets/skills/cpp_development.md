# ⚡ Skill: Desarrollo C++ Modular (C++ Web & C++ App)

## 🌐 1. C++ Web (WebAssembly & Browser Execution)
- **Propósito**: Ejecución de algoritmos C++ en la Web mediante WebAssembly / Emscripten.
- **Estructura**:
  - `/main.cpp`: Lógica de cómputo en C++ (rutinas `extern "C"` exportables).
  - `/CMakeLists.txt`: Configuración de compilación para Emscripten / WebAssembly.
  - `/index.html`, `/app.js`, `/style.css`: Interfaz Web moderna e interactiva para probar y visualizar la consola de salida C++ en vivo.

## 📱 2. C++ App (Android Native NDK & JNI)
- **Propósito**: Desarrollo de módulos y aplicaciones nativas Android en C++ con alto rendimiento.
- **Estructura**:
  - `/cpp/engine.cpp`: Código nativo C++ NDK con firmas JNI `Java_com_example_native_CppEngine_...`.
  - `/CMakeLists.txt`: Configuración para compilar la librería `.so` (`libcppengine.so`).
  - `/index.html`, `/app.js`, `/style.css`: Vista simulada de teléfono Android con consola de prueba de llamadas JNI en vivo.
