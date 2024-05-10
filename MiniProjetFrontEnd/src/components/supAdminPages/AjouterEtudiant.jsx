import React, { useState } from 'react';
import { TextField, Button, Grid, Paper, Avatar } from '@mui/material';

const AjouterEtudiant = () => {
  const [EtudiantData, setEtudiantData] = useState({
    cin: '',
    email: '',
    nom: '',
    prenom: '',
    motDePasse: '',
    dateNaissance: '',
    numTel: '',
    adresse: '',
    status: '',
    photo: '' 
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEtudiantData({
      ...EtudiantData,
      [name]: value
    });
  };


  // const handleAddEtudiant = () => {
  //   // Vérifiez si toutes les données nécessaires sont remplies
  //   if (
  //     EtudiantData.cin.trim() !== '' &&
  //     EtudiantData.email.trim() !== '' &&
  //     EtudiantData.nom.trim() !== '' &&
  //     EtudiantData.prenom.trim() !== '' &&
  //     EtudiantData.motDePasse.trim() !== '' &&
  //     EtudiantData.dateNaissance.trim() !== '' &&
  //     EtudiantData.numTel.trim() !== '' &&
  //     EtudiantData.adresse.trim() !== '' &&
  //     EtudiantData.status.trim() !== '' &&
  //     EtudiantData.photo !== ''
  //   ) {
  //     // Appelez la méthode ajouterEtudiant de votre service avec les données de l'Etudiant
  //     EtudiantService.ajouterEtudiant(EtudiantData)
  //       .then(response => {
  //         console.log('Etudiant ajouté avec succès:', response);
  //         // Réinitialisez les données après l'ajout
  //         setEtudiantData({
  //           cin: '',
  //           email: '',
  //           nom: '',
  //           prenom: '',
  //           motDePasse: '',
  //           dateNaissance: '',
  //           numTel: '',
  //           adresse: '',
  //           status: '',
  //           photo: ''
  //         });
  //       })
  //       .catch(error => {
  //         console.error('Erreur lors de l\'ajout de l\'Etudiant:', error);
  //       });
  //   } else {
  //     console.error('Veuillez remplir tous les champs.');
  //   }
  // }
  const handlePhotoChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setEtudiantData({
          ...EtudiantData,
          photo: reader.result
        });
      };
      reader.readAsDataURL(file);
    }
  };

  return (
    <Grid container justifyContent="center" alignItems="center" style={{ height: '100vh' ,width:"100vw",marginLeft:"15vh"}}>
      <Grid  xs={7} >
        <Paper elevation={4}  style={{ padding: '20px' }}>
          <h2>Ajouter Etudiant</h2>
          <form>
          <label htmlFor="photo-input">
                  <Avatar
                    alt="Photo de profil"
                    src={EtudiantData.photo}
                    sx={{ width: 100, height: 100, cursor: 'pointer' ,marginBottom:"1vh", backgroundColor:"var(--third-color)"}}
                  />
                </label>
            <Grid container spacing={2}>
              <Grid item xs={6}>
                <TextField name="cin" label="CIN" value={EtudiantData.cin} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="email" label="Email" value={EtudiantData.email} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="nom" label="Nom" value={EtudiantData.nom} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="prenom" label="Prénom" value={EtudiantData.prenom} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="motDePasse" label="Mot de passe" type="password" value={EtudiantData.motDePasse} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="dateNaissance" label="Date de naissance" type="date" value={EtudiantData.dateNaissance} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="numTel" label="Numéro de téléphone" value={EtudiantData.numTel} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="adresse" label="Adresse" value={EtudiantData.adresse} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="status" label="Statut" value={EtudiantData.status} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <input
                  accept="image/*"
                  id="photo-input"
                  type="file"
                  style={{ display: 'none' }}
                  onChange={handlePhotoChange}
                />
             
              </Grid>
              <Grid item xs={12}>
                <Button variant="contained" color="primary">Ajouter</Button>
              </Grid>
            </Grid>
          </form>
        </Paper>
      </Grid>
    </Grid>
  );
};

export default AjouterEtudiant;
