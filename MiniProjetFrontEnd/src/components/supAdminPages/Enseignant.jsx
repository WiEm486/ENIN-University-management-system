import React, { useState, useEffect } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import AddIcon from '@mui/icons-material/Add';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import { useNavigate } from 'react-router-dom';
import EnseignantService from '../../services/EnseignantService'; // Import EnseignantService

const Enseignant = () => {
  const [Enseignants, setEnseignants] = useState([]);
  const navigate = useNavigate();
  // Create an instance of EnseignantService

  // Function to fetch Enseignantistrators
  const fetchEnseignants = () => {
    EnseignantService.getEnseignants()
      .then(data => {
        setEnseignants(data); // Update the state with fetched Enseignants
      })
      .catch(error => {
        console.error('Error fetching Enseignants:', error);
        // Handle errors here
      });
  };

  // Call fetchEnseignants when the component mounts
  useEffect(() => {
    fetchEnseignants();
  }, []);

  const handleAdd = () => {
    navigate("/AjouterEnseignant");
  };

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>
        <h2>Liste des Enseignants</h2>
        <div style={{ display: "flex", justifyContent: "flex-end" }}>
          <IconButton aria-label="add" onClick={handleAdd}>
            <AddIcon />
          </IconButton>
        </div>
        <TableContainer>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>cin</TableCell>
                <TableCell>email</TableCell>
                <TableCell>nom</TableCell>
                <TableCell>departement</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {Enseignants.map((ad) => (
                <TableRow key={ad.id}>
                  <TableCell>{ad.cin}</TableCell>
                  <TableCell>{ad.email}</TableCell>
                  <TableCell>{ad.nom}</TableCell>
                  <TableCell>{ad.departement}</TableCell>
                  <TableCell>
                    <IconButton aria-label="modify">
                      <EditIcon />
                    </IconButton>
                    <IconButton aria-label="delete">
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

export default Enseignant;
