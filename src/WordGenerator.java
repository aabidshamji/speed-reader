import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class WordGenerator {
	private int wordCount;
	private int sentenceCount;
	private Scanner text;

	public WordGenerator (String filename) throws IOException  {
		this.text = new Scanner (new File (filename));
		this.wordCount = 0;
		this.sentenceCount = 0;

	}

	public boolean hasNext(){
		if (text.hasNext())
			return true;
		else
			return false;
	}

	public String next() {
		String nextWord = this.text.next();
		char[] wordArr = nextWord.toCharArray();

		this.wordCount++;
		if ((wordArr[wordArr.length - 1] == '.') ||
				(wordArr[wordArr.length - 1] == '!')||
				(wordArr[wordArr.length - 1] == '?')) 
			this.sentenceCount++;
		return (nextWord);
	}

	public int getWordCount() {
		return this.wordCount;
	}

	public int getSentenceCount(){
		return this.sentenceCount;
	}

	public static void main (String[] args) throws IOException, InterruptedException {
		/*WordGenerator test = new WordGenerator("test.txt");
		while (test.hasNext()) {
			System.out.println(test.next());
			System.out.println(test.getWordCount());
			System.out.println(test.getSentenceCount());
		}*/
		
		DrawingPanel panel = new DrawingPanel(400, 300);
	    Graphics g = panel.getGraphics();
	    Font f = new Font("Courier", Font.BOLD, 46);
	    g.setFont(f);
	    g.drawString("Hello World!", 100, 100);
	    
	    WordGenerator test = new WordGenerator("test.txt");
	        while(test.hasNext()) {
	            System.out.println(test.next());
	            Thread.sleep(1000);
	        
	    }
	}
}
