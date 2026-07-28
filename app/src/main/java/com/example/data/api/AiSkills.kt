package com.example.data.api

object AiSkills {

    val TOOL_USAGE_SKILL = """
        🛠️ [SKILL: CORE / HERRAMIENTAS - /skills/core/tool_usage.md]
        - Usar `get_project_structure` para explorar la jerarquía de carpetas.
        - Usar `read_file` para inspeccionar el contenido de un archivo antes de modificarlo.
        - Usar `edit_file` para ediciones quirúrgicas de líneas específicas. 
          ⛔ ESTRICTAMENTE PROHIBIDO: Reescribir un archivo completo usando `edit_file`. `target_content` debe ser únicamente el bloque exacto a cambiar.
        - Usar `create_file` para crear nuevos archivos con su contenido inicial.
        - Usar `delete_file` únicamente para eliminar un archivo o carpeta.
        - Usar `get_diagnostics` para consultar los logs de la Consola de Diagnóstico en Vivo y errores del Linter.
    """.trimIndent()

    val WEB_SKILLS = """
        🌐 [SKILLS: WEB HTML5 / CSS / JS - /skills/web/]
        - **UI/UX Design (`web_design.md`)**: Material Design 3, paletas de color coherentes, jerarquía visual, bordes suaves y micro-interacciones.
        - **Clean Logic & ES Modules (`web_logic.md`)**: JavaScript ES6+, Import Maps (`<script type="importmap">`) para librerías npm desde CDNs ES (`https://esm.sh/`), Módulos ES (`type="module"`), manejo de errores y validaciones.
        - **Responsive Design (`web_responsive.md`)**: Mobile-First, Flexbox, CSS Grid (`auto-fit`), Media Queries y prevención de scroll horizontal.
    """.trimIndent()

    val REACT_SKILLS = """
        ⚛️ [SKILLS: REACT 18 FRAMEWORK - /skills/react/]
        - **React UI/UX Design (`react_design.md`)**: Componentes funcionales M3/Tailwind, estados visuales claros (Loading, Success, Empty, Error), animaciones y temas dinámicos.
        - **React Logic & Hooks (`react_logic.md`)**: Hooks (`useState`, `useEffect`, `useCallback`, `useMemo`, `useContext`), JSX transpilado con Babel standalone, Import Maps (`react`, `react-dom/client`, `lucide-react`, `canvas-confetti` vía `esm.sh`), e inmutabilidad de estado.
        - **React Responsive (`react_responsive.md`)**: Layouts adaptativos en JSX, componentes móviles y de escritorio, touch targets accesibles (48px min).
    """.trimIndent()

    val CPP_SKILLS = """
        ⚡ [SKILLS: C++ MODULAR - /skills/cpp/]
        - **C++ Web (`cpp_web.md`)**: Compilación WebAssembly / Emscripten, rutina `extern "C"`, `CMakeLists.txt` y runner web interactivo con consola stdout en vivo.
        - **C++ App (`cpp_app.md`)**: Android NDK nativo, JNI Bridge (`Java_com_example_native_CppEngine_...`), compilación de librería `.so` (`libcppengine.so`) y simulador móvil de prueba JNI.
    """.trimIndent()

    val CSHARP_SKILLS = """
        🔷 [SKILLS: C# / .NET WEBASSEMBLY - /skills/csharp/]
        - **C# Design (`csharp_design.md`)**: Estilado Blazor / M3 con tonos .NET, tarjetas interactivas y paneles de métricas de ejecución.
        - **C# Logic & WASM (`csharp_logic.md`)**: C# .NET moderno (C# 12+ / .NET 8/9), LINQ, Async/Await, JSInterop (`[JSInvokable]`), archivos `/Program.cs` y `/App.csproj`.
        - **C# Responsive (`csharp_responsive.md`)**: Layouts adaptativos Mobile-First para aplicaciones web en C# .NET WebAssembly.
    """.trimIndent()

    fun getAllSkillsSystemPrompt(): String {
        return """
            🚀 HABILIDADES ESPECIALIZADAS ACTIVAS ORGANIZADAS POR MÓDULOS (/skills/):
            
            $TOOL_USAGE_SKILL
            
            $WEB_SKILLS
            
            $REACT_SKILLS
            
            $CPP_SKILLS
            
            $CSHARP_SKILLS
        """.trimIndent()
    }
}

