import axios from "axios";
class EnseignantService {
  async ajouterEnseignant(enseignantData) {
    try {
      const response = await axios.post(
        "http://localhost:8081/enseignant/ajouter",
        enseignantData
      );

      return response.data; // Retournez les données ajoutées (par exemple, l'enseignant ajouté avec son ID)
    } catch (error) {
      throw new Error(error.message);
    }
  }

  async getEnseignants() {
    try {
      const response = await axios.get(`http://localhost:8081/enseignant/tous`);
      return response.data;
    } catch (error) {
      console.error("Erreur lors de la récupération des enseignants:", error);
      throw error;
    }
  }
}

export default new EnseignantService();
