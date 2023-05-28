
import java.util.*;
public class car
{
	public int car_id;
	public float price;
	public String carType;
	public float drive_range;
	public String pinakida;
	public int insurance;
	public int provider_id;
	public int arithmos_kykloforias;

	public ArrayList<car> carList;

	public car(int car_id,float price,String carType,float drive_range,String pinakida, int insurance,int provider_id,int arithmos_kykloforias){
		this.car_id=car_id;
		this.price=price;
		this.carType=carType;
		this.drive_range=drive_range;
		this.pinakida=pinakida;
		this.insurance=insurance;
		this.provider_id=provider_id;
		this.arithmos_kykloforias=arithmos_kykloforias;
		this.carList=new ArrayList<car>();
	}
	public void set_carList(car car) throws D2DException{
		if(this.carList.contains(car)){   //check if car already exists in the list
			throw new D2DException("Item already exists"); //exception class if item already in list
		}
		else{                   //if not exists add it to the list
			this.carList.add(car);
		}


	}

	public void setInsurance_id(Insurance ins) {
		this.insurance = ins.insurance_id;
	}
	public int getProviderId() {
		return provider_id;
	}


	public int getCar_id() {return car_id ;}

	public String getPinakida(){return pinakida;}

	public ArrayList<car> getCarList() {
		return carList;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	public String getCarType() {
		return carType;
	}
	public void print_car(car car){
		System.out.print("Car id: "+ car.car_id+"\n");
		System.out.print("Car price: "+car.price+"\n");
		System.out.print("Car model: "+car.carType+"\n");
		System.out.print("Car drive range: "+car.drive_range+"\n");
		System.out.print("Car pinakida: "+ car.pinakida+"\n");
		System.out.print("Car insurance number: "+ car.insurance+"\n");
		System.out.print("Car owner id: "+car.provider_id+"\n");

	}
	public void editinfo() {
		car newcar = new car(0, 1, "tesla model S", 25, "KYR8851", 0, 3252564, 0);

		System.out.println("Welcome to edit car info page\n");
		Scanner edit = new Scanner(System.in);
		newcar.print_car(newcar);
		System.out.println("Choose which value you would like to change:\n" + "carType(1)\n" + "drive_range(2)\n" + "pinakida(3)\n" + "insurance(4)\n");
		String nedit = edit.nextLine();
		int int_edit = Integer.parseInt(nedit);

		if (int_edit == 1) {
			Scanner m = new Scanner(System.in);
			System.out.println("Type the new carType");
			String carType = m.nextLine();
			newcar.carType = carType;
			newcar.print_car(newcar);
		} else if (int_edit == 2) {
			Scanner fr = new Scanner(System.in);
			System.out.println("Type the new drive range");
			String flightr = fr.nextLine();
			float nflightr = Float.parseFloat(flightr);
			newcar.drive_range = nflightr;
			newcar.print_car(newcar);
		} else if (int_edit == 3) {
			Scanner qs = new Scanner(System.in);
			System.out.println("Type the new pinakida");
			String quas = qs.nextLine();
			newcar.pinakida = quas;
			newcar.print_car(newcar);
		} else if (int_edit == 4) {
			Scanner lc = new Scanner(System.in);
			System.out.println("Type the new insurance number");
			String insr = lc.nextLine();
			int insur = Integer.parseInt(insr);
			newcar.print_car(newcar);
		} else {
			System.out.println("Invalid option");
		}
	}

	public void changePrice() {
		Scanner pr = new Scanner(System.in);
		System.out.println("Type the new price per km");
		String nprice = pr.nextLine();
		float price = Float.parseFloat(nprice);
		this.price = price;
		this.print_car(this);
	}

}