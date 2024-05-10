import React, { useState } from 'react';
import { TextField, Button, Grid, Paper, Avatar, FormControl, InputLabel, Select, MenuItem } from '@mui/material';
import AdminService from '../../services/AdminService';

const AjouterAdmin = () => {
  const [role,setRole]=useState("");
  const [AdminData, setAdminData] = useState({
    cin: '',
    email: '',
    nom: '',
    prenom: '',
    password: '',
    date_naissance: '',
    num_tel: '',
    addresse: '',
   role:"ADMIN_ETUDIANT",
    photo: '' 
  });



  const handleChange = (e) => {
    const { name, value } = e.target;
    setAdminData({
      ...AdminData,
      [name]: value
    });
  };

  const handleAdd = () => {
   
    AdminService.createAdmin(AdminData, AdminData.role)
      .then(data => {
        console.log('Admin créé avec succès:', data);
        // Faites quelque chose avec les données retournées si nécessaire
      })
      .catch(error => {
        console.error('Erreur lors de la création de l\'administrateur:', error);
        // Gérer les erreurs ici
      });
  };
  
  const handlePhotoChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        const imageUrl = reader.result; // Récupérer l'URL de données de l'image
        setAdminData({
          ...AdminData,
          photo: imageUrl
        });
        console.log(imageUrl);
      };
      reader.readAsDataURL(file);
    }
  };
  

  return (
    <Grid container justifyContent="center" alignItems="center" style={{ height: '100vh' ,width:"100vw",marginLeft:"15vh"}}>
      <Grid  xs={7} >
        <Paper elevation={4}  style={{ padding: '20px' }}>
          <h2>Ajouter Admin</h2>
          <form>
          <label htmlFor="photo-input">
                  <Avatar
                    alt="Photo de profil"
                    src={AdminData.photo}
                    sx={{ width: 100, height: 100, cursor: 'pointer' ,marginBottom:"1vh", backgroundColor:"var(--third-color)"}}
                  />
                </label>
            <Grid container spacing={2}>
              <Grid item xs={6}>
                <TextField name="cin" label="CIN" value={AdminData.cin} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="email" label="Email" value={AdminData.email} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="nom" label="Nom" value={AdminData.nom} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="prenom" label="Prénom" value={AdminData.prenom} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="password" label="Mot de passe" type="password" value={AdminData.password} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="date_naissance" label="Date de naissance" type="date" value={AdminData.date_naissance} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="num_tel" label="Numéro de téléphone" value={AdminData.num_tel} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="addresse" label="Adresse" value={AdminData.addresse} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <FormControl fullWidth>
                  <InputLabel id="role-label">Rôle</InputLabel>
                  <Select
                    labelId="role-label"
                    id="role"
                    value={AdminData.role}
                    name="role"
                    onChange={handleChange}
                  >
                    <MenuItem value="ADMIN_ETUDIANT">ADMIN_ETUDIANT</MenuItem>
                    <MenuItem value="ADMIN_SCOLARITE">ADMIN_SCOLARITE</MenuItem>
                  </Select>
                </FormControl>
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
                <Button variant="contained" color="primary" onClick={handleAdd}>Ajouter</Button>
              </Grid>
            </Grid>
          </form>
        </Paper>
      </Grid>
    </Grid>
  );
};

export default AjouterAdmin;
