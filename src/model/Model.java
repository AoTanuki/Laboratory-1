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
    public static final char INTEGERS = 'c';

    /**
     * 
     */
    public static final char FLOAT = 'f';

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
     * this method read the numbers within file and, depend of numbertype, chooses which converter uses
     * finally, set the correct list with that numbers.
     * 
     * @param file is the file that contain the set of number to sort 
     * @param numberType defines what kind of number are within file
     * @throws FileWithNotNumbersSet 
     * @throws FileWithNoSetSizeException 
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public void readNumbersFile(File file, char numberType) throws NumberFormatException, IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {
        
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
     * @param buffer 
     * @return
     * @throws IOException 
     * @throws NumberFormatException 
     * @throws FileWithNoSetSizeException 
     * @throws FileWithNotNumbersSet 
     */
    public float[] convertFileToFloatList(BufferedReader buffer) throws NumberFormatException, IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {
       
    	float[] auxiliarList = null;
    	if(!buffer.readLine().equalsIgnoreCase("#set's size"))
        {
    		throw new FileWithNoSetSizeException();
        }
        	
    	int size = Integer.parseInt(buffer.readLine());
    	auxiliarList = new float[size];
    	
    	String line = buffer.readLine();
    	
    	if(line== null) {
    		throw new FileWithNotNumbersSet();
    	}
    	
    	int numberline = 4;
    	while(line!= null && !line.isEmpty())
    	{
    		line = line.trim();
    		String[] lineList = line.split("-");
    		
    		for (int i = 0; i < lineList.length; i++) {
    			try {
				auxiliarList[i] = Float.parseFloat(lineList[i]);
    			}catch (NumberFormatException e)
    			{
    				throw new NumberFormatException("There is a problem in your file, some value was not good write "+"\n the number is: "+ lineList[i]+ " in the line: "+numberline);
    			}
			}
    		numberline++;
    		line = buffer.readLine();
    	}
        
        return auxiliarList;
    }

    /**
     * @param buffer 
     * @return
     */
    public int[] convertFileToIntegerList(BufferedReader buffer) {
        // TODO implement here
        return null;
    }

    /**
     * @param size 
     * @param startInterval 
     * @param endInterval 
     * @param cloneNumber 
     * @param numberType
     */
    public void generateElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType) {
        // TODO implement here
    }

    /**
     * @param size 
     * @param startInterval 
     * @param endInterval 
     * @param cloneNumber 
     * @param numberType 
     * @param randomPorcentage
     */
    public void generateElements(int size, int startInterval, int endInterval, char cloneNumber, char numberType, int randomPorcentage) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float[] sortedFloatElements() {
        // TODO implement here
        return null;
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
    public float[] completeFloatRandomElements() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int[] completeIntegerRandomElements() {
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
     * @return informacion con el runtime,  espacio usado, algoritmo empleado.
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

}