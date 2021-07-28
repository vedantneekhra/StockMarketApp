import React from 'react';
import './App.css';
import LandingPage from "./landing/LandingPage";
import LoginPage from "./login/LoginPage";
import RegisterPage from "./login/RegisterPage";
import Dashboard from "./dashboard/Dashboard";
import AdminLoginPage from './adminLogin/AdminLoginPage';
import {Switch, Route} from "react-router-dom";
import AdminDashboard from './adminDashboard/AdminDashboard';

function App() {
  return (
    <main>
      <Switch>
        <Route exact path="/" component={LandingPage} />
        <Route path="/login" component={LoginPage} />
        <Route path="/admin/login" component={AdminLoginPage} />
        <Route path="/register" component={RegisterPage} />
        <Route path="/dashboard" component={Dashboard} />
        <Route path="/admin/dashboard" component={AdminDashboard} />
      </Switch>
      {/* <LandingPage /> */}
    </main>
  );
}

export default App;
