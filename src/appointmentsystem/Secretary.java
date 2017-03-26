/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsystem;


public class Secretary {
    
    String name;
    String id;
    public Secretary(String n,String i)
    {
        name=n;
        id=i;
    }
    public boolean cancelfinalizeAppointment(Patient p,int a)
    {
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
        if(d.availSlot(date, from, to))
        {
            p.appointmentList.add(new Appointment(desc,date,from,to,p,d));
            return true;
        }
        else
        {
            return false;
        }
        
      

    }
    
    public boolean finalizechngRequestAppointment(String desc, String date,String from, String to,Patient p,Doctor d)
    {
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
