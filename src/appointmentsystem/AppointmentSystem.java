
package appointmentsystem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
        
        
        doctorList.add(new Doctor("d1n","d1", "Dentist"));
        doctorList.add(new Doctor("d1n","d1", "Dermatologist"));
        doctorList.add(new Doctor("d1n","d1", "Medicine"));
        
        
        patientList.get(0).appointmentList.add(new Appointment(1,"Heart Problm","24/3/2017 05:00","24/3/2017 05:30",patientList.get(0),doctorList.get(0)));
        patientList.get(1).appointmentList.add(new Appointment(2,"Heart Problm","24/3/2017 05:31","24/3/2017 06:30",patientList.get(1),doctorList.get(0)));
        patientList.get(2).appointmentList.add(new Appointment(3,"Heart Problm","24/3/2017 01:00","24/3/2017 01:30",patientList.get(2),doctorList.get(0)));
        patientList.get(3).appointmentList.add(new Appointment(4,"Heart Problm","24/3/2017 01:30","24/3/2017 02:00",patientList.get(3),doctorList.get(0)));
        patientList.get(4).appointmentList.add(new Appointment(5,"Heart Problm","24/3/2017 02:00","24/3/2017 02:30",patientList.get(4),doctorList.get(0)));
        patientList.get(0).appointmentList.add(new Appointment(1,"Heart Problm","24/3/2017 05:00","24/3/2017 05:30",patientList.get(5),doctorList.get(0)));
        
        
        
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
                        patientDialog.dispose();
                        Patient p=new Patient(namefield.getText(), addrField.getText(),mobfield.getText(),idfield.getText());
                        patientList.add(p);
                        
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
                        doctDialog.dispose();
                        Doctor d=new Doctor(namefield.getText(), idField.getText(),typefield.getText());
                        doctorList.add(d);
                        
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
                        dialog.dispose();
                        Secretary d=new Secretary(namefield.getText(), idField.getText());
                        secretaryList.add(d);
                        
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
                        dialog.dispose();
                        Pharmacist d=new Pharmacist(namefield.getText(), idField.getText());
                        pharmaList.add(d);
                        
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
                JDialog loginDialog=new JDialog();
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
                        Patient p;
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
                                }
                                
                            }
                            
                            if(flag)
                            {
                                JFrame patientFrame=new JFrame("Patient Window");
                                JButton requestAppntButton=new JButton("Request Appointment");
                                JButton viewAppointmentbutton=new JButton("View Appointment");

                                requestAppntButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        
                                         //p.requestAppointment();
                                    }
                                });
                               

                                viewAppointmentbutton.addActionListener(new ActionListener() 
                                {
                                    public void actionPerformed(ActionEvent e) 
                                    {

                                    }
                                });

                                patientFrame.add(requestAppntButton);
                                patientFrame.add(viewAppointmentbutton);
                                

                                setLayout(new FlowLayout());
                                setSize(500,500);
                                setVisible(true);
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
                            Doctor d;
                            for(int pp=0;pp<doctorList.size();pp++)
                            {
                                d=doctorList.get(pp);
                                if(d.doctorId==Integer.parseInt(namefield.getText()))
                                {
                                    flag=true;
                                }
                                
                            }
                            
                            if(flag)
                            {
                                JFrame patientFrame=new JFrame("Doctor Window");
                                JButton viewPatientbutton=new JButton("View Patient List");

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
                                JOptionPane.showMessageDialog(null,"The SEcretary ID is not registered!", "Error", JOptionPane.ERROR_MESSAGE);
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
                                if(d.pharmacistId==Integer.parseInt(namefield.getText()))
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
