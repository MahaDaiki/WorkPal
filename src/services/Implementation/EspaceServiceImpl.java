package services.Implementation;

import entities.Espace;
import repositories.Implementation.EspaceRepositoryImpl;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.EspaceRepository;
import repositories.Interface.UserRepository;
import services.Interfaces.EspaceService;

import java.util.List;

public class EspaceServiceImpl implements EspaceService {
    private final EspaceRepository espaceRepository = new EspaceRepositoryImpl();
    @Override
    public boolean addEspace(Espace espace, int gestionnaireId) {
        return espaceRepository.addEspace(espace, gestionnaireId);
    }

    @Override
    public boolean updateEspace(Espace espace, int gestionnaireId) {
        return espaceRepository.updateEspace(espace, gestionnaireId);
    }

    @Override
    public boolean deleteEspace(int espaceId, int gestionnaireId) {
        return espaceRepository.deleteEspace(espaceId, gestionnaireId);
    }

    @Override
    public List<Espace> getEspacesByGestionnaireId(int gestionnaireId) {
        return espaceRepository.getEspacesByGestionnaireId(gestionnaireId);
    }

    @Override
    public List<Espace> getEspacesByDisponibilite(boolean disponibilite) {
        return espaceRepository.getEspacesByDisponibilite(disponibilite);
    }
}
