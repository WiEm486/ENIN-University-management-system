import React, { useEffect, useState } from 'react';
import { TextField, Button, Grid, Paper, Avatar, FormControl, InputLabel, Select, MenuItem } from '@mui/material';
import GradeService from '../../services/GradeService';
import MatiereService from '../../services/MatiereService';
import DepartementService from '../../services/ServiceDepartement';
import EnseignantService from '../../services/EnseignantService';
const AjouterEnseignant = () => {
 
  const [EnseignantData, setEnseignantData] = useState({
    cin: '',
    email: '',
    nom: '',
    prenom: '',
    password: '',
    date_naissance: '',
    matiere: '',
    addresse: '',

    photo: '' ,
    grade:"",
    departement:""
  });
  const [grades, setGrades] = useState([]);
  const [departements, setDepartements] = useState([]);
  const [matieres, setMatieres] = useState([]);

  useEffect(() => {
    // Récupérer les grades depuis le backend
    GradeService.getGrades()
      .then(response => {
        setGrades(response);
      })
      .catch(error => console.error('Erreur lors de la récupération des grades:', error));

    MatiereService.getMatieres()
      .then(response => {
        setMatieres(response);
      })
      .catch(error => console.error('Erreur lors de la récupération des matières:', error));

   
    DepartementService.getDepartements()
      .then(response => {
        setDepartements(response);
      })
      .catch(error => console.error('Erreur lors de la récupération des départements:', error));
  }, []);



  const handleChange = (e) => {
    const { name, value } = e.target;
    setEnseignantData({
      ...EnseignantData,
      [name]: value
    });
  };

  const handleAdd = () => {
   
    EnseignantService.ajouterEnseignant(EnseignantData)
      .then(data => {
        console.log('Enseignant créé avec succès:', data);
        // Faites quelque chose avec les données retournées si nécessaire
      })
      .catch(error => {
        console.error('Erreur lors de la création de l\'Enseignantistrateur:', error);
        // Gérer les erreurs ici
      });
  };
  
  const handlePhotoChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        const imageUrl = reader.result; // Récupérer l'URL de données de l'image
        setEnseignantData({
          ...EnseignantData,
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
          <h2>Ajouter Enseignant</h2>
          <form>
          <label htmlFor="photo-input">
                  <Avatar
                    alt="Photo de profil"
                    src={EnseignantData.photo}
                    sx={{ width: 100, height: 100, cursor: 'pointer' ,marginBottom:"1vh", backgroundColor:"var(--third-color)"}}
                  />
                </label>
            <Grid container spacing={2}>
              <Grid item xs={6}>
                <TextField name="cin" label="CIN" value={EnseignantData.cin} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="email" label="Email" value={EnseignantData.email} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="nom" label="Nom" value={EnseignantData.nom} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="prenom" label="Prénom" value={EnseignantData.prenom} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="password" label="Mot de passe" type="password" value={EnseignantData.password} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="date_naissance" label="Date de naissance" type="date" value={EnseignantData.date_naissance} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
                <TextField name="addresse" label="Adresse" value={EnseignantData.addresse} onChange={handleChange} fullWidth />
              </Grid>
              <Grid item xs={6}>
              <FormControl fullWidth>
                <InputLabel id="grade-label">Grade</InputLabel>
                <Select
                  labelId="grade-label"
                  id="grade"
                  value={EnseignantData.grade}
                  name="grade"
                  onChange={handleChange}
                >
                  {grades.map((grade, index) => (
                    <MenuItem key={index} value={grade}>{grade.grade}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={6}>
              <FormControl fullWidth>
                <InputLabel id="matiere-label">Matière</InputLabel>
                <Select
                  labelId="matiere-label"
                  id="matiere"
                  value={EnseignantData.matiere}
                  name="matiere"
                  onChange={handleChange}
                >
                  {matieres.map((matiere, index) => (
                    <MenuItem key={index} value={matiere}>{matiere.nom}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={6}>
              <FormControl fullWidth>
                <InputLabel id="departement-label">Département</InputLabel>
                <Select
                  labelId="departement-label"
                  id="departement"
                  value={EnseignantData.departement}
                  name="departement"
                  onChange={handleChange}
                >
                  {departements.map((departement, index) => (
                    <MenuItem key={index} value={departement}>{departement.departement}</MenuItem>
                  ))}
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

export default AjouterEnseignant;
