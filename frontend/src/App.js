import {BrowserRouter, Routes, Route} from "react-router-dom";
import Register from './Register';
import Login from './Login';
import './App.css';

function App() {
  return (
    <main className="App">
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="register" element={<Register />} />
      </Routes>
    </BrowserRouter>
    </main>
  );
}

export default App;
