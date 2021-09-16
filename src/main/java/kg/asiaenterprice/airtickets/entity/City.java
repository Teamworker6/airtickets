package kg.asiaenterprice.airtickets.entity;

public class City {



    private Integer idCity; // null
    private String cityName; // null
    private String countryName; // null
    private double lat;
    private double lng;
    private long population; // null

    public City(){

    }

    public City(Integer idCity, String cityName, String countryName, double lat, double lng, long population) {
        this.idCity = idCity;
        this.cityName = cityName;
        this.countryName = countryName;
        this.lat = lat;
        this.lng = lng;
        this.population = population;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", population=" + population +
                '}';
    }
}
