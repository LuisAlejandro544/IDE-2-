package com.example.data.repository.delegate.template

import com.example.data.db.ProjectFileEntity

object CppAppTemplateProvider {
    fun getFiles(projectId: Long): List<ProjectFileEntity> {
        return listOf(
            ProjectFileEntity(
                projectId = projectId,
                name = "engine.cpp",
                path = "/cpp/engine.cpp",
                extension = "cpp",
                parentPath = "/cpp",
                content = """
                    #include <jni.h>
                    #include <string>
                    #include <vector>
                    #include <numeric>

                    // C++ Native App Core Logic for Android NDK
                    extern "C" JNIEXPORT jstring JNICALL
                    Java_com_example_native_CppEngine_calculate(JNIEnv* env, jobject /* this */, jint valA, jint valB) {
                        int product = valA * valB;
                        int sum = valA + valB;
                        
                        std::string message = "📱 [C++ App Native Core]: " + std::to_string(valA) + 
                                              " x " + std::to_string(valB) + " = " + std::to_string(product) + 
                                              " | Suma: " + std::to_string(sum);
                                              
                        return env->NewStringUTF(message.c_str());
                    }

                    extern "C" JNIEXPORT jint JNICALL
                    Java_com_example_native_CppEngine_processVector(JNIEnv* env, jobject /* this */, jintArray arr) {
                        jsize len = env->GetArrayLength(arr);
                        jint *body = env->GetIntArrayElements(arr, 0);
                        
                        int sum = 0;
                        for (int i = 0; i < len; i++) {
                            sum += body[i];
                        }
                        
                        env->ReleaseIntArrayElements(arr, body, 0);
                        return sum;
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
                    project("cpp_native_app")

                    # Compila la librería nativa para la App Android
                    add_library(cppengine SHARED cpp/engine.cpp)

                    find_library(log-lib log)
                    target_link_libraries(cppengine ${'$'}{log-lib})
                """.trimIndent()
            ),
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
                      <title>C++ Native App - DevStudio IDE</title>
                      <link rel="stylesheet" href="style.css">
                    </head>
                    <body>
                      <div class="mobile-frame">
                        <div class="screen">
                          <header class="app-header">
                            <span class="status-bar">📱 Android Native C++ (NDK/JNI)</span>
                            <h2>App Nativa C++</h2>
                            <p class="subtitle">Interfaz Móvil conectada con C++ NDK Engine</p>
                          </header>

                          <div class="card">
                            <h3>⚡ JNI Native Bridge</h3>
                            <div class="input-row">
                              <input type="number" id="numA" value="12" placeholder="Num A">
                              <span>×</span>
                              <input type="number" id="numB" value="8" placeholder="Num B">
                            </div>
                            <button class="btn btn-primary" id="btnCallJni">Llamar C++ vía JNI</button>
                          </div>

                          <div class="card">
                            <h3>📋 Log del Sistema Nativo</h3>
                            <div id="nativeLog" class="terminal-log">
                              > System.loadLibrary("cppengine");<br>
                              > Bridge JNI preparado en Android.
                            </div>
                          </div>
                        </div>
                      </div>

                      <script type="module" src="app.js"></script>
                    </body>
                    </html>
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "app.js",
                path = "/app.js",
                extension = "js",
                content = """
                    // Simulador interactivo de llamadas JNI C++ para Live Preview
                    document.addEventListener('DOMContentLoaded', () => {
                      const btn = document.getElementById('btnCallJni');
                      const inputA = document.getElementById('numA');
                      const inputB = document.getElementById('numB');
                      const log = document.getElementById('nativeLog');

                      if (btn && log) {
                        btn.addEventListener('click', () => {
                          const valA = parseInt(inputA.value) || 0;
                          const valB = parseInt(inputB.value) || 0;
                          const result = valA * valB;
                          const sum = valA + valB;

                          const time = new Date().toLocaleTimeString();
                          log.innerHTML += `<br><br><b>[\${'$'}{time}]</b> JNI Call Native_CppEngine_calculate(\${'$'}{valA}, \${'$'}{valB})<br>` +
                                           `<span style="color:#4facfe;">📱 [C++ App Native Core]: \${'$'}{valA} x \${'$'}{valB} = \${'$'}{result} | Suma: \${'$'}{sum}</span>`;
                        });
                      }
                    });
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "style.css",
                path = "/style.css",
                extension = "css",
                content = """
                    * {
                      box-sizing: border-box;
                      margin: 0;
                      padding: 0;
                      font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
                    }

                    body {
                      background-color: #0f172a;
                      color: #f8fafc;
                      display: flex;
                      justify-content: center;
                      align-items: center;
                      min-height: 100vh;
                      padding: 16px;
                    }

                    .mobile-frame {
                      width: 100%;
                      max-width: 380px;
                      background: #1e293b;
                      border-radius: 24px;
                      border: 2px solid #334155;
                      box-shadow: 0 12px 30px rgba(0,0,0,0.5);
                      overflow: hidden;
                    }

                    .screen {
                      padding: 20px;
                    }

                    .app-header {
                      text-align: center;
                      margin-bottom: 20px;
                    }

                    .status-bar {
                      font-size: 0.7rem;
                      text-transform: uppercase;
                      background: rgba(56, 189, 248, 0.15);
                      color: #38bdf8;
                      padding: 4px 10px;
                      border-radius: 10px;
                      font-weight: bold;
                    }

                    .app-header h2 {
                      margin-top: 8px;
                      font-size: 1.4rem;
                    }

                    .subtitle {
                      font-size: 0.8rem;
                      color: #94a3b8;
                    }

                    .card {
                      background: #0f172a;
                      border-radius: 12px;
                      padding: 16px;
                      margin-bottom: 16px;
                      border: 1px solid #334155;
                    }

                    .card h3 {
                      font-size: 0.95rem;
                      color: #38bdf8;
                      margin-bottom: 12px;
                    }

                    .input-row {
                      display: flex;
                      align-items: center;
                      gap: 8px;
                      margin-bottom: 12px;
                    }

                    .input-row input {
                      flex: 1;
                      background: #1e293b;
                      border: 1px solid #475569;
                      color: #fff;
                      padding: 8px;
                      border-radius: 6px;
                      text-align: center;
                      font-size: 1rem;
                    }

                    .btn {
                      width: 100%;
                      padding: 10px;
                      border-radius: 8px;
                      border: none;
                      font-weight: bold;
                      cursor: pointer;
                    }

                    .btn-primary {
                      background: linear-gradient(135deg, #00c6ff, #0072ff);
                      color: #fff;
                    }

                    .terminal-log {
                      background: #020617;
                      border-radius: 8px;
                      padding: 10px;
                      font-family: monospace;
                      font-size: 0.75rem;
                      color: #22c55e;
                      max-height: 180px;
                      overflow-y: auto;
                      line-height: 1.4;
                    }
                """.trimIndent()
            )
        )
    }
}
