# ⚡🌐 Skill: C++ Web (WebAssembly & Browser Execution)
- Compilación y ejecución de código C++ para la Web usando WebAssembly / Emscripten.
- Estructura del proyecto:
  • `/main.cpp`: Algoritmos C++ exportables mediante rutinas `extern "C"`.
  • `/CMakeLists.txt`: Configuración de build Emscripten para C++17.
  • `/index.html`, `/app.js`, `/style.css`: Interfaz Web interactiva con ejecutor WASM y consola terminal `stdout` en vivo.
- Rendimiento de nivel nativo ejecutado directamente en el navegador del usuario.
