/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;


public class Appointment 
{
    int app_id;
    String desc;
    String from,to;
    
    Patient patient;
    Doctor doctor;
    public Appointment(int id,String d,String f,String t,Patient pa,Doctor da)
    {
        app_id=id;
        desc=d;
        from=f;
        to=t;
        patient=pa;
        doctor=da;
        
    }
}
