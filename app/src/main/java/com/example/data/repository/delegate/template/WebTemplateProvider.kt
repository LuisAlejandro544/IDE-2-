package com.example.data.repository.delegate.template

import com.example.data.db.ProjectFileEntity

object WebTemplateProvider {
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
                      <title>DevStudio Web Demo</title>
                      <link rel="stylesheet" href="style.css">
                      <!-- Import Map para resolución nativa de módulos ES sin Node.js / bundlers -->
                      <script type="importmap">
                      {
                        "imports": {
                          "canvas-confetti": "https://esm.sh/canvas-confetti@1.9.3"
                        }
                      }
                      </script>
                    </head>
                    <body>
                      <div class="container">
                        <nav class="nav-bar">
                          <a href="index.html" class="nav-link active">Inicio</a>
                          <a href="about.html" class="nav-link">Acerca de</a>
                        </nav>

                        <div class="header">
                          <span class="badge">PROYECTO MULTIPÁGINA + ES MODULES</span>
                          <h1>Mi Aplicación Web</h1>
                          <p>Diseñada con Import Maps y ES Modules en DevStudio</p>
                        </div>

                        <div class="card">
                          <h3>Contador Interactivo</h3>
                          <div class="counter-display" id="counter">0</div>
                          <div class="button-group">
                            <button class="btn btn-secondary" onclick="decrement()">- Disminuir</button>
                            <button class="btn btn-primary" onclick="increment()">+ Incrementar</button>
                          </div>
                        </div>

                        <div class="card">
                          <h3>🎉 Módulos ES & Librerías</h3>
                          <p style="margin-bottom: 12px; font-size: 0.9rem; color: var(--text-secondary);">Prueba la librería <code>canvas-confetti</code> importada mediante ES Modules e Import Maps:</p>
                          <button class="btn btn-primary" id="btnConfetti">🎊 Lanzar Confeti ES Module</button>
                        </div>

                        <div class="card">
                          <h3>Lista de Tareas Rápidas</h3>
                          <ul id="taskList">
                            <li>✨ Crear interfaz de IDE Móvil</li>
                            <li>📦 Usar Import Maps y ES Modules</li>
                            <li>📁 Integrar gestor de archivos multipágina</li>
                            <li>👁️ Habilitar vista previa en vivo con servidor Rust</li>
                          </ul>
                        </div>
                      </div>

                      <!-- Carga de JavaScript usando ES Modules (type="module") -->
                      <script type="module" src="script.js"></script>
                    </body>
                    </html>
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "about.html",
                path = "/about.html",
                extension = "html",
                content = """
                    <!DOCTYPE html>
                    <html lang="es">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>Acerca de - DevStudio</title>
                      <link rel="stylesheet" href="style.css">
                    </head>
                    <body>
                      <div class="container">
                        <nav class="nav-bar">
                          <a href="index.html" class="nav-link">← Inicio</a>
                          <a href="about.html" class="nav-link active">Acerca de</a>
                        </nav>

                        <div class="header">
                          <span class="badge">SOPORTE MULTIPÁGINA</span>
                          <h1>Acerca del Proyecto</h1>
                          <p>Esta página demuestra la navegación entre múltiples archivos HTML en el servidor local DevStudio.</p>
                        </div>

                        <div class="card">
                          <h3>🚀 Características del IDE</h3>
                          <ul style="margin-left: 20px; line-height: 1.8;">
                            <li>Navegación nativa entre páginas HTML.</li>
                            <li>Servidor HTTP ultra-rápido en tiempo real.</li>
                            <li>Soporte para CSS, JavaScript y assets locales.</li>
                            <li>Generación de proyectos con Agente de IA.</li>
                          </ul>
                        </div>
                      </div>
                    </body>
                    </html>
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "style.css",
                path = "/style.css",
                extension = "css",
                content = """
                    :root {
                      --bg-color: #121318;
                      --card-bg: #1A1C23;
                      --border-color: #2D303E;
                      --text-primary: #F1F5F9;
                      --text-secondary: #94A3B8;
                      --primary-blue: #4F83F6;
                      --accent-green: #10B981;
                    }

                    * {
                      box-sizing: border-box;
                      margin: 0;
                      padding: 0;
                    }

                    body {
                      background-color: var(--bg-color);
                      color: var(--text-primary);
                      font-family: system-ui, sans-serif;
                      padding: 20px;
                      display: flex;
                      justify-content: center;
                    }

                    .container {
                      width: 100%;
                      max-width: 500px;
                      display: flex;
                      flex-direction: column;
                      gap: 16px;
                    }

                    .nav-bar {
                      display: flex;
                      gap: 12px;
                      background: var(--card-bg);
                      padding: 10px 16px;
                      border-radius: 8px;
                      border: 1px solid var(--border-color);
                    }

                    .nav-link {
                      color: var(--text-secondary);
                      text-decoration: none;
                      font-weight: 600;
                      font-size: 0.9rem;
                    }

                    .nav-link.active, .nav-link:hover {
                      color: var(--primary-blue);
                    }

                    .badge {
                      display: inline-block;
                      background: rgba(16, 185, 129, 0.15);
                      color: var(--accent-green);
                      padding: 4px 8px;
                      border-radius: 4px;
                      font-size: 0.75rem;
                      font-weight: 700;
                      margin-bottom: 8px;
                    }

                    .card {
                      background: var(--card-bg);
                      border: 1px solid var(--border-color);
                      border-radius: 12px;
                      padding: 20px;
                    }

                    .counter-display {
                      font-size: 3rem;
                      font-weight: 800;
                      text-align: center;
                      color: var(--primary-blue);
                      margin: 16px 0;
                    }

                    .button-group {
                      display: flex;
                      gap: 10px;
                    }

                    .btn {
                      flex: 1;
                      padding: 12px;
                      border: none;
                      border-radius: 8px;
                      font-weight: 600;
                      cursor: pointer;
                    }

                    .btn-primary {
                      background: var(--primary-blue);
                      color: #FFFFFF;
                    }

                    .btn-secondary {
                      background: #2D303E;
                      color: var(--text-primary);
                    }
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "script.js",
                path = "/script.js",
                extension = "js",
                content = """
                    // Importación de librerías mediante Import Maps y ES Modules
                    import confetti from 'canvas-confetti';

                    let count = 0;

                    function updateDisplay() {
                      const display = document.getElementById('counter');
                      if (display) {
                        display.textContent = count;
                      }
                    }

                    window.increment = function() {
                      count++;
                      updateDisplay();
                    };

                    window.decrement = function() {
                      count--;
                      updateDisplay();
                    };

                    document.addEventListener('DOMContentLoaded', () => {
                      const btnConfetti = document.getElementById('btnConfetti');
                      if (btnConfetti) {
                        btnConfetti.addEventListener('click', () => {
                          confetti({
                            particleCount: 80,
                            spread: 70,
                            origin: { y: 0.6 }
                          });
                        });
                      }
                    });

                    console.log("DevStudio IDE: Script ES Module cargado con éxito.");
                """.trimIndent()
            )
        )
    }
}
