package com.example.data.repository.delegate.template

import com.example.data.db.ProjectFileEntity

object ReactPureTemplateProvider {
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
                      <title>React 18 + ES Modules - DevStudio IDE</title>
                      <link rel="stylesheet" href="style.css">
                      <!-- Import Map para resolución nativa de paquetes npm vía esm.sh -->
                      <script type="importmap">
                      {
                        "imports": {
                          "react": "https://esm.sh/react@18.3.1",
                          "react-dom/client": "https://esm.sh/react-dom@18.3.1/client",
                          "canvas-confetti": "https://esm.sh/canvas-confetti@1.9.3"
                        }
                      }
                      </script>
                      <!-- Babel Standalone para transpilar JSX en tiempo real -->
                      <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
                    </head>
                    <body>
                      <div id="root"></div>

                      <!-- Carga de app.js con Babel y soporte para ES Modules (data-type="module") -->
                      <script type="text/babel" data-type="module" src="app.js"></script>
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
                    import React, { useState } from 'react';
                    import ReactDOM from 'react-dom/client';
                    import confetti from 'canvas-confetti';

                    function Header({ theme, toggleTheme }) {
                      return (
                        <header className="header-card">
                          <div className="header-title-row">
                            <div className="brand">
                              <span className="react-icon">⚛️</span>
                              <div>
                                <h2>React 18 + ES Modules</h2>
                                <p className="subtitle">Desarrollado con Import Maps en DevStudio</p>
                              </div>
                            </div>
                            <button className="btn-icon" onClick={toggleTheme} title="Cambiar Tema">
                              {theme === 'dark' ? '☀️' : '🌙'}
                            </button>
                          </div>
                        </header>
                      );
                    }

                    function ConfettiCard() {
                      const triggerConfetti = () => {
                        confetti({
                          particleCount: 100,
                          spread: 80,
                          origin: { y: 0.6 }
                        });
                      };

                      return (
                        <div className="card">
                          <h3>🎉 Librerías npm con Import Maps</h3>
                          <p style={{ fontSize: '0.85rem', opacity: 0.8 }}>
                            Importa cualquier librería (ej: <code>canvas-confetti</code>) sin Node.js usando ES Modules.
                          </p>
                          <button className="btn btn-primary" onClick={triggerConfetti}>
                            🎊 Celebrar con Confeti ES Module
                          </button>
                        </div>
                      );
                    }

                    function CounterCard() {
                      const [count, setCount] = useState(0);

                      return (
                        <div className="card">
                          <h3>🔢 Contador Interactivo React</h3>
                          <div className="counter-value">{count}</div>
                          <div className="button-group">
                            <button className="btn btn-secondary" onClick={() => setCount(c => c - 1)}>- Disminuir</button>
                            <button className="btn btn-outline" onClick={() => setCount(0)}>Reiniciar</button>
                            <button className="btn btn-primary" onClick={() => setCount(c => c + 1)}>+ Incrementar</button>
                          </div>
                        </div>
                      );
                    }

                    function TodoListCard() {
                      const [todos, setTodos] = useState([
                        { id: 1, text: '⚛️ Integrar React 18 con Import Maps', completed: true },
                        { id: 2, text: '📦 Importar librerías npm desde esm.sh', completed: true },
                        { id: 3, text: '📱 Crear componentes React en DevStudio', completed: false }
                      ]);
                      const [input, setInput] = useState('');
                      const [filter, setFilter] = useState('all');

                      const addTodo = (e) => {
                        e.preventDefault();
                        if (!input.trim()) return;
                        setTodos([...todos, { id: Date.now(), text: input.trim(), completed: false }]);
                        setInput('');
                      };

                      const toggleTodo = (id) => {
                        setTodos(todos.map(t => t.id === id ? { ...t, completed: !t.completed } : t));
                      };

                      const deleteTodo = (id) => {
                        setTodos(todos.filter(t => t.id !== id));
                      };

                      const filteredTodos = todos.filter(t => {
                        if (filter === 'active') return !t.completed;
                        if (filter === 'completed') return t.completed;
                        return true;
                      });

                      return (
                        <div className="card">
                          <h3>📋 Lista de Tareas React State</h3>
                          <form onSubmit={addTodo} className="todo-form">
                            <input
                              type="text"
                              value={input}
                              onChange={(e) => setInput(e.target.value)}
                              placeholder="Nueva tarea React..."
                              className="input-field"
                            />
                            <button type="submit" className="btn btn-primary">Añadir</button>
                          </form>

                          <div className="filter-chips">
                            <button
                              className={"chip " + (filter === 'all' ? 'active' : '')}
                              onClick={() => setFilter('all')}
                            >
                              Todas ({todos.length})
                            </button>
                            <button
                              className={"chip " + (filter === 'active' ? 'active' : '')}
                              onClick={() => setFilter('active')}
                            >
                              Pendientes ({todos.filter(t => !t.completed).length})
                            </button>
                            <button
                              className={"chip " + (filter === 'completed' ? 'active' : '')}
                              onClick={() => setFilter('completed')}
                            >
                              Completadas ({todos.filter(t => t.completed).length})
                            </button>
                          </div>

                          <ul className="todo-list">
                            {filteredTodos.map(todo => (
                              <li key={todo.id} className={"todo-item " + (todo.completed ? 'completed' : '')}>
                                <span onClick={() => toggleTodo(todo.id)} className="todo-text">
                                  {todo.completed ? '✅ ' : '⏳ '} {todo.text}
                                </span>
                                <button className="btn-delete" onClick={() => deleteTodo(todo.id)}>🗑️</button>
                              </li>
                            ))}
                            {filteredTodos.length === 0 && (
                              <li className="empty-message">No hay tareas en esta categoría.</li>
                            )}
                          </ul>
                        </div>
                      );
                    }

                    function App() {
                      const [theme, setTheme] = useState('dark');

                      const toggleTheme = () => {
                        setTheme(prev => prev === 'dark' ? 'light' : 'dark');
                      };

                      return (
                        <div className={"app-container theme-" + theme}>
                          <Header theme={theme} toggleTheme={toggleTheme} />
                          <ConfettiCard />
                          <CounterCard />
                          <TodoListCard />
                          <footer className="footer-info">
                            <p>Procesado por React 18 + Import Maps ES Modules en DevStudio</p>
                          </footer>
                        </div>
                      );
                    }

                    const root = ReactDOM.createRoot(document.getElementById('root'));
                    root.render(<App />);
                """.trimIndent()
            ),
            ProjectFileEntity(
                projectId = projectId,
                name = "style.css",
                path = "/style.css",
                extension = "css",
                content = """
                    :root {
                      --bg-dark: #121318;
                      --card-dark: #1A1C23;
                      --border-dark: #2D303E;
                      --text-dark: #F1F5F9;
                      --subtext-dark: #94A3B8;

                      --bg-light: #F8FAFC;
                      --card-light: #FFFFFF;
                      --border-light: #E2E8F0;
                      --text-light: #0F172A;
                      --subtext-light: #64748B;

                      --primary: #61DAFB;
                      --primary-hover: #38BDF8;
                      --accent: #10B981;
                      --danger: #EF4444;
                    }

                    * {
                      box-sizing: border-box;
                      margin: 0;
                      padding: 0;
                      transition: background-color 0.2s ease, color 0.2s ease;
                    }

                    body {
                      font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
                      display: flex;
                      justify-content: center;
                      min-height: 100vh;
                    }

                    #root {
                      width: 100%;
                      display: flex;
                      justify-content: center;
                    }

                    .app-container {
                      width: 100%;
                      max-width: 540px;
                      padding: 20px;
                      display: flex;
                      flex-direction: column;
                      gap: 16px;
                      min-height: 100vh;
                    }

                    .theme-dark {
                      background-color: var(--bg-dark);
                      color: var(--text-dark);
                    }

                    .theme-light {
                      background-color: var(--bg-light);
                      color: var(--text-light);
                    }

                    .header-card {
                      padding: 16px 20px;
                      border-radius: 12px;
                    }

                    .theme-dark .header-card,
                    .theme-dark .card {
                      background-color: var(--card-dark);
                      border: 1px solid var(--border-dark);
                    }

                    .theme-light .header-card,
                    .theme-light .card {
                      background-color: var(--card-light);
                      border: 1px solid var(--border-light);
                      box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05);
                    }

                    .header-title-row {
                      display: flex;
                      justify-content: space-between;
                      align-items: center;
                    }

                    .brand {
                      display: flex;
                      align-items: center;
                      gap: 12px;
                    }

                    .react-icon {
                      font-size: 2rem;
                      animation: spin 12s linear infinite;
                    }

                    @keyframes spin {
                      from { transform: rotate(0deg); }
                      to { transform: rotate(360deg); }
                    }

                    .subtitle {
                      font-size: 0.8rem;
                      opacity: 0.7;
                    }

                    .card {
                      padding: 20px;
                      border-radius: 12px;
                      display: flex;
                      flex-direction: column;
                      gap: 14px;
                    }

                    .counter-value {
                      font-size: 3.2rem;
                      font-weight: 800;
                      text-align: center;
                      color: var(--primary);
                      margin: 10px 0;
                    }

                    .button-group {
                      display: flex;
                      gap: 8px;
                    }

                    .btn {
                      padding: 10px 16px;
                      border-radius: 8px;
                      font-weight: 600;
                      cursor: pointer;
                      border: none;
                      font-size: 0.9rem;
                    }

                    .btn-primary {
                      background-color: #0284C7;
                      color: white;
                    }

                    .btn-secondary {
                      background-color: #334155;
                      color: white;
                    }

                    .btn-outline {
                      background-color: transparent;
                      border: 1px solid var(--border-dark);
                      color: inherit;
                    }

                    .btn-icon {
                      background: none;
                      border: none;
                      font-size: 1.4rem;
                      cursor: pointer;
                    }

                    .todo-form {
                      display: flex;
                      gap: 8px;
                    }

                    .input-field {
                      flex: 1;
                      padding: 10px 14px;
                      border-radius: 8px;
                      border: 1px solid var(--border-dark);
                      background-color: transparent;
                      color: inherit;
                      font-size: 0.9rem;
                    }

                    .filter-chips {
                      display: flex;
                      gap: 6px;
                    }

                    .chip {
                      padding: 6px 12px;
                      border-radius: 20px;
                      border: 1px solid var(--border-dark);
                      background: transparent;
                      color: inherit;
                      font-size: 0.75rem;
                      cursor: pointer;
                    }

                    .chip.active {
                      background-color: #0284C7;
                      color: white;
                      border-color: #0284C7;
                    }

                    .todo-list {
                      list-style: none;
                      display: flex;
                      flex-direction: column;
                      gap: 8px;
                    }

                    .todo-item {
                      display: flex;
                      justify-content: space-between;
                      align-items: center;
                      padding: 10px 12px;
                      border-radius: 8px;
                      background-color: rgba(255, 255, 255, 0.03);
                      border: 1px solid var(--border-dark);
                    }

                    .todo-item.completed .todo-text {
                      text-decoration: line-through;
                      opacity: 0.5;
                    }

                    .todo-text {
                      cursor: pointer;
                      font-size: 0.9rem;
                    }

                    .btn-delete {
                      background: none;
                      border: none;
                      cursor: pointer;
                      opacity: 0.7;
                    }

                    .btn-delete:hover {
                      opacity: 1;
                    }

                    .empty-message {
                      text-align: center;
                      padding: 12px;
                      font-size: 0.85rem;
                      opacity: 0.6;
                    }

                    .footer-info {
                      text-align: center;
                      font-size: 0.75rem;
                      opacity: 0.6;
                      margin-top: auto;
                      padding-top: 10px;
                    }
                """.trimIndent()
            )
        )
    }
}
