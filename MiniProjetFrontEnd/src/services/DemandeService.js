import axios from "axios";

class DemandeService {
  static async getDemandes() {
    try {
      const response = await axios.get(
        "http://localhost:8081/api//demanderattrapage/tout"
      );
      return response.data;
    } catch (error) {
      console.error("Erreur:", error);
      throw error;
    }
  }

  static async updateDemande(id, newState) {
    try {
      const response = await axios.put(`url_de_votre_backend/demandes/${id}`, {
        etat: newState,
      });
      return response.data;
    } catch (error) {
      console.error("Erreur lors de la mise à jour de la demande:", error);
      throw error;
    }
  }
}

export default DemandeService;


