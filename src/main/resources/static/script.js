// Carrega tarefas ao abrir
window.onload = loadTasks;

function loadTasks() {
    fetch('http://localhost:8080/tasks')
        .then(response => response.json())
        .then(tasks => {
            const taskList = document.getElementById("taskList");
            taskList.innerHTML = "";

            tasks.forEach(task => {
                const li = document.createElement("li");
                li.textContent = task.title;
                if(task.completed) li.classList.add("completed");

                // Alterna completed ao clicar na tarefa
                li.addEventListener("click", function() {
                    fetch(`http://localhost:8080/tasks/${task.id}`, {
                        method: 'PUT',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({ title: task.title, completed: !task.completed })
                    })
                        .then(() => loadTasks());
                });

                const deleteBtn = document.createElement("button");
                deleteBtn.textContent = "Excluir";
                deleteBtn.className = "delete";
                deleteBtn.onclick = function() {
                    fetch(`http://localhost:8080/tasks/${task.id}`, {
                        method: 'DELETE'
                    })
                        .then(() => loadTasks());
                };

                li.appendChild(deleteBtn);
                taskList.appendChild(li);
            });
        })
        .catch(error => console.error('Erro ao carregar tarefas:', error));
}

function addTask() {
    const taskInput = document.getElementById("taskInput");
    const taskText = taskInput.value.trim();
    if (taskText === "") {
        alert("Digite uma tarefa!");
        return;
    }

    fetch('http://localhost:8080/tasks', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ title: taskText, completed: false })
    })
        .then(response => response.json())
        .then(() => {
            loadTasks();
            taskInput.value = "";
        })
        .catch(error => console.error('Erro ao adicionar tarefa:', error));
}
