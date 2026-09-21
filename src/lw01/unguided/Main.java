import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rental> rentals = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int jumlahRental = sc.nextInt();
        
        for(int i = 0; i < jumlahRental; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

            if(type.equals("LAPTOP")) {
                rentals.add(new LaptopRental(id, days));
            } else if (type.equals("PROJECTOR")) {
                rentals.add(new ProjectorRental(id, days));
            }

            System.out.println(rentals.get(i).summary() + " | " + rentals.get(i).calculateCharge() * units);
        }

        /*for(Rental rental : rentals) {
            System.out.println(rental.summary() + " | " + rental.calculateCharge());
        }*/
    }
}
