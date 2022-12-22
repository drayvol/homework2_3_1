package transport;
import static validate.Validate.validateString;
import java.time.LocalDate;

public class Car extends Transport {
    private double engineVolume;
    private String gears;
    private final String typeOfBody;
    private String regNumber;
    private final int seatsCount;
    private boolean summerTyres;
    private Key key;
    private Insurance insurance;

    public Car(String brand,
               String model,
               int year,
               String country,
               String color,
               int maxSpeed,
               Double fuelPercentage,
               Double engineVolume,
               String gears,
               String typeOfBody,
               String regNumber,
               Integer seatsCount,
               boolean summerTyres,
               Key key,
               Insurance insurance){
        super(brand,model,year,country,color,maxSpeed,fuelPercentage);
        if (engineVolume == null) this.engineVolume=1.5;
        else this.engineVolume = engineVolume;
        if (gears == null) this.gears = "МКПП";
        else this.gears = gears;
        if (regNumber == null) this.regNumber = "x000xx000";
        else this.regNumber = regNumber;
        if( typeOfBody == null) this.typeOfBody = "седан";
        else this.typeOfBody = typeOfBody;
        this.seatsCount = seatsCount;
        this.summerTyres = summerTyres;
        if (key == null) this.key = new Key();
        else this.key = key;
        if (insurance == null) this.insurance = new Insurance();
        else this.insurance = insurance;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }




    public String getTypeOfBody() {
        return typeOfBody;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }


    public String getGears() {
        return gears;
    }

    public void setGears(String gears) {
        if (gears == null) this.gears = "МКПП";
        else this.gears = gears;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null) this.regNumber ="x000x000";
        else this.regNumber = regNumber;
    }

    public boolean isSummerTyres() {
        return summerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {

        this.summerTyres = summerTyres;
    }
    public void changeTyres(){
        summerTyres = !summerTyres;
    }
    public boolean isCorrectRegNumber(){
        if (regNumber.length()!=9) return false;
        char[] chars = regNumber.toCharArray();
        if(!Character.isAlphabetic(chars[0]) ||!Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) return false;
        if(!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) || !Character.isDigit(chars[3])
                || !Character.isDigit(chars[6]) || !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) return false;
        return true;
    }
    public static class Key{
        private final boolean remoreRunEngine;
        private final boolean withoutKeyAccess;

        public Key(boolean remoreRunEngine, boolean withoutKeyAccess) {
            this.remoreRunEngine = remoreRunEngine;
            this.withoutKeyAccess = withoutKeyAccess;
        }
        public Key(){
            this(false,false);
        }

        public boolean isRemoreRunEngine() {
            return remoreRunEngine;
        }

        public boolean isWithoutKeyAccess() {
            return withoutKeyAccess;
        }
    }
    public static class Insurance{
        private final LocalDate expireDate;
        private final double cost;
        private final String number;

        public Insurance(LocalDate expireDate, double cost, String number) {
            if(expireDate== null) this.expireDate = LocalDate.now().plusDays(365);
            else this.expireDate = expireDate;

            this.cost = cost;
            if (number == null ) this.number ="123456789";
            else this.number = number;
        }
        public Insurance(){
            this(null, 10000, null);
        }

        public LocalDate getExpireDate() {
            return expireDate;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }
        public void checkExpireDate(){
            if(expireDate.isBefore(LocalDate.now()) || expireDate.isEqual(LocalDate.now())) System.out.println("Надо менять страховку");
        }
        public void checkNumber(){
            if(number.length()!=9) System.out.println("Неправильно введен номер");
        }
    }
    @Override
    void refill(){
        System.out.println("Машину можно заправлять бензином, дизелем или заряжать");
        setFuelPercentage(100.00);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", year=" + super.getYear() +
                ", country='" + super.getCountry() + '\'' +
                ", color='" + super.getColor() + '\'' +
                ", maxSpeed=" + super.getMaxSpeed()+
                ", fuelPercentage=" + super.getFuelPercentage() +
                "engineVolume=" + engineVolume +
                ", gears='" + gears + '\'' +
                ", typeOfBody='" + typeOfBody + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", seatsCount=" + seatsCount +
                ", summerTyres=" + summerTyres +
                ", key=" + key +
                ", insurance=" + insurance +
                '}';
    }
}
