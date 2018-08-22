package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Danfee
 */
public class Model {

	/**
	 * 
	 */
	public static final char CLONE_NUMBERS = 'Y';

	/**
	 * 
	 */
	public static final char NO_CLONE_NUMBERS = 'N';

	/**
	 * 
	 */
	public static final String MERGE_SORT = "Merge Sort";

	/**
	 * 
	 */
	public static final String QUICK_SORT = "Quick Sort";

	/**
	 * 
	 */
	public static final String PIGEONHOLE_SORT = "PigeonHole Sort";

	/**
	 * 
	 */
	public static final char INTEGERS = 'i';

	/**
	 * 
	 */
	public static final char FLOAT = 'f';

	/**
	 * 
	 */
	public static final char SORT_GENERATION = 's';

	/**
	 * 
	 */
	public static final char INVERSAL_SORT_GENERATION = 'S';

	/**
	 * 
	 */
	public static final char COMPLETLY_RANDOM_GENERATION = 'c';
	/**
	 * 
	 */
	private float[] floatList;

	/**
	 * 
	 */
	private float[] floatSortedist;

	/**
	 * 
	 */
	private int[] integerList;

	/**
	 * 
	 */
	private int[] integerSortedist;

	/**
	 * Default constructor
	 */
	public Model() {
	}

	/**
	 * this method read the numbers within file and, depend of number type, chooses
	 * which converter uses finally, set the correct list with that numbers.
	 * 
	 * @param file       is the file that contain the set of number to sort
	 * @param numberType defines what kind of number are within file
	 * @throws FileWithNotNumbersSet      throws when the file has not lines with
	 *                                    numbers to setting
	 * @throws FileWithNoSetSizeException throws when the file has not a line
	 *                                    specifying set's size
	 * @throws IOException                throws when a problem reading line appears
	 * @throws NumberFormatException      throws when is not possible to convert a
	 *                                    String to a float
	 */
	public void readNumbersFile(File file, char numberType)
			throws NumberFormatException, IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {

		switch (numberType) {
		case FLOAT:

			floatList = convertFileToFloatList(new BufferedReader(new FileReader(file)));
			break;

		case INTEGERS:

			integerList = convertFileToIntegerList(new BufferedReader(new FileReader(file)));
			break;
		}
	}

	/**
	 * this method converts the file in a float set.
	 * 
	 * @param buffer is the buffer that allow the method to read every line
	 * @return auxiliarList is the float set with every float within file
	 * @throws IOException                throws when a problem reading line appears
	 * @throws NumberFormatException      throws when is not possible to convert a
	 *                                    String to a float
	 * @throws FileWithNoSetSizeException throws when the file has not a line
	 *                                    specifying set's size
	 * @throws FileWithNotNumbersSet      throws when the file has not lines with
	 *                                    numbers to setting
	 */
	public float[] convertFileToFloatList(BufferedReader buffer)
			throws NumberFormatException, IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {

		float[] auxiliarList = null;
		if (!buffer.readLine().equalsIgnoreCase("#set's size")) {
			throw new FileWithNoSetSizeException();
		}

		int size = Integer.parseInt(buffer.readLine());
		auxiliarList = new float[size];

		String line = buffer.readLine();

		if (line == null || line.isEmpty()) {
			throw new FileWithNotNumbersSet();
		}

		int numberline = 4;
		while (line != null && !line.isEmpty()) {
			line = line.trim();
			String[] lineList = line.split("-");

			for (int i = 0; i < lineList.length; i++) {
				try {
					auxiliarList[i] = Float.parseFloat(lineList[i]);
				} catch (NumberFormatException e) {
					throw new NumberFormatException("There is a problem in your file, some value was not good write "
							+ "\n the number is: " + lineList[i] + " in the line: " + numberline);
				}
			}
			numberline++;
			line = buffer.readLine();
		}

		return auxiliarList;
	}

	/**
	 * this method converts the file in a integer set.
	 * 
	 * @param buffer is the buffer that allow the method to read every line
	 * @return auxiliarList is the float set with every float within file
	 * @throws IOException                throws when a problem reading line appears
	 * @throws NumberFormatException      throws when is not possible to convert a
	 *                                    String to a float
	 * @throws FileWithNoSetSizeException throws when the file has not a line
	 *                                    specifying set's size
	 * @throws FileWithNotNumbersSet      throws when the file has not lines with
	 *                                    numbers to setting
	 */
	public int[] convertFileToIntegerList(BufferedReader buffer)
			throws IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {

		int[] auxiliarList = null;
		if (!buffer.readLine().equalsIgnoreCase("#set's size")) {
			throw new FileWithNoSetSizeException();
		}

		int size = Integer.parseInt(buffer.readLine());
		auxiliarList = new int[size];

		String line = buffer.readLine();

		if (line == null || line.isEmpty()) {
			throw new FileWithNotNumbersSet();
		}

		int numberline = 4;
		while (line != null && !line.isEmpty()) {
			line = line.trim();
			String[] lineList = line.split("-");

			for (int i = 0; i < lineList.length; i++) {
				try {
					auxiliarList[i] = Integer.parseInt(lineList[i]);
				} catch (NumberFormatException e) {
					throw new NumberFormatException("There is a problem in your file, some value was not good write "
							+ "\n the number is: " + lineList[i] + " in the line: " + numberline);
				}
			}
			numberline++;
			line = buffer.readLine();
		}

		return auxiliarList;
	}

	/**
	 * this method decide which algorithm use to generate the random list to sort
	 * 
	 * @param size          is the length of the list
	 * @param startInterval define the interval's start of numbers what user want
	 * @param endInterval   define the interval's end of numbers what user want
	 * @param cloneNumber   this parameter define if the list would has numbers
	 *                      clone
	 * @param numberType    define which type of number is.
	 */
	public void generateElements(int size, int startInterval, int endInterval, char cloneNumber, char generateType,
			char numberType) {
		Random rand = new Random();
		Object[] list = null;
		switch (numberType) {
		case INTEGERS:

			switch (generateType) {
			case SORT_GENERATION:

				// TODO
				break;

			case INVERSAL_SORT_GENERATION:
				// TODO
				break;

			case COMPLETLY_RANDOM_GENERATION:

				list = completeRandomElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;
			}

			this.integerList = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				this.integerList[i] = (int) list[i];
			}

			break;

		case FLOAT:

			switch (generateType) {
			case SORT_GENERATION:

				// TODO
				break;

			case INVERSAL_SORT_GENERATION:
				// TODO
				break;

			case COMPLETLY_RANDOM_GENERATION:
				list = completeRandomElements(size, startInterval, endInterval, cloneNumber, numberType, rand);
				break;
			}

			this.floatList = new float[list.length];
			for (int i = 0; i < list.length; i++) {
				this.floatList[i] = (float) list[i];
			}

			break;
		}

	}

	/**
	 * @param size
	 * @param startInterval
	 * @param endInterval
	 * @param cloneNumber
	 * @param numberType
	 * @param randomPorcentage
	 */
	public void generateElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType,
			int randomPorcentage) {
		// TODO implement here
	}

	/**
	 * this method create a list with the numbers in the interval but in random
	 * position.
	 * 
	 * @param size          is the length of the list
	 * @param startInterval define the interval's start of numbers what user want
	 * @param endInterval   define the interval's end of numbers what user want
	 * @param cloneNumber   this parameter define if the list would has numbers
	 *                      clone
	 * @param numberType    define which type of number is.
	 * @return list is a object array that provide a list with the numbers in the
	 *         interval but in random position. This list only has one type of
	 *         number. it is defined by the parameter "numberType"
	 */
	public Object[] completeRandomElements(int size, int startInterval, int endInterval, char cloneNumber,
			char numberType, Random rand) {

		// if we need to create a list without clone numbers and the numbertypes are
		// integers, the list's size would be the same as the interval
		if (cloneNumber == NO_CLONE_NUMBERS && (endInterval - startInterval + 1) < size && numberType == INTEGERS)
			size = endInterval - startInterval + 1;

		Object[] list = new Object[size];

		// fill the list with numbers in the interval
		fillListWithNumbersInAInterval(numberType, cloneNumber, list, startInterval, endInterval, rand);

		for (int i = 0; i < list.length; i++) {
			int randomIndex = (int) Math.floor(Math.random() * (-(list.length + 1)) + list.length);

			Object temp = list[i];
			list[i] = list[randomIndex];
			list[randomIndex] = temp;
		}

		return list;
	}

	/**
	 * @return
	 */
	public Object[] sortedElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType,
			Random rand) {
		// TODO implement here

		// if we need to create a list without clone numbers and the numbertypes are
		// integers, the list's size would be the same as the interval
		if (cloneNumber == NO_CLONE_NUMBERS && (endInterval - startInterval + 1) < size && numberType == INTEGERS)
			size = endInterval - startInterval + 1;

		Object[] list = new Object[size];

		// fill the list with numbers in the interval
		fillListWithNumbersInAInterval(numberType, cloneNumber, list, startInterval, endInterval, rand);
		
		if(numberType == FLOAT)
		{
			float[] auxiliarList = new float[list.length];
			for (int i = 0; i < list.length; i++) {
				auxiliarList[i] = (float) list[i];
			}
			auxiliarList =radixSort(auxiliarList);
			
			for (int i = 0; i < list.length; i++) {
				list[i] = auxiliarList[i];
			}
		}else
		{
			int[] auxiliarList = new int[list.length];
			for (int i = 0; i < list.length; i++) {
				auxiliarList[i] = (int) list[i];
			}
			
			auxiliarList=pigeonHoleSort(auxiliarList);
			
			for (int i = 0; i < list.length; i++) {
				list[i] = auxiliarList[i];
			}
		}
		
		return list;
	}

	// this method fill the list with numbers in a interval.
	public void fillListWithNumbersInAInterval(char numberType, char cloneNumber, Object[] list, int startInterval,
			int endInterval, Random rand) {
		for (int i = 0; i < list.length; i++) {
			if (numberType == FLOAT) {
				list[i] = startInterval + (endInterval - startInterval) * rand.nextFloat();
			} else {
				if (cloneNumber == NO_CLONE_NUMBERS) {
					list[i] = startInterval + i;
				} else {
					list[i] = (int) Math.floor(Math.random() * (startInterval - (endInterval + 1)) + endInterval);
				}
			}
		}
	}

	/**
	 * @return
	 */
	public int[] sortedIntegerElements() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public float[] invertedFloatElements() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public int[] invertedIntegerElements() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public float[] segmentalFloatRandomElements() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public int[] segmentalIntegerRandomElements() {
		// TODO implement here
		return null;
	}

	/**
	 * @param numbertype
	 * @return informacion con el runtime, espacio usado, algoritmo empleado.
	 */
	public Object sortPerformance(char numbertype) {
		// TODO implement here
		return null;
	}

	/**
	 * @param numberType
	 */
	public void choiceAlgorithm(char numberType) {
		// TODO implement here
	}

	/**
	 * @param list
	 * @return
	 */
	public float[] sortFloats(float[] list) {
		// TODO implement here
		return null;
	}

	/**
	 * @param list
	 * @return
	 */
	public int[] sortIntegers(int[] list) {
		// TODO implement here
		return null;
	}

	/**
	 * @param list
	 * @return
	 */
	public int[] quickSort(int[] list) {
		// TODO implement here
		return null;
	}

	/**
	 * @param list
	 * @return
	 */
	public int[] pigeonHoleSort(int[] list) {
		// TODO implement here
		return null;
	}

	/**
	 * @param list
	 * @return
	 */
	public float[] radixSort(float[] list) {
		// TODO implement here
		return null;
	}

	public float[] getFloatList() {
		return floatList;
	}

	public void setFloatList(float[] floatList) {
		this.floatList = floatList;
	}

	public float[] getFloatSortedist() {
		return floatSortedist;
	}

	public void setFloatSortedist(float[] floatSortedist) {
		this.floatSortedist = floatSortedist;
	}

	public int[] getIntegerList() {
		return integerList;
	}

	public void setIntegerList(int[] integerList) {
		this.integerList = integerList;
	}

	public int[] getIntegerSortedist() {
		return integerSortedist;
	}

	public void setIntegerSortedist(int[] integerSortedist) {
		this.integerSortedist = integerSortedist;
	}

}