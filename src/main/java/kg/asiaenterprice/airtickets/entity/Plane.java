package kg.asiaenterprice.airtickets.entity;

public class Plane {



    private Integer idPlane;
    private String company;
    private String model;
    private int seats;

    public Plane() {}

    public Plane(String company, String model, int seats) {
        this.company = company;
        this.model = model;
        this.seats = seats;
    }

    public Integer getIdPlane() {
        return idPlane;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    @Override
    public String toString() {
        return "Plane{" +
                "idPlane=" + idPlane +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                '}';
    }
}
