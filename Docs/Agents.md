# 📋 Guía y Convenciones para Agentes de Código

Este documento especifica las pautas de estilo de código, flujos de trabajo y estándares para cualquier Agente de IA o desarrollador.

---

## 🎨 Estilo de Código y UI

- **Material Design 3**: Utiliza exclusivamente componentes M3 (`androidx.compose.material3`).
- **Paleta Oscura Cómoda**: La interfaz utiliza colores oscuros suaves (`#121318`, `#1A1C23`, `#2D303E`) evitando el contraste excesivo o brillante para cuidar la vista del usuario en sesiones prolongadas.
- **Editor de Código Nativo**: Mantener la implementación de `CodeEditorView.kt` y `SyntaxHighlighter.kt` en Jetpack Compose nativo.
- **Iconos**: Utilizar `Icons.Default` o `Icons.AutoMirrored` para elementos de navegación.

---

## 🧠 Sistema de Skills de IA Aisladas por Módulos (`/skills/`)

El motor de inteligencia artificial de DevStudio incorpora un sistema de 12 Skills especializadas organizadas por tecnología en carpetas independientes (`/skills/core/`, `/skills/web/`, `/skills/react/`, `/skills/cpp/`, `/skills/csharp/`):
1. **🛠️ Core (`/skills/core/tool_usage.md`)**: Enseña al modelo a consultar archivos antes de editar y prohíbe explícitamente reescribir un archivo entero con `edit_file`.
2. **🌐 Web HTML/CSS/JS (`/skills/web/`)**:
   - `web_design.md`: Estética M3, sombras sutiles, bordes suaves y paleta cromática.
   - `web_logic.md`: JavaScript ES6+ limpio, Import Maps, Módulos ES, manejo de errores y validaciones.
   - `web_responsive.md`: Maquetación adaptativa Mobile-First con Flexbox y CSS Grid.
3. **⚛️ React 18 Framework (`/skills/react/`)**:
   - `react_design.md`: Componentes funcionales M3/Tailwind, estados de carga y animaciones.
   - `react_logic.md`: Hooks (`useState`, `useEffect`), JSX Babel standalone e Import Maps npm (`esm.sh`).
   - `react_responsive.md`: Layouts adaptativos en JSX y touch targets accesibles.
4. **⚡ C++ Modular (`/skills/cpp/`)**:
   - `cpp_web.md`: Guías y plantillas para **C++ Web** (WebAssembly / Emscripten).
   - `cpp_app.md`: Guías y plantillas para **C++ App** (Android NDK / JNI).
5. **🔷 C# / .NET WebAssembly (`/skills/csharp/`)**:
   - `csharp_design.md`: Estilado Blazor / M3 con paleta .NET.
   - `csharp_logic.md`: C# .NET moderno, LINQ, Async/Await, JSInterop (`[JSInvokable]`).
   - `csharp_responsive.md`: Layouts adaptativos Mobile-First en C# Web.

---

## 🛠️ Ejecución de Herramientas IA (Tool Calling)

- El agente de IA cuenta con herramientas ejecutables en tiempo real (`get_project_structure`, `read_file`, `edit_file`, `create_file`, `delete_file`).
- Al invocar `edit_file`, las modificaciones se aplican quirúrgicamente al repositorio de Room DB y se reflejan al instante en la pestaña activa del editor.

---

## 📁 Manejo de Archivos y Carpetas

- **Jerarquía y Anidación**: Toda adición de carpetas o archivos debe registrar `parentPath` en `ProjectFileEntity`.
- **Eliminación Segura**: Al borrar un directorio, se deben eliminar tanto el registro de la carpeta como sus hijos mediante `deletePathAndChildren` en `ProjectFileDao`.

---

## 🔧 Compilación y Verificación

- Antes de finalizar cualquier turno o entregar cambios, ejecuta la verificación con `compile_applet`.
- No alteres las versiones principales de Gradle ni plugins sin necesidad estricta.
