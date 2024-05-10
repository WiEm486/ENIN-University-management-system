// Etudiant.js

import React, { useState, useEffect } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button, Avatar } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import AddIcon from '@mui/icons-material/Add';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import { useNavigate } from 'react-router-dom';
//import EtudiantService from './EtudiantService'; // Importez votre service API

import "../../App.css"

const Etudiant = () => {
  const [EtudiantsState, setEtudiantsState] = useState([]);
  const navigate = useNavigate();

  // useEffect(() => {
  //   fetchEtudiants();
  // }, []);

  // const fetchEtudiants = async () => {
  //   try {
  //     const Etudiants = await EtudiantService.getEtudiants();
  //     setEtudiantsState(Etudiants);
  //   } catch (error) {
  //     // Gérer les erreurs de récupération des Etudiants
  //   }
  // };

  const handleAdd = () => {
    navigate("/AjouterEtudiant");
  };

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>

        <h2>Liste des Etudiants</h2>
        <div style={{ display: "flex", justifyContent: "flex-end" }}>
          <IconButton aria-label="add" onClick={handleAdd}>
            <AddIcon />
          </IconButton>
        </div>

        <TableContainer>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Photo</TableCell>
                <TableCell>Etudiant</TableCell>
                <TableCell>Description</TableCell>
                <TableCell>Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {EtudiantsState.map((ens) => (
                <TableRow key={ens.id}>
                  <TableCell>
                    <Avatar alt={ens.Etudiant} src={ens.photo} sx={{ width: 50, height: 50 }} />
                  </TableCell>
                  <TableCell>{ens.Etudiant}</TableCell>
                  <TableCell>{ens.Description}</TableCell>
                  <TableCell>
                    <IconButton aria-label="modify" style={{ color: "green" }}>
                      <EditIcon />
                    </IconButton>
                    <IconButton aria-label="delete" style={{ color: "orange" }}>
                      <DeleteIcon />
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

export default Etudiant;
