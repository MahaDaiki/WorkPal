package services.Implementation;

import repositories.Implementation.GestionnaireDespacesRepositoryImpl;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.GestionnaireDespacesRepository;
import repositories.Interface.UserRepository;
import services.Interfaces.GestionnaireDespacesService;

public class GestionnairedespaceServiceImpl implements GestionnaireDespacesService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final GestionnaireDespacesRepository Gestionnaire = new GestionnaireDespacesRepositoryImpl();


    @Override
    public int getGestionnaireIdByUserId(int userId) {
        return Gestionnaire.getGestionnaireIdByUserId(userId);
    }
}
