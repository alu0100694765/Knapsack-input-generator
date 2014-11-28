import java.io.File;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class InputGenerator.
 */

/**
 * @author Sawan
 * 
 */
public class InputGenerator {
	
	/** The Constant NUM_FILES_PER_LOT. */
	private final static int NUM_FILES_PER_LOT = 20;
	
	/** The Constant RELATIVE_PATH. */
	private final static String RELATIVE_PATH = "input_files";

	/**
	 * Generate input.
	 *
	 * @param number_files the number_files
	 * @param number_objects the number_objects
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void generateInput(int number_files, int number_objects) throws IOException {
			for (int i = 0; i < number_files; i++) {
				FileGenerator output_file_content = new FileGenerator(
						generatePath(i, number_objects));
				output_file_content.generateData(number_objects);
				FileWriter output_file = new FileWriter(output_file_content.getFile_name());
				output_file.writeContent(output_file_content.getFile_content());
			}
	}

	/**
	 * Generate path.
	 *
	 * @param number the number
	 * @param file_name the file_name
	 * @return the string
	 */
	public static String generatePath(int number, int file_name) {
		File directory = new File(RELATIVE_PATH + "//" + Integer.toString(file_name));
		
		if (!directory.exists()) {
			directory.mkdir();
		}
		String path = directory.getPath() + "//" + Integer.toString(number) + ".txt";
		return path;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int count = 0;
		do {
			count = count + 100;
			generateInput(NUM_FILES_PER_LOT, count);
			System.out.println("Generated" + " " + count);
		} while (count < 1000);
			
	}

}
