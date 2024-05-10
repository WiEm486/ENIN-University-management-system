import React, { useState, useEffect } from 'react';
import { FormControl, InputLabel, MenuItem, Select, Button, Grid, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
import { useNavigate } from 'react-router-dom';
//import SpecialiteService from './path/to/SpecialiteService'; // Assurez-vous d'importer correctement votre service SpecialiteService
//import GroupeService from './path/to/GroupeService'; // Assurez-vous d'importer correctement votre service GroupeService

const EmploiEtudiant = () => {
  const [specialites, setSpecialites] = useState([]);
  const [selectedSpecialite, setSelectedSpecialite] = useState('');
  const [groupes, setGroupes] = useState([]);
  const [selectedGroupe, setSelectedGroupe] = useState('');
  const [emploiDuTemps, setEmploiDuTemps] = useState([]);
  
  const navigate=useNavigate();

  // useEffect(() => {
  //   SpecialiteService.getSpecialites()
  //     .then((data) => setSpecialites(data))
  //     .catch((error) => console.error('Erreur lors de la récupération des spécialités:', error));
  // }, []);

  // useEffect(() => {
  //   if (selectedSpecialite) {
  //     GroupeService.getGroupes(selectedSpecialite)
  //       .then((data) => setGroupes(data))
  //       .catch((error) => console.error('Erreur lors de la récupération des groupes:', error));
  //   }
  // }, [selectedSpecialite]);

  // useEffect(() => {
  //   if (selectedGroupe && selectedSpecialite) {
  //     GroupeService.getEmploi(selectedGroupe, selectedSpecialite)
  //       .then((data) => setEmploiDuTemps(data))
  //       .catch((error) => console.error('Erreur lors de la récupération de l\'emploi du temps:', error));
  //   }
  // }, [selectedGroupe, selectedSpecialite]);

  const handleSpecialiteChange = (event) => {
    setSelectedSpecialite(event.target.value);
  };

  const handleGroupeChange = (event) => {
    setSelectedGroupe(event.target.value);
  };

  const handleAjouterEmploi = () => {
    navigate(`/ajouterEmploi/${emploiDuTemps.id}`);
  }

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>

        <h2 >Emploi du temps Etudiant </h2>
        <div style={{ display: "flex", gap: "10vw", marginTop: "3vw" }}>
          <FormControl>
            <InputLabel>Spécialité</InputLabel>
            <Select value={selectedSpecialite} onChange={handleSpecialiteChange} label="Spécialité" style={{ width: "20vh" }}>
              <MenuItem value="">Toutes</MenuItem>
              {specialites.map((specialite) => (
                <MenuItem key={specialite.id} value={specialite.id}>
                  {specialite.nom}
                </MenuItem>
              ))}
            </Select>
          </FormControl>

          <FormControl>
            <InputLabel>Groupe</InputLabel>
            <Select value={selectedGroupe} onChange={handleGroupeChange} label="Groupe" style={{ width: "20vh" }}>
              <MenuItem value="">Tous</MenuItem>
              {groupes.map((groupe) => (
                <MenuItem key={groupe.id} value={groupe.id}>
                  {groupe.nom}
                </MenuItem>
              ))}
            </Select>
          </FormControl>

          <Button style={{ backgroundColor: "var(--secondary-color)", padding: "0.5em" }} variant="contained" onClick={handleAjouterEmploi}>Ajouter Emploi</Button>
        </div>

        <TableContainer style={{ width: '60vw', marginTop: "2vh" }}>
          <Table>
            <TableHead style={{ backgroundColor: 'var(--third-color)', fontWeight: 'bold', color: 'black' }}>
              <TableRow  >
                <TableCell style={{ color: 'white' }}>Jour</TableCell>
                <TableCell style={{ color: 'white' }}>Début</TableCell>
                <TableCell style={{ color: 'white' }}>Fin</TableCell>
                <TableCell style={{color: 'white'}}>Matière</TableCell>
              <TableCell style={{color: 'white'}}>Salle</TableCell>
              <TableCell style={{color: 'white'}}>Régime</TableCell>
                {/* Ajoutez les en-têtes de colonnes supplémentaires ici */}
              </TableRow>
            </TableHead>
            <TableBody>
              {emploiDuTemps.map((emploi) => (
                <TableRow key={emploi.id} style={{ backgroundColor: '#fff', padding: '5px' }}>
                  <TableCell>{emploi.jour}</TableCell>
                  <TableCell>{emploi.debut_seance}</TableCell>
                  <TableCell>{emploi.fin_seance}</TableCell>
                  <TableCell>{emploi.matière}</TableCell>
                  <TableCell>{emploi.salle}</TableCell>
                  <TableCell>{emploi.regime}</TableCell>
                  {/* Ajoutez les cellules pour les données supplémentaires ici */}
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>

      </div>
    </div>
  );
};

export default EmploiEtudiant;
