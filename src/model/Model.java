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
     * this method read the numbers within file and, depend of number type, chooses which converter uses
     * finally, set the correct list with that numbers.
     * 
     * @param file is the file that contain the set of number to sort 
     * @param numberType defines what kind of number are within file
     * @throws FileWithNotNumbersSet throws when the file has not lines with numbers to setting
     * @throws FileWithNoSetSizeException throws when the file has not a line specifying set's size
     * @throws IOException throws when a problem reading line appears
     * @throws NumberFormatException throws when is not possible to convert a String to a float
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
     * this method converts the file in a float set.
     * @param buffer is the buffer that allow the method to read every line
     * @return auxiliarList is the float set with every float within file
     * @throws IOException  throws when a problem reading line appears
     * @throws NumberFormatException throws when is not possible to convert a String to a float
     * @throws FileWithNoSetSizeException throws when the file has not a line specifying set's size
     * @throws FileWithNotNumbersSet  throws when the file has not lines with numbers to setting
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
    	
    	if(line== null || line.isEmpty()) {
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
     *this method converts the file in a integer set.
     * @param buffer is the buffer that allow the method to read every line
     * @return auxiliarList is the float set with every float within file
     * @throws IOException  throws when a problem reading line appears
     * @throws NumberFormatException throws when is not possible to convert a String to a float
     * @throws FileWithNoSetSizeException throws when the file has not a line specifying set's size
     * @throws FileWithNotNumbersSet  throws when the file has not lines with numbers to setting
     */
    public int[] convertFileToIntegerList(BufferedReader buffer) throws IOException, FileWithNoSetSizeException, FileWithNotNumbersSet {
    	
    	int[] auxiliarList = null;
    	if(!buffer.readLine().equalsIgnoreCase("#set's size"))
        {
    		throw new FileWithNoSetSizeException();
        }
        	
    	int size = Integer.parseInt(buffer.readLine());
    	auxiliarList = new int[size];
    	
    	String line = buffer.readLine();
    	
    	if(line== null || line.isEmpty()) {
    		throw new FileWithNotNumbersSet();
    	}
    	
    	int numberline = 4;
    	while(line!= null && !line.isEmpty())
    	{
    		line = line.trim();
    		String[] lineList = line.split("-");
    		
    		for (int i = 0; i < lineList.length; i++) {
    			try {
				auxiliarList[i] = Integer.parseInt(lineList[i]);
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