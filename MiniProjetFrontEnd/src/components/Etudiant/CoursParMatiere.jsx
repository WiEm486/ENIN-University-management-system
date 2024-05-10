import React, { useEffect, useState } from 'react';
import { Container, Typography, TextField, Button, Grid, Card, CardContent, MenuItem, IconButton } from '@mui/material';
import CloudDownloadIcon from '@mui/icons-material/CloudDownload';
import { useUser } from '../UserProvider';
import CoursService from '../../services/CoursService';
import MatiereService from '../../services/MatiereService';

function CoursParMatiere() {
  const { user } = useUser();
  const [selectedMatiere, setSelectedMatiere] = useState('');
  const [cours, setCours] = useState([]);
  const [matieres, setMatieres] = useState([]);

  useEffect(() => {
    const fetchMatieres = async () => {
      try {
        // Vous devez implémenter la méthode getMatieres dans votre service MatiereService
        const matieresData = await MatiereService.getMatieres();
        setMatieres(matieresData);
      } catch (error) {
        console.error(error.message);
      }
    };

    fetchMatieres();
  }, []);

  const handleMatiereChange = (e) => {
    setSelectedMatiere(e.target.value);
  };

  const getCoursParMatiere = async () => {
    try {
      console.log(selectedMatiere);
      const coursData = await CoursService.getCoursParMatiere(selectedMatiere);
      setCours(coursData);
    } catch (error) {
      console.error(error.message);
    }
  };



  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
      <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>
        <h2>Cours par Matière</h2>
        <Grid container spacing={3} alignItems="center" justifyContent="center">
          <Grid item xs={8} sm={4}>
            <TextField
              select
              label="Sélectionner une matière"
              value={selectedMatiere}
              onChange={handleMatiereChange}
              variant="outlined"
              fullWidth
            >
              {matieres.map((matiere) => (
                <MenuItem key={matiere.id} value={matiere.nom}>
                  {matiere.nom}
                </MenuItem>
              ))}
            </TextField>
          </Grid>
          <Grid item xs={12} sm={3}>
            <Button variant="contained" onClick={getCoursParMatiere}>Afficher les Cours</Button>
          </Grid>
        </Grid>
        <Grid container spacing={3} justifyContent="center">
          {cours.map((cours) => (
            <Grid item xs={8} key={cours.id}>
              <Card style={{ backgroundColor: '#F9F9F9', borderRadius: '10px' }}>
                <CardContent>
                  <Typography variant="h6" gutterBottom>{cours.matiere}</Typography>
                  <Typography variant="subtitle2" color="textSecondary" gutterBottom>Date de publication : {cours.datePublication}</Typography>
                {/* <IconButton onClick={() => handleDownload(cours.lien)} style={{ color: 'var(--secondary-color)' }} aria-label="Télécharger le Cours"> */}
                    <CloudDownloadIcon  />
              
                </CardContent>
              </Card>
            </Grid>
          ))}
        </Grid>
      </div>
    </div>
  );
}

export default CoursParMatiere;
