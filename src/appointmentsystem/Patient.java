
package appointmentsystem;

import java.util.ArrayList;

public class Patient
{
    String patientName;
    String address;
    String mobile;
    String patientId;
    ArrayList<Appointment> appointmentList;
    ArrayList<Doctor> doctorList;
    
    
    
    
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
    public boolean requestAppointment(Secretary p,String desc,String date,String from,String to,Doctor d)
    {
      // System.out.println("date:"+date+"  desc:"+desc);
        return p.finalizeRequestAppointment(desc,date,from,to,this,d);
        
    }
    
      ///adding new appointment
    public boolean chngrequestAppointment(Secretary p,String date,String desc,String from,String to,Doctor d)
    {
       
        return p.finalizechngRequestAppointment(desc,date,from,to,this,d);
        
    }
    
    //// delete aappointment
    public boolean cancelAppointment(int a,Secretary p)
    {
        return p.cancelfinalizeAppointment(this,a);
        
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
