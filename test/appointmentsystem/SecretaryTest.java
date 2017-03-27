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
public class SecretaryTest {
    
    public SecretaryTest() {
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
     * Test of cancelfinalizeAppointment method, of class Secretary.
     */
    @Test
    public void testCancelfinalizeAppointment() {
        System.out.println("cancelfinalizeAppointment");
        Patient p = new Patient("pa","paddr","mob", "id");
        
        Appointment ap=new Appointment("des", "3/3/2017","12:00","12:30", new Patient("pa","paddr","mob", "id"), new Doctor("d1","d1id","Medicine"));
        p.appointmentList.add(ap);

        int a = 0;
        Secretary instance = new Secretary("sn","sid");
        boolean expResult = false;
        boolean result = instance.cancelfinalizeAppointment(p, a);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of finalizeRequestAppointment method, of class Secretary.
     */
    @Test
    public void testFinalizeRequestAppointment() {
        System.out.println("finalizeRequestAppointment");
        String desc = "des";
        String date = "3/3/2017";
        String from = "12:00";
        String to = "12:30";
        Patient p =  new Patient("pa","paddr","mob", "id");
        Doctor d =  new Doctor("d1","d1id","Medicine");
        Secretary instance = new Secretary("s1","sid");
        boolean expResult = true;
        boolean result = instance.finalizeRequestAppointment(desc, date, from, to, p, d);
        assertEquals(expResult, result);
       
   
    }

    /**
     * Test of finalizechngRequestAppointment method, of class Secretary.
     */
    @Test
    public void testFinalizechngRequestAppointment() {
        System.out.println("finalizechngRequestAppointment");
        String desc = "des";
        String date = "3/3/2017";
        String from = "12:00";
        String to = "12:30";
        Patient p =  new Patient("pa","paddr","mob", "id");
        Doctor d =  new Doctor("d1","d1id","Medicine");
        Secretary instance = new Secretary("s1","sid");
        boolean expResult = true;
        boolean result = instance.finalizechngRequestAppointment(desc, date, from, to, p, d);
        assertEquals(expResult, result);
       
    }
}