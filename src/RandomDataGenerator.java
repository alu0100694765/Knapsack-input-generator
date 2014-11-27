// TODO: Auto-generated Javadoc
/**
 * The Class RandomDataGenerator.
 */

/**
 * @author alu4412
 * 
 */
public class RandomDataGenerator {
	
	/** The Constant WEIGHT_FACTOR. */
	private final static double WEIGHT_FACTOR = 0.7;
	
	/** The Constant MAX_WEIGHT. */
	private final static int MAX_WEIGHT = 100;
	
	/** The Constant MIN_WEIGHT. */
	private final static int MIN_WEIGHT = 1;
	
	/** The Constant MAX_VALUE. */
	private final static int MAX_VALUE = 200;
	
	/** The Constant MIN_VALUE. */
	private final static int MIN_VALUE = 10;

	
	
	/**
	 * Knapsack weight.
	 *
	 * @param sum_weight_objects the sum_weight_objects
	 * @return the int
	 */
	public static int knapsackWeight(int sum_weight_objects) {
		return (int) (sum_weight_objects * WEIGHT_FACTOR);
	}

	/**
	 * Object weights.
	 *
	 * @param number_objects the number_objects
	 * @return the int[]
	 */
	public static int[] objectWeights(int number_objects) {
		int[] object_weight = new int[number_objects];

		for (int i = 0; i < number_objects; i++) {
			object_weight[i] = randomNumber(MIN_WEIGHT, MAX_WEIGHT);
		}
		return object_weight;
	}

	/**
	 * Object values.
	 *
	 * @param number_objects the number_objects
	 * @return the int[]
	 */
	public static int[] objectValues(int number_objects) {
		int[] object_values = new int[number_objects];

		for (int i = 0; i < number_objects; i++) {
			object_values[i] = randomNumber(MIN_VALUE, MAX_VALUE);
		}
		return object_values;
	}

	/**
	 * Random number.
	 *
	 * @param min_range the min_range
	 * @param max_range the max_range
	 * @return the int
	 */
	public static int randomNumber(int min_range, int max_range) {
		return (min_range + (int) (Math.random() * ((max_range - min_range) + 1)));
	}
}
