import React from 'react';
import './Navbar.css'
import { Link, useNavigate } from 'react-router-dom';
import HomeIcon from '@mui/icons-material/Home';
import SchoolIcon from '@mui/icons-material/School';
import ScheduleIcon from '@mui/icons-material/Schedule';
import EventNoteIcon from '@mui/icons-material/EventNote';
import { useUser } from '../UserProvider';
import logoImage from "../../assets/logo.png"
import { IconButton } from '@mui/material';
import { Logout } from '@mui/icons-material';
import ExitToAppIcon from '@mui/icons-material/ExitToApp';

const NavBarAdminChef = (props) => {
    const { user } = useUser();
    const navigate = useNavigate();
    

    const handleLogout = () => {
      // Mettez ici la logique de déconnexion si nécessaire
      // Par exemple, déconnectez l'utilisateur de sa session ou supprimez ses données de session
      
      // Redirection vers la page d'inscription (ou une autre page de votre choix)
      navigate('/register');
    };
    return (
        <div style={{ display: "flex" }}>
            <div className="navbar">
                <div className="head">
           
       
                    <div className="logo">ENIN SCOPE</div>
             
                  
                </div>

                <div>Bienvenue, {user?.prenom} !</div>
                <div className="navbarBody">
                    <Link to="/GérerSpécialite" className={`navLine ${props.navLineClicked === 'home' ? 'navClicked' : 'notClicked'}`} onClick={props.clickHome}>
                        <HomeIcon />
                        <div className="title">Gérer Spécialité</div>
                    </Link>
                    <Link to="/AffecterSpécialité" className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={props.clickDashboard}>
                        <SchoolIcon />
                        <div className="title">Affecter Spécialité</div>
                    </Link>
                    <Link to="/AffecterMatière" className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={props.clickDashboard}>
                        <ScheduleIcon />
                        <div className="title">Affecter Matière</div>
                    </Link>
                     <Link  className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={()=>{props.setUserConnected(false);localStorage.removeItem('user');navigate("/register")}}>
                     <ExitToAppIcon />
                        <div className="title">Déconnexion </div>
                    </Link>
                </div>
            </div>
            <div className="blur-overlay" onClick={props.showNavbar}></div>

            <IconButton onClick={handleLogout}>
      <Logout />
    </IconButton>
        </div>
    )
}

export default NavBarAdminChef ;
