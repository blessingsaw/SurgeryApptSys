
package appointmentsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
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
    JMenuBar jm=new JMenuBar();
    JMenu addmenu=new JMenu("Add Menu");
    JMenuItem addPatientItem=new JMenuItem("Add Patient to System");
    JMenuItem addDoctorItem=new JMenuItem("Add Doctor Item");
    JMenuItem addPharmacistItem=new JMenuItem("Add Pharmacist");
    JMenuItem addSecretaryItem=new JMenuItem("Add Secretary");
    
    ArrayList<Patient> patientList=new ArrayList<Patient>();
    ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
    ArrayList<Secretary> secretaryList=new ArrayList<Secretary>();
    ArrayList<Pharmacist> pharmaList=new ArrayList<Pharmacist>();
    
    public AppointmentSystem()
    {
        
        //// initialize preregistered member
        patientList.add(new Patient("p1name","Mumbai","Mob","p1"));
        patientList.add(new Patient("p2n","Mumbai","Mob2","p2"));
        patientList.add(new Patient("p3n","Mumbai","Mob3","p3"));
        patientList.add(new Patient("p4n","Mumbai","Mob4","p4"));
        patientList.add(new Patient("p5n","Mumbai","Mob5","p5"));
        patientList.add(new Patient("p6n","Mumbai","Mob2","p6"));
        patientList.add(new Patient("p7n","Mumbai","Mob2","p7"));
        patientList.add(new Patient("p8n","Mumbai","Mob2","p8"));
        patientList.add(new Patient("p9n","Mumbai","Mob2","p9"));
        patientList.add(new Patient("p10n","Mumbai","Mob2","p10"));
        
        secretaryList.add(new Secretary("Secretart1","s1"));
        secretaryList.add(new Secretary("Secretart2","s2"));
        secretaryList.add(new Secretary("Secretart3","s3"));
        
        pharmaList.add(new Pharmacist("Pharmacist1", "Ph1"));
        

        doctorList.add(new Doctor("d1n","d1", "Dentist"));
        doctorList.add(new Doctor("d2n","d2", "Dermatologist"));
        doctorList.add(new Doctor("d3n","d3", "Medicine"));
        
        
        patientList.get(0).appointmentList.add(new Appointment("Heart Problm","24/3/2017", "17:00","17:30",patientList.get(0),doctorList.get(0)));
        patientList.get(1).appointmentList.add(new Appointment("Heart Problm","24/3/2017","17:31","18:30",patientList.get(1),doctorList.get(0)));
        patientList.get(2).appointmentList.add(new Appointment("Heart Problm","24/3/2017","13:00","13:30",patientList.get(2),doctorList.get(0)));
        patientList.get(3).appointmentList.add(new Appointment("Heart Problm","24/3/2017", "13:30","14:00",patientList.get(3),doctorList.get(0)));
        patientList.get(4).appointmentList.add(new Appointment("Heart Problm","24/3/2017", "14:00","14:30",patientList.get(4),doctorList.get(0)));
        patientList.get(5).appointmentList.add(new Appointment("Heart Problm","24/3/2017","14:30","15:00",patientList.get(5),doctorList.get(0)));
        patientList.get(6).appointmentList.add(new Appointment("Heart Problm","24/3/2017", "14:30","15:00",patientList.get(6),doctorList.get(0)));
        patientList.get(7).appointmentList.add(new Appointment("Stomach Problm","24/3/2017","12:00","12:30",patientList.get(7),doctorList.get(1)));
        patientList.get(5).appointmentList.add(new Appointment("Stomach Problm","25/3/2017", "12:30","13:00",patientList.get(5),doctorList.get(0)));
        patientList.get(0).appointmentList.add(new Appointment("Stomach Problm","25/3/2017","13:30","14:00",patientList.get(0),doctorList.get(0)));
        patientList.get(1).appointmentList.add(new Appointment("Stomach Problm","25/3/2017","13:30","14:00",patientList.get(1),doctorList.get(1)));
        patientList.get(2).appointmentList.add(new Appointment("Stomach Problm","25/3/2017","14:00","14:30",patientList.get(2),doctorList.get(1)));
        patientList.get(7).appointmentList.add(new Appointment("Brain Problm","26/3/2017","13:30","14:00",patientList.get(7),doctorList.get(2)));
        patientList.get(8).appointmentList.add(new Appointment("Brain Problm","26/3/2017","13:30","14:00",patientList.get(8),doctorList.get(2)));
        patientList.get(9).appointmentList.add(new Appointment("Brain Problm","26/3/2017","13:30","14:00",patientList.get(9),doctorList.get(2)));
        
        //// adding Menu
        addmenu.add(addPatientItem);
        addmenu.add(addDoctorItem);
        addmenu.add(addPharmacistItem);
        addmenu.add(addSecretaryItem);
        setJMenuBar(jm);
        jm.add(addmenu);
        //// Login Dialog
        JDialog loginDialog=new JDialog();
        
        
        /// end of Login Dialog
        
        addPatientItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                final JDialog patientDialog=new JDialog();
              
                patientDialog.setLayout(null);
                
                
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
        
        //// End of Adding menu
        
        setTitle("Appointment System");
        setSize(600,600);
        setLayout(new FlowLayout());

        /// addding Login Button
        JButton loginButton=new JButton("Login");
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ///Login Dialog
                final JDialog loginDialog=new JDialog();
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
                
                String type[]={"Patient","Doctor","Secretary","Pharmacist"};        
                final JComboBox cb=new JComboBox(type);    
                cb.setBounds(230, 70,100,60); 
                loginDialog.add(cb);
              
                loginDialog.setSize(450,500);
                loginDialog.setResizable(false);
                loginDialog.setLocationRelativeTo(null);
                loginDialog.setVisible(true);
                
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
                                JFrame patientFrame=new JFrame("Patient Window");
                                JButton requestAppntButton=new JButton("Request Appointment");
                                JButton viewAppointmentbutton=new JButton("View Appointment");

                                
                                /// request appointment
                                requestAppntButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        final JDialog requestAppntDialog=new JDialog();
                                        requestAppntDialog.setLayout(null);
                                        JLabel appIDLbl=new JLabel("Description:");
                                        final JTextField appfield=new JTextField();
                                        
                                        JLabel date=new JLabel("Date");
                                        final JTextField datefield=new JTextField();
                                        
                                        JLabel appntFrom=new JLabel("From(Time)");
                                        final JTextField frmFld=new JTextField();
                                        
                                        JLabel appntTo=new JLabel("To(Time)");
                                        final JTextField toField=new JTextField();
                                        
                                        
                                        JButton submitButton=new JButton("Request Appointment");
                                        appIDLbl.setBounds(10, 5,200,25);
                                        appfield.setBounds(100,5,200,25);

                                        appntFrom.setBounds(10,30,200,25);
                                        frmFld.setBounds(100, 30,200,25);

                                        appntTo.setBounds(10,50,200,25);
                                        toField.setBounds(100,50,200,25);
                                        
                                        date.setBounds(10,80,200,25);
                                        datefield.setBounds(100,80,200,25);

                                        submitButton.setBounds(100,180,200,60);
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
                                            type[dd]=doctorList.get(dd).doctorName;
                                        }
                                        
                                        
                                        JLabel doctLabel=new JLabel("Doctor");
                                        final JComboBox cb=new JComboBox(type);
                                        doctLabel.setBounds(10, 110,100,60);
                                        cb.setBounds(100, 110,100,60); 
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
                                                    if(fpatient.requestAppointment(secretaryList.get(0),datefield.getText(),appfield.getText(),frmFld.getText(),toField.getText(),doctorList.get(cb.getSelectedIndex())))
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
                                        final JFrame frame = new JFrame("View Appointment");   
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
                                                JLabel date=new JLabel("Date");
                                                final JTextField datefield=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).date);
                                        
                                                final JDialog requestAppntDialog=new JDialog();
                                                requestAppntDialog.setLayout(null);
                                                JLabel appIDLbl=new JLabel("Description:");
                                                final JTextField appfield=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).desc);

                                                JLabel appntFrom=new JLabel("From (Time)");
                                                final JTextField frmFld=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).from);

                                                JLabel appntTo=new JLabel("To (Time)");
                                                final JTextField toField=new JTextField(fpatient.appointmentList.get(list.getSelectedIndex()-1).to);


                                                JButton submitButton=new JButton("Request Appointment Change");
                                                
                                                appIDLbl.setBounds(10, 5,200,25);
                                                appfield.setBounds(100,5,200,25);

                                                appntFrom.setBounds(10,30,200,25);
                                                frmFld.setBounds(100, 30,200,25);

                                                appntTo.setBounds(10,50,200,25);
                                                toField.setBounds(100,50,200,25);

                                                date.setBounds(10,80,200,25);
                                                datefield.setBounds(100,80,200,25);

                                                submitButton.setBounds(100,180,260,60);
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
                                                    type[dd]=doctorList.get(dd).doctorName;
                                                }


                                                JLabel doctLabel=new JLabel("Doctor");
                                                final JComboBox cb=new JComboBox(type);
                                                doctLabel.setBounds(10, 110,100,60);
                                                cb.setBounds(100, 110,100,60); 
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
                                                        JOptionPane.showMessageDialog(null,"Cancel Appointment Successfully");
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
                                        
                                        
                                        
                                        model.addElement("Description ---"+"DoctorName ---"+"From(Time) ---"+"To(Time)---");
                                        
                                        for (int i = 0; i < fpatient.appointmentList.size(); i++)
                                        {
                                            
                                             model.addElement(" --- "+fpatient.appointmentList.get(i).desc+"---"+fpatient.appointmentList.get(i).doctor.doctorName+"---"+fpatient.appointmentList.get(i).from+"---"+fpatient.appointmentList.get(i).to);
                                        
                                        }
                                           

                                       jp.add(pane, BorderLayout.NORTH);
                                       jp.add(chngButton, BorderLayout.WEST);
                                       jp.add(cancelButton, BorderLayout.EAST);
                                       frame.setContentPane(jp);
                                       frame.setSize(700,230);
                                       frame.setVisible(true);
                                    }
                                });

                                patientFrame.add(requestAppntButton);
                                patientFrame.add(viewAppointmentbutton);
                                

                                patientFrame.setLayout(new FlowLayout());
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
                                JFrame doctorFrame=new JFrame("Doctor Window");
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
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Complete Appointment Unsuccessful");
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
                            Secretary s;
                            for(int pp=0;pp<secretaryList.size();pp++)
                            {
                                s=secretaryList.get(pp);
                                if(s.id.equals(namefield.getText()))
                                {
                                    flag=true;
                                }
                                
                            }
                            
                            if(flag)
                            {
                                JFrame patientFrame=new JFrame("Secretary Window");
                                JButton viewPatientbutton=new JButton("View Requested Appointment List");

                                viewPatientbutton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        
                                         //p.requestAppointment();
                                    }
                                });

                                patientFrame.add(viewPatientbutton);
                                setLayout(new FlowLayout());
                                setSize(500,500);
                                setVisible(true);
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
                            Pharmacist d;
                            for(int pp=0;pp<pharmaList.size();pp++)
                            {
                                d=pharmaList.get(pp);
                                if(d.pharmacistId.equals(namefield.getText()))
                                {
                                    flag=true;
                                }
                                
                            }
                            
                            if(flag)
                            {
                                JFrame patientFrame=new JFrame("Pharmacist Window");
                                JButton viewPatientbutton=new JButton("View Medication List For Patient");

                                viewPatientbutton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        
                                         //p.requestAppointment();
                                    }
                                });

                                patientFrame.add(viewPatientbutton);
                                setLayout(new FlowLayout());
                                setSize(500,500);
                                setVisible(true);
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
        });
        
        
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
      });
        
    }
    public static void main(String[] args) 
    {
        AppointmentSystem ap=new AppointmentSystem();
        ap.setVisible(true);
        
    }
}
