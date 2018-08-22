package model;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Model;

class ModelTest {

	private Model model = new Model();

	@Test
	void testReadNumbersFile01() {
		File integersFile = new File("./data/test/fileTest1Integers.txt");
		File floatsFile = new File("./data/test/fileTest1Floats.txt");
		try {
			model.readNumbersFile(integersFile, Model.INTEGERS);

			int[] list = model.getIntegerList();

			assertEquals(5000, list.length,
					"el tama�o que se espera es: 5000 " + "pero el arreglo tiene un tama�o de: " + list.length);

		} catch (Exception e) {
			fail(e.getMessage());
		}

		try {
			model.readNumbersFile(floatsFile, Model.FLOAT);

			float[] list = model.getFloatList();

			assertEquals(5000, list.length,
					"el tama�o que se espera es: 5000 " + "pero el arreglo tiene un tama�o de: " + list.length);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGenerateElementsSortGeneration() {

		try {

			int[] list;
			
			model.generateElements(5000, 0, 5000, Model.CLONE_NUMBERS, Model.SORT_GENERATION, Model.INTEGERS);
			list = model.getIntegerList();

			for (int i = 0; i < list.length - 1; i++) {

				if (!(list[i] <= list[i + 1])) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list[i]
							+ " debe ser menor que: " + list[i + 1]);
				} else {
					assertTrue(true);
				}

			}

			model.generateElements(5000, 1, 5000, Model.NO_CLONE_NUMBERS, Model.SORT_GENERATION, Model.INTEGERS);
			list = model.getIntegerList();

			for (int i = 0; i < list.length - 1; i++) {

				if (!(list[i] <= list[i + 1]) && list[i]!= list[i+1]) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list[i]
							+ " debe ser menor que: " + list[i + 1]);
				} else {
					assertTrue(true);
				}

			}
			
			//floats
			
			float[] list1;
			model.generateElements(5000, 0, 5000, Model.CLONE_NUMBERS, Model.SORT_GENERATION, Model.FLOAT);
			list1 = model.getFloatList();

			for (int i = 0; i < list1.length - 1; i++) {
				
				int bit1 = Float.floatToIntBits(list1[i]);
				int bit2 = Float.floatToIntBits(list1[i+1]);
				if (!(bit1 <= bit2)) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list1[i]
							+ " debe ser menor que: " + list1[i + 1]);
				} else {
					assertTrue(true);
				}

			}

			model.generateElements(5000, 1, 5000, Model.NO_CLONE_NUMBERS, Model.SORT_GENERATION, Model.FLOAT);
			list1 = model.getFloatList();

			for (int i = 0; i < list1.length - 1; i++) {

				int bit1 = Float.floatToIntBits(list1[i]);
				int bit2 = Float.floatToIntBits(list1[i+1]);
				
				if (!(bit1 <= bit2) && bit1!= bit2) {
					fail("hay un numero que es mayor y esta en una posicion que no corresponde el cu�l es: " + list1[i]
							+ " debe ser menor que: " + list1[i + 1]);
				} else {
					assertTrue(true);
				}

			}
			
			
			

		} catch (IOException e) {
			fail("there is a problem");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}


	@Test
	void testSortPerformance() {
		fail("Not yet implemented");
	}

}
