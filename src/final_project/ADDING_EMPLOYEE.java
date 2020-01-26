
package final_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import final_project.HOME_PAGE;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import final_project.FILE_MANAGER;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class ADDING_EMPLOYEE {
    public static JFrame frame;
    public static Container panel;
    synchronized static int getMaxId(File f1)throws IOException{
        Scanner k=new Scanner(f1);
        int mxId=k.nextInt();
        k.close();
        FileWriter fr=new FileWriter(f1);
        BufferedWriter br=new BufferedWriter(fr);
        br.write(String.valueOf(mxId+1));
        br.close();
        fr.close();
        return mxId;
    }
    synchronized static int getMaxPort(File f1)throws IOException{
        Scanner k=new Scanner(f1);
        int mxId=k.nextInt();
        k.close();
        FileWriter fr=new FileWriter(f1);
        BufferedWriter br=new BufferedWriter(fr);
        br.write(String.valueOf(mxId+1));
        br.close();
        fr.close();
        return mxId;
    }
    public static void main(String[] args) {
        addEmployee();
    }
    static void addEmployee(){
        
        Font font1=new Font("f1",Font.BOLD+Font.ITALIC,16);
        frame=new JFrame();
        frame.setBounds(10,10,1170,700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel=frame.getContentPane();
        ImageIcon icon=new ImageIcon("image2.jpg");
        JLabel background=new JLabel(icon);
        background.setBounds(0,0,1170,700);
        frame.setLayout(null);
        panel.setLayout(null);
       // panel.setBackground(Color.CYAN);
        JButton exit=new JButton("BACK");
        exit.setBounds(10,10,100,40);
        exit.setBackground(Color.CYAN);
        exit.setForeground(Color.PINK);
        exit.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                //try{
            //    frame.dispose();
                  panel.setVisible(false);
                  HOME_PAGE.home.remove(panel);
                  HOME_PAGE.home.setContentPane(HOME_PAGE.panel);
                  HOME_PAGE.panel.setVisible(true);
            //  HOME_PAGE.viewHome();
               // }catch(IOException a){}
            }
        });
        panel.add(exit);
        JLabel label1=new JLabel("Enter employee name");
        label1.setBounds(40,100,300,50);
        label1.setForeground(Color.GREEN);
        label1.setFont(font1);
        panel.add(label1);
        JLabel label2=new JLabel("Enter employee designation");
        label2.setBounds(440,100,300,50);
        label2.setForeground(Color.GREEN);
        label2.setFont(font1);
        panel.add(label2);
        JLabel label3=new JLabel("Enter employee salary");
        label3.setBounds(840,100,300,50);
        label3.setForeground(Color.GREEN);
        label3.setFont(font1);
        panel.add(label3);
        JLabel label4=new JLabel("Enter employee's birth day");
        label4.setBounds(40,300,300,50);
        label4.setForeground(Color.GREEN);
        label4.setFont(font1);
        panel.add(label4);
        JLabel label5=new JLabel("Enter employee's contact info");
        label5.setBounds(440,300,300,50);
        label5.setForeground(Color.GREEN);
        label5.setFont(font1);
        panel.add(label5);
        JTextField nameField=new JTextField();
        nameField.setBounds(40,200,200,50);
        nameField.setFont(font1);
        JTextField birthDayD=new JTextField("dd");
        birthDayD.setBounds(40,400,70,50);
        birthDayD.setFont(font1);
        panel.add(birthDayD);
        JTextField birthDayM=new JTextField("mm");
        birthDayM.setBounds(130,400,70,50);
        birthDayM.setFont(font1);
        panel.add(birthDayM);
        JTextField birthDayY=new JTextField("yy");
        birthDayY.setBounds(210,400,70,50);
        birthDayY.setFont(font1);
        panel.add(birthDayY);
        JTextField contactInfo=new JTextField();
        contactInfo.setBounds(440,400,200,50);
        panel.add(contactInfo);
       // nameField.setBackground(Color.GREEN);
        JTextField designationField=new JTextField();
        designationField.setBounds(440,200,200,50);
        designationField.setFont(font1);
      //  designationField.setBackground(Color.GREEN);
        JTextField salaryField=new JTextField();
        salaryField.setBounds(840,200,200,50);
        
        salaryField.setFont(font1);
        
       // salaryField.setBackground(Color.GREEN);
        panel.add(nameField);
        panel.add(salaryField);
        panel.add(designationField);
        JButton ok=new JButton("OK");
        ok.setBounds(40,500,80,40);
        panel.add(ok);
        panel.add(background);
        background.setVisible(true);
//        exit.addActionListener(new ActionListener(){ 
//            public void actionPerformed(ActionEvent e) {
//                try{
//                    
//                HOME_PAGE.viewHome();
//                }catch(IOException a){}
//            }
//        });
        ok.addActionListener(new ActionListener(){
            synchronized public void actionPerformed(ActionEvent e){
                //System.out.println("tefg");
                String name=nameField.getText().replace(' ', '_');
                
                String designation=designationField.getText();
                String salary=salaryField.getText();
               // System.out.println(salary);
                int id;
                int port;
                if(name.equals("")||designation.equals("")||salaryField.getText().equals("")||contactInfo.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"YOU CAN NOT KEEP ANY ENTRY EMPTY","WARNING",0);
                }
                else {
                try{
                    File f1=new File("MAX_ID.txt");
                    
                    id=getMaxId(f1)+1;
                    GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
                    int ara[]={0,31,29,31,30,31,30,31,31,30,31,30,31};
                    // cal.getDiffence();
                    Date da=cal.getTime();
                    int day=da.getDate();
                    int month=da.getMonth()+1;
                    int year=da.getYear()+1900;
                    //System.out.println("m"+month+"Y"+year);
                    int bday=0,bmonth=0,byear=0;
                    String JoiningDateJoiningDate = day+"/"+month+"/"+year;
                    int flag=0;
                    try{
                    bday=Integer.parseInt(birthDayD.getText());
                    bmonth=Integer.parseInt(birthDayM.getText());
                    byear=Integer.parseInt(birthDayY.getText());
                    if(bmonth<=0||bmonth>12){JOptionPane.showMessageDialog(null, "Invalid date");flag=1;}
                    else if(bday<=0||bday>=ara[bmonth]){JOptionPane.showMessageDialog(null,"Invalid date");flag=1;}
                    
                    }catch(Exception a){JOptionPane.showMessageDialog(null,"Invalid date");flag=1;}
                    //System.out.println("hellow");
                    if(flag==0){
                    FileManager fm=new FileManager("EMPLOYEE_LIST.txt");
                    String birthDay=bday+"/"+bmonth+"/"+byear;
                    int choice=JOptionPane.showConfirmDialog(null,"Are you sure to recruit this employee with User Id :"+id,"Select option",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(choice==JOptionPane.YES_OPTION){
                    fm.insert_employee(id, name, designation, Integer.parseInt(salary), "null", birthDay,JoiningDateJoiningDate,contactInfo.getText());
                   // System.out.println("done");
                    JOptionPane.showMessageDialog(null,"RECRUITMENT SUCCESSFULL");
                    }
                    }
                }catch(Exception df){ JOptionPane.showMessageDialog(null,"Invalid Input","Error",2);}
            }
                
            }
        });
      //  panel.setVisible(false);
       // HOME_PAGE.home.remove(panel);
       // HOME_PAGE.home.setContentPane(HOME_PAGE.panel);
       // HOME_PAGE.panel.setVisible(true);
        //frame.setVisible(true);
        
        
    }
    
}
