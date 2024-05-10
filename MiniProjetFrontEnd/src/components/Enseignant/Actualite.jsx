import React, { useEffect, useState } from 'react';
import { Container, Typography, TextField, Grid, Card, IconButton, MenuItem } from '@mui/material';
import FilterListIcon from '@mui/icons-material/FilterList';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import { useNavigate } from 'react-router-dom';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import SchoolIcon from '@mui/icons-material/School';
import ActualitéService from '../../services/ActualitéService';

function Actualite() {
  const [actualites, setActualites] = useState([]);
  const [filteredActualites, setFilteredActualites] = useState([]);
  const [filtreDate, setFiltreDate] = useState('');

  
  const fetchActualiteByCibleEns = () => {
    ActualitéService.getActualitesByEnseignant()
      .then(data => {
        setActualites(data);
        setFilteredActualites(data);
      })
      .catch(error => {
        console.error('Error fetching Actualités:', error);
      });
  };

  useEffect(() => {
    fetchActualiteByCibleEns();
  }, []);

  const navigate = useNavigate();

  const handleFiltreDateChange = (e) => {
    setFiltreDate(e.target.value);
  };


  const handleAjouterActualite = () => {
    navigate("/AjouterActualite");
  };

  const filtrerActualites = () => {
    let filtered = actualites;
  
    // Filtrer par date
    if (filtreDate !== '') {
      const dateFiltre = new Date(filtreDate);
      filtered = filtered.filter(actualite => {
        const datePublication = new Date(actualite.date_publication);
        return datePublication.getFullYear() === dateFiltre.getFullYear() &&
               datePublication.getMonth() === dateFiltre.getMonth() &&
               datePublication.getDate() === dateFiltre.getDate();
      });
    }
  
    // Filtrer par cible
   
  
    setFilteredActualites(filtered);
  };

  const getTypeBackgroundColor = (type) => {
    switch (type) {
      case 'annonce':
        return '#FD661F'; // Jaune pour annonce
      case 'bourse':
        return '#D2E6E4'; // Orange pour bourse
      case 'événement':
        return '#e78f8f'; // Vert pour événement
      default:
        return '#ffffff'; // Couleur de fond par défaut
    }
  };

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>
        <Container>
          <h2> Liste des Actualités</h2>
          <Grid container spacing={2} alignItems="center">
            <Grid item xs={12} sm={4}>
              <TextField
                label="Filtrer par date"
                type="date"
                value={filtreDate}
                onChange={handleFiltreDateChange}
                InputLabelProps={{ shrink: true }}
                variant="outlined"
                fullWidth
              />
            </Grid>
           
            <Grid item xs={6} sm={2} container justifyContent="flex-end">
              <IconButton onClick={handleAjouterActualite} style={{ marginLeft: '8px' }}>
                <AddCircleOutlineIcon />
              </IconButton>
              <IconButton variant="contained" onClick={filtrerActualites} style={{ marginLeft: '8px' }}>
                <FilterListIcon />
              </IconButton>
            </Grid>
          </Grid>
          <div style={{ overflowY: 'auto', maxHeight: '500px' }}>
            <Grid container spacing={2}>
              {filteredActualites.map(actualite => (
                <Grid item xs={12} key={actualite.titre}>
                  <Card style={{ display: 'flex', alignItems: 'center', padding: '15px', backgroundColor: "#fff", borderRadius: '10px', boxShadow: '0px 4px 10px rgba(0, 0, 0, 0.1)' }}>
                    {actualite.cible === "enseignant" ? <AccountCircleIcon style={{ marginRight: '10px',color:"#0B7077" }} /> : <SchoolIcon style={{ marginRight: '10px' ,color:"#0B7077"}} />}
                    <div>
                      <Typography variant="h6" gutterBottom>{actualite.titre}</Typography>
                      <Typography variant="body2" color="textSecondary">{actualite.date_publication}</Typography>
                    </div>
                    <div style={{ marginLeft: 'auto', backgroundColor: getTypeBackgroundColor(actualite.type), padding: '5px', borderRadius: '5px' }}>
                      <Typography variant="caption">{actualite.type}</Typography>
                    </div>
                  </Card>
                </Grid>
              ))}
            </Grid>
          </div>
        </Container>
      </div>
    </div>
  );
}

export default Actualite;
