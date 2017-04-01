/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;

import java.util.ArrayList;


public class Secretary 
{
    
    String name;
    String id;
    
    ArrayList<Appointment> secappntmentList=new ArrayList<Appointment>();
    
    
    public Secretary(String n,String i)
    {
        name=n;
        id=i;
    }
    
  
    public boolean cancelfinalizeAppointment(Patient p,int a)
    {
        p.appointmentList.get(a).type="Cancelled";
        secappntmentList.add(p.appointmentList.get(a));
        
        
        if(p.appointmentList.get(a).doctor.removeSlot(p,p.appointmentList.get(a).from,p.appointmentList.get(a).to))
        {   
            p.appointmentList.remove(a);
            return true;
        
        }
        else
        {
            return false;
        }
        
    }
    
    public boolean finalizeRequestAppointment(String desc, String date,String from, String to,Patient p,Doctor d)
    {
        Appointment a=new Appointment(desc,date,from,to,p,d);
        
        secappntmentList.add(a);
        
        if(d.availSlot(date, from, to))
        {
            p.appointmentList.add(a);
            d.bookSlot(p, date, from, to);
            return true;
        }
        else
        {
            return false;
        }
        
      

    }
    
    public boolean finalizechngRequestAppointment(String desc, String date,String from, String to,Patient p,Doctor d)
    {
        
        
        for(int a=0;a<p.appointmentList.size();a++)
        {
              if(p.appointmentList.get(a).from.equals(from) && p.appointmentList.get(a).to.equals(to))
              {
                  p.appointmentList.get(a).type="change";
                  secappntmentList.add(p.appointmentList.get(a));
              }
                
        }
        
        if(d.removeSlot(p, from, to))
        {
            if(d.availSlot(date, from, to))
            {
                for(int a=0;a<p.appointmentList.size();a++)
                {
                    if(p.appointmentList.get(a).from.equals(from) && p.appointmentList.get(a).to.equals(to))
                    {
                        p.appointmentList.get(a).doctor.removeSlot(p, from, to);
                        p.appointmentList.remove(a);
                        
                    }
                
                }
                p.appointmentList.add(new Appointment(desc,date,from,to,p,d));
                return true;
            }
            else
            {
                
                d.bookedSlot.add(new Slot(p,date,from,to));
                
                return false;
            }
        
        }
        else
        {
            if(d.availSlot(date, from, to))
            {
                for(int a=0;a<p.appointmentList.size();a++)
                {
                    if(p.appointmentList.get(a).from.equals(from) && p.appointmentList.get(a).to.equals(to))
                    {
                        p.appointmentList.get(a).doctor.removeSlot(p, from, to);
                        p.appointmentList.remove(a);
                        
                    }
                
                }
                p.appointmentList.add(new Appointment(desc,date,from,to,p,d));
                return true;
            }
            else
            {
                d.bookedSlot.add(new Slot(p,date,from,to));
                
                return false;
            }
        }
        

    }
}
