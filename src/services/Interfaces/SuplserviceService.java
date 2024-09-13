package services.Interfaces;

import entities.SuplService;

import java.util.List;

public interface SuplserviceService {
    boolean addSuplservice(SuplService suplservice);
    boolean updateSuplservice(SuplService suplservice, int gestionnaireId);
    boolean deleteSuplservice(int suplserviceId, int gestionnaireId);
    SuplService getSuplserviceById(int suplserviceId);
    List<SuplService> getAllSuplservices();
    List<SuplService> getSuplservicesByGestionnaireId(int gestionnaireId);
}
