import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Button } from '@mui/material';
import axios from 'axios';
import { useUser } from '../UserProvider';


const DemandeRat = () => {
  const [status, setStatus] = useState('');
  const [commentaire, setCommentaire] = useState('');
  const [jour, setJour] = useState('');
  const [debut, setDebut] = useState('');
  const [fin, setFin] = useState('');
  const [proprietaireR, setProprietaireR] = useState('');
  const [nom_groupe, setNomGroupe] = useState('');
  const [matiere, setMatiere] = useState('');

  const [emploiDuTemps, setEmploiDuTemps] = useState([]);
  const { user } = useUser();

  const addDemande = async (demande) => {
    console.log(user.nom)
    try {
      const response = await axios.post(`http://localhost:8081/demanderattrapage/ajouter`, demande);

      // Si la demande est ajoutée avec succès, vous pouvez effectuer des actions supplémentaires ici
      console.log('Demande ajoutée avec succès');

      // Mettre à jour l'état local ou effectuer d'autres actions si nécessaire
      // Par exemple, recharger la liste des demandes depuis le serveur
      // fetchDemandes();
    } catch (error) {
      console.error('Erreur:', error.message);
    }
  };

  const handleAddLigne = () => {
    const nouvelleDemande = {
      matiere,nom_groupe,proprietaireR:"Ben Ftima",fin,debut,jour,commentaire,status:"en cours"
    };

    addDemande(nouvelleDemande);

    // Mise à jour de l'état local si nécessaire
    setEmploiDuTemps([...emploiDuTemps, nouvelleDemande]);

    // Réinitialisation des champs de saisie après l'ajout de la demande
   
  };

  return (
    <>
      <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
        <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>

          <h2>Demande Rattrapage</h2>
          <div >
            <form style={{ display: "grid", gridTemplateColumns: "repeat(3, 2fr)", gap: "5vh", marginTop: "5vh" }}>
            
              <TextField label="Commentaire" value={commentaire} onChange={(e) => setCommentaire(e.target.value)} />
              <TextField label="Jour" value={jour} onChange={(e) => setJour(e.target.value)} />
              <TextField type="time" id="start" name="debut" value={debut} onChange={(e) => setDebut(e.target.value)} />
              <TextField type="time" id="end" name="fin" value={fin} onChange={(e) => setFin(e.target.value)} />
           
              <TextField label="Nom Groupe" value={nom_groupe} onChange={(e) => setNomGroupe(e.target.value)} />
              <TextField label="Matière" value={matiere} onChange={(e) => setMatiere(e.target.value)} />
            </form>
            <Button variant="contained" onClick={handleAddLigne} style={{ marginTop: "5vh", marginBottom: "5vh" }}>Ajouter</Button>
          </div>

          <TableContainer>
            <Table>
              <TableHead>
                <TableRow>
             
                  <TableCell>Commentaire</TableCell>
                  <TableCell>Jour</TableCell>
                  <TableCell>Début</TableCell>
                  <TableCell>Fin</TableCell>
               
                  <TableCell>Nom Groupe</TableCell>
                  <TableCell>Matière</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {emploiDuTemps.map((ligne, index) => (
                  <TableRow key={index}>
                 
                    <TableCell>{ligne.commentaire}</TableCell>
                    <TableCell>{ligne.jour}</TableCell>
                    <TableCell>{ligne.debut}</TableCell>
                    <TableCell>{ligne.fin}</TableCell>
            
                    <TableCell>{ligne.nomGroupe}</TableCell>
                    <TableCell>{ligne.matiere}</TableCell>
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

export default DemandeRat;
