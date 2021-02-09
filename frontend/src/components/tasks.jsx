import React, { useState, useEffect } from 'react'
import api from '../services/api'

export default function Tasks(){

    const [states, setStates] = useState([]);
    const [description, setDescription] = useState("");
    const [priority, setPriority] = useState("");

    useEffect(() => {
        api.get("/tasks").then(response => {
            setStates(response.data)
        })
    }, [])

    async function handlecreateTask(e) {
        e.preventDefault();

        const data = {
            description,
            priority,
        };
    
        try {
            await api.post("tasks", data);
      
            alert("Task Criada");
      
            window.location.reload();
          } catch (err) {
            alert(err);
          }
    }

    return(
        <div className="Geral">
            <div className="create-tasks">
            <form onSubmit={handlecreateTask}>
                <textarea
                    placeholder="Descrição da tarefa"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                />

                <div class='col-md-4 col-form-label text-md-right btn-group'>
                    <label className="btn btn-secondary">
                        <input type="radio" name="prioridade" value="1" id='default' onClick={(e) => setPriority(e.target.value)}/> priority 1
                    </label>
                    <label className="btn btn-secondary">
                        <input type="radio" name="prioridade" value="2" onClick={(e) => setPriority(e.target.value)}/> priority  2
                    </label>
                </div>

                <button className="btn btn-success" type="submit">
                    Criar Tarefa
                </button>
            </form>
            </div>
            
            <div className="show-tasks">
                {states.map((key) => <li>{key.description}</li>)}
            </div>
        </div>
    )
}