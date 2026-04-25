/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class DamageAlgorithmTest {
	
	public DamageAlgorithmTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
}
	/**
	 * Test of execute method, of class DamageAlgorithm.
	 */
	@Test
	public void testExecute() {
		System.out.println("execute");
		GameCharacter c = null;
		DamageAlgorithm instance = new DamageAlgorithm();
		int expResult = 0;
		int result = instance.execute(c);
		assertEquals(expResult, result);
	}

