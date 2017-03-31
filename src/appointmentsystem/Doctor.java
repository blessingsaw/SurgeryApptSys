
package appointmentsystem;

import java.util.ArrayList;
import java.util.Date;

class Slot
{
    String from,to,date;
    Patient p;
    public Slot(Patient pa,String da,String f,String t)
    {
        p=pa;
        date=da;
        from=f;
        to=t;
    }
    
}
public class Doctor 
{
    String doctorName;
    String doctorId;
    String type;
    ArrayList<Slot> bookedSlot=new ArrayList<Slot>();
    
    public Doctor(String n,String id,String t)
    {
        doctorName=n;
        doctorId=id;
        type=t;
    }
    
    public boolean completeAppointment(int d)
    {
        try
        {
            bookedSlot.remove(d);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean removeSlot(Patient p,String f,String t)
    {
        for(int b=0;b<bookedSlot.size();b++)
        {
            if(bookedSlot.get(b).p.patientId.equals(p.patientId) && bookedSlot.get(b).from.trim().equals(f.trim()) && bookedSlot.get(b).to.equals(t.trim()))
            {
                bookedSlot.remove(b);
                return true;
            }
        }
        return false;
    }
    
    public void bookSlot(Patient pa,String date,String from,String to)
    {
        Slot s=new Slot(pa,date,from,to);
        bookedSlot.add(s);
        
    }
    
   public boolean availSlot(String date,String from,String to)
   {
        for(int i=0;i<bookedSlot.size();i++)
        {
            if(bookedSlot.get(i).date.equals(date) && (bookedSlot.get(i).from.equals(from) || bookedSlot.get(i).to.equals(to)))
            {
                return false;
            }
            
        }
        
        return true;
    }

    void makeNotes(int d,String no,String m) 
    {
        Patient p=bookedSlot.get(d).p;
        
        for(int i=0;i<p.appointmentList.size();i++)
        {
            if(bookedSlot.get(d).date.equals(p.appointmentList.get(i).date) && bookedSlot.get(d).from.equals(p.appointmentList.get(i).from))    
            {
                p.appointmentList.get(i).medications=m;
                p.appointmentList.get(i).notes=no;
            }
        }
        
    }
    
}