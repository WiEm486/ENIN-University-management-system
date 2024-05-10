import React, { useState, useEffect } from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button } from '@mui/material';
import IconButton from '@mui/material/IconButton';
import AddIcon from '@mui/icons-material/Add';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import { useNavigate } from 'react-router-dom';
import AdminService from '../../services/AdminService'; // Import AdminService

const Admin = () => {
  const [admins, setAdmins] = useState([]);
  const navigate = useNavigate();
  // Create an instance of AdminService

  // Function to fetch administrators
  const fetchAdmins = () => {
    AdminService.getAdmins()
      .then(data => {
        setAdmins(data); // Update the state with fetched admins
      })
      .catch(error => {
        console.error('Error fetching admins:', error);
        // Handle errors here
      });
  };

  // Call fetchAdmins when the component mounts
  useEffect(() => {
    fetchAdmins();
  }, []);

  const handleAdd = () => {
    navigate("/AjouterAdmin");
  };

  return (
    <div style={{ marginLeft: "50vh", marginTop: "5vh" }}>
      <div style={{ width: "70vw", height: "85vh", backgroundColor: "white", borderRadius: "20px", padding: "3vh" }}>
        <h2>Liste des Admins</h2>
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
                <TableCell>prenom</TableCell>
                <TableCell>role</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {admins.map((ad) => (
                <TableRow key={ad.id}>
                  <TableCell>{ad.cin}</TableCell>
                  <TableCell>{ad.email}</TableCell>
                  <TableCell>{ad.nom}</TableCell>
                  <TableCell>{ad.role}</TableCell>
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

export default Admin;
