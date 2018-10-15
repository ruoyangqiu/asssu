/*
 *  This class will construct a zippy which store every line of strings in a source file
 *  It will return a string chosen from the file randomly or sequentially. 
 */



package zippy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zippy {
	private List<String> zippyQuoteFile; // Arraylist store the zippy quote file 
	// The location of zippy quote file
	private static final String FILE_NAME = "C:\\Users\\robin\\Documents\\JeeWorkspace\\Session1InClass\\data\\yow.lines"; 

	// Constructor. It will store every line of zippy quote file as a string in an Arraylist
	public Zippy() {
		zippyQuoteFile = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
			String currentLine = br.readLine();
			while(currentLine != null) {
				zippyQuoteFile.add(currentLine);
				currentLine = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Return a Zippy Quote chosen from the source file
	// It will pass a integer called order to decide
	// If it will return a random chosen sentence from file
	// If order is negative. Else it will return the sentence of
	// the line of order
	
	public String toString(int order) {
		if(order < 0) {
			return zippyQuoteFile.get(this.random());
		} else {
			return zippyQuoteFile.get(order);
		}
		
	}
	
	// Generate a random integer between 0 and the length of the file - 1.
	private int random() {
		Random rand = new Random();
		return rand.nextInt(zippyQuoteFile.size() + 1);
	}
	
}
