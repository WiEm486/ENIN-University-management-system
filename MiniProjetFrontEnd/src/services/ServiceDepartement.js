import axios from "axios";

class ServiceDepartement {
  static async getDepartements() {
    try {
      const response = await axios.get(
        "http://localhost:8081/departement/tout"
      );
      return response.data;
    } catch (error) {
      console.error("Error fetching departements:", error);
      throw error;
    }
  }
}

export default ServiceDepartement;
