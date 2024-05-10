import React from 'react';
import { Grid, Paper, Typography } from '@mui/material';
import ChartD from './ChartD';
import DonutChart from './DonutChart';
import CeChart from './CeChart';

const Dashboard2 = () => {
  return (
    <div style={{ marginLeft: '50vh', marginTop: '5vh' }}>
      <div style={{ width: '70vw', height: '85vh', backgroundColor: 'white', borderRadius: '20px', padding: '3vh' }}>
        <Grid container spacing={3} >
          <Grid item xs={12} sm={6} md={3}>
            <Paper style={{ background:'linear-gradient(to right, #0B7077, #024b4e)', padding: '20px', borderRadius: '10px', boxShadow: '0px 4px 10px rgba(0, 0, 0, 0.1)', color: 'white', animation: 'zoomIn 1s forwards' }}>
              <Typography variant="h6">
           Total Etudiant
              </Typography>
              <Typography variant="h3">
                400
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} sm={6} md={3}>
            <Paper style={{ background: 'linear-gradient(to right, #FFA500, #FD661F)', padding: '20px', borderRadius: '10px', boxShadow: '0px 4px 10px rgba(0, 0, 0, 0.1)', color: 'white', animation: 'zoomIn 1s forwards', animationDelay: '0.5s' }}>
              <Typography variant="h6">
           Total Enseignants
              </Typography>
              <Typography variant="h3" >
                75
              </Typography>
            </Paper>
          </Grid>
          <Grid item xs={12} md={6}>
            <div style={{ width:"15vw", height:"20vh", animation: 'rotate 3s linear infinite' }}>
              <CeChart />
            </div>
          </Grid>
        </Grid>
        <div style={{marginTop:"10vh", width:"46vw", animation: 'fadeIn 2s forwards' }}>
          <ChartD />
        </div>
      </div>
    </div>
  );
};

export default Dashboard2;
