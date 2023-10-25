package TrainReservationSystem;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		Train train = new Train();
		Scanner scan = new Scanner(System.in);
		int option = 0;
		
		while (option != 6) {
		System.out.println("\n----------------------------------\n"
				+ "Please Select an Option (1-6):\r\n\n"
				+ "1- Read passenger file.\r\n"
				+ "2- Reserve a new empty seat.\r\n"
				+ "3- Delete a reserved seat.\r\n"
				+ "4- Delete all reserved seats.\r\n"
				+ "5- Update passengers file.\r\n"
				+ "6- Quit.");
		
		
		option = scan.nextInt();
		
		switch (option) {
		      case 1: train.readFile(); break;
		      case 2: train.reserve(); break;
		      case 3: train.deleteReservedSeat(); break;
		      case 4: train.deleteAllReservedSeats(); break;
		      case 5: train.updateFile(); break;
		      case 6: System.out.println("You have quit the system."); break;
		      default: System.out.println("Incorrect input."); break;
	
		}
		
		} 
		
		scan.close();
		
	} 

}
