import React from 'react'
import { BrowserRouter, Route, Switch} from 'react-router-dom';
import Home from './components/home';
import Register from "./components/register"
import Tasks from './components/tasks';

const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path="/" exact component={Home}/>
            <Route path="/register" exact component={Register}/>
            <Route path="/tasks" exact component={Tasks}/>
            
        </Switch>
    </BrowserRouter>
)


export default Routes;