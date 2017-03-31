
package appointmentsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class AppointmentSystem extends JFrame
{
 
    
    ArrayList<Patient> patientList=new ArrayList<Patient>();
    ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
    ArrayList<Secretary> secretaryList=new ArrayList<Secretary>();
    ArrayList<Pharmacist> pharmaList=new ArrayList<Pharmacist>();
    
    public AppointmentSystem()
    {
        
        //// initialize preregistered member
        patientList.add(new Patient("Patient_Name_1","Singapore","+6587654321","P1"));
        patientList.add(new Patient("Patient_Name_2","Singapore","+6587654322","P2"));
        patientList.add(new Patient("Patient_Name_3","Singapore","+6587654323","P3"));
        patientList.add(new Patient("Patient_Name_4","Singapore","+6587654324","P4"));
        patientList.add(new Patient("Patient_Name_5","Singapore","+6587654325","P5"));
        patientList.add(new Patient("Patient_Name_6","Singapore","+6587654326","P6"));
        patientList.add(new Patient("Patient_Name_7","Singapore","+6587654327","P7"));
        patientList.add(new Patient("Patient_Name_8","Singapore","+6587654328","P8"));
        patientList.add(new Patient("Patient_Name_9","Singapore","+6587654329","P9"));
        patientList.add(new Patient("Patient_Name_10","Singapore","+6587654330","P10"));
        
        secretaryList.add(new Secretary("Secretary_Name_1","S1"));
        
        
        pharmaList.add(new Pharmacist("Pharmacist_Name_1", "Ph1"));
        

        doctorList.add(new Doctor("d1n","d1", "Dentist"));
        doctorList.add(new Doctor("d2n","d2", "Dermatologist"));
        doctorList.add(new Doctor("d3n","d3", "Medicine"));
        
        
        patientList.get(0).requestAppointment(secretaryList.get(0),"Heart Problm","29/3/2017", "17:00","17:30",doctorList.get(0));
        patientList.get(1).requestAppointment(secretaryList.get(0),"Heart Problm","29/3/2017","17:31","18:30",doctorList.get(0));
        patientList.get(2).requestAppointment(secretaryList.get(0),"Heart Problm","29/3/2017","13:00","13:30",doctorList.get(0));
        patientList.get(3).requestAppointment(secretaryList.get(0),"Heart Problm","24/3/2017", "13:30","14:00",doctorList.get(0));
        patientList.get(4).requestAppointment(secretaryList.get(0),"Heart Problm","27/3/2017", "14:00","14:30",doctorList.get(0));
        patientList.get(5).requestAppointment(secretaryList.get(0),"Heart Problm","27/3/2017","14:30","15:00",doctorList.get(0));
        patientList.get(6).requestAppointment(secretaryList.get(0),"Heart Problm","27/3/2017", "14:30","15:00",doctorList.get(0));
        patientList.get(7).requestAppointment(secretaryList.get(0),"Stomach Problm","27/3/2017","12:00","12:30",doctorList.get(1));
        patientList.get(5).requestAppointment(secretaryList.get(0),"Stomach Problm","25/3/2017", "12:30","13:00",doctorList.get(0));
        patientList.get(0).requestAppointment(secretaryList.get(0),"Stomach Problm","25/3/2017","13:30","14:00",doctorList.get(1));
        patientList.get(1).requestAppointment(secretaryList.get(0),"Stomach Problm","25/3/2017","13:30","14:00",doctorList.get(1));
        patientList.get(2).requestAppointment(secretaryList.get(0),"Stomach Problm","25/3/2017","14:00","14:30",doctorList.get(1));
        patientList.get(7).requestAppointment(secretaryList.get(0),"Brain Problm","26/3/2017","13:30","14:00",doctorList.get(2));
        patientList.get(8).requestAppointment(secretaryList.get(0),"Brain Problm","26/3/2017","13:30","14:00",doctorList.get(2));
        patientList.get(9).requestAppointment(secretaryList.get(0),"Brain Problm","26/3/2017","13:30","14:00",doctorList.get(2));
        
       
       
       
        
                ///Login Dialog
                final JDialog loginDialog=new JDialog();
                loginDialog.setTitle("UHSurgery Appointment Management System");
                
                loginDialog.setLayout(null);
                JLabel nameLabel=new JLabel("ID:");
                final JTextField namefield=new JTextField();
                JButton submitButton=new JButton("Login");
                nameLabel.setBounds(10, 5,200,25);
                namefield.setBounds(100,5,200,25);
                submitButton.setBounds(100,70,100,60);
                loginDialog.add(submitButton);
                loginDialog.add(nameLabel);
                loginDialog.add(namefield);
                loginDialog.add(submitButton);
                
                String type[]={"Patient","Doctor","Secretary","Pharmacist","Admin"};        
                final JComboBox cb=new JComboBox(type);    
                cb.setBounds(230, 70,100,60); 
                loginDialog.add(cb);
              
                loginDialog.setSize(450,500);
                loginDialog.setResizable(false);
                loginDialog.setLocationRelativeTo(null);
                loginDialog.setVisible(true);
                
                loginDialog.addWindowListener(new WindowAdapter() { 
                @Override public void windowClosed(WindowEvent e) { 
                  System.exit(0);
                }
                 });
                
                submitButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) 
                    {
                        if(namefield.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Please Complete all the field");
                        }
                        else
                        {
                            
                        Patient p = null;
                        final Patient fpatient;
                        int index=cb.getSelectedIndex();
                        
                        ///admin
                        if(index==4)
                        {
                            if(namefield.getText().equalsIgnoreCase("admin"))
                            {
                            JFrame adminFrame=new JFrame("Admin Frame");
                            adminFrame.setTitle("UHSurgery Appointment Management System – Admin Module");
                            adminFrame.setSize(600,600);
                            adminFrame.setLayout(new FlowLayout());
                            adminFrame.setVisible(true);
                            
                            JMenuBar jm=new JMenuBar();
                            JMenu addmenu=new JMenu("Add Menu");
                            JMenuItem addPatientItem=new JMenuItem("Add Patient to System");
                            JMenuItem addDoctorItem=new JMenuItem("Add Doctor Item");
                            JMenuItem addPharmacistItem=new JMenuItem("Add Pharmacist");
                            JMenuItem addSecretaryItem=new JMenuItem("Add Secretary");

                            JMenu reportMenu=new JMenu("Report");
                            JMenuItem preportItem=new JMenuItem("Patient Report");
                            JMenuItem dreportItem=new JMenuItem("Doctor Report");
                            JMenuItem areportItem=new JMenuItem("Appointment Report");
                             //// adding Menu
                            addmenu.add(addPatientItem);
                            addmenu.add(addDoctorItem);
                            addmenu.add(addPharmacistItem);
                            addmenu.add(addSecretaryItem);

                            reportMenu.add(preportItem);
                            reportMenu.add(dreportItem);
                            reportMenu.add(areportItem);

                            adminFrame.setJMenuBar(jm);
                            jm.add(addmenu);
                            jm.add(reportMenu);
                          


                            dreportItem.addActionListener(new ActionListener() 
                            {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {

                                    final JFrame frame = new JFrame("Doctor Report Window");   
                                    JPanel jp=new JPanel(new BorderLayout());
                                    final JList list;
                                    final DefaultListModel model;

                                    model = new DefaultListModel();
                                    list = new JList(model);
                                    JScrollPane pane = new JScrollPane(list);       
                                    jp.add(pane);
                                    frame.setContentPane(jp);
                                    frame.setName("UHSurgery Appointment Management System – Doctor Report Module");
                                    frame.setSize(800,600);
                                    frame.setVisible(true);

                                    for(int d=0;d<doctorList.size();d++)
                                    {
                                        Doctor tDoct=doctorList.get(d);
                                        model.addElement("ID:"+tDoct.doctorId+"\tName:"+tDoct.doctorName+"\tType:"+tDoct.type);

                                    }



                                }
                            });
                            preportItem.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    String startdate=JOptionPane.showInputDialog(null,"Please Enter start Date(dd/mm/yyyy)");
                                    String endDate=JOptionPane.showInputDialog(null,"Please Enter End Date(dd/mm/yyyy)");
                                    Date date1 = null,date2=null;

                                    try 
                                    {
                                        date1=new SimpleDateFormat("dd/MM/yyyy").parse(startdate);
                                        date2=new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
                                    } 
                                    catch (ParseException ex) 
                                    {
                                        Logger.getLogger(AppointmentSystem.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    final JFrame frame = new JFrame("Patient Report Window");   
                                    JPanel jp=new JPanel(new BorderLayout());
                                    final JList list;
                                    final DefaultListModel model;

                                    model = new DefaultListModel();
                                    list = new JList(model);
                                    JScrollPane pane = new JScrollPane(list);       
                                    jp.add(pane);
                                    frame.setContentPane(jp);
                                    frame.setSize(800,600);
                                    frame.setVisible(true);
                                    
                                    frame.setName("UHSurgery Appointment Management System – Patient Report Module");

                                    for(int i=0;i<patientList.size();i++)
                                    {
                                        Patient temp=patientList.get(i);
                                        model.addElement("PatientId:"+temp.patientId+"  PatientName: "+temp.patientName+"  Address:"+temp.address+"  Medications:"+temp.medications+"  Mobile:"+temp.mobile);
                                        model.addElement("\n***********  Appointment List for the Patient:"+temp.patientName+" ***********");

                                        for(int s=0;s<temp.appointmentList.size();s++)
                                        {
                                            Date date=null;
                                            Appointment atemp=temp.appointmentList.get(s);
                                            try
                                            {
                                                date=new SimpleDateFormat("dd/MM/yyyy").parse(atemp.date);
                                            }
                                            catch(Exception ee)
                                            {

                                            }

                                            //System.out.println(date+"  "+date1+"  "+date2+" "+date1.before(date)+"  "+date2.after(date));


                                            if(date1.before(date) && date2.after(date))
                                            {

                                                model.addElement("Date:"+atemp.date+"  From:"+atemp.from+" To:"+atemp.to+" Description:"+atemp.desc+"  DoctorName:"+atemp.doctor.doctorName);
                                            }

                                        }

                                        model.addElement("\n");
                                    }
                                }
                            });



                            areportItem.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    String startdate=JOptionPane.showInputDialog(null,"Please Enter start Date(dd/mm/yyyy)");
                                    String endDate=JOptionPane.showInputDialog(null,"Please Enter End Date(dd/mm/yyyy)");
                                    Date date1 = null,date2=null;

                                    try 
                                    {
                                        date1=new SimpleDateFormat("dd/MM/yyyy").parse(startdate);
                                        date2=new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
                                    } 
                                    catch (ParseException ex) 
                                    {
                                        Logger.getLogger(AppointmentSystem.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    final JFrame frame = new JFrame("UHSurgery Appointment Management System – Appointment Report Module");   
                                    JPanel jp=new JPanel(new BorderLayout());
                                    final JList list;
                                    final DefaultListModel model;

                                    model = new DefaultListModel();
                                    list = new JList(model);
                                    JScrollPane pane = new JScrollPane(list);       
                                    jp.add(pane);
                                    frame.setContentPane(jp);
                                    frame.setSize(800,600);
                                    frame.setVisible(true);

                                    for(int p=0;p<patientList.size();p++)
                                    {
                                        ArrayList<Appointment> tempList=patientList.get(p).appointmentList;

                                        for(int t=0;t<tempList.size();t++)
                                        {
                                            Date date=null;
                                            Appointment tAppnt=tempList.get(t);
                                            try
                                            {
                                                date=new SimpleDateFormat("dd/MM/yyyy").parse(tAppnt.date);
                                            }
                                            catch(Exception ee)
                                            {

                                            }
                                            if(date1.before(date) && date2.after(date))
                                            {
                                                model.addElement("Date:"+tAppnt.date+"  From:"+tAppnt.from+"  To:"+tAppnt.to+"  Description:"+tAppnt.desc+"  Status:"+tAppnt.type);
                                            }
                                        }

                                    }
                                }
                            });

                            /// end of Login Dialog

                            addPatientItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    final JDialog patientDialog=new JDialog();

                                    patientDialog.setLayout(null);

                                    patientDialog.setName("UHSurgery Appointment Management System – Patient Module");

                                    JLabel nameLabel=new JLabel("Enter Name:");
                                    final JTextField namefield=new JTextField();
                                    JLabel addrLabel=new JLabel("Enter Address");
                                    final JTextField addrField=new JTextField();
                                    JLabel idLabel=new JLabel("Enter ID:");
                                    final JTextField idfield=new JTextField();
                                    JLabel mobLabel=new JLabel("Enter Mobile:");
                                    final JTextField mobfield=new JTextField();

                                    JButton submitButton=new JButton("Add");

                                    nameLabel.setBounds(10, 5,200,25);
                                    namefield.setBounds(100,5,200,25);

                                    idLabel.setBounds(10,30,200,25);
                                    idfield.setBounds(100, 30,200,25);

                                    addrLabel.setBounds(10,50,200,25);
                                    addrField.setBounds(100,50,200,25);

                                    mobLabel.setBounds(10,70,200,25);
                                    mobfield.setBounds(100,70,200,25);

                                    submitButton.setBounds(100,110,200,60);



                                    patientDialog.add(submitButton);
                                    patientDialog.add(nameLabel);
                                    patientDialog.add(namefield);
                                    patientDialog.add(idLabel);
                                    patientDialog.add(idfield);
                                    patientDialog.add(addrLabel);
                                    patientDialog.add(addrField);
                                    patientDialog.add(mobLabel);
                                    patientDialog.add(mobfield);
                                    patientDialog.add(submitButton);
                                    patientDialog.setSize(350,350);



                                    patientDialog.setResizable(false);
                                    patientDialog.setLocationRelativeTo(null);
                                    patientDialog.setVisible(true);


                                    submitButton.addActionListener(new ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            if(namefield.getText().equals("") || addrField.getText().equals("") || mobfield.getText().equals("") || idfield.getText().equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"Please complete all the field");
                                            }
                                            else
                                            {
                                                patientDialog.dispose();
                                                Patient p=new Patient(namefield.getText(), addrField.getText(),mobfield.getText(),idfield.getText());
                                                patientList.add(p);
                                            }

                                        }
                                    });



                                }
                            });

                            /// end of Login Dialog

                            addDoctorItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    final JDialog doctDialog=new JDialog();
                                    doctDialog.setLayout(null);
                                    doctDialog.setName("UHSurgery Appointment Management System – Doctor Module");
                                    JLabel nameLabel=new JLabel("Enter Name:");
                                    final JTextField namefield=new JTextField();
                                    JLabel idLabel=new JLabel("Enter ID");
                                    final JTextField idField=new JTextField();
                                    JLabel typeLabel=new JLabel("Enter Type:");
                                    final JTextField typefield=new JTextField();
                                    JButton submitButton=new JButton("Add");

                                    nameLabel.setBounds(10, 5,200,25);
                                    namefield.setBounds(100,5,200,25);

                                    idLabel.setBounds(10,30,200,25);
                                    idField.setBounds(100, 30,200,25);

                                    typeLabel.setBounds(10,50,200,25);
                                    typefield.setBounds(100,50,200,25);


                                    submitButton.setBounds(100,110,200,60);



                                    doctDialog.add(submitButton);
                                    doctDialog.add(nameLabel);
                                    doctDialog.add(namefield);
                                    doctDialog.add(idLabel);
                                    doctDialog.add(idField);
                                    doctDialog.add(typeLabel);
                                    doctDialog.add(typefield);
                                    doctDialog.add(submitButton);
                                    doctDialog.setSize(350,350);



                                    doctDialog.setResizable(false);
                                    doctDialog.setLocationRelativeTo(null);
                                    doctDialog.setVisible(true);


                                    submitButton.addActionListener(new ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            if(namefield.getText().equals("") || idField.getText().equals("") || typefield.getText().equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"Please complete all the field");
                                            }
                                            else
                                            {
                                                doctDialog.dispose();
                                                Doctor d=new Doctor(namefield.getText(), idField.getText(),typefield.getText());
                                                doctorList.add(d);
                                            }

                                        }
                                    });



                                }
                            });


                            addSecretaryItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    final JDialog dialog=new JDialog();
                                    dialog.setName("UHSurgery Appointment Management System – Secretary Module");
                                    dialog.setLayout(null);
                                    JLabel nameLabel=new JLabel("Enter Name:");
                                    final JTextField namefield=new JTextField();
                                    JLabel idLabel=new JLabel("Enter ID");
                                    final JTextField idField=new JTextField();
                                    JButton submitButton=new JButton("Add");
                                    nameLabel.setBounds(10, 5,200,25);
                                    namefield.setBounds(100,5,200,25);
                                    idLabel.setBounds(10,30,200,25);
                                    idField.setBounds(100, 30,200,25);
                                    submitButton.setBounds(100,110,200,60);
                                    dialog.add(submitButton);
                                    dialog.add(nameLabel);
                                    dialog.add(namefield);
                                    dialog.add(idLabel);
                                    dialog.add(idField);

                                    dialog.add(submitButton);
                                    dialog.setSize(350,350);

                                    dialog.setResizable(false);
                                    dialog.setLocationRelativeTo(null);
                                    dialog.setVisible(true);
                                    submitButton.addActionListener(new ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            if(namefield.getText().equals("") || idField.getText().equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"Please complete all the field");
                                            }
                                            else
                                            {
                                                dialog.dispose();
                                                Secretary d=new Secretary(namefield.getText(), idField.getText());
                                                secretaryList.add(d);
                                            }
                                        }
                                    });
                                }
                            });

                            addPharmacistItem.addActionListener(new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent e) 
                                {
                                    final JDialog dialog=new JDialog();
                                    dialog.setLayout(null);
                                    dialog.setName("UHSurgery Appointment Management System – Pharmacist Module");
                                    JLabel nameLabel=new JLabel("Enter Name:");
                                    final JTextField namefield=new JTextField();
                                    JLabel idLabel=new JLabel("Enter ID");
                                    final JTextField idField=new JTextField();
                                    JButton submitButton=new JButton("Add");
                                    nameLabel.setBounds(10, 5,200,25);
                                    namefield.setBounds(100,5,200,25);
                                    idLabel.setBounds(10,30,200,25);
                                    idField.setBounds(100, 30,200,25);
                                    submitButton.setBounds(100,110,200,60);
                                    dialog.add(submitButton);
                                    dialog.add(nameLabel);
                                    dialog.add(namefield);
                                    dialog.add(idLabel);
                                    dialog.add(idField);

                                    dialog.add(submitButton);
                                    dialog.setSize(350,350);

                                    dialog.setResizable(false);
                                    dialog.setLocationRelativeTo(null);
                                    dialog.setVisible(true);


                                    submitButton.addActionListener(new ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent e) 
                                        {
                                            if(namefield.getText().equals("") || idField.getText().equals(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"Please Complete All the field");
                                            }
                                            else
                                            {
                                                dialog.dispose();
                                                Pharmacist d=new Pharmacist(namefield.getText(), idField.getText());
                                                pharmaList.add(d);
                                            }

                                        }
                                    });



                                }
                            });
        
                            }
                        }
                        ///patient
                        if(index==0)
                        {   
                            
                            boolean flag=false;
                            for(int pp=0;pp<patientList.size();pp++)
                            {
                                p=patientList.get(pp);
                                if(p.patientId.equals(namefield.getText()))
                                {
                                    flag=true;
                                    break;
                                }
                                
                            }
                            
                            if(flag)
                            {
                                fpatient=p;
                                JFrame patientFrame=new JFrame("UHSurgery Appointment Management System – Patient Module");
                                JLabel welcome=new JLabel("Welcome Patient "+fpatient.patientName);
                                JButton requestAppntButton=new JButton("Request Appointment");
                                JButton viewAppointmentbutton=new JButton("View Appointments");

                                
                                /// request appointment
                                requestAppntButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        final JDialog requestAppntDialog=new JDialog();
                                        requestAppntDialog.setLayout(null);
                                        JLabel appIDLbl=new JLabel("Symptoms");
                                        final JTextField appfield=new JTextField();
                                        
                                        JLabel date=new JLabel("Date(dd/mm/yyyy)");
                                        final JTextField datefield=new JTextField();
                                        
                                        JLabel appntFrom=new JLabel("Start Time(hh:mm)");
                                        final JTextField frmFld=new JTextField();
                                        
                                        JLabel appntTo=new JLabel("End Time(hh:mm)");
                                        final JTextField toField=new JTextField();
                                        
                                        
                                        JButton submitButton=new JButton("Request Appointment");
                                        appIDLbl.setBounds(10, 5,200,25);
                                        appfield.setBounds(120,5,200,25);

                                        appntFrom.setBounds(10,30,200,25);
                                        frmFld.setBounds(120, 30,200,25);

                                        appntTo.setBounds(10,50,200,25);
                                        toField.setBounds(120,50,200,25);
                                        
                                        date.setBounds(10,80,200,25);
                                        datefield.setBounds(120,80,200,25);

                                        submitButton.setBounds(120,180,200,60);
                                        requestAppntDialog.add(appIDLbl);
                                        requestAppntDialog.add(appfield);
                                        requestAppntDialog.add(appntFrom);
                                        requestAppntDialog.add(frmFld);
                                        requestAppntDialog.add(appntTo);
                                        requestAppntDialog.add(toField);
                                        requestAppntDialog.add(date);
                                        requestAppntDialog.add(datefield);
                                        requestAppntDialog.add(submitButton);

                                        String type[]=new String[doctorList.size()];
                                        
                                        for(int dd=0;dd<doctorList.size();dd++)
                                        {
                                            type[dd]=doctorList.get(dd).doctorName+","+doctorList.get(dd).type;
                                        }
                                        
                                        
                                        JLabel doctLabel=new JLabel("Doctor");
                                        final JComboBox cb=new JComboBox(type);
                                        doctLabel.setBounds(10, 110,100,60);
                                        cb.setBounds(120, 110,120,60); 
                                        requestAppntDialog.add(doctLabel);
                                        requestAppntDialog.add(cb);
                                        
                                        
                                        submitButton.addActionListener(new ActionListener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent e) 
                                            {
                                                if(datefield.getText().equals("") || appfield.getText().equals("") || frmFld.getText().equals("") || toField.getText().equals(""))
                                                {
                                                    JOptionPane.showMessageDialog(null,"Please Complete all the field");
                                                }
                                                else
                                                {
                                                    if(fpatient.requestAppointment(secretaryList.get(0),appfield.getText(),datefield.getText(),frmFld.getText(),toField.getText(),doctorList.get(cb.getSelectedIndex())))
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Appointment Successfully Done");
                                                        requestAppntDialog.dispose();
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Sorry No available slot at this entered time. Try other time slot");
                                                    }
                                                }
                                            }
                                        });

                                        requestAppntDialog.setSize(450,500);
                                        requestAppntDialog.setResizable(false);
                                        requestAppntDialog.setLocationRelativeTo(null);
                                        requestAppntDialog.setVisible(true);
                                    }
                                }); 
                               
                                /// view appointment
                                viewAppointmentbutton.addActionListener(new ActionListener() 
                                {
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        final JFrame frame = new JFrame("List Of Your Appointments");   
                                        JPanel jp=new JPanel(new BorderLayout());
                                        final JList list;
                                        final DefaultListModel model;
                                        
                                        model = new DefaultListModel();
                                        list = new JList(model);
                                        JScrollPane pane = new JScrollPane(list);
                                        JButton chngButton = new JButton("Change Appointment");
                                        JButton cancelButton = new JButton("Cancel Appointment");
                                        
                                        chngButton.addActionListener(new ActionListener() 
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) 
                                            {
                                                try
                                                {
                                                JLabel date=new JLabel("Date(dd/mm/yyyy)");
                                                final JTextField datefield=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).date);
                                        
                                                final JDialog requestAppntDialog=new JDialog();
                                                requestAppntDialog.setLayout(null);
                                                requestAppntDialog.setName("Modify Your Appointment");
                                                JLabel appIDLbl=new JLabel("Symptoms:");
                                                final JTextField appfield=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).desc);

                                                JLabel appntFrom=new JLabel("Start Time(hh:mm)");
                                                final JTextField frmFld=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).from);

                                                JLabel appntTo=new JLabel("End Time(hh:mm)");
                                                final JTextField toField=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).to);


                                                JButton submitButton=new JButton("Request Appointment Change");
                                                
                                                appIDLbl.setBounds(10, 5,200,25);
                                                appfield.setBounds(120,5,200,25);

                                                appntFrom.setBounds(10,30,200,25);
                                                frmFld.setBounds(120, 30,200,25);

                                                appntTo.setBounds(10,50,200,25);
                                                toField.setBounds(120,50,200,25);

                                                date.setBounds(10,80,200,25);
                                                datefield.setBounds(120,80,200,25);

                                                submitButton.setBounds(120,180,260,60);
                                                requestAppntDialog.add(appIDLbl);
                                                requestAppntDialog.add(appfield);
                                                requestAppntDialog.add(appntFrom);
                                                requestAppntDialog.add(frmFld);
                                                requestAppntDialog.add(appntTo);
                                                requestAppntDialog.add(toField);
                                                requestAppntDialog.add(date);
                                                requestAppntDialog.add(datefield);
                                                requestAppntDialog.add(submitButton);

                                                String type[]=new String[doctorList.size()];

                                                for(int dd=0;dd<doctorList.size();dd++)
                                                {
                                                    type[dd]=doctorList.get(dd).doctorName+" ,"+doctorList.get(dd).type;
                                                }


                                                JLabel doctLabel=new JLabel("Doctor");
                                                final JComboBox cb=new JComboBox(type);
                                                doctLabel.setBounds(10, 110,100,60);
                                                cb.setBounds(100, 110,120,60); 
                                                requestAppntDialog.add(doctLabel);
                                                requestAppntDialog.add(cb);
                                        
                                                submitButton.addActionListener(new ActionListener() {

                                                    @Override
                                                    public void actionPerformed(ActionEvent e) 
                                                    {
                                                        try
                                                        {
                                                        if(datefield.getText().equals("") || appfield.getText().equals("") || frmFld.getText().equals("") || toField.getText().equals(""))
                                                        {
                                                            JOptionPane.showMessageDialog(null,"Please Complete all the field");
                                                        }
                                                        else
                                                        {
                                                            if(fpatient.chngrequestAppointment(secretaryList.get(0),datefield.getText(),appfield.getText(),frmFld.getText(),toField.getText(),doctorList.get(cb.getSelectedIndex())))
                                                            {
                                                                JOptionPane.showMessageDialog(null,"Appointment Change Successfully Done");
                                                                requestAppntDialog.dispose();
                                                                model.removeAllElements();
                                                                 model.addElement("Description ---"+"DoctorName ---"+"Date----"+"From(Time) ---"+"To(Time)---");
                                        
                                        for (int i = 0; i < fpatient.appointmentList.size(); i++)
                                        {
                                            
                                             model.addElement(" --- "+fpatient.appointmentList.get(i).desc+"---"+fpatient.appointmentList.get(i).doctor.doctorName+"---"+fpatient.appointmentList.get(i).date+"---"+fpatient.appointmentList.get(i).from+"---"+fpatient.appointmentList.get(i).to);
                                        
                                        }
                                                                frame.revalidate();
                                                               
                                                                
                                                            }
                                                            else
                                                            {
                                                                JOptionPane.showMessageDialog(null,"Sorry No available slot at this entered time. Try other time slot");
                                                            }
                                                        }
                                                        }
                                                        catch(Exception ee)
                                                        {
                                                            JOptionPane.showMessageDialog(null,"Please Select a appointment first");
                                                        }
                                                    }
                                                });

                                                requestAppntDialog.setSize(450,500);
                                                requestAppntDialog.setResizable(false);
                                                requestAppntDialog.setLocationRelativeTo(null);
                                                requestAppntDialog.setVisible(true);
                                                }
                                                catch(Exception ee)
                                                {
                                                    JOptionPane.showMessageDialog(null,"Please Select an Appointment Firsts");
                                                }
                                            }
                                        });
                                        
                                        cancelButton.addActionListener(new ActionListener() 
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) 
                                            {
                                                try
                                                {
                                                    if(fpatient.cancelAppointment(list.getSelectedIndex()-1,secretaryList.get(0)))
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Appointment Cancelled Successfully!!!");
                                                        model.remove(list.getSelectedIndex());
                                                        frame.revalidate();
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Cancel Appointment Unsuccessful");
                                                    }
                                                }
                                                catch(Exception ee)
                                                {
                                                    JOptionPane.showMessageDialog(null,"Please select an appointment to Cancel");
                                                }
                                                
                                                
                                            }
                                        });
                                        
                                        
                                        
                                        model.addElement("Description ---"+"DoctorName ---"+"Date----"+"From(Time) ---"+"To(Time)---");
                                        
                                        for (int i = 0; i < fpatient.appointmentList.size(); i++)
                                        {
                                            
                                             model.addElement(" --- "+fpatient.appointmentList.get(i).desc+"---"+fpatient.appointmentList.get(i).doctor.doctorName+"---"+fpatient.appointmentList.get(i).date+"---"+fpatient.appointmentList.get(i).from+"---"+fpatient.appointmentList.get(i).to);
                                        
                                        }
                                           

                                       jp.add(pane, BorderLayout.NORTH);
                                       
                                       jp.add(chngButton, BorderLayout.WEST);
                                       jp.add(cancelButton, BorderLayout.EAST);
                                       frame.setContentPane(jp);
                                       frame.setSize(700,230);
                                       frame.setVisible(true);
                                    }
                                });

                                patientFrame.add(welcome);
                                patientFrame.add(requestAppntButton);
                                patientFrame.add(viewAppointmentbutton);
                                

                                patientFrame.setLayout(null);
                                
                                welcome.setBounds(50,3,300,70);
                                requestAppntButton.setBounds(50,70,270,60);
                                viewAppointmentbutton.setBounds(50,150,270,60);
                                patientFrame.setSize(500,500);
                                loginDialog.setVisible(false);
                                patientFrame.setVisible(true);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"The Patient ID is not registered!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            
                        
                        }
                        //doctor
                        else if(index==1)
                        {
                            boolean flag=false;
                            Doctor d = null;
                            final Doctor fd;
                            for(int pp=0;pp<doctorList.size();pp++)
                            {
                                d=doctorList.get(pp);
                                if(d.doctorId.equals(namefield.getText()))
                                {
                                    flag=true;
                                    break;
                                }
                                
                            }
                            
                            if(flag)
                            {
                                fd=d;
                                JFrame doctorFrame=new JFrame("UHSurgery Appointment Management System – Doctor Module");
                                JButton viewPatientbutton=new JButton("View Patient List");

                                viewPatientbutton.addActionListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        
                                        final JFrame frame = new JFrame("View Patient Window");   
                                        JPanel jp=new JPanel(new BorderLayout());
                                        final JList list;
                                        final DefaultListModel model;
                                        
                                        model = new DefaultListModel();
                                        list = new JList(model);
                                        JScrollPane pane = new JScrollPane(list);
                                        JButton completeButton = new JButton("Complete Appointment");
                                        JButton makeMedicationsButton = new JButton("Make Notes");
                                        
                                        model.addElement("Patient ---"+"Mobile ---"+"Medications ---");
                                        
                                        for (int i = 0; i < fd.bookedSlot.size(); i++)
                                        {
                                            model.addElement(fd.bookedSlot.get(i).p.patientName+"---"+fd.bookedSlot.get(i).p.mobile+"---"+fd.bookedSlot.get(i).p.medications);
                                        
                                        }
                                        
                                        completeButton.addActionListener(new ActionListener() 
                                        {

                                            @Override
                                            public void actionPerformed(ActionEvent e) 
                                            {
                                                try
                                                {
                                                    if(fd.completeAppointment(list.getSelectedIndex()-1))
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Completed Appointment Successfully");
                                                        model.remove(list.getSelectedIndex());
                                                        frame.revalidate();
                                                        frame.dispose();
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Complete Appointment Unsuccessful");
                                                        frame.dispose();
                                                    }
                                                }
                                                catch(Exception ee)
                                                {
                                                    JOptionPane.showMessageDialog(null,"Please select an appointment to Cancel");
                                                }
                                                
                                                
                                            }
                                        });
                                        
                                        
                                        /// make notes to patient
                                        makeMedicationsButton.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e) 
                                            {
                                                String notes=JOptionPane.showInputDialog("Enter Notes For the Patient");
                                                fd.makeNotes(list.getSelectedIndex(),notes);
                                                frame.revalidate();
                                            }
                                        });
                                        
                                       jp.add(pane, BorderLayout.NORTH);
                                       jp.add(completeButton, BorderLayout.WEST);
                                       jp.add(makeMedicationsButton,BorderLayout.EAST);
                                       frame.setContentPane(jp);
                                       frame.setSize(700,230);
                                       frame.setVisible(true);
                                         //p.requestAppointment();
                                    }
                                });

                                doctorFrame.add(viewPatientbutton);
                                doctorFrame.setLayout(new FlowLayout());
                                doctorFrame.setSize(500,500);
                                doctorFrame.setVisible(true);
                                loginDialog.setVisible(false);
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"The Doctor ID is not registered!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            
                        }
                         ///secretary
                        else if(index==2)
                        {
                            boolean flag=false;
                            Secretary s=null;
                            final Secretary fs;
                            for(int pp=0;pp<secretaryList.size();pp++)
                            {
                                s=secretaryList.get(pp);
                                if(s.id.equals(namefield.getText()))
                                {
                                    flag=true;
                                    break;
                                }
                                
                            }
                            
                            if(flag)
                            {
                                fs=s;
                                JFrame secretaryFrame=new JFrame("UHSurgery Appointment Management System – Secretary Module");
                                JLabel welcome=new JLabel("Welcome "+fs.name);
                                JButton viewPatientbutton=new JButton("View Requested Appointment List");
                                
                                viewPatientbutton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        String startDate=JOptionPane.showInputDialog("Please Enter Start Date(dd/mm/yyyy)");
                                        String endDate=JOptionPane.showInputDialog("Please Enter End Date(dd/mm/yyyy)");
                                        
                                        
                                        
                                        
                                        final JFrame frame = new JFrame("List Of All Appointments");   
                                        JPanel jp=new JPanel(new BorderLayout());
                                        final JList list;
                                        final DefaultListModel model;
                                        
                                        model = new DefaultListModel();
                                        list = new JList(model);
                                        JScrollPane pane = new JScrollPane(list);
                                        JButton completeButton = new JButton("Finalize Appointment");
                                        Date date1=null,date2=null;
                                        try 
                                        {
                                            date1=new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
                                            date2=new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
                                        } 
                                        catch (ParseException ex) 
                                        {
                                            Logger.getLogger(AppointmentSystem.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        
                                        
                                        model.addElement("Patient ---"+"Mobile ---"+"Doctor ---"+"Type ---"+"Date"+"----"+"Start(time)---"+"End Time");
                                        
                                        //System.out.println("Size:"+fs.secappntmentList.size());
                                        for (int i = 0; i < fs.secappntmentList.size(); i++)
                                        {
                                            try {
                                                Date date=new SimpleDateFormat("dd/MM/yyyy").parse(fs.secappntmentList.get(i).date);
                                                
                                                if(date1.before(date) && date2.after(date))
                                                {
                                                    model.addElement(fs.secappntmentList.get(i).patient.patientName+"---"+fs.secappntmentList.get(i).patient.mobile+"---"+fs.secappntmentList.get(i).doctor.doctorName+" ----"+fs.secappntmentList.get(i).type+" -----"+fs.secappntmentList.get(i).date+" -----"+fs.secappntmentList.get(i).from+"-----"+fs.secappntmentList.get(i).to);
                                            
                                                }
                                            } catch (ParseException ex) {
                                                Logger.getLogger(AppointmentSystem.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        
                                        }
                                        
                                        
                                        completeButton.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e)
                                            {
                                               try
                                               {
                                                   model.remove(list.getSelectedIndex());
                                                   frame.revalidate();
                                                   JOptionPane.showMessageDialog(null,"Finalize Appointment Successfully");
                                                   
                                                   frame.dispose();
                                               }
                                               catch(Exception ee)
                                               {
                                                   JOptionPane.showMessageDialog(null,"Please Select an Appointment to finalize appointment");
                                                   frame.dispose();
                                               }    
                                                    
                                            
                                            }
                                        });
                                        
                                        jp.add(pane, BorderLayout.NORTH);
                                        jp.add(completeButton, BorderLayout.WEST);
                                        frame.setContentPane(jp);
                                        frame.setSize(700,230);
                                        frame.setVisible(true);
                                              
                                         }
                                  
                                    
                                });

                                secretaryFrame.add(welcome);
                                secretaryFrame.add(viewPatientbutton);
                                secretaryFrame.setLayout(null);
                                
                                welcome.setBounds(20, 3,250,65);
                                viewPatientbutton.setBounds(20,60,250,60);
                                
                                
                                secretaryFrame.setSize(500,500);
                                secretaryFrame.setVisible(true);
                                loginDialog.setVisible(false);
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"The Secretary ID is not registered!", "Error", JOptionPane.ERROR_MESSAGE);
                                
                            }
                        }
                        //Pharmacist
                        else if(index==3)
                        {
                            boolean flag=false;
                            Pharmacist ph=null;
                            final Pharmacist fph;
                            for(int pp=0;pp<pharmaList.size();pp++)
                            {
                                ph=pharmaList.get(pp);
                                if(ph.pharmacistId.equals(namefield.getText()))
                                {
                                    flag=true;
                                    break;
                                }
                            }
                            
                            if(flag)
                            {
                                JFrame pharmacistFrame=new JFrame("UHSurgery Appointment Management System – Pharmacist Module");
                                JButton viewPharmacistbutton=new JButton("View Medication List For Patient");

                                viewPharmacistbutton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        final JFrame frame = new JFrame("View Medication List For Patient");   
                                        JPanel jp=new JPanel(new BorderLayout());
                                        final JList list;
                                        final DefaultListModel model;
                                        
                                        model = new DefaultListModel();
                                        list = new JList(model);
                                        JScrollPane pane = new JScrollPane(list);
                                        JButton completeButton = new JButton("Deliver Medications");
                                        
                                        
                                        model.addElement("Patient ---"+"Mobile ---"+"Medications ---");
                                        
                                        final ArrayList<Integer> al=new ArrayList<Integer>();
                                        
                                        for (int i = 0; i < patientList.size(); i++)
                                        {
                                            if(!patientList.get(i).medications.equals("Empty"))
                                            {
                                                al.add(i);
                                                model.addElement(patientList.get(i).patientName+"---"+patientList.get(i).mobile+"---"+patientList.get(i).medications);
                                            }
                                        
                                        }
                                        
                                        
                                        completeButton.addActionListener(new ActionListener() {

                                            @Override
                                            public void actionPerformed(ActionEvent e)
                                            {
                                               try
                                               {
                                                   int index=list.getSelectedIndex();
                                                   model.remove(index);
                        
                                                   //System.out.println("s:"+index);
                                                   patientList.remove(al.get(index-1));
                                                   
                                                   frame.revalidate();
                                                   JOptionPane.showMessageDialog(null,"Medication Giving Successfully");
                                                   
                                                   frame.dispose();
                                               }
                                               catch(Exception ee)
                                               {
                                                   JOptionPane.showMessageDialog(null,"Please Select an medications from the list to give medications"+ee);
                                                   frame.dispose();
                                               }
                                                    
                                            
                                            }
                                        });
                                        
                                        jp.add(pane, BorderLayout.NORTH);
                                        jp.add(completeButton, BorderLayout.WEST);
                                        frame.setContentPane(jp);
                                        frame.setSize(700,230);
                                        frame.setVisible(true);
                                        
                                    }
                                });

                                pharmacistFrame.add(viewPharmacistbutton);
                                pharmacistFrame.setLayout(new FlowLayout());
                                pharmacistFrame.setSize(500,500);
                                pharmacistFrame.setVisible(true);
                                loginDialog.setVisible(false);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"The Pharmacist ID is not registered!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        }
                    }
                });
                
              
     
        
       
        
    }
    public static void main(String[] args) 
    {
        AppointmentSystem ap=new AppointmentSystem();
    }
}
