import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// TODO: Auto-generated Javadoc
/**
 * The Class FileGenerator.
 */

/**
 * @author alu4412
 * 
 */
public class FileGenerator {
	
	/** The file_name. */
	private String file_name;
	
	/** The file_content. */
	private ArrayList<String> file_content;

	/**
	 * Instantiates a new file generator.
	 *
	 * @param file_name the file_name
	 */
	public FileGenerator(String file_name) {
		this.file_name = file_name;
		file_content = new ArrayList<String>();
	}

	/**
	 * Generate data.
	 *
	 * @param number_objects the number_objects
	 */
	public void generateData(int number_objects) {
		// Add number of objects
		file_content.add(Integer.toString(number_objects));

		//Arraylist for object data (weight value)
		ArrayList<Integer> object_weights = new ArrayList<Integer>(
				Arrays.asList(intToIntegrer(RandomDataGenerator
						.objectWeights(number_objects))));
		ArrayList<Integer> object_values = new ArrayList<Integer>(
				Arrays.asList(intToIntegrer(RandomDataGenerator
						.objectValues(number_objects))));
		
		// Add knapsack weight
		int sum_values_weight = sumValuesArraylist(object_weights);
		file_content.add(Integer.toString(RandomDataGenerator.knapsackWeight(sum_values_weight)));
		
		// Add pairs (weight value) of objects
		Iterator<Integer> iterator_values = object_values.iterator();
		Iterator<Integer> iterator_weights = object_weights.iterator();
		
		while (iterator_values.hasNext() && iterator_weights.hasNext()) {
			Integer value = (Integer) iterator_values.next();
			Integer weight = (Integer) iterator_weights.next();
			
			file_content.add(createPair(weight, value));
		}
		
		
	}

	/**
	 * Int to integrer.
	 *
	 * @param data the data
	 * @return the integer[]
	 */
	public static Integer[] intToIntegrer(int[] data) {
		Integer[] result = new Integer[data.length];

		for (int i = 0; i < data.length; i++) {
			result[i] = data[i];
		}

		return result;
	}
	
	/**
	 * Sum values arraylist.
	 *
	 * @param data the data
	 * @return the integer
	 */
	public static Integer sumValuesArraylist(ArrayList<Integer> data) {
		Integer sum_values = 0;
		
		for (Iterator<Integer> iterator = data.iterator(); iterator.hasNext();) {
			Integer data_value = (Integer) iterator.next();
			sum_values += data_value;
		}
		
		return sum_values;
	}

	/**
	 * Creates the pair.
	 *
	 * @param value the value
	 * @param weight the weight
	 * @return the string
	 */
	public String createPair(Integer value, Integer weight) {
		String pair = Integer.toString(value) + " " + Integer.toString(weight);
		
		return pair;
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * @return the file_content
	 */
	public ArrayList<String> getFile_content() {
		return file_content;
	}
	
	
}
