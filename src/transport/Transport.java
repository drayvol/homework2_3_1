package transport;

import static validate.Validate.validateString;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private String color;
    private int maxSpeed;
    private Double fuelPercentage;

    public Transport(String brand, String model, int year, String country, String color, int maxSpeed, Double fuelPercentage) {
        this.brand = validateCarParameters(brand);
        this.model = validateCarParameters(model);
        this.year = validateYear(year);
        this.country = validateCountry(country);
        this.color = validateColor(color);
        this.maxSpeed = maxSpeed;
        this.fuelPercentage = validateFuel(fuelPercentage);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getFuelPercentage() {
        return fuelPercentage;
    }

    public void setFuelPercentage(Double fuelPercentage) {
        this.fuelPercentage = fuelPercentage;
    }

    public static int validateYear(Integer value){ return value == null || value <=1900 ? 2000: value;}
    public static String validateColor (String value){ return validateString(value,"белый");}
    public static String validateCountry(String value){ return validateString(value, "Rus");}
    public static String validateCarParameters(String value){return validateString(value,"не указано");}
    public static Double validateFuel(Double value) {return value == null || value < 0 || value > 100 ? 0.00 : value;}
    abstract void refill();

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuelPercentage=" + fuelPercentage +
                '}';
    }
}
