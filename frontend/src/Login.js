import { useRef, useState, useEffect, useContext } from "react";
import axios from './api/axios';
import AuthContext from "./context/AuthProvider";
const LOGIN_URL = 'api/user/login';

const Login = () => {
    const {setAuth} = useContext(AuthContext);
    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);


    useEffect(()=> {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setErrMsg('');
    }, [user, pwd])


    const handleSubmit = async (e) => {
        e.preventDefault();
        
        
        if (!user || !pwd) {
            setErrMsg("Please provide Username and Password.");
            return;
        }
        try {
            const response = await axios.post(LOGIN_URL, 
                JSON.stringify({login: user, password: pwd}),
                {
                     headers: {' Content-Type' : 'application/json'},
                    //withCredentials: true
                }
            );
            console.log(JSON.stringify(response?.data));
            const accessToken = response?.data?.accessToken;
            const roles = response?.data?.roles;
            setAuth({user, pwd, roles, accessToken});
            setUser('');
            setPwd('');
            setSuccess(true);
        } catch (err) {
            if (!err?.response){
                setErrMsg('No Server Response.');
            }
            else if(err.response?.status === 400){
                setErrMsg('Missing Username or Password');
            }
            else if(err.response?.status === 401){
                setErrMsg('Incorrect Username or Password');
            }
            else {
                errMsg('Login Failed');
            }
            errRef.current.focus();
        }
        
    }
    

    return (
        <>
        { success ? (
            <h1> Successful login!</h1>
        ) : (
        <section>
            <h1>Login</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="username">
                Username:       
                </label>
                    <input 
                    type="text"
                    id="username"
                    ref={userRef}
                    autoComplete="off"
                    onChange={(e) => setUser(e.target.value)}
                    required
                    placeholder="Enter Username"
                    value={user}
                    />
                <label htmlFor="password">
                Password:
                </label>
                    <input 
                    type="password"
                    id="password"
                    value={pwd}
                    onChange={(e) => setPwd(e.target.value)}
                    required
                    />

            <button>Login</button>
            <p ref = {errRef} className={errMsg ? "errMsg" : "offscreen"} aria-live="assertive">{errMsg}</p>
        </form>
        <p>
            Don't have account? <br />
            <a href="/register/">Register</a>
        </p>
        
        </section>
        
    )}
    </>
    )
}

export default Login