/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;

import java.util.ArrayList;

public class Patient {
    String patientName;
    String address;
    String mobile;
    String patientId;
    ArrayList<Appointment> appointmentList;
    ArrayList<Doctor> doctorList;
    
    String medications="";
    
    
    //// patient class constructor
    public Patient(String name,String addr,String mob,String id)
    {
        patientName=name;
        patientId=id;
        address=addr;
        mobile=mob;
        appointmentList=new ArrayList<Appointment>();
        doctorList=new ArrayList<Doctor>();
    }
    
    ///adding new appointment
    public void requestAppointment(Appointment a)
    {
        appointmentList.add(a);
    }
    
    //// delete aappointment
    public void cancelAppointment(Appointment a)
    {
        appointmentList.remove(a);
    }
    
    /// return appointment list for the specified patient
    public ArrayList<Appointment> getAppointmentList()
    {
        return appointmentList;
    }
    
    /// return doctor list for the specified patient
    public ArrayList<Doctor> getDoctorList()
    {
        return doctorList;
    }
    
    
}
