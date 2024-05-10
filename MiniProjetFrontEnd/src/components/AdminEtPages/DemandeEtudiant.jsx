import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button } from '@mui/material';

const demandes = [
  {
    id: 1,
    contenu: "Demande de Lettre d'Affectation ",
    enseignant: "M. Dupont",
    date: "2023-11-14",
    etat: "En attente"
  },
  {
    id: 2,
    contenu: "Demande d' Attestation de Présence ",
    enseignant: "Mme Durand",
    date: "2023-11-15",
    etat: "En attente"
  },
  // ... autres demandes
];

const DemandeEtudiant = () => {
  const [demandesState, setDemandesState] = useState(demandes);

  const handleAccepter = (id) => {
    // Mettre à jour l'état de la demande dans le tableau
    const updatedDemandes = demandesState.map((demande) => {
      if (demande.id === id) {
        demande.etat = "Acceptée";
      }
      return demande;
    });
    setDemandesState(updatedDemandes);
  };

  const handleRefuser = (id) => {
    // Mettre à jour l'état de la demande dans le tableau
    const updatedDemandes = demandesState.map((demande) => {
      if (demande.id === id) {
        demande.etat = "Refusée";
      }
      return demande;
    });
    setDemandesState(updatedDemandes);
  };

  return (
<div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>


    <h2>Liste des demandes </h2>
      <TableContainer>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Contenu</TableCell>
              <TableCell>Etudiant </TableCell>
              <TableCell>Date</TableCell>
              <TableCell>État</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {demandesState.map((demande) => (
              <TableRow key={demande.id}>
                <TableCell>{demande.id}</TableCell>
                <TableCell>{demande.contenu}</TableCell>
                <TableCell>{demande.enseignant}</TableCell>
                <TableCell>{demande.date}</TableCell>
                <TableCell>{demande.etat}</TableCell>
                <TableCell>
                  <Button variant="contained" color="success" onClick={() => handleAccepter(demande.id)}  style={{width:"5vw",height:"3vh",marginLeft:"2vh"}}>Accepter</Button>
                  <Button variant="contained" color="error" onClick={() => handleRefuser(demande.id)} style={{width:"5vw",height:"3vh",marginLeft:"2vh"}}>Refuser</Button>
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

export default DemandeEtudiant;
