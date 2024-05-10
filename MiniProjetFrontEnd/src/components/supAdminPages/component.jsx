import React, { useState } from 'react';
import Button from '@mui/material/Button';
import MessageSnackbar from './MessageSnackbar';

function ExampleComponent() {
  const [openSnackbar, setOpenSnackbar] = useState(false);
  const [snackbarMessage, setSnackbarMessage] = useState('');
  const [snackbarSeverity, setSnackbarSeverity] = useState('success');

  const handleSnackbarClose = () => {
    setOpenSnackbar(false);
  };

  const handleSuccess = () => {
    setSnackbarSeverity('success');
    setSnackbarMessage('Opération réussie !');
    setOpenSnackbar(true);
  };

  const handleError = () => {
    setSnackbarSeverity('error');
    setSnackbarMessage('Une erreur est survenue.');
    setOpenSnackbar(true);
  };

  return (
    <div>
      <Button onClick={handleSuccess}>Succès</Button>
      <Button onClick={handleError}>Erreur</Button>
      <MessageSnackbar
        open={openSnackbar}
        onClose={handleSnackbarClose}
        message={snackbarMessage}
        severity={snackbarSeverity}
      />
    </div>
  );
}

export default ExampleComponent;
