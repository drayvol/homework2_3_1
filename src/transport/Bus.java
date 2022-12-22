package transport;
import static validate.Validate.validateString;
public class Bus extends Transport {
    public Bus(String brand, String model, int year, String country, String color, int maxSpeed, Double fuelPercentage){
        super(brand,model,year,country,color,maxSpeed, fuelPercentage);
    }
    @Override
    void refill(){
        System.out.println("Автобус можно заправлять бензином или дизелем");
        setFuelPercentage(100.00);
    }

}
