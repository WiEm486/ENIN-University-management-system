import axios from "axios";

const API_URL = "http://localhost:8081/"; // L'URL de votre API

class CoursService {
  static async getCoursParMatiere(nomMatiere) {
    try {
      const response = await axios.get(
        `http://localhost:8081/cours/all/${nomMatiere}`
      );
      return response.data;
    } catch (error) {
      throw new Error(
        `Erreur lors de la récupération des cours pour la matière ${nomMatiere} : ${error.message}`
      );
    }
  }
}

export default CoursService;
