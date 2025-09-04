import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = 3;
        Car[] cars = new Car[numberOfCars];
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Chassis id for car number #" + i + ": ");
            String chassis = scanner.nextLine();
            System.out.println("License id for car number #" + i + ": ");
            String licenseNumber = scanner.nextLine();
            cars[i] = new Car(licenseNumber, new Chassis(chassis));
        }
        for(Car car: cars){
            System.out.println("Chassis: " + car.getChassis().getNumber());
            System.out.println("License id:");
            String lNum = scanner.nextLine();
            System.out.println("Chassis id:");
            String cNum = scanner.nextLine();
            car.setChassis(new Chassis(cNum));
            car.setLicenseNumber(lNum);
        }
        for (Car car : cars){
            System.out.println("Chassis: " + car.getChassis().getNumber());

        }
    }
}