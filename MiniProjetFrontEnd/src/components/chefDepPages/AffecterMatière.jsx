import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Button, FormControl, Select, InputLabel, MenuItem } from '@mui/material';

const AffecterMatière= () => {
  const [selectedSpecialite, setselectedSpecialite] = useState('');

  const [selectedMatière, setselectedMatière] = useState('');

const [specialites,setSpecialites]=useState([{id:"1",nom:"GL"}]);

const [matières,setMatières]=useState([{id:"1",nom:"Algorithme"}]);

  const handleAddLigne = () => {
    const newLigne = {
     
    };

    // // Send the newLigne object to the backend for storage
    // fetch('/add-emploi-du-temps', {
    //   method: 'POST',
    //   body: JSON.stringify(newLigne),
    //   headers: { 'Content-Type': 'application/json' }
    // })
    // .then(response => response.json())
    // .then(data => {
    //   // Assuming the backend returns the stored data
    //   setEmploiDuTemps([...emploiDuTemps, data]);
    // })
    // .catch(error => {
    //   console.error('Error adding emploi du temps:', error);
    //   // Handle errors appropriately, e.g., display an error message
    // });

    // Reset form fields
}

  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>

    <h2>Affecter Matière</h2>
      <div >
      <form  style={{display:"grid", gridTemplateRows:"repeat(3, 1fr)", gap:"2vh", marginTop:"5vh"}}>

      <FormControl>
        <InputLabel>Spécialité</InputLabel>
        <Select value={selectedSpecialite} label="Spécialité" style={{width:"50vh"}}>
       
        {specialites.map((specialite) => (
          <MenuItem key={specialite.id} value={specialite.id}>
            {specialite.nom}
          </MenuItem>
        ))}
      </Select>
      </FormControl>


      <FormControl>
        <InputLabel>Matière</InputLabel>
        <Select value={selectedMatière} label="Matière" style={{width:"50vh"}}>
       
        {matières.map((mat) => (
          <MenuItem key={mat.id} value={mat.id}>
            {mat.nom}
          </MenuItem>
        ))}
      </Select>
      </FormControl>




     
       
       
      </form>
      <Button variant="contained" onClick={handleAddLigne} style={{marginTop:"1vh",marginBottom:"1vh"}}>Affecter</Button>
      </div>
     



      
      </div>
     </div>
  );
};

export default AffecterMatière;
