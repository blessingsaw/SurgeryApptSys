/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;

import java.util.ArrayList;
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
public class PatientTest {
    
    public PatientTest() {
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
     * Test of requestAppointment method, of class Patient.
     */
    @Test
    public void testRequestAppointment() {
        System.out.println("requestAppointment");
        Secretary p = new Secretary("Sname", "sid");
        String desc = "des";
        String date = "3/3/2017";
        String from = "12:00";
        String to = "12:30";
        Doctor d = new Doctor("d1","d1id","Medicine");
        Patient instance = new Patient("pa","paddr","mob", "id");
        boolean expResult = true;
        boolean result = instance.requestAppointment(p, desc, date, from, to, d);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of chngrequestAppointment method, of class Patient.
     */
    @Test
    public void testChngrequestAppointment() {
        System.out.println("chngrequestAppointment");
        Secretary p = new Secretary("Sname","Sid");
        String date = "3/3/2017";
        String desc = "desc";
        String from = "12:00";
        String to = "12:30";
        Doctor d = new Doctor("d1","d1id","Medicine");
        Patient instance = new Patient("pa","paddr","mob", "id");
        boolean expResult = true;
        boolean result = instance.chngrequestAppointment(p, date, desc, from, to, d);
        assertEquals(expResult, result);
      
    }

   

    /**
     * Test of getAppointmentList method, of class Patient.
     */
    @Test
    public void testGetAppointmentList() {
        System.out.println("getAppointmentList");
        Patient instance = new Patient("pa","paddr","mob", "id");
        Appointment a=new Appointment("des", "3/3/2017","12:00","12:30", new Patient("pa","paddr","mob", "id"), new Doctor("d1","d1id","Medicine"));
        instance.appointmentList.add(a);
        ArrayList<Appointment>expResult = new ArrayList<Appointment>();
        expResult.add(a);
        
        ArrayList result = instance.getAppointmentList();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getDoctorList method, of class Patient.
     */
    @Test
    public void testGetDoctorList() {
        System.out.println("getDoctorList");
        Patient instance = new Patient("pa","paddr","mob", "id");
        instance.doctorList.add(new Doctor("dn","did","Medicine"));
        
        Doctor d=new Doctor("dn","did","Medicine");
        ArrayList<Doctor> expResult =new ArrayList<Doctor>() ;
        expResult.add(d);
        ArrayList<Doctor>result = instance.getDoctorList();
        assertEquals(expResult.get(0).doctorName, result.get(0).doctorName);
        
    }
}