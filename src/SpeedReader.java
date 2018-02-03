import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public class SpeedReader {
	public static void SpeedReader1 (String filename, int width, int height, int fsize, int wpm) throws IOException, InterruptedException {
		
	
		DrawingPanel panel = new DrawingPanel(width, height);
	    Graphics g = panel.getGraphics();
	    Font f = new Font("Courier", Font.BOLD, fsize);
	    g.setFont(f);
	    g.clearRect(0, 0, 400, 300);
	    g.setColor(Color.WHITE);
	    
	    WordGenerator test = new WordGenerator(filename);
	        while(test.hasNext()) {	        	
	            g.drawString(test.next(), 100, 100);	      
	            Thread.sleep((60/wpm)*1000);          
	            g.clearRect(0, 0, width, height);
   
	    }
	        
	        g.drawString("Number of words processed: " + test.getWordCount(), 100, 100);
	        g.drawString("Number of sentences processed: " + test.getSentenceCount(), 100, 200);
	}
	
	public static boolean check (int x) {
		if (x <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(args.length);
		if (args.length != 5) {	
			System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
			
			System.exit(0);
		}
		
		int width = Integer.parseInt(args[1]);
		int heigth = Integer.parseInt(args[2]);
		int fontSize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);
		
		File temp = new File (args[0]);
		if (!temp.exists()) {
			System.out.println("The file does not exist");
		}
		
		if (!(check(width) && 
				check(heigth) && 
				check(fontSize) && 
				check(wpm))) {
			System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
			System.exit(0);
		}

		SpeedReader1(args[0],width, heigth, fontSize, wpm);
	}

}
