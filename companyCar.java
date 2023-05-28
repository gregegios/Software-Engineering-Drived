import java.util.*;

public class companyCar {
    private final String companyId;
    private final car car;

    public companyCar(String companyId, car carObj) {
        this.companyId = companyId;
        this.car = carObj;
    }

    public void editInfo() {
        if (car.getProviderId() == Integer.parseInt(companyId)) {
            car.editinfo();
        } else {
            System.out.println("You are not authorized to edit this car's information.");
        }
    }

    public void changePrice() {
        if (car.getProviderId() == Integer.parseInt(companyId)) {
            Scanner pr = new Scanner(System.in);
            System.out.println("Type the new price per km");
            String nprice = pr.nextLine();
            float price = Float.parseFloat(nprice);
            car.setPrice(price);
            car.print_car(car);
        } else {
            System.out.println("You are not authorized to change the price of this car.");
        }
    }

    public void deleteCar() {
        ArrayList<car> carList = car.getCarList();
        if (car.getProviderId() == Integer.parseInt(companyId)) {
            if (carList.contains(car)) {
                carList.remove(car);
                System.out.println("Deleting car: " + car.getCarType());
            } else {
                System.out.println("Car not found in the car list.");
            }
        }
        else {
            System.out.println("You are not authorized to make any modifications to this car.");
        }

        // Other methods and fields of the OwnerCar class
    }

}
