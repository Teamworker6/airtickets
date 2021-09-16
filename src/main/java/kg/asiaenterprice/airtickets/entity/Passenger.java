package kg.asiaenterprice.airtickets.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Passenger {


    public static final SimpleDateFormat formatter;

    static {
        formatter = new SimpleDateFormat("dd/MM/yyyy");
    }

    private Integer idPassenger;
    private String firstname;
    private String lastname;
    private String middleName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String passport;
    private LocalDate birthDate;

    public Passenger() {

    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Passenger(Integer idPassenger, String firstname, String lastname, String middleName, String gender, String phoneNumber, String email, String passport, LocalDate birthDate) {
        this.idPassenger = idPassenger;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleName = middleName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passport = passport;
        this.birthDate = birthDate;
    }

    public Integer getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(Integer idPassenger) {
        this.idPassenger = idPassenger;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("" +
                "First name: %s%n" +
                "Last name: %s%n" +
                "Gender: %s%n" +
                "Birth date: %s%n" +
                "Phone number: %s%n" +
                "E-mail: %s%n" +
                "Passport: %s",
                firstname,
                lastname,
                gender,
                formatter.format(birthDate),
                phoneNumber,
                email,
                passport);
    }
}
