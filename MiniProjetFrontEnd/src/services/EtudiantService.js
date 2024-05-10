import axios from "axios";
class EtudiantService {
  async ajouterEtudiant(EtudiantData) {
    try {
      const response = await axios.post(this.baseURL, EtudiantData);

      return response.data; // Retournez les données ajoutées (par exemple, l'Etudiant ajouté avec son ID)
    } catch (error) {
      throw new Error(error.message);
    }
  }

  async getEtudiants() {
    try {
      const response = await axios.get(`/Etudiants`);
      return response.data;
    } catch (error) {
      console.error("Erreur lors de la récupération des Etudiants:", error);
      throw error;
    }
  }
}

export default new EtudiantService();
