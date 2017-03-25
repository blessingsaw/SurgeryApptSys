
package appointmentsystem;

import java.util.ArrayList;
import java.util.Date;

class Slot
{
    Date from,to;
    public Slot(Date f,Date t)
    {
        from=f;
        to=t;
    }
    
}
public class Doctor 
{
    String doctorName;
    int doctorId;
    String type;
    ArrayList<Slot> bookedSlot=new ArrayList<Slot>();
    
    public Doctor(String n,String id,String t)
    {
        doctorName=n;
        doctorId=Integer.parseInt(id);
        type=t;
    }
    
    public void bookSlot(Date from,Date to)
    {
        Slot s=new Slot(from,to);
        bookedSlot.add(s);
        
    }
    
   /* public boolean availSlot(String from,String to)
    {
        for(int i=0;i<bookedSlot.size();i++)
        {
            //if(bookedSlot.get(i).from)
            
        }
    }*/
    
}