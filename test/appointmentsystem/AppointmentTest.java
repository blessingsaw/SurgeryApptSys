/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PKD
 */
public class AppointmentTest {
    
    public AppointmentTest() {
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

    /**
     * Test of description method, of class Appointment.
     */
    @Test
    public void testDescription() {
        System.out.println("description");
        Appointment instance = new Appointment("des", "3/3/2017","12:00","12:30", new Patient("pa","paddr","mob", "id"), new Doctor("d1","d1id","Medicine"));
        String expResult = "des";
        String result = instance.description();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of from method, of class Appointment.
     */
    @Test
    public void testFrom() {
        System.out.println("from");
        Appointment instance = new Appointment("des", "3/3/2017","12:00","12:30", new Patient("pa","paddr","mob", "id"), new Doctor("d1","d1id","Medicine"));
        String expResult = "12:00";
        String result = instance.from();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of to method, of class Appointment.
     */
    @Test
    public void testTo() {
        System.out.println("to");
        Appointment instance = new Appointment("des", "3/3/2017","12:00","12:30", new Patient("pa","paddr","mob", "id"), new Doctor("d1","d1id","Medicine"));
        String expResult = "12:30";
        String result = instance.to();
        assertEquals(expResult, result);
        
    }
}