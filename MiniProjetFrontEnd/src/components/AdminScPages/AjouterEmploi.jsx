import React, { useState, useEffect } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Button, Box, MenuItem } from '@mui/material';
import { useParams } from 'react-router-dom';
//import MatiereService from './services/MatiereService';
//import EnseignantService from './services/EnseignantService';
//import SalleService from './services/SalleService';
//import EmploiService from './services/EmploiService';

const AjouterEmploi = () => {
  const [jour, setJour] = useState('');
  const [debut, setDebut] = useState('');
  const [fin, setFin] = useState('');
  const [matiereId, setMatiereId] = useState('');
  const [enseignantId, setEnseignantId] = useState('');
  const [type, setType] = useState('');
  const [salleId, setSalleId] = useState('');
  const [regime, setRegime] = useState('');
  const [emploiDuTemps, setEmploiDuTemps] = useState([]);
  const [matieres, setMatieres] = useState([]);
  const [enseignants, setEnseignants] = useState([]);
  const [salles, setSalles] = useState([]);
  const { id } = useParams();

  // useEffect(() => {
  //   fetchMatieres();
  //   fetchEnseignants();
  //   fetchSalles();
//     getEmploiById();
  // }, []);

  // const fetchMatieres = async () => {
  //   try {
  //     const data = await MatiereService.getMatieres();
  //     setMatieres(data);
  //   } catch (error) {
  //     console.error('Erreur lors de la récupération des matières:', error);
  //   }
  // };

  // const fetchEnseignants = async () => {
  //   try {
  //     const data = await EnseignantService.getEnseignants();
  //     setEnseignants(data);
  //   } catch (error) {
  //     console.error('Erreur lors de la récupération des enseignants:', error);
  //   }
  // };

  // const fetchSalles = async () => {
  //   try {
  //     const data = await SalleService.getSalles();
  //     setSalles(data);
  //   } catch (error) {
  //     console.error('Erreur lors de la récupération des salles:', error);
  //   }
  // };


  // const getEmploiById=async()=>{
  //   try {
  //     //     const data = await EmploiService.getEmploiById(id);
  //     //     setEmploiduTemps(data);
  //     //   } catch (error) {
  //     //     console.error('Erreur lors de la récupération des enseignants:', error);
  //     //   }
    
  // }



  // const handleAddLigne = async () => {
  //   const newLigne = {
  //     jour,
  //     debut,
  //     fin,
  //     matiereId,
  //     enseignantId,
  //     type,
  //     salleId,
  //     regime,
  //   };

  //   try {
  //     // Ajouter l'emploi du temps à la base de données
  //     const data = await EmploiService.addEmploi(newLigne);
  //     setEmploiDuTemps([...emploiDuTemps, data]);
  //   } catch (error) {
  //     console.error('Erreur lors de l\'ajout de l\'emploi du temps:', error);
  //   }

  //   // Réinitialiser les champs du formulaire
  //   setJour('');
  //   setDebut('');
  //   setFin('');
  //   setMatiereId('');
  //   setEnseignantId('');
  //   setType('');
  //   setSalleId('');
  //   setRegime('');
  // };

  return (
    <>
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>

    <h2>Ajouter une ligne à l'emploi du temps</h2>
      <div >
      <form  style={{display:"grid", gridTemplateColumns:"repeat(3, 2fr)", gap:"5vh", marginTop:"5vh"}}>
        <TextField label="Jour"  value={jour} onChange={(e) => setJour(e.target.value)} />
        <TextField label="Début" value={debut} onChange={(e) => setDebut(e.target.value)} />
        <TextField label="Fin" value={fin} onChange={(e) => setFin(e.target.value)} />
        <TextField select label="Matière" value={matiereId} onChange={(e) => setMatiereId(e.target.value)}>
          {matieres.map((matiere) => (
            <MenuItem key={matiere.id} value={matiere.id}>{matiere.nom}</MenuItem>
          ))}
        </TextField>
        <TextField select label="Enseignant" value={enseignantId} onChange={(e) => setEnseignantId(e.target.value)}>
          {enseignants.map((enseignant) => (
            <MenuItem key={enseignant.id} value={enseignant.id}>{enseignant.nom}</MenuItem>
          ))}
        </TextField>
        <TextField label="Type" value={type} onChange={(e) => setType(e.target.value)} />
        <TextField select label="Salle" value={salleId} onChange={(e) => setSalleId(e.target.value)}>
          {salles.map((salle) => (
            <MenuItem key={salle.id} value={salle.id}>{salle.nom}</MenuItem>
          ))}
        </TextField>
        <TextField label="Régime" value={regime} onChange={(e) => setRegime(e.target.value)} />
      </form>
      <Button variant="contained"  style={{marginTop:"5vh",marginBottom:"5vh"}}>Ajouter</Button>
      </div>
     
      <TableContainer>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Jour</TableCell>
              <TableCell>Début</TableCell>
              <TableCell>Fin</TableCell>
              <TableCell>Matière</TableCell>
              <TableCell>Enseignant</TableCell>
              <TableCell>Type</TableCell>
              <TableCell>Salle</TableCell>
              <TableCell>Régime</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {emploiDuTemps.map((ligne) => (
              <TableRow key={ligne.id}>
                <TableCell>{ligne.jour}</TableCell>
                <TableCell>{ligne.debut}</TableCell>
                <TableCell>{ligne.fin}</TableCell>
                <TableCell>{ligne.matiere}</TableCell>
                <TableCell>{ligne.enseignant}</TableCell>
                <TableCell>{ligne.type}</TableCell>
                <TableCell>{ligne.salle}</TableCell>
                <TableCell>{ligne.regime}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
    </div>
    </>
  );
};

export default AjouterEmploi;
