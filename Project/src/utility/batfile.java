package utility;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class batfile {
	public static void main(String[] args) throws IOException {

		/*
		 * File dir = new File(
		 "C:\\Travlogix\\Batch file execution\\Salesrefundcar");
		  ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","Start","Carbookingcard.bat"); pb.directory(dir); Process p =
		  pb.start();
		 */

		File dir = new File("C:\\Travlogix\\Batch file execution\\Salesrefundcar");

		String[] files = dir.list();

		// pathnames = dir.list();
		for (int i = 0; i < files.length; i++) 
		{
			
			System.out.println(files[i]);
			//ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","Start","Carbookingcard.bat"); 
			ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","Start",""); 
			
			//pb.directory(dir); 
			
			Process p = pb.start();
			
			p.destroy();
			
		
		}
	}
}