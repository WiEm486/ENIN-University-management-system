import axios from "axios";

class SpecialiteService {
  static async getSpecialites() {
    try {
      const response = await axios.get("http://votre-api.com/specialites");
      return response.data;
    } catch (error) {
      console.error("Erreur dans SpecialiteService:", error);
      throw error;
    }
  }
}

export default SpecialiteService;
