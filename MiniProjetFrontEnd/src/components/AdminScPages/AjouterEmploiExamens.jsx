import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Button } from '@mui/material';


const AjouterEmploiExamens = () => {
  const [jour, setJour] = useState('');
  const [debut, setDebut] = useState('');
  const [fin, setFin] = useState('');
  const [matiere, setMatiere] = useState('');

  const [salle, setSalle] = useState('');

  const [emploiDuTemps, setEmploiDuTemps] = useState([]);

  const handleAddLigne = () => {
    const newLigne = {
      jour,
      debut,
      fin,
      matiere,
    
      salle,

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
    setEmploiDuTemps([...emploiDuTemps, newLigne])
    setJour('');
    setDebut('');
    setFin('');
    setMatiere('');
  
    setSalle('');

  };

  return (
    <>

<div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>


      <h2>Ajouter une ligne à l'emploi des Examens</h2>
      <div >
      <form  style={{display:"grid", gridTemplateColumns:"repeat(3, 2fr)", gap:"5vh", marginTop:"5vh"}}>
      <TextField label="Spécialité"  value={jour} onChange={(e) => setJour(e.target.value)} />
        <TextField label="Jour"  value={jour} onChange={(e) => setJour(e.target.value)} />
        <TextField label="Début" value={debut} onChange={(e) => setDebut(e.target.value)} />
        <TextField label="Fin" value={fin} onChange={(e) => setFin(e.target.value)} />
        <TextField label="Matière" value={matiere} onChange={(e) => setMatiere(e.target.value)} />
   
        <TextField label="Salle" value={salle} onChange={(e) => setSalle(e.target.value)} />
        
       
      </form>
      <Button variant="contained" onClick={handleAddLigne} style={{marginTop:"5vh",marginBottom:"5vh"}}>Ajouter</Button>
      </div>
     
      <TableContainer>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Jour</TableCell>
              <TableCell>Début</TableCell>
              <TableCell>Fin</TableCell>
              <TableCell>Matière</TableCell>
          
              <TableCell>Salle</TableCell>
       
            </TableRow>
          </TableHead>
          <TableBody>
            {emploiDuTemps.map((ligne) => (
              <TableRow key={ligne.id}>
                <TableCell>{ligne.jour}</TableCell>
                <TableCell>{ligne.debut}</TableCell>
                <TableCell>{ligne.fin}</TableCell>
                <TableCell>{ligne.matiere}</TableCell>
             
                <TableCell>{ligne.salle}</TableCell>
              
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
    


      </div>

    
    </>

  );
};

export default AjouterEmploiExamens;
