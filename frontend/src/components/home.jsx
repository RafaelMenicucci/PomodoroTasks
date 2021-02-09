import React from 'react';
import {useHistory} from 'react-router-dom'
import "./styles/home.css"

export default function Home(){

  const history = useHistory();
  
  async function handleClickLogin() {
    try{
      history.push("/login")
    } catch (err){
      alert(err);
    }
  }

  async function handleClickRegister() {
    try{
      history.push("/register")
    } catch (err){
      alert(err);
    }
  }

  return (
    <div>
      <div className = "home-container">
        <h1>POMODORO TASKS</h1>
      </div>
      <div className="buttons">
        <button className="btn btn-primary" onClick={handleClickLogin}>Login</button>
      </div>
      <div className="buttons">
        <button className="btn btn-primary" onClick={handleClickRegister}>Register</button>
      </div>
    </div>
  )
}
