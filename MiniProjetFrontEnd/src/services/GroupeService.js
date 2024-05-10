import axios from "axios";

class GroupeService {
  static async getGroupes(specialiteId) {
    try {
      const response = await axios.get(
        `http://votre-api.com/specialites/${specialiteId}/groupes`
      );
      return response.data;
    } catch (error) {
      console.error("Erreur dans GroupeService:", error);
      throw error;
    }
  }

  static async getEmploi(groupeId, specialiteId) {
    try {
      const response = await axios.get(
        `http://votre-api.com/specialites/${specialiteId}/groupes/${groupeId}/emploi`
      );
      return response.data;
    } catch (error) {
      console.error("Erreur dans GroupeService:", error);
      throw error;
    }
  }
}

export default GroupeService;
