package repositories.Interface;

import entities.Admin;
import entities.GestionnaireDespaces;

public interface GestionnaireDespacesRepository {
    void register(GestionnaireDespaces GestionnaireDespaces);
    int getGestionnaireIdByUserId(int userId);
}
