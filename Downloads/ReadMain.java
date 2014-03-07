import java.util.Scanner;


public class ReadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String filePathIn = "";
		String filePathOut = "";
		ReadFile reader = new ReadFile();
		System.out.println("Please enter a file path to write from");
		filePathIn = in.next();
		System.out.println("Please enter a file path to write to");
		filePathOut = in.next();
		reader.setInPath(filePathIn);
		reader.setOutPath(filePathOut);
		reader.setIO();
		reader.initCopy();


	}

}
