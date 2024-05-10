import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Button } from '@mui/material';

const AjouterMatière= () => {
  const [nomMatière, setnomMatière] = useState('');

  const [description, setdescription] = useState('');

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

    <h2>Ajouter Matière</h2>
      <div >
      <form  style={{display:"grid", gridTemplateRows:"repeat(3, 1fr)", gap:"2vh", marginTop:"5vh"}}>
        <TextField label="nom du Matière"  value={nomMatière} onChange={(e) => setnomMatière(e.target.value)} />
        <TextField label="description" value={description} onChange={(e) => setdescription(e.target.value)} />
       
       
      </form>
      <Button variant="contained" onClick={handleAddLigne} style={{marginTop:"5vh",marginBottom:"5vh"}}>Ajouter</Button>
      </div>
     



      
      </div>
     </div>
  );
};

export default AjouterMatière;
