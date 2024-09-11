package services.Interfaces;

import entities.Admin;
import entities.GestionnaireDespaces;

public interface GestionnaireDespacesService {
    boolean registerGestionnaire(GestionnaireDespaces GestionnaireDespaces);
    boolean login(String email, String password);
}
