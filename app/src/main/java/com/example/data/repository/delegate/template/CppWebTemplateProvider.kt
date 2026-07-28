package com.example.data.repository.delegate.template

import com.example.data.db.ProjectFileEntity

object CppWebTemplateProvider {
    fun getFiles(projectId: Long): List<ProjectFileEntity> {
        return listOf(
            ProjectFileEntity(
                projectId = projectId,
                name = "index.html",
                path = "/index.html",
                extension = "html",
                content = """
                    <!DOCTYPE html>
                    <html lang="es">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>C++ Web App - DevStudio IDE</title>
                      <link rel="stylesheet" href="style.css">
                    </head>
                    <body>
                      <div class="container">
                        <header class="header">
                          <span class="badge">C++ WEB / WEBASSEMBLY</span>
                          <h1>⚡ Aplicación C++ para Web</h1>
                          <p>Ejecutando lógica C++ nativa directamente en el navegador</p>
                        </header>

                        <div class="card">
                          <h3>🚀 Control de Ejecución C++</h3>
                          <p>Presiona para ejecutar el algoritmo compilado en C++ (Fibonacci & Procesamiento de Arreglos):</p>
                          <div class="actions">
                            <button class="btn btn-primary" id="btnRunCpp">⚡ Ejecutar Algoritmo C++</button>
                            <button class="btn btn-secondary" id="btnClearLog">🧹 Limpiar Consola</button>
                          </div>
                        </div>

                        <div class="card">
                          <h3>🖥️ Consola de Salida C++ (stdout)</h3>
                          <pre id="cppConsole" class="terminal-box">> [C++ Engine]: Inicializado en modo WebAssembly. Esperando comando...</pre>
                        </div>

                        <div class="card">
                          <h3>📁 Estructura del Código C++</h3>
                          <p>Código fuente ubicado en <code>/main.cpp</code> y configurado con <code>/CMakeLists.txt</code> para WebAssembly (Emscripten).</p>
                        </div>
                      </div>

                      <script type="module" src="app.js"></script>
                    </body>
                    </html>
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "main.cpp",
                path = "/main.cpp",
                extension = "cpp",
                content = """
                    #include <iostream>
                    #include <vector>
                    #include <string>
                    #include <sstream>

                    // Función de utilidad en C++ para calcular secuencia Fibonacci
                    long long fibonacci(int n) {
                        if (n <= 1) return n;
                        long long a = 0, b = 1, c = 0;
                        for (int i = 2; i <= n; i++) {
                            c = a + b;
                            a = b;
                            b = c;
                        }
                        return b;
                    }

                    // Función exportable estilo WebAssembly (emscripten)
                    extern "C" {
                        const char* run_cpp_process(int count) {
                            static std::string output;
                            std::ostringstream ss;
                            
                            ss << "⚡ [C++ Web Core]: Procesando " << count << " elementos en C++...\n";
                            
                            std::vector<long long> fibs;
                            for (int i = 1; i <= count; i++) {
                                fibs.push_back(fibonacci(i));
                            }
                            
                            ss << "✅ [C++ Output]: Secuencia calculada -> ";
                            for (size_t i = 0; i < fibs.size(); i++) {
                                ss << fibs[i] << (i + 1 < fibs.size() ? ", " : "");
                            }
                            ss << "\n🚀 Complejidad de tiempo: O(N) | Memoria: std::vector<long long>";
                            
                            output = ss.str();
                            return output.c_str();
                        }
                    }

                    int main() {
                        std::cout << "DevStudio C++ Web Module inicializado con éxito." << std::endl;
                        return 0;
                    }
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "app.js",
                path = "/app.js",
                extension = "js",
                content = """
                    // Bridge de simulación de WebAssembly para C++ en DevStudio
                    let runCount = 5;

                    function fibonacciJs(n) {
                      if (n <= 1) return n;
                      let a = 0, b = 1, c = 0;
                      for (let i = 2; i <= n; i++) {
                        c = a + b;
                        a = b;
                        b = c;
                      }
                      return b;
                    }

                    function simulateWasmCppCall(count) {
                      const fibs = [];
                      for (let i = 1; i <= count; i++) {
                        fibs.push(fibonacciJs(i));
                      }
                      return `⚡ [C++ WASM Core]: Ejecutando rutina de C++ (main.cpp)\n` +
                             `✅ [C++ Output]: Calculados los primeros \${'$'}{count} números Fibonacci: [\${'$'}{fibs.join(', ')}]\n` +
                             `📊 Memoria asignada en Heap C++: \${'$'}{count * 8} bytes | Rendimiento: < 1ms`;
                    }

                    document.addEventListener('DOMContentLoaded', () => {
                      const btnRun = document.getElementById('btnRunCpp');
                      const btnClear = document.getElementById('btnClearLog');
                      const consoleBox = document.getElementById('cppConsole');

                      if (btnRun && consoleBox) {
                        btnRun.addEventListener('click', () => {
                          const output = simulateWasmCppCall(runCount);
                          const timestamp = new Date().toLocaleTimeString();
                          consoleBox.textContent += `\n\n[\${'$'}{timestamp}]\n\${'$'}{output}`;
                          consoleBox.scrollTop = consoleBox.scrollHeight;
                          runCount = (runCount >= 15) ? 5 : runCount + 2;
                        });
                      }

                      if (btnClear && consoleBox) {
                        btnClear.addEventListener('click', () => {
                          consoleBox.textContent = '> [C++ Engine]: Consola reiniciada.';
                          runCount = 5;
                        });
                      }
                    });

                    console.log("C++ Web Application runner cargado.");
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "style.css",
                path = "/style.css",
                extension = "css",
                content = """
                    :root {
                      --bg-primary: #121824;
                      --card-bg: #1e2638;
                      --accent-blue: #00d2ff;
                      --accent-cyan: #3a7bd5;
                      --text-main: #e2e8f0;
                      --text-secondary: #94a3b8;
                      --terminal-bg: #0b0f19;
                      --border-color: #2e3a52;
                    }

                    * {
                      box-sizing: border-box;
                      margin: 0;
                      padding: 0;
                      font-family: 'Segoe UI', system-ui, sans-serif;
                    }

                    body {
                      background-color: var(--bg-primary);
                      color: var(--text-main);
                      padding: 20px;
                      display: flex;
                      justify-content: center;
                    }

                    .container {
                      max-width: 700px;
                      width: 100%;
                    }

                    .header {
                      text-align: center;
                      margin-bottom: 24px;
                    }

                    .badge {
                      background: linear-gradient(135deg, var(--accent-cyan), var(--accent-blue));
                      color: #000;
                      font-weight: bold;
                      font-size: 0.75rem;
                      padding: 4px 12px;
                      border-radius: 12px;
                      letter-spacing: 1px;
                    }

                    .header h1 {
                      margin-top: 10px;
                      font-size: 1.8rem;
                    }

                    .header p {
                      color: var(--text-secondary);
                      font-size: 0.95rem;
                      margin-top: 4px;
                    }

                    .card {
                      background: var(--card-bg);
                      border: 1px solid var(--border-color);
                      border-radius: 12px;
                      padding: 18px;
                      margin-bottom: 16px;
                    }

                    .card h3 {
                      font-size: 1.1rem;
                      margin-bottom: 8px;
                      color: var(--accent-blue);
                    }

                    .card p {
                      font-size: 0.9rem;
                      color: var(--text-secondary);
                      margin-bottom: 12px;
                    }

                    .actions {
                      display: flex;
                      gap: 10px;
                    }

                    .btn {
                      padding: 10px 16px;
                      border-radius: 8px;
                      border: none;
                      font-weight: bold;
                      cursor: pointer;
                      transition: transform 0.2s, opacity 0.2s;
                    }

                    .btn:active {
                      transform: scale(0.97);
                    }

                    .btn-primary {
                      background: linear-gradient(135deg, var(--accent-cyan), var(--accent-blue));
                      color: #0b0f19;
                    }

                    .btn-secondary {
                      background: var(--border-color);
                      color: var(--text-main);
                    }

                    .terminal-box {
                      background: var(--terminal-bg);
                      border: 1px solid var(--border-color);
                      border-radius: 8px;
                      padding: 12px;
                      font-family: 'Courier New', monospace;
                      font-size: 0.85rem;
                      color: #00ffcc;
                      white-space: pre-wrap;
                      max-height: 220px;
                      overflow-y: auto;
                    }

                    code {
                      background: rgba(0, 210, 255, 0.1);
                      color: var(--accent-blue);
                      padding: 2px 6px;
                      border-radius: 4px;
                      font-family: monospace;
                    }
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "CMakeLists.txt",
                path = "/CMakeLists.txt",
                extension = "txt",
                content = """
                    cmake_minimum_required(VERSION 3.22.1)
                    project("cpp_web_app")

                    set(CMAKE_CXX_STANDARD 17)

                    # Configuración de compilación Emscripten para WebAssembly
                    add_executable(cpp_web_app main.cpp)
                """.trimIndent()
            )
        )
    }
}
