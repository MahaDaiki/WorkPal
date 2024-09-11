package services.Implementation;

import entities.GestionnaireDespaces;
import repositories.Implementation.AdminRepositoryImpl;
import repositories.Implementation.GestionnaireDespacesRepositoryImpl;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.AdminRepository;
import repositories.Interface.GestionnaireDespacesRepository;
import repositories.Interface.UserRepository;
import services.Interfaces.GestionnaireDespacesService;

public class GestionnairedespaceImpl implements GestionnaireDespacesService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final GestionnaireDespacesRepository Gestionnaire = new GestionnaireDespacesRepositoryImpl();



}
