# 🔷⚡ Skill: C# / .NET Logic & WASM WebAssembly
- Programación C# moderna (.NET 8/9, C# 12+), orientada a objetos y funcional (LINQ, Async/Await, Generics, Pattern Matching).
- Estructura limpia y desacoplada para WebAssembly y Blazor:
  • `/Program.cs`: Punto de entrada .NET, métodos estáticos `[JSInvokable]` o lógica de servicios.
  • `/App.csproj`: Configuración de proyecto SDK .NET / Blazor WebAssembly.
  • Lógica modular, POCOs (Plain Old CLR Objects), Récords (`record`), e interfaces.
- Manejo explícito de excepciones (`try-catch-finally`, custom exceptions).
- Interop bidireccional entre C# .NET y JavaScript / DOM (`IJSRuntime` / JSImport / JSExport).
- Validación de datos y principios SOLID para máxima mantenibilidad.
