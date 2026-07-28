# 🗺️ DevStudio - Roadmap de Desarrollo

Este documento detalla el plan de evolución técnica de DevStudio, destacando las fases completadas y las próximas metas de integración de tecnologías.

---

## 🟢 Fase 1: Núcleo e Infraestructura (Completado)
- [x] **Arquitectura Políglota**: Soporte nativo para proyectos Web (HTML, CSS, JS), Kotlin y Rust.
- [x] **Editor de Código Avanzado**: Resaltado de sintaxis con `SyntaxHighlighter` y soporte para archivos `.md` con renderizado en tiempo real.
- [x] **Agente de IA Integrado**: Integración con **Google Gemini** y **OpenRouter AI**.
- [x] **Sistema de Herramientas (Tool Calling)**: Ejecución de comandos de archivos (`create_file`, `edit_file`, `delete_file`, `get_project_structure`) con buffers acumulativos streaming.
- [x] **Gestión de Archivos con Room DB**: Estructura jerárquica con `parentPath` e `isDirectory`.

---

## 🟢 Fase 2: Módulo React ⚛️ & Import Maps (Completado ✅)
- [x] **Soporte para Módulo CDN / Import Maps de React 18**:
  - Habilitado el entorno ligero de **React 18 + ReactDOM + Babel Standalone + Import Maps (`<script type="importmap">`)**.
  - Mantiene la aplicación liviana (bajo tamaño de APK) resolviendo paquetes npm directamente vía CDN (`esm.sh`).
- [x] **Renderizado de JSX e Importación de Módulos ES**:
  - Transpilación e interpretación en tiempo real de JSX mediante Babel standalone (`data-type="module"`).
  - Importación directa de bibliotecas npm (`import ... from 'paquete'`) en la vista previa del proyecto.
- [x] **Generador de Plantillas React + ES Modules**:
  - El Agente de IA genera proyectos de React basados en componentes funcionales, hooks (`useState`, `useEffect`), Módulos ES e Import Maps.

---

## 🔮 Fase 3: Futuras Integraciones (Planificadas)
- [ ] Soporte para Frameworks CSS (Tailwind CDN / Bootstrap).
- [ ] Integración con TypeScript nativo en navegador/WebView.
- [ ] Exportación directa de proyectos como ZIP y sincronización con GitHub Releases.
