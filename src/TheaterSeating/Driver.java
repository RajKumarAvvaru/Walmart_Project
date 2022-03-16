package TheaterSeating;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		Theater theater = new Theater(10);
		
		StringBuilder confirmation = new StringBuilder();
	 String input=args[0];
	 
	 //Reading input
	 try (BufferedReader br = new BufferedReader(new FileReader(input))){
		String line = br.readLine();
		//theater.PrintTheater();
		System.out.println("input file content...................");
		while(line!=null) {
			String[] order = line.split(" ");//splitting the line   
			String reservationIdentifier = order[0];
			int numberOfSeats = Integer.parseInt(order[1]);
			confirmation.append(theater.fillSeats(reservationIdentifier, numberOfSeats));
	        
			line = br.readLine();
		}
		//writing to the output file
		File file = new File("output.txt");
	      BufferedWriter b = new BufferedWriter(new FileWriter(file));
	      b.write(confirmation.toString());
	      System.out.println("\noutput file content...................");
	      System.out.println(confirmation.toString());
	      b.flush();
	      b.close();
	      System.out.println("\nOutput File Path: "+file.getAbsoluteFile()+"\n");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
		 
	 
	 
	 //theater.PrintTheater();

}
}
