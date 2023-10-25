package TrainReservationSystem;
import java.util.Scanner;
import java.io.*;

public class Train {
	
	private static Seat [][] seat;
	private Scanner scan;
	
	Train () {
		scan = new Scanner(System.in);
		
		seat = new Seat [23][];		
		seat[0] = new Seat[2];
		seat[22] = new Seat[2];
		
		for (int i = 1; i < 22; i++)
			seat[i] = new Seat[4];
		
		}
	
	
	
	void readFile () throws FileNotFoundException {
		File file = new File("/Users/Admin/Desktop/passengers.txt");
		Scanner scan = new Scanner(file);
		
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
		
		scan.close();
	}
	
	void reserve () {
		int seatNumber;
		do { System.out.println("Enter a valid seat number: ");
	    seatNumber = scan.nextInt();
			} while (!Seat.isValid(seatNumber));
			
			int r = Seat.getRow(seatNumber);
			int c = Seat.getColumn(seatNumber);
			
			if (seatNumber == 91 || seatNumber == 92) 
				c -= 2;
		
		if (seat[r][c] == null) {
			
		seat[r][c] = new Seat(seatNumber);
		System.out.println("Please enter the passenger's name: ");
		String name = scan.next(); 
		seat[r][c].setPasseneger(name);
		System.out.println("Done. Reserved.");
		
		} else if (seat[r][c].isEmpty()) {
			System.out.println("Please enter passenger's name: ");
			String name = scan.next();
			seat[r][c].setPasseneger(name);
			
		} else
			System.out.println("Seat is occupied.");
		
		
	}
	
	void deleteReservedSeat () {
		int seatNumber;
		do { System.out.println("Enter a valid seat number: ");
	    seatNumber = scan.nextInt();
			} while (!Seat.isValid(seatNumber));
		
		int r = Seat.getRow(seatNumber);
		int c = Seat.getColumn(seatNumber);
		
		if (seatNumber == 91 || seatNumber == 92) 
			c -= 2;
		
		if (seat[r][c] == null) {
			System.out.println("This seat is yet to be created.");
		} else if (seat[r][c].isEmpty()) {
			System.out.println("Seat is already empty.");
		} else {
			seat[r][c].setPasseneger("null");
			System.out.println("deleted.");
		}
		
		
	}
	
	void deleteAllReservedSeats () {
		for (int i = 1; i <= 92; i++) {
			if (Seat.isValid(i)) {
				int r = Seat.getRow(i);
				int c = Seat.getColumn(i);
				
				if (i == 91 || i == 92) 
					c -= 2;
				
				if (seat[r][c] != null && !seat[r][c].isEmpty()) {
				  seat[r][c].setPasseneger(null);
			}
		}
	}
		
	}
	
	void updateFile () throws IOException {
		BufferedWriter writer = new BufferedWriter (new FileWriter("/Users/Admin/Desktop/passengers.txt"));
		
		for (int i = 1; i <= 92; i++) {
			
			if (Seat.isValid(i)) {
					int r = Seat.getRow(i);
					int c = Seat.getColumn(i);
					
					if (i == 91 || i == 92) 
						c -= 2;
					
					if (seat[r][c] == null) 			
						writer.write(i + " : Null.  ");						
					 else {
						 if (seat[r][c].getPassenger() == "null")   
							    writer.write(i + " : Null.  ");
					        else 
								writer.write(i + " : " + seat[r][c].getPassenger() + "  ");
					     }
					 											
	if (i == 2 || i % 4 == 0)
		writer.write("\n");
		  } 
			
		}  // end of for loop
		
		writer.close();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

}
