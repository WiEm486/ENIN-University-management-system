

import React, { useState } from 'react';

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import { Button, FormControl, IconButton, InputLabel } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import AddIcon from '@mui/icons-material/Add';


const EmploiExamens = () => {
//      const [specialites, setSpecialites] = useState([]);
//   const [selectedSpecialite, setSelectedSpecialite] = useState('');
//   const [groupes, setGroupes] = useState([]);
//   const [emploiDuTemps, setEmploiDuTemps] = useState([]);

//   useEffect(() => {
//     fetch('/specialites')
//       .then((response) => response.json())
//       .then((data) => setSpecialites(data));
//   }, []);

//   useEffect(() => {
//     if (selectedSpecialite) {
//       fetch(`/groupes/${selectedSpecialite}`)
//         .then((response) => response.json())
//         .then((data) => setGroupes(data));
//     }
//   }, [selectedSpecialite]);

//   useEffect(() => {
//     if (selectedGroupe) {
//       fetch(`/emploi-du-temps/${selectedGroupe}`)
//         .then((response) => response.json())
//         .then((data) => setEmploiDuTemps(data));
//     }
//   }, [selectedGroupe]);

//   const handleSpecialiteChange = (event) => {
//     setSelectedSpecialite(event.target.value);
//   };

//   const handleGroupeClick = (groupe) => {
//     setSelectedGroupe(groupe.id);
//   };

  const matieres = [
    { id: 1, nom: 'Mathématiques' },
    { id: 2, nom: 'Français' },
  ];

  const specialites = [
    { id: 1, nom: 'GL' },
    { id: 2, nom: 'Mécanique' },
  ];
  
  const navigate=useNavigate();


  const emploiDuTemps = [
    {
      id: 1,
      jour: 'Lundi',
      debut: '8h00',
      fin: '9h30',
      matiere: 1,
      specialite: 1,
      enseignant: 'M. Dupont',
      type: 'Cours',
      salle: 'B12',
      regime: 'obligatoire',
    },
    {
      id: 2,
      jour: 'Lundi',
      debut: '9h30',
      fin: '11h00',
      matiere: 2,
      specialite: 2,
      enseignant: 'Mme Durand',
      type: 'TD',
      salle: 'C23',
      regime: 'facultatif',
    },
    {
      id: 3,
      jour: 'Mardi',
      debut: '10h00',
      fin: '11h30',
      matiere: 1,
      specialite: 2,
      enseignant: 'M. Rossi',
      type: 'TP',
      salle: 'A15',
      regime: 'obligatoire',
    },
  ];

  const [selectedMatiere, setSelectedMatiere] = useState('');
  const [selectedSpecialite, setSelectedSpecialite] = useState('');

  const filteredEmploiDuTemps = emploiDuTemps.filter((emploi) => {
    return (
      (emploi.matiere === selectedMatiere || !selectedMatiere) &&
      (emploi.specialite === selectedSpecialite || !selectedSpecialite)
    );
  });


  const handleSpecialiteChange = (event) => {
    setSelectedSpecialite(event.target.value);
  };
  const handleAjouterEmploi=()=>{
    navigate('/ajouterEmploiExamen')
  }

  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>


    <h2>Emploi des examens </h2>
      <div style={{display:"flex",gap:"10vw",marginTop:"3vw"}}>
      <FormControl>
        <InputLabel>Spécialité</InputLabel>
        <Select value={selectedSpecialite} onChange={handleSpecialiteChange} label="Spécialité" style={{width:"20vh"}}>
        <MenuItem value="Groupe" >Toutes</MenuItem>
        {specialites.map((specialite) => (
          <MenuItem key={specialite.id} value={specialite.id}>
            {specialite.nom}
          </MenuItem>
        ))}
      </Select>
      </FormControl>
      
     
      <IconButton onClick={handleAjouterEmploi}>
            <AddIcon />
          </IconButton>

      </div>
     
      <TableContainer style={{ width: '60vw' ,marginTop:"2vh"}}>
        <Table>
          <TableHead style={{  fontWeight: 'bold'}}>
            <TableRow  >
              <TableCell style={{color: 'white'}}>Jour</TableCell>
              <TableCell style={{color: 'white'}} >Début</TableCell>
              <TableCell style={{color: 'white'}}>Fin</TableCell>
              <TableCell style={{color: 'white'}}>Matière</TableCell>
           
              <TableCell style={{color: 'white'}}>Salle</TableCell>
            
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredEmploiDuTemps.map((emploi) => (
              <TableRow key={emploi.id} style={{ backgroundColor: '#fff', padding: '5px' }}>
                <TableCell>{emploi.jour}</TableCell>
                <TableCell>{emploi.debut}</TableCell>
                <TableCell>{emploi.fin}</TableCell>
                <TableCell>
                  {matieres.find((m) => m.id === emploi.matiere)?.nom}
                </TableCell>
                <TableCell>{emploi.salle}</TableCell>
         
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      
      </div>
     </div>
  );
};

export default  EmploiExamens ;