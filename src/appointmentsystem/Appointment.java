/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;


public class Appointment 
{
    String desc;
    String date,from,to;
    Patient patient;
    Doctor doctor;
    
    String type;
    
    String medications="Empty";
    String notes="Empty";
    public Appointment(String d,String datepar,String f,String t,Patient pa,Doctor da)
    {
        date=datepar;
        desc=d;
        from=f;
        to=t;
        patient=pa;
        doctor=da;
        type="requested";
        
        
    }
    
    public String description()
    {
        return desc;
    }
    
    public String from()
    {
        return from;
    }
    public  String to()
    {
        return to;
    }
            
}
