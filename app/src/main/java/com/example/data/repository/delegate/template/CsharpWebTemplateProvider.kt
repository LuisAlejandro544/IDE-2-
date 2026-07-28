package com.example.data.repository.delegate.template

import com.example.data.db.ProjectFileEntity

object CsharpWebTemplateProvider {
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
                      <title>C# .NET WebAssembly App - DevStudio IDE</title>
                      <link rel="stylesheet" href="style.css">
                    </head>
                    <body>
                      <div class="container">
                        <header class="header">
                          <span class="badge">🔷 C# / .NET WEBASSEMBLY</span>
                          <h1>⚡ Aplicación C# .NET en Navegador</h1>
                          <p>Ejecutando lógica C# con LINQ y Async directamente sobre Mono/WebAssembly Runtime</p>
                        </header>

                        <div class="card">
                          <h3>🚀 Panel de Control C# .NET</h3>
                          <p>Presiona para ejecutar rutinas C# (Procesamiento LINQ, Generador de Números y Cálculo de Estadísticas):</p>
                          <div class="actions">
                            <button class="btn btn-primary" id="btnRunCsharp">🔷 Ejecutar Rutina C# LINQ</button>
                            <button class="btn btn-secondary" id="btnClearLog">🧹 Limpiar Consola</button>
                          </div>
                        </div>

                        <div class="card">
                          <h3>🖥️ Consola de Salida .NET (stdout / JSInterop)</h3>
                          <pre id="dotnetConsole" class="terminal-box">> [.NET WASM Engine]: Inicializado el runtime de C#. Esperando interacción...</pre>
                        </div>

                        <div class="card">
                          <h3>📁 Código Fuente .NET</h3>
                          <p>Código fuente principal en <code>/Program.cs</code> y configuración de proyecto en <code>/App.csproj</code>.</p>
                        </div>
                      </div>

                      <script type="module" src="app.js"></script>
                    </body>
                    </html>
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "Program.cs",
                path = "/Program.cs",
                extension = "cs",
                content = """
                    using System;
                    using System.Collections.Generic;
                    using System.Linq;

                    namespace DevStudioCsharpApp
                    {
                        public class Program
                        {
                            public static void Main(string[] args)
                            {
                                Console.WriteLine("🔷 [C# .NET Core]: Entorno de ejecución WebAssembly listo.");
                            }

                            public static string RunLinqDemo(int itemCount)
                            {
                                var numbers = Enumerable.Range(1, itemCount).Select(x => x * 7).ToList();
                                var evenNumbers = numbers.Where(n => n % 2 == 0).ToList();
                                var sum = numbers.Sum();
                                var average = numbers.Average();

                                return $"🔷 [C# LINQ Engine]:\n" +
                                       $"  • Muestra procesada ({itemCount} elementos): [{string.Join(", ", numbers.Take(6))}...]\n" +
                                       $"  • Pares filtrados con LINQ: {evenNumbers.Count} números\n" +
                                       $"  • Suma total: {sum} | Promedio: {average:F2}\n" +
                                       $"  • Estado: OK | Runtime .NET 8 WebAssembly";
                            }
                        }
                    }
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "App.csproj",
                path = "/App.csproj",
                extension = "csproj",
                content = """
                    <Project Sdk="Microsoft.NET.Sdk.BlazorWebAssembly">
                      <PropertyGroup>
                        <TargetFramework>net8.0</TargetFramework>
                        <Nullable>enable</Nullable>
                        <ImplicitUsings>enable</ImplicitUsings>
                        <RootNamespace>DevStudioCsharpApp</RootNamespace>
                      </PropertyGroup>
                    </Project>
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "app.js",
                path = "/app.js",
                extension = "js",
                content = """
                    // Runner simulador de interop JS / C# .NET WebAssembly
                    let runCount = 5;

                    function simulateDotnetCall(count) {
                      const numbers = Array.from({length: count}, (_, i) => (i + 1) * 7);
                      const evens = numbers.filter(n => n % 2 === 0);
                      const sum = numbers.reduce((a, b) => a + b, 0);
                      const avg = (sum / numbers.length).toFixed(2);

                      return `🔷 [C# .NET 8 WASM Core]: Ejecutando Program.RunLinqDemo(\${'$'}{count})\n` +
                             `✅ [LINQ Output]: Muestra (\${'$'}{count} elems): [\${'$'}{numbers.slice(0, 5).join(', ')}...]\n` +
                             `📊 Pares filtrados: \${'$'}{evens.length} | Suma: \${'$'}{sum} | Promedio: \${'$'}{avg}\n` +
                             `⚡ Estado: Ejecución en Mono WASM Runtime (< 1ms)`;
                    }

                    document.addEventListener('DOMContentLoaded', () => {
                      const btnRun = document.getElementById('btnRunCsharp');
                      const btnClear = document.getElementById('btnClearLog');
                      const consoleBox = document.getElementById('dotnetConsole');

                      if (btnRun && consoleBox) {
                        btnRun.addEventListener('click', () => {
                          const output = simulateDotnetCall(runCount);
                          const timestamp = new Date().toLocaleTimeString();
                          consoleBox.textContent += `\n\n[\${'$'}{timestamp}]\n\${'$'}{output}`;
                          consoleBox.scrollTop = consoleBox.scrollHeight;
                          runCount = (runCount >= 20) ? 5 : runCount + 3;
                        });
                      }

                      if (btnClear && consoleBox) {
                        btnClear.addEventListener('click', () => {
                          consoleBox.textContent = '> [.NET WASM Engine]: Consola reiniciada.';
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
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                    }

                    body {
                      background-color: #0f0d1a;
                      color: #e2e8f0;
                      padding: 24px;
                    }

                    .container {
                      max-width: 760px;
                      margin: 0 auto;
                    }

                    .header {
                      text-align: center;
                      margin-bottom: 24px;
                    }

                    .badge {
                      background: linear-gradient(135deg, #512bd4, #68217a);
                      color: white;
                      font-size: 11px;
                      font-weight: bold;
                      padding: 4px 12px;
                      border-radius: 12px;
                      display: inline-block;
                      margin-bottom: 8px;
                    }

                    h1 {
                      font-size: 24px;
                      color: #ffffff;
                      margin-bottom: 6px;
                    }

                    p {
                      color: #94a3b8;
                      font-size: 14px;
                    }

                    .card {
                      background: #181528;
                      border: 1px solid #2d264a;
                      border-radius: 14px;
                      padding: 18px;
                      margin-bottom: 18px;
                    }

                    .card h3 {
                      font-size: 16px;
                      color: #a78bfa;
                      margin-bottom: 8px;
                    }

                    .actions {
                      display: flex;
                      gap: 10px;
                      margin-top: 12px;
                    }

                    .btn {
                      padding: 10px 18px;
                      border: none;
                      border-radius: 8px;
                      font-size: 13px;
                      font-weight: 600;
                      cursor: pointer;
                      transition: all 0.2s ease;
                    }

                    .btn-primary {
                      background: linear-gradient(135deg, #512bd4, #7c3aed);
                      color: white;
                    }

                    .btn-primary:hover {
                      opacity: 0.9;
                      transform: translateY(-1px);
                    }

                    .btn-secondary {
                      background: #2a2440;
                      color: #cbd5e1;
                    }

                    .terminal-box {
                      background: #090710;
                      border: 1px solid #251d38;
                      border-radius: 8px;
                      padding: 14px;
                      font-family: 'Consolas', 'Fira Code', monospace;
                      font-size: 12px;
                      color: #38bdf8;
                      white-space: pre-wrap;
                      max-height: 220px;
                      overflow-y: auto;
                      margin-top: 10px;
                    }

                    code {
                      background: #231b3b;
                      color: #c084fc;
                      padding: 2px 6px;
                      border-radius: 4px;
                      font-family: monospace;
                    }
                """.trimIndent()
            )
        )
    }
}
