import React from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import Navbar from './components/layout/Navbar';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
  <Navbar/>
  <Dashboard/>
    </div>
  );
}

export default App;
