package entities;

public class SuplService {

    private int suplservice_id;
    private String type;
    private String details;
    private int prix;

    public SuplService(String type, String details, int prix) {
        this.type = type;
        this.details = details;
        this.prix = prix;
    }


    public int getSuplservice_id() {
        return suplservice_id;
    }

    public void setSuplservice_id(int suplservice_id) {
        this.suplservice_id = suplservice_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "SuplService{" +
                "suplservice_id=" + suplservice_id +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }


}
