# ⚡📱 Skill: C++ App (Android Native NDK & JNI)
- Desarrollo de aplicaciones y módulos nativos C++ para Android NDK.
- Estructura del proyecto:
  • `/cpp/engine.cpp`: Lógica nativa en C++ expuesta vía JNI Bridge `Java_com_example_native_CppEngine_...`.
  • `/CMakeLists.txt`: Configuración para compilar la librería nativa `.so` (`libcppengine.so`).
  • `/index.html`, `/app.js`, `/style.css`: Simulador de interfaz móvil Android conectada con la consola JNI en vivo.
- Comunicación bidireccional entre Java/Kotlin y C++ nativo a máxima velocidad de procesamiento.
