// ServiceMatiere.js
import axios from "axios";

class MatiereService {
  static async getMatieres() {
    try {
      const response = await axios.get(`http://localhost:8081/matiere/tout`);
      return response.data;
    } catch (error) {
      console.error("Error fetching matieres:", error);
      throw error;
    }
  }
}

export default MatiereService;
