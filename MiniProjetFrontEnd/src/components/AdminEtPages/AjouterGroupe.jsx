import { useState, useEffect, useCallback } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { Button, FormControl, Grid, InputLabel, Select, Checkbox } from '@mui/material';

const AjouterGroupe = () => {
  const [specialites, setSpecialites] = useState([]);
  const [groupes, setGroupes] = useState([]);
  const [etudiants, setEtudiants] = useState([{ id: "1" }, { id: "2" }]);

  // Use custom hook for student selection
  const { selectedStudents, toggleSelection } = useStudentSelection(etudiants);

  const [specialiteSelectionnee, setSpecialiteSelectionnee] = useState('');
  const [groupeSelectionne, setGroupeSelectionne] = useState('');

  // ... (rest of the code remains the same)

  const handleChangeSpecialite = (event) => {
    setSpecialiteSelectionnee(event.target.value);
  };

  const handleChangeGroupe = (event) => {
    setGroupeSelectionne(event.target.value);
  };

  const handleSubmit = async () => {
    if (specialiteSelectionnee === '' || groupeSelectionne === '') {
      alert('Veuillez sélectionner une spécialité et un groupe');
      return;
    }

    if (selectedStudents.length === 0) {
      alert('Veuillez sélectionner des étudiants');
      return;
    }

    try {
      // Send data using Axios POST
      const response = await axios.post('https://developers.letudiant.fr/', {
        specialite: specialiteSelectionnee,
        groupe: groupeSelectionne,
        etudiants: selectedStudents, // Pass array of selected student IDs
      });

      alert('Les étudiants ont été affectés avec succès');
      // Optionally, reload data or update UI
    } catch (error) {
      console.error(error);
      alert('Une erreur est survenue');
    }
  };

  const columns = [
    { field: 'id', headerName: 'ID' },
    { field: 'nom', headerName: 'Nom' },
    { field: 'prenom', headerName: 'Prénom' },
    { field: 'specialite', headerName: 'Spécialité' },
    { field: 'groupe', headerName: 'Groupe' },
    {
      field: 'selected',
      headerName: 'Sélectionner',
      width: 90,
      renderCell: (params) => (
        <Checkbox
          checked={selectedStudents.includes(params.row.id)}
          onChange={() => toggleSelection(params.row.id)}
        />
      ),
    },
    {
      field: 'actions',
      headerName: 'Actions',
      // ... (your existing actions column logic)
    },
  ];

  return (
    <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>

    <FormControl style={{ width: "15vh" ,marginRight:"3vh",marginBottom:"2vh"}}>
        <InputLabel>Spécialité</InputLabel>
        <Select
          label="Spécialité"
          value={specialiteSelectionnee}
          onChange={handleChangeSpecialite}
        >
          <option value="">Toutes les spécialités</option>
          {/* ... (rest of the options) */}
        </Select>
      </FormControl>
      <FormControl style={{ width: "15vh",marginBottom:"2vh" }}>
        <InputLabel>Groupe</InputLabel>
        <Select
          label="Groupe"
          value={groupeSelectionne}
          onChange={handleChangeGroupe}
        >
          <option value="">Tous les groupes</option>
          {/* ... (rest of the options) */}
        </Select>
      </FormControl>
      <Grid container spacing={2}>
        <Grid item xs={12}>
          <DataGrid
            rows={etudiants}
            columns={columns}
            // No selectionModel needed here
          />
        </Grid>
        <Grid item xs={12}>
          <Button variant="contained" onClick={handleSubmit}>
            Affecter les étudiants
          </Button>
        </Grid>
      </Grid>

      
      </div>
     </div>
  );
};
export default AjouterGroupe;
const useStudentSelection = (etudiants) => {
  const [selectedStudents, setSelectedStudents] = useState([]);

  const toggleSelection = useCallback((studentId) => {
    const isSelected = selectedStudents.includes(studentId);
    const newSelection = isSelected
      ? selectedStudents.filter((id) => id !== studentId)
      : [...selectedStudents, studentId];
    setSelectedStudents(newSelection);
  }, [selectedStudents]);

  return { selectedStudents, toggleSelection };
};
