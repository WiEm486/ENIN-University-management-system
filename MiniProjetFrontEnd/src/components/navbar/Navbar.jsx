import React from 'react';
import './Navbar.css'
import { Link } from 'react-router-dom';
const  Navbar = (props) => {

  return (
  <div style={{display:"flex"}}>
    <div className="navbar">
        <div className="head"> 
          <div className="logo">MyIssatSo</div>
          {/* <div className="croix"><FontAwesomeIcon icon={faX} style={{cursor:'pointer'}} onClick={props.showNavbar}/></div> */}
        </div>
        <div className="navbarBody">
            <Link to="/EmploiEtudiant" className={`navLine ${props.navLineClicked === 'home' ? 'navClicked' : 'notClicked'}`} onClick={props.clickHome}>
                    <img src="./assets/dashIcon.png" alt=""  />
                    <div className="title" >Gérer Emploi Etudiant </div>
            </Link>
         
            <Link to="/emploiEnseignant" className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={props.clickDashboard}>
                    <img src="./assets/absenceIcon.png" alt="" />
                    <div className="title" >Gérer Emploi Enseignant  </div>
            </Link>

            <Link to="/emploiExamens" className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={props.clickDashboard}>
                    <img src="./assets/settingsIcon.png" alt="" />
                    <div className="title" >Gérer Emploi Examens </div>
            </Link>
            <Link to="" className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={props.clickDashboard}>
                    <img src="./assets/coursIcon.png" alt="" />
                    <div className="title" > Gérer Demande Rattrapages</div>
            </Link>
            <Link to="/ajouterEmploiExamen" className={`navLine ${props.navLineClicked === 'dashboard' ? 'navClicked' : 'notClicked'}`} onClick={props.clickDashboard}>
                    <img src="./assets/coursIcon.png" alt="" />
                    <div className="title" > Gérer Emploi Examen </div>
            </Link>
          
        </div>      
    </div>
    <div className="blur-overlay" onClick={props.showNavbar}></div>
  </div>
  )
}

export default Navbar