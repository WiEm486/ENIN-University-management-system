import React from 'react'
import TextField from '@mui/material/TextField';


const AddSupportCours = () => {
  return (
    <div className="addSupportCours">
        <div className="supportCoursFormTitle">Ajouter Un Support de cours</div>
        <div className="supportCoursForm">
            <TextField
            required
            id="filled-required"
            label="Required"
            defaultValue="Hello World"
            variant="filled"
            />
        </div>
    </div>
  )
}

export default AddSupportCours