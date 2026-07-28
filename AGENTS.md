# AGENTS.md - Reglas del Proyecto DevStudio

Consulte la documentación detallada en `Docs/Agents.md` y `Docs/AI_Context.md`.

## Resumen de Reglas:
1. **Arquitectura Polyglot**: Kotlin + C++ JNI + Rust Localhost HTTP Server.
2. **Jerarquía y Persistencia**: `parentPath` e `isDirectory` en `ProjectFileEntity` con Room DB.
3. **Llamada a Herramientas de IA (Tool Calling)**: Soporte de herramientas en tiempo real (`get_project_structure`, `read_file`, `edit_file`, `create_file`, `delete_file`) ejecutables mediante llamadas a funciones de Gemini u OpenRouter.
4. **Sistema de Skills Aisladas y Modulares (`/skills/`)**: Carga e inyección automática en el Agente de IA:
   - 🛠️ `/skills/core/`: `tool_usage.md` (Guía de herramientas, prohibición estricta de reescritura total con `edit_file`).
   - 🌐 `/skills/web/`: `web_design.md`, `web_logic.md`, `web_responsive.md` (HTML5, CSS M3, ES6+, Import Maps & ES Modules).
   - ⚛️ `/skills/react/`: `react_design.md`, `react_logic.md`, `react_responsive.md` (React 18, Hooks, Babel standalone, JSX, Tailwind, Import Maps).
   - ⚡ `/skills/cpp/`: `cpp_web.md` (WebAssembly/Emscripten) y `cpp_app.md` (Android NDK nativo con JNI Bridge).
   - 🔷 `/skills/csharp/`: `csharp_design.md`, `csharp_logic.md`, `csharp_responsive.md` (C# .NET, Blazor UI, Mono WASM & JSInterop).
5. **Edición Nativa**: `CodeEditorView.kt` con `SyntaxHighlighter.kt`.
6. **Paleta M3**: Seguir temas y colores en `ui/theme/`.
7. **Compilación**: Validar con `compile_applet` tras cualquier cambio.
