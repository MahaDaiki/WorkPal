package services.Implementation;

import entities.SuplService;
import repositories.Implementation.EspaceRepositoryImpl;
import repositories.Implementation.SuplserviceRepositoryImpl;
import repositories.Interface.EspaceRepository;
import repositories.Interface.SuplserviceRepository;

import java.util.List;

public class SuplserviceServiceImpl implements SuplserviceRepository {
    private final SuplserviceRepository suplserviceRepository = new SuplserviceRepositoryImpl();
    @Override
    public boolean addSuplservice(SuplService suplservice) {
      return suplserviceRepository.addSuplservice(suplservice);
    }

    @Override
    public boolean updateSuplservice(SuplService suplservice, int gestionnaireId) {
        return suplserviceRepository.updateSuplservice( suplservice, gestionnaireId) ;
    }

    @Override
    public boolean deleteSuplservice(int suplserviceId, int gestionnaireId) {
        return suplserviceRepository.deleteSuplservice(suplserviceId, gestionnaireId);
    }

    @Override
    public SuplService getSuplserviceById(int suplserviceId) {
        return suplserviceRepository.getSuplserviceById(suplserviceId);
    }

    @Override
    public List<SuplService> getAllSuplservices() {
        return suplserviceRepository.getAllSuplservices();
    }

    @Override
    public List<SuplService> getSuplservicesByGestionnaireId(int gestionnaireId) {
        return suplserviceRepository.getSuplservicesByGestionnaireId(gestionnaireId);
    }
}
