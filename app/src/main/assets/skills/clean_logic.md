# ⚡ Skill: Lógica Robusta, Import Maps & Clean Code

## Principios de Programación
- **Principio de Responsabilidad Única (SRP)**: Cada función debe realizar una sola tarea bien definida.
- **Import Maps & ES Modules (Importación de Librerías npm sin Bundler)**:
  - Usa `<script type="importmap">` en el `<head>` de HTML para mapear nombres de paquetes npm a CDN de módulos ES (ej: `"react": "https://esm.sh/react@18.3.1"`, `"canvas-confetti": "https://esm.sh/canvas-confetti@1.9.3"`).
  - Carga JavaScript moderno usando `<script type="module" src="script.js"></script>` o React/JSX con `<script type="text/babel" data-type="module" src="app.js"></script>`.
  - Importa librerías directamente con sintaxis ES6: `import React, { useState } from 'react';` o `import confetti from 'canvas-confetti';`.
- **Manejo de Errores Explícito**: Usa bloques `try-catch`, validaciones nulas y muestra mensajes de error útiles al usuario en lugar de fallar silenciosamente.
- **JavaScript ES6+ Moderno**: Prioriza `const/let`, arrow functions, `async/await`, destructuring y arreglos declarativos (`map`, `filter`, `reduce`).
- **Validación de Entradas**: Sanitiza y valida todas las entradas de usuario antes de procesarlas o guardarlas.
- **Optimización y Evitar Fugas de Memoria**: Limpia timers y eventos globales innecesarios.
