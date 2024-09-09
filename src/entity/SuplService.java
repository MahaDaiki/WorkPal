package entity;

public class SuplService {

    private int suplservice_id;
    private String type;
    private String details;

    public SuplService(String type, String details) {
        this.type = type;
        this.details = details;
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

    @Override
    public String toString() {
        return "SuplService{" +
                "suplservice_id=" + suplservice_id +
                ", type='" + type + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
