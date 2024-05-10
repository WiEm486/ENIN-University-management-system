// ActualitéService.js

import axios from "axios";

class ActualitéService {
  async ajouterActualite(nouvelleActualite) {
    try {
      const response = await axios.post(
        "http://localhost:8081/actualite/ajouter",
        nouvelleActualite
      );
      console.log(response.data);
      return response.data; // Retournez les données ajoutées (par exemple, l'enseignant ajouté avec son ID)
    } catch (error) {
      console.error("Erreur lors de l'ajout de l'actualité:", error);
    }
  }

  async getActualites() {
    try {
      const response = await axios.get(`http://localhost:8081/actualite/tout`);
      return response.data;
    } catch (error) {
      console.error("Erreur lors de la récupération des actuallité:", error);
      throw error;
    }
  }

  async getActualitesByEnseignant() {
    try {
      const response = await axios.get(
        `http://localhost:8081/actualite/enseignant`
      );
      return response.data;
    } catch (error) {
      console.error("Erreur lors de la récupération des actuallité:", error);
      throw error;
    }
  }

  async getActualitesByEtudiant() {
    try {
      const response = await axios.get(
        `http://localhost:8081/actualite/etudiant`
      );
      return response.data;
    } catch (error) {
      console.error("Erreur lors de la récupération des actuallité:", error);
      throw error;
    }
  }
}

export default new ActualitéService();
