package transport;
import static validate.Validate.validateString;
public class Main {
    public static void main(String[] args) {
    Bus bus1 = new Bus("Эпл","айфон",2009, "Америка","черный",10, 5.8);
    System.out.println(bus1.toString());
    bus1.refill();
    System.out.println(bus1.toString());
    Car car1 = new Car("тесла", "тесла1", 2022, "Америка", "черный", 200, 0.0, 1.5,null,null,null,2,false,null,null);
    System.out.println(car1.toString());
    car1.refill();
    System.out.println(car1.toString());
    Bus bus2 = new Bus("Тайота", "камри", 2003, "Пакистан",null,5,null);
    System.out.println(bus2.toString());
    bus2.refill();
    System.out.println(bus2.toString());
    }
}