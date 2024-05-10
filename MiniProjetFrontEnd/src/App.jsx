import './App.css'
import { Register ,Home } from './components'
import { useEffect, useState } from 'react'
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import CeChart  from "./components/supAdminPages/CeChart"
import { ThemeProvider, createTheme } from '@mui/material';

import Actualite from "./components/Etudiant/Actualite" 
import CoursParMatiere from './components/Etudiant/CoursParMatiere';
import EmploiEtudiant from './components/Etudiant/EmploiEtudiant';


import DemandeRat from "./components/Enseignant/DemandeRat"
import ActualitéE from './components/Enseignant/Actualite';
import TeacherDepotCours from './components/Enseignant/TeacherDepotCours';



import Matière from "./components/supAdminPages/Matière"
import ActualitéSup from "./components/supAdminPages/Actualité"
import  Enseignant from "./components/supAdminPages/Enseignant"
import  DashboradSup from "./components/supAdminPages/Dashboard2"
import  EtudiantSup from "./components/supAdminPages/Etudiant"
import Admin from './components/supAdminPages/Admin';
import AjouterEnseignant from "./components/supAdminPages/AjouterEnseignant"
import AjouterActualité from "./components/supAdminPages/AjouterActualité"
import AjouterMatière from "./components/supAdminPages/AjouterMatière"
import AjouterAdmin from "./components/supAdminPages/AjouterAdmin"
import AjouterEtudiant from "./components/supAdminPages/AjouterEtudiant"


import DemandeRattrapage from './components/AdminScPages/DemandeRattrapage';
import EmploiEnseignant from './components/AdminScPages/EmploiEnseignant';
import EmploiEtudiantAD from './components/AdminScPages/EmploiEtudiant';
import EmploiExamenAD from './components/AdminScPages/EmploiExamens';
import AjouterEmploi from './components/AdminScPages/AjouterEmploi';


import AjouterEtudiantET from './components/AdminEtPages/AjouterEtudiant';
import AjouterGroupe from './components/AdminEtPages/AjouterGroupe';
import DemandeEtudiant from './components/AdminEtPages/DemandeEtudiant';


import AffecterSpécialité from "./components/chefDepPages/AffecterSpecialite"
import AffecterMatière from "./components/chefDepPages/AffecterMatière"
import AjouterSpecialite from "./components/chefDepPages/AjouterSpecialite"
import GérerSpécialite from "./components/chefDepPages/Specialites"
import { useUser } from './components/UserProvider';


const theme = createTheme({

  components: {
    MuiPaper: {
      styleOverrides: {
        root: {
          borderRadius: '20px', // Applique un border radius de 20px à tous les composants Paper
          boxShadow: '0px 10px 20px rgba(0, 0, 0, 0.1)', // Ajoute une ombre douce
          padding: '20px', // Ajoute un espace intérieur
          marginBottom: '20px', // Ajoute un espacement en bas
          backgroundColor: '#fffff', // Couleur de fond pour le Paper
        },
      },
    },
    MuiTable: {
      styleOverrides: {
        root: {
          borderRadius: '20px', // Applique un border radius de 20px à tous les composants Table
          overflow: 'hidden', // Cache les coins arrondis en cas de débordement
        },
      },
    },
    MuiTableCell: {
      styleOverrides: {
        root: {
          // Supprime la bordure du bas des cellules
          padding: '16px', // Ajoute un espacement intérieur aux cellules
        },
        head: {
          backgroundColor: 'var(--third-color)', // Couleur de fond pour les cellules d'en-tête
          color: '#fff', // Couleur du texte pour les cellules d'en-tête
          fontWeight: 'bold', // Texte en gras pour les cellules d'en-tête
        },
      },
    },
    MuiButton: {
      styleOverrides: {
        root: {
          backgroundColor: '#FD661F', // Remplacez "your_color_here" par la couleur souhaitée,
          color:"white",
          borderRadius:"30px"
        },
      },
    },
  },
});
const App = () => {
  const [userConnected, setUserConnected] = useState(false)
  const [role, setRole] = useState("");
  const { setUser } = useUser();
  useEffect(() => {
    const storedUser = JSON.parse(localStorage.getItem('user'));
    if (storedUser && storedUser.email && storedUser.password) {
      setUser(localStorage.getItem('user'))
     const obj=JSON.parse(localStorage.getItem('user'));
     setRole(obj.role);
     setUserConnected(true)}
   
    
}, []);
  return (
    <ThemeProvider theme={theme}>
    <div>
      {userConnected ? 
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home  setUserConnected = {setUserConnected}  role={role} userConnected={userConnected}/>} >
          
           {/* Routes Etudiant */}
           <Route path="/ActualiteEtudiant" index element={<Actualite/>} />
           <Route path="/CoursEtudiant"  element={<CoursParMatiere/>} />
           <Route path="/EmploiEtudiant"  element={<EmploiEtudiant/>} />
            



           {/* Routes Enseignants */}


              <Route path="/ActualiteEnseignant" index element={<ActualitéE/>} />
              <Route path="/DeposeCours"  element={<TeacherDepotCours/>} />
              <Route path="/demandeRattrapage"  element={<DemandeRat/>} />

          {/* Routes Super Admin  */}
           
          <Route path="/GererMatieres" index element={<Matière/>} />
        
          <Route path="/GererActualite"  element={<ActualitéSup/>} />
          <Route path="/GererEnseignant"  element={<Enseignant/>} />
          <Route path="/GererEtudiants"  element={<EtudiantSup/>} />
          <Route path="/GererAdmin"  element={<Admin/>} />
          <Route path="/Dashborad"  element={<DashboradSup/>} />
          <Route path="/AjouterActualite"  element={<AjouterActualité/>} />
          <Route path="/AjouterAdmin"  element={<AjouterAdmin/>} />
       
          <Route path="/AjouterEtudiant"  element={<AjouterEtudiant/>} />
          <Route path="/Ajoutermatière"  element={<AjouterMatière/>} />
        
           {/* Route Admin Scolarite */}

          <Route path="/GererEmploiEnseignant" index element={<EmploiEnseignant/>} />
          <Route path="/GererEmploiEtudiant" index element={<EmploiEtudiantAD/>} />
          <Route path="/GererEmploiExamens" index element={<EmploiExamenAD/>} />
          <Route path="/GererDemandes" index element={<DemandeRattrapage/>} />
          <Route path="/ajouterEmploi" index element={<AjouterEmploi/>} />

          {/* Route Admin Et  */}

          <Route path="/AjouterGroupe" index element={<AjouterGroupe/>} />
          <Route path="/DemandeEtudiant" index element={<DemandeEtudiant/>} />
          <Route path="/AjouterEtudiantEt" index element={<AjouterEtudiantET/>} />
          


          {/* Route Chef Dep */}

           <Route path="/AffecterMatière" index element={<AffecterMatière/>} />
           <Route path="/AffecterSpécialité" index element={<AffecterSpécialité/>} />
           <Route path="/GérerSpécialite" index element={<GérerSpécialite/>} />
           <Route path="/AjouterSpecialite" index element={<AjouterSpecialite/>} />
      
           </Route>
         
        </Routes>
      </BrowserRouter>  
       : <Register setUserConnected = {setUserConnected} role={role} setRole={setRole} userConnected={userConnected}/> }
    </div>
    </ThemeProvider>
  )
}

export default App