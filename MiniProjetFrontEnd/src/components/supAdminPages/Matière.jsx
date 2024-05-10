import React, { useState } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import AddIcon from '@mui/icons-material/Add';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';


import "../../App.css"
import { useNavigate } from 'react-router-dom';
const matières = [
  {
    id: 1,
    matière: "Algorithme ",
    Description: "Description 1",
   
  },
  {
    id: 2,
    matière: "Conception",
    Description: "Description 2",
  },
  // ... autres demandes
];

const Matière= () => {
  const [matièresState, setMatièresState] = useState(matières);

  const navigate=useNavigate();

   const handleAdd=()=>{
     navigate("/Ajoutermatière")
   }


  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>
    

    <h2>Liste des Matières</h2>
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
              <TableCell>Matière</TableCell>
              <TableCell>Description</TableCell>
          
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {matièresState.map((mat) => (
              <TableRow key={mat.id}>
                <TableCell>{mat.id}</TableCell>
                <TableCell>{mat.matière}</TableCell>
                <TableCell>{mat.Description}</TableCell>
          
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

export default Matière;
