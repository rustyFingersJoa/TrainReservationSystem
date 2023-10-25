package TrainReservationSystem;

public class Seat {
	private int seatNumber;
	private String passenger;
	
	Seat () {
		this(0);
	}
	
	Seat (int seatNumber){
		this.setSeatNumber(seatNumber);
		this.passenger = null;
	}
	
    boolean isEmpty () {
		if (passenger == null) {
			return true;
		} else
			return false;
	}
	
	static boolean isValid (int sn) {
		if (sn >= 1 && sn <= 92 && sn != 3 && sn != 4 && sn != 89 && sn != 90) 
			return true;
		 else 
			return false;
	}
	static int getRow (int seatNumber) {
		if (seatNumber % 4 == 0)
			return (seatNumber - 1) / 4;
		else
			return (seatNumber / 4);
}
	
	static int getColumn (int seatNumber) {
		 if (seatNumber % 4 == 0) {
			 return 3;
		 } else
			 return (seatNumber % 4) - 1;
  }
	
	
	
	void setSeatNumber (int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	int getSeatNumber () {
		return seatNumber;
	}
	
	void setPasseneger (String passenger) {
		this.passenger = passenger;
	}
	
	String getPassenger () {
		return passenger;
	}
	
	public String toString () {
		return this.seatNumber + " : " + this.passenger;
	}

	
}
