import axios from "axios";
class EmploiEducationService {


getEmploibyGroupeAndSpeciality(groupe,specialite)
{
    return axios.get("....../${specialite}/${groupe}")
}



}

export default new EmploiEducationService();

