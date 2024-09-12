package services.Interfaces;

import entities.Espace;

import java.util.List;

public interface EspaceService {
    boolean addEspace(Espace espace, int gestionnaireId);
    boolean updateEspace(Espace espace, int gestionnaireId);
    boolean deleteEspace(int espaceId, int gestionnaireId);
    List<Espace> getEspacesByGestionnaireId(int gestionnaireId);
    List<Espace> getEspacesByDisponibilite(boolean disponibilite);
}
