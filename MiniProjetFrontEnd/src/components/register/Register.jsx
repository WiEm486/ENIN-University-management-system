import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import './Register.css'
import Radio from '@mui/material/Radio';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import RadioGroup from '@mui/material/RadioGroup';
import Button from '@mui/material/Button';
import { useEffect, useState } from 'react';
import { FormGroup } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import img1 from "../../assets/register.png"
import img2 from "../../assets/Group 9.png"
import img3 from "../../assets/Group 236.png"
import Axios from '../../services/Axios';
import logoImage from "../../assets/logo.png"
import '../../App.css'

import Typewriter from './TypeWriter';
import { useUser } from '../UserProvider';
const Register = ({setUserConnected,setRole,userConnected}) => {
    const { setUser } = useUser();
    const [registerForm, setRegisterForm] = useState(true)
    const [dataTAb,setData]=useState(null)
    const initialRegisterValues = {
        cin : '',
        email : '',
        password : '',
        confirmPassword : '',
        role : ''
    }
    const initialLoginValues = {
        email : '',
        password : '',
        rememberMe : false
    }

    const [registerValues, setRegisterValues] = useState(initialRegisterValues)
    const [loginValues, setLoginValues] = useState(initialLoginValues)


    const handleChangeCin = (e) => {
        setRegisterValues({...registerValues, cin : e.target.value})
    }

    const handleChangeEmail = (e) => {
        setRegisterValues({...registerValues, email : e.target.value})
    }

    const handleChangePassword = (e) => {
        setRegisterValues({...registerValues, password : e.target.value})
    }

    const handleChangeConfirmPassword = (e) => {
        setRegisterValues({...registerValues, confirmPassword : e.target.value})
    }

    const handleChangeRole = (e) => {
        setRegisterValues({...registerValues, role : e.target.value})
    }

    const handleChangeRememberMe = (e) => {
        setLoginValues({...loginValues, rememberMe : e.target.checked})
    }

    const handleChangeLoginEmail = (e) => {
        setLoginValues({...loginValues, email : e.target.value})
    }

    const handleChangeLoginPassword = (e) => {
        setLoginValues({...loginValues, password : e.target.value})
    }


    const changeFormState = () => {
        setRegisterForm(!registerForm)
    }
    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);
  
    const handleMouseDownPassword = (event) => {
      event.preventDefault();
    };

    const handleRegister = () => {
        Axios.post('/auth/register', registerValues)
        .then(res => {
            console.log(res.data)
            setRegisterForm(false)
        })
        .catch(err => {
            console.log(err)
        })
    }
    const handleLogin = () => {
        const { email, password } = loginValues;
    
        fetch('http://localhost:8081/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        })
        .then(res => {
            if (res.ok) {
                // Vérification du type de contenu
                const contentType = res.headers.get('content-type');
                if (contentType && contentType.includes('application/json')) {
                    return res.json();
                  
                } else {
                    throw new Error('La réponse du serveur n\'est pas un objet JSON valide.');
                }
            } else {
                throw new Error('Erreur lors de la requête : statut ' + res.status);
            }
        })
        .then(data => {
            setUserConnected(true);
            console.log(data);
            setUser(data);
            setRole(data.role);
            localStorage.setItem('user', JSON.stringify({nom:data.nom,email:data.email,role:data.role,password:data.password}));
        })
        .catch(err => {
            console.error('Erreur lors de la requête :', err);
        });
    }
    
  return (
    <div className="register">
        <div className="formBox">
            <div className="logo">   <img src={logoImage} alt="MyIssatSo" style={{ height: '25vh',width:"25vh" }} /></div>
            <div className="formTitle">{ registerForm ? "S'inscrire" : "Bonjour à nouveau!"}</div>
            <div className="formSubTitle">
                { registerForm ? "Inscrivez-vous pour acceder a votre compte MyIssatSo" :
                 "Connectez-vous pour acceder a votre compte ENIN SCOPE"}
            </div>
            <Box
                component="form"
                sx={{
                '& .MuiTextField-root': { m: 1, width: '22vw' },
                }}
                noValidate
                autoComplete="off"
            >
                { registerForm ? <>
                    <div>
                    <TextField
                        required
                        id="outlined-required"
                        label="Numero Cin ou Passeport"
                        value={registerValues.cin}
                        onChange={handleChangeCin}
                    />
                    </div>
                    <div>
                    <TextField
                        required
                        id="outlined-required"
                        label="Email Institusionnel"
                        value={registerValues.email}
                        onChange={handleChangeEmail}
                    />
                    </div>
                    <div>
                    <TextField
                        required
                        id="outlined-required"
                        label="Mot De Passe"
                        value={registerValues.password}
                        onChange={handleChangePassword}
                    />
                    </div>
                    <div>
                    <TextField
                        required
                        id="outlined-required"
                        label="Confirmer Mot De Passe"
                        value={registerValues.confirmPassword}
                        onChange={handleChangeConfirmPassword}
                    />
                    </div>
                </>
                : <>
                    <div>
                    <TextField
                        required
                        id="outlined-required"
                        label="Email"
                        value={loginValues.email}
                        onChange={handleChangeLoginEmail}
                    />
                    </div>
                    <div>
                    <FormControl sx={{ m: 1, width: '22vw' }} variant="outlined">
                        <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
                        <OutlinedInput
                            id="outlined-adornment-password"
                            value={loginValues.password}
                            type={showPassword ? 'text' : 'password'}
                            onChange={handleChangeLoginPassword}
                            endAdornment={
                            <InputAdornment position="end">
                                <IconButton
                                aria-label="toggle password visibility"
                                onClick={handleClickShowPassword}
                                onMouseDown={handleMouseDownPassword}
                                edge="end"
                                
                                >
                                {showPassword ? <VisibilityOff /> : <Visibility />}
                                </IconButton>
                            </InputAdornment>
            }
            label="Password"
          />
        </FormControl>
                    </div>
                </>
                }
                { registerForm ? <RadioGroup
                    row
                    aria-labelledby="demo-row-radio-buttons-group-label"
                    name="row-radio-buttons-group"
                    style={{justifyContent:'center' , gap:'20px', marginTop:'20px'}}
                    onChange={handleChangeRole}
                    value={registerValues.role}
                >
                    <FormControlLabel value="student" control={<Radio />} label="Etudiant" />
                    <FormControlLabel value="teacher" control={<Radio />} label="Enseignant" />
                </RadioGroup>
                : 
                <FormGroup style={{ marginLeft : '10px'}}>
                    <FormControlLabel control={<Checkbox/>} label="Rester Connecté" onChange={handleChangeRememberMe} />
                </FormGroup>}
                { registerForm ? <Button variant="contained" disableElevation className='registerButton' onClick={handleRegister}>
                    S'inscrire
                </Button>
                : <Button variant="contained" disableElevation className='registerButton' onClick={handleLogin}>
                    Se Connecter
                </Button>}
                <div className="formSubTitle">{ registerForm ? "Avez vous déjà un compte?" : "Besoin d'un compte?"}
                <span onClick={changeFormState}>{ registerForm ? "Connecter" : "S'inscrire"}</span></div>
            </Box>
           
        </div>
        
        <div className="backgroundBox"  >
    

            <div style={{fontSize:"5em"}}></div>
             <br></br>
            <img src={img2} style={{width:"8vh",marginLeft:"70vh"}}></img>
            <div style={{fontSize:"5vh",fontFamily:"var(--big-font)",textAlign:"start",paddingLeft:"5vh",color:"var( --primary-color)", animation: "fadeIn 2s"}}>
    <Typewriter text={"Bonjour !"}></Typewriter> Bienvenue dans l'université de l'excellence et de l'innovation.
</div>

            <img alt='' style={{width:"40vw",height:"70vh"}} src={img1}></img>
        </div>
        
    </div>
  )
}

export default Register

