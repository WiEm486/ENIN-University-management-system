import React, { useState, useEffect } from 'react';
import {  Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
import axios from 'axios';

//import SpecialiteService from './path/to/SpecialiteService'; // Assurez-vous d'importer correctement votre service SpecialiteService
//import GroupeService from './path/to/GroupeService'; // Assurez-vous d'importer correctement votre service GroupeService

const EmploiEtudiant = () => {

  
  
  const emploiDuTemp = {
    id_emploi: null,
    annee_univ: "2023-2024",
    seme: 2,
    groupe: "GL-A2-01",
    lignes: [
      {
        id_ligne_emp: "1",
        jour: null,
        debut_seance: "08:00:00",
        fin_seance: "10:00:00.899",
        regime: "QB",
        type: "Cours",
        emploiEt: null,
        salle_et: "I-02",
        enseignant_et: "Lamouchi",
        matiere_et: "Base de Données"
      }
    ]
  };
  const [emploiDuTemps, setEmploiDuTemps] = useState(emploiDuTemp);

  useEffect(() => {
    const fetchEmploi = async () => {
      try {
        const response = await axios.get('http://localhost:8081/emploietude/1'); // Remplacez URL_DE_VOTRE_API par l'URL de votre API
        setEmploiDuTemps(response.data);
        console.log(response.data)
      } catch (error) {
        console.error('Erreur lors de la récupération des demandes:', error);
      }
    };

    fetchEmploi();
  }, []); 



  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>

        <h2 >Emploi du temps Etudiant </h2>
      

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
              <TableCell style={{color: 'white'}}>Enseignant</TableCell>
                {/* Ajoutez les en-têtes de colonnes supplémentaires ici */}
              </TableRow>
            </TableHead>
            <TableBody>
              {emploiDuTemps.lignes.map((item) => (
                <TableRow key={item.id_ligne_emp} style={{ backgroundColor: '#fff', padding: '5px' }}>
                   <TableCell>{item.jour}</TableCell>
                  <TableCell>{item.debut_seance}</TableCell>
                  <TableCell>{item.fin_seance}</TableCell>
                  <TableCell>{item.matiere_et}</TableCell>
                  <TableCell>{item.salle_et}</TableCell>
                  <TableCell>{item.regime}</TableCell>
                  <TableCell>{item.enseignant_et}</TableCell>
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
