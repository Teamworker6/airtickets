package kg.asiaenterprice.airtickets.entity;
import  kg.asiaenterprice.airtickets.entity.Plane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Flight {


    public static final SimpleDateFormat formatter;

    static {
        formatter = new SimpleDateFormat("HH:mm dd/MM/yyyy");
    }

    private Integer idFlight;
    private Date flightDate;
    private Plane plane;
    private City from;
    private City to;
    private ArrayList<Passenger> passengers;

    public Flight(Integer idFlight, Date flightDate, Plane plane, City from, City to, ArrayList<Passenger> passengers) {
        this.idFlight= idFlight;
        this.flightDate = flightDate;
        this.plane = plane;
        this.from = from;
        this.to = to;
        this.passengers = passengers;
    }

    public Integer getIdFlight() {
        return idFlight;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return String.format("" +
                "ID of flight: \033[32m%d\033[0m%n" +
                "Date of flight: \033[32m%s\033[0m%n" +
                "\033[97mFrom:\033[0m%n%s%n" +
                "\033[97mTo:\033[0m%n%s%n" +
                "%s%n" +
                "Seats available: \033[32m%d\033[0m",
                idFlight,
                formatter.format(flightDate),
                from,
                to,
                plane,
                plane.getSeats() - passengers.size());
    }
}
