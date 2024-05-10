// AjouterActualite.js

import React, { useState } from 'react';
import { Container, Typography, TextField, Button, Grid, MenuItem } from '@mui/material';
import ActualitéService from '../../services/ActualitéService';
import MessageSnackbar from './MessageSnackbar';

function AjouterActualite() {
  const [titre, setTitre] = useState('');
  const [datePublication, setDatePublication] = useState('');
  const [contenu, setContenu] = useState('');
  const [cible, setCible] = useState('');
  const [status, setStatus] = useState('');
  const [typeActualite, setTypeActualite] = useState('');
  const [openSnackbar, setOpenSnackbar] = useState(false);
  const [snackbarMessage, setSnackbarMessage] = useState('');
  const [snackbarSeverity, setSnackbarSeverity] = useState('success');


  //handleSnackBar

  const handleSnackbarClose = () => {
    setOpenSnackbar(false);
  };

  const handleSuccess = () => {
    setSnackbarSeverity('success');
    setSnackbarMessage('Opération réussie !');
    setOpenSnackbar(true);
  };

  const handleError = () => {
    setSnackbarSeverity('error');
    setSnackbarMessage('Une erreur est survenue.');
    setOpenSnackbar(true);
  };





  const handleAjouter = async () => {
    // Vérification si les champs sont remplis
    if (!titre || !datePublication || !contenu || !cible || !typeActualite) {
   
      return;
    }

    // Création de l'objet actualité avec les valeurs sélectionnées par l'utilisateur
    const nouvelleActualite = {
      titre,
      datePublication,
      contenu,
      cible,
      type: typeActualite,
      status ,// Utilisation directe de la valeur sélectionnée par l'utilisateur
    };

 
      // Appel de la méthode statique pour ajouter l'actualité dans la base de données
       ActualitéService.ajouterActualite(nouvelleActualite);
     //<MessageSnackbar open={true} ></MessageSnackbar>
      // Vous pouvez gérer la redirection ici après l'ajout réussi
    
  };

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>
        <Container>
          <h2>Ajouter une Actualité</h2>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                label="Titre"
                value={titre}
                onChange={(e) => setTitre(e.target.value)}
                variant="outlined"
                fullWidth
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="Date de publication"
                type="date"
                value={datePublication}
                onChange={(e) => setDatePublication(e.target.value)}
                InputLabelProps={{ shrink: true }}
                variant="outlined"
                fullWidth
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                select
                label="Cible"
                value={cible}
                onChange={(e) => setCible(e.target.value)}
                variant="outlined"
                fullWidth
              >
                <MenuItem value="etudiant">etudiant</MenuItem>
                <MenuItem value="enseignant">enseignant</MenuItem>
              </TextField>
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                select
                label="Type d'actualité"
                value={typeActualite}
                onChange={(e) => setTypeActualite(e.target.value)}
                variant="outlined"
                fullWidth
              >
                <MenuItem value="bourse">bourse</MenuItem>
                <MenuItem value="annonce">annonce</MenuItem>
                <MenuItem value="évènement">événement</MenuItem>
              </TextField>
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="Contenu"
                value={contenu}
                onChange={(e) => setContenu(e.target.value)}
                variant="outlined"
                fullWidth
                multiline
                rows={4}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                label="Status"
                value={status}
                onChange={(e) => setStatus(e.target.value)}
                variant="outlined"
                fullWidth
               
                rows={4}
              />
            </Grid>
            <Grid item xs={2}>
              <Button
                variant="contained"
                onClick={handleAjouter}
                
              >
                Ajouter
              </Button>
            </Grid>
          </Grid>
        </Container>

        <MessageSnackbar
      open={openSnackbar}
      onClose={handleSnackbarClose}
      message={snackbarMessage}
      severity={snackbarSeverity}
    />
      </div>
    </div>
  );
}

export default AjouterActualite;
