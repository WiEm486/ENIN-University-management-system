import React, { useEffect } from 'react';
import './Home.css';
import { Outlet } from 'react-router-dom';
import NavBarEtudiant from '../navbar/NavBarEtudiant';
import NavBarEnseignant from '../navbar/NavBarEnseignant';
import NavBarAdminSc from '../navbar/NavBarAdminSc';
import NavBarSuperAdmin from '../navbar/NavBarSuperAdmin';
import NavBarAdminEt from '../navbar/NavBarAdminEt';
import NavBarAdminChef from '../navbar/NavBarAdminChef';

const Home = ({ role, userConnected, setUserConnected  }) => {
  let NavBarComponent;

  // Sélectionnez le composant de barre de navigation approprié en fonction du rôle
  switch (role) {
    case 'ETUDIANT':
      NavBarComponent = NavBarEtudiant;
      break;
    case "ENSEIGNANT":
      NavBarComponent = NavBarEnseignant;
      break;

    case 'SUPER_ADMIN':
      NavBarComponent = NavBarSuperAdmin;
      break;
    case 'ADMIN_SCOLARITE':
      NavBarComponent = NavBarAdminSc;
      break;
    case 'ADMIN_ETUDIANT':
        NavBarComponent = NavBarAdminEt;
        break;
    case 'CHEF_DEPARTEMENT':
          NavBarComponent = NavBarAdminChef;
          break;
    default:
      // Gérez le cas où le rôle n'est pas valide ou non défini
      // eslint-disable-next-line react/display-name
      NavBarComponent = NavBarAdminEt;
  }

  return (
    <div className='home'>
      <NavBarComponent  userConnected={userConnected}  setUserConnected = {setUserConnected} />
    
      <Outlet />
    </div>
  );
};

export default Home;
