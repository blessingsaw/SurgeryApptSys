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
public class DoctorTest {
    
    public DoctorTest() {
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
     * Test of completeAppointment method, of class Doctor.
     */
    @Test
    public void testCompleteAppointment() {
        System.out.println("completeAppointment");
        int d = 0;
        
       
        Doctor instance = new Doctor("d1","d1id","Medicine");
        boolean expResult = false;
        boolean result = instance.completeAppointment(d);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeSlot method, of class Doctor.
     */
    @Test
    public void testRemoveSlot() {
        System.out.println("removeSlot");
        Patient p = new Patient("pa","paddr","mob", "id");
        String f = "12:00";
        String t = "12:30";
        Doctor instance = new Doctor("d1","d1id","Medicine");
        boolean expResult = false;
        boolean result = instance.removeSlot(p, f, t);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of bookSlot method, of class Doctor.
     */
    @Test
    public void testBookSlot() {
        System.out.println("bookSlot");
        Patient pa = new Patient("pa","paddr","mob", "id");
        String date = "3/3/2017";
        String from = "12:00";
        String to = "12:30";
        Doctor instance = new Doctor("d1","d1id","Medicine");;
        instance.bookSlot(pa, date, from, to);
       
    }

    /**
     * Test of availSlot method, of class Doctor.
     */
    @Test
    public void testAvailSlot() {
        System.out.println("availSlot");
        String date = "3/3/2017";
        String from = "12:00";
        String to = "12:30";
        Doctor instance = new Doctor("d1","d1id","Medicine");;
        boolean expResult = true;
        boolean result = instance.availSlot(date, from, to);
        assertEquals(expResult, result);
        
    }

    
}