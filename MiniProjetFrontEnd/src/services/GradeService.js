// ServiceGrade.js
import axios from "axios";

class GradeService {
  static async getGrades() {
    try {
      const response = await axios.get("http://localhost:8081/grade/tout");
      return response.data;
    } catch (error) {
      console.error("Error fetching grades:", error);
      throw error;
    }
  }
}

export default GradeService;
