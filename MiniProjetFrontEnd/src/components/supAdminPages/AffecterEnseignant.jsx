import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Select, MenuItem, Button, Grid } from '@mui/material';
// import DepartementService from './DepartementService'; // Import du service pour les départements
// import EnseignantService from './EnseignantService'; // Import du service pour les enseignants

function AffectationEnseignant() {
  const [enseignants, setEnseignants] = useState([
    { id: 1, nom: "Enseignant 1" },
    { id: 2, nom: "Enseignant 2" },
    { id: 3, nom: "Enseignant 3" },
  ]);
  const [departements, setDepartements] = useState([
    { id: 1, nom: "Département 1" },
    { id: 2, nom: "Département 2" },
    { id: 3, nom: "Département 3" },
  ]);
  const [enseignantSelectionne, setEnseignantSelectionne] = useState('');
  const [departementSelectionne, setDepartementSelectionne] = useState('');
 // Utilisation de useNavigate pour obtenir la fonction de navigation

  // useEffect(() => {
  //   // Récupération de la liste des enseignants depuis le service EnseignantService
  //   const fetchEnseignants = async () => {
  //     try {
  //       const response = await EnseignantService.getEnseignants();
  //       setEnseignants(response.data);
  //     } catch (error) {
  //       console.error('Erreur lors de la récupération des enseignants :', error);
  //     }
  //   };

  //   // Récupération de la liste des départements depuis le service DepartementService
  //   const fetchDepartements = async () => {
  //     try {
  //       const response = await DepartementService.getDepartements();
  //       setDepartements(response.data);
  //     } catch (error) {
  //       console.error('Erreur lors de la récupération des départements :', error);
  //     }
  //   };

  //   fetchEnseignants();
  //   fetchDepartements();
  // }, []);

  const handleAffectation = async () => {
    try {
      // Envoi de la requête pour effectuer l'affectation avec l'ID de l'enseignant et du département sélectionnés
      // await AffectationService.affecter(enseignantSelectionne, departementSelectionne);
      alert('Affectation effectuée avec succès !');
     // Navigation vers la liste des affectations après l'affectation
    } catch (error) {
      console.error('Erreur lors de l\'affectation :', error);
      alert('Erreur lors de l\'affectation');
    }
  };

  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>

        <Container>
          <h2>Affectation Enseignant - Département</h2>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <FormControl fullWidth>
                <InputLabel id="enseignant-label">Enseignant</InputLabel>
                <Select
                  labelId="enseignant-label"
                  value={enseignantSelectionne}
                  onChange={(e) => setEnseignantSelectionne(e.target.value)}
                  fullWidth
                >
                  {enseignants.map(enseignant => (
                    <MenuItem key={enseignant.id} value={enseignant.id}>{enseignant.nom}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={6}>
              <FormControl fullWidth>
                <InputLabel id="departement-label">Département</InputLabel>
                <Select
                  labelId="departement-label"
                  value={departementSelectionne}
                  onChange={(e) => setDepartementSelectionne(e.target.value)}
                  fullWidth
                >
                  {departements.map(departement => (
                    <MenuItem key={departement.id} value={departement.id}>{departement.nom}</MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12}>
              <Button
                variant="contained"
                onClick={handleAffectation}
                fullWidth
              >
                Affecter
              </Button>
            </Grid>
          </Grid>
        </Container>
      </div>
   </div>
  );
}

export default AffectationEnseignant;
