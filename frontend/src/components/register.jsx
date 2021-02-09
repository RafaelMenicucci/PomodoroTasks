import React, { useState, useEffect } from "react";
import api from '../services/api'

export default function Register(){

    const [states, setStates] = useState([]);

    useEffect(() => {
        api.get("/register").then(response => {
            setStates(response)
        })
    }, [])

    return (
        <div className = "register-container">
           {JSON.stringify(states)}
        </div>
    )
}