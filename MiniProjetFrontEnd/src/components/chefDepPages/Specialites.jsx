import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import AddIcon from '@mui/icons-material/Add';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';


import "../../App.css"
import { useNavigate } from 'react-router-dom';
const specialites = [
  {
    id: 1,
    specialite: "Genie Logiciel ",
    Description: "Description 1",
   
  },
  {
    id: 2,
    specialite: "Mécanique",
    Description: "Description 2",
  },
  // ... autres demandes
];

const Specialites = () => {
  const [specialitesState, setSpecialitesState] = useState(specialites);

  const navigate=useNavigate();

   const handleAdd=()=>{
     navigate("/AjouterSpecialite")
   }


  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>
    

    <h2>Liste des Specialitées</h2>
    <div style={{display:"flex",justifyContent:"flex-end"}}>
    <IconButton aria-label="add"  onClick={handleAdd}>
      <AddIcon />
    </IconButton>
    </div>

      <TableContainer>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>nom du Spécialité</TableCell>
              <TableCell>Description</TableCell>
          
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {specialites.map((spec) => (
              <TableRow key={spec.id}>
                <TableCell>{spec.id}</TableCell>
                <TableCell>{spec.specialite}</TableCell>
                <TableCell>{spec.Description}</TableCell>
          
                <TableCell>
                <IconButton aria-label="modify">
                <EditIcon />
                 </IconButton>
                  <IconButton aria-label="delete" >
                  <DeleteIcon/>
                  </IconButton>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      
      </div>
     </div>
  );
};

export default Specialites;
