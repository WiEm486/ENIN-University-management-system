import Axios from "axios";

class AdminService {
  async getAdmins() {
    try {
      const response = await Axios.get(
        "http://localhost:8081/api/super/admins"
      );
      // Handle the response here if needed
      console.log("Admins:", response.data);
      return response.data;
    } catch (error) {
      // Handle errors here
      console.error("Error fetching admins:", error);
      throw error; // Throw the error to handle elsewhere if needed
    }
  }
  async createAdmin(newAdmin, role) {
    try {
      if (role === "ADMIN_SCOLARITE") {
        const response = await Axios.post(
          "http://localhost:8081/api/admins/adminscolarite/new",
          newAdmin,
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        );
        console.log("Nouvel administrateur créé avec succès:", response.data);
        return response.data;
      }

      if (role === "ADMIN_ETUDIANT") {
        const response = await Axios.post(
          "http://localhost:8081/api/admins/adminetudiant/new",
          newAdmin,
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        );

        console.log("Nouvel administrateur créé avec succès:", response.data);
        return response.data;
      }

      // Traitez la réponse ici si nécessaire
    } catch (error) {
      // Gérez les erreurs ici
      console.error("Erreur lors de la création de l'administrateur:", error);
      throw error; // Renvoyez l'erreur pour la traiter ailleurs si nécessaire
    }
  }
}

export default new AdminService();

// http://localhost:8081/api/admins/adminetudiant/new

// http://localhost:8081/api/admins/adminscolarite/new
