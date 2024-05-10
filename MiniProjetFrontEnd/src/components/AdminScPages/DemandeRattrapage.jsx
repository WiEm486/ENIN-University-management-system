import React, { useState, useEffect } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button } from '@mui/material';
import CheckIcon from '@mui/icons-material/Check';
import ClearIcon from '@mui/icons-material/Clear';
import DemandeService from '../../services/DemandeService'; // Chemin d'accès au service
import axios from 'axios';

const DemandeRattrapage = () => {



  const [demandes, setDemandes] = useState([]);


  useEffect(() => {
    const fetchDemandes = async () => {
      try {
        const response = await axios.get('http://localhost:8081/demanderattrapage/tout'); // Remplacez URL_DE_VOTRE_API par l'URL de votre API
        setDemandes(response.data);
      } catch (error) {
        console.error('Erreur lors de la récupération des demandes:', error);
      }
    };

    fetchDemandes();
  }, []); 


  const handleAccepter = (id) => {
    setDemandes(demandes.map(demande => demande.id === id ? { ...demande, status: 'Acceptée' } : demande));
  };

  const handleRefuser = (id) => {
    setDemandes(demandes.map(demande => demande.id === id ? { ...demande, status: 'Refusée' } : demande));
  };

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>
        <h2>Liste des demandes de rattrapage</h2>
        <TableContainer>
          <Table>
            <TableHead>
              <TableRow>
            
                <TableCell>commentaire</TableCell>
                <TableCell>groupe</TableCell>
                <TableCell>matiere</TableCell>
                <TableCell>etat</TableCell>
                <TableCell>Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {demandes.map((demande) => (
                <TableRow key={demande.id}>
             
                  <TableCell>{demande.commentaire}</TableCell>
                  <TableCell>{demande.nom_groupe}</TableCell>
                  <TableCell>{demande.matiere}</TableCell>
                  <TableCell>{demande.status}</TableCell>
                  <TableCell>
                    <Button variant="contained" color="success" onClick={() => handleAccepter(demande.id)} style={{ backgroundColor:"green",width: "5vw", height: "3vh", marginLeft: "2vh" }}><CheckIcon /></Button>
                    <Button variant="contained" color="error" onClick={() => handleRefuser(demande.id)} style={{ width: "5vw", height: "3vh", marginLeft: "2vh", backgroundColor:"#dc5b5b"}}><ClearIcon /></Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    </div>
  );
};

export default DemandeRattrapage;
