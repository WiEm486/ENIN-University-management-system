import React, { useState } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  TextField,
  Button,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
} from "@mui/material";

const TeacherDepotCours = () => {
  const [groupe, setgroupe] = useState("");
  const [specialite, setspecialite] = useState("");
  const [matiere, setMatiere] = useState("");


  const [emploiDuTemps, setEmploiDuTemps] = useState([]);
  const [fileName, setFileName] = useState('');
  const [file, setFile] = useState();

  const handleUpload = (event) => {
    const file = event.target.files[0];
    setFileName(file.name);
    setFile(file);
  };

  const handleAddLigne = () => {
    const newLigne = {
      groupe,
      specialite,
      matiere,
      file
 
    };

    setEmploiDuTemps([...emploiDuTemps, newLigne]);


    setMatiere("");
    setgroupe("");
    setspecialite("");
    setFile()
    setFileName("");
  };

  return (
    <>
  <div style={{marginLeft:"50vh",marginTop:"5vh"}}>
    <div style={{width:"70vw",height:"85vh" ,backgroundColor:"white",borderRadius:"20px", padding:"3vh"}}>
   
          <h2>Ajouter Un Support de cours</h2>
          <div style={{ display:'flex' ,flexDirection: 'row-reverse', padding:"20px" }}>
            <div style={{ width:'500px', marginLeft:"40px"}} >
              <InputLabel>Matière</InputLabel>
              <Select
                fullWidth
                value={matiere}
                label="Matière"
                onChange={(e) => setMatiere(e.target.value)}
              >
                <MenuItem value={'Ten'}>Algoriyhme</MenuItem>
                <MenuItem value={'Twenty'}>BDD</MenuItem>
                <MenuItem value={'Thirty'}>coneception</MenuItem>
              </Select>

              <InputLabel>groupe</InputLabel>
              <Select
                fullWidth
                value={groupe}
                label="groupe"
                onChange={(e) => setgroupe(e.target.value)}
              >
                <MenuItem value={'Ten'}>FIA1</MenuItem>
                <MenuItem value={'Twenty'}>FIA2</MenuItem>
                <MenuItem value={'Thirty'}>FIA3</MenuItem>
              </Select>

              <InputLabel>fillière</InputLabel>
              <Select
                fullWidth
                value={specialite}
                label="specialite"
                onChange={(e) => setspecialite(e.target.value)}
              >
                <MenuItem value={'Ten'}>Informatique</MenuItem>
                <MenuItem value={'Twenty'}>Genie Civil</MenuItem>
                <MenuItem value={'Thirty'}>Mécanique</MenuItem>
              </Select>

              <Button variant="contained" component="label" style={{marginTop:'20px'}}>
                Upload File
                <input type="file" hidden onChange={handleUpload} />
              </Button>
              <p>{fileName}</p>

              <div>
              <Button
                variant="contained"
                onClick={handleAddLigne}
                style={{ marginTop: "5vh", marginBottom: "5vh" }}
              >
                Ajouter
              </Button>
              </div>
            </div>

            <TableContainer>
              <Table>
                <TableHead>
                  <TableRow>
                    <TableCell>fillière</TableCell>
                    <TableCell>groupe</TableCell>
                    <TableCell>Matiere</TableCell>
                    <TableCell>file</TableCell>
                
                  </TableRow>
                </TableHead>
                <TableBody>
  {emploiDuTemps.map((ligne, index) => (
    <TableRow key={index}>
      <TableCell>{ligne.specialite}</TableCell>
      <TableCell>{ligne.groupe}</TableCell>
      <TableCell>{ligne.matiere}</TableCell>
      <TableCell>
        <a href={URL.createObjectURL(ligne.file)} download={ligne.file.name}>
          {ligne.file.name}
        </a>
      </TableCell>
    </TableRow>
  ))}
</TableBody>
              </Table>
            </TableContainer>
          </div>
        </div>
      </div>
    </>
  );
};

export default TeacherDepotCours;
