
package final_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import final_project.EMPLOYEE_LIST;
import java.io.IOException;
import final_project.ADDING_EMPLOYEE;
import static final_project.ANEMPLOYEE.id;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class HOME_PAGE {
        public static String folder="";

        public static Container panel;
        public static JFrame home;
        public static view_Attendance viewAttendance;
        static void viewHome()throws IOException{
        home=new JFrame();
        viewAttendance=new view_Attendance();
        Image logo=ImageIO.read(new File(folder+"logo.jpg"));
        home.setIconImage(logo);
        home.setBounds(10,10,1170,700);
        home.setLayout(null);
        home.setDefaultCloseOperation(home.EXIT_ON_CLOSE);
        Font font=new Font("myfont",Font.BOLD+Font.ITALIC,20);
        Font font1=new Font("myfont1",Font.BOLD+Font.ITALIC,15);
        panel=new JPanel();
        panel.setLayout(null);
        BufferedImage bimg=ImageIO.read(new File(folder+"Image_1.jpg"));
        Image img=bimg.getScaledInstance(home.getWidth(), home.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon=new ImageIcon(img);
        JLabel background=new JLabel(icon);
        background.setBounds(1,1,home.getWidth()-2,home.getHeight()-2);
        
        home.setContentPane(panel);
        
        
        JLabel label=new JLabel("WELCOME TO HRM.COM"); 
        
        //panel.setBackground(Color.LIGHT_GRAY);
        label.setFont(font);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.BLUE);
        label.setBounds(400,0,800,100);
        panel.add(label);
        //delete button
        JButton deleteButton=new JButton("REMOVE EMPLOYEE");
        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.setVisible(false);
                home.remove(panel);
                DELETING_EMPLOYEE de=new DELETING_EMPLOYEE();
                home.setContentPane(de);
                de.setVisible(true);
            }
            
        });
      
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.setBounds(50,300,200,40);
        deleteButton.setFont(font1);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.RED);
        panel.add(deleteButton);
        
        JButton updateButton=new JButton("UPDATE EMPLOYEE");
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.BLUE);
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.setBounds(50,400,200,40);
        updateButton.setFont(font1);
        panel.add(updateButton);

        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel.setVisible(false);
                home.remove(panel);
                UPDATING_EMPLOYEE ue=new UPDATING_EMPLOYEE();
                home.setContentPane(ue);
                ue.setVisible(true);
            }
        });
        JButton viewAtendaceButton=new JButton("VIEW ATTENDANCE");
        viewAtendaceButton.setFont(font1);
        viewAtendaceButton.setBounds(50,500,200,40);
        viewAtendaceButton.setBackground(Color.BLACK);
        viewAtendaceButton.setForeground(Color.red);
        viewAtendaceButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                File f1=new File(folder+"attendance_Jan.txt");
                try {
                    viewAttendance.view_Attendance_list(f1);
                } catch (IOException ex) {
                    Logger.getLogger(HOME_PAGE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                panel.add(viewAtendaceButton);
        JButton addEmployee=new JButton("ADD EMPLOYEE");
        addEmployee.setFont(font1);
        addEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addEmployee.setBounds(50,200,200,40);
        addEmployee.setBackground(Color.BLACK);
        addEmployee.setForeground(Color.BLUE);
        addEmployee.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
                //home.dispose();
                ADDING_EMPLOYEE addingEmployee=new ADDING_EMPLOYEE();
                addingEmployee.addEmployee();
                panel.setVisible(false);
                home.remove(panel);
                home.setContentPane(ADDING_EMPLOYEE.panel);
                ADDING_EMPLOYEE.panel.setVisible(true);
                
            }
        });
        panel.add(addEmployee);
        JButton employeeList=new JButton("EMPLOYEE LIST");
        employeeList.setBackground(Color.BLACK);
        employeeList.setForeground(Color.MAGENTA);
        employeeList.setFont(font1);
        employeeList.setBounds(50,100,200,40);
        employeeList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(employeeList);
        panel.add(background);
        home.setVisible(true);
        employeeList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               // home.dispose();
                try{
              //  home.dispose();
                    EMPLOYEE_LIST employeeList=new EMPLOYEE_LIST();
                    EMPLOYEE_LIST.viewList();
                    panel.setVisible(false);
                    home.remove(panel);
                    home.setContentPane(employeeList.p);
                    employeeList.p.setVisible(true);
                }catch(IOException a){}
            }
    }
);
    }
    
    
    
    
    
    public static void main(String[] args) throws IOException{
         viewHome();
         EmployeeThread e1=new EmployeeThread(3222);
         EmployeeThread e2=new EmployeeThread(3223);
         EmployeeThread e3=new EmployeeThread(3224);
         EmployeeThread e4=new EmployeeThread(3225);
         EmployeeThread e5=new EmployeeThread(3226);
         
         
    }
}






class ControlerVariables{
    
}
class EmployeeThread extends Thread{
    int id;
    int port;
    EmployeeThread(int port){
        this.port=port;
        this.start();
    }
    public void run(){
        //System.out.println("hi");
        try{
        FileManager fm=new FileManager("EMPLOYEE_LIST.txt");
        
        fm.search(id);
            ServerSocket client=new ServerSocket(port);
            Socket socket=client.accept();
            DataInputStream is=new DataInputStream(socket.getInputStream());
            DataOutputStream os=new DataOutputStream(socket.getOutputStream());
            while(true){
                 String str=is.readUTF();
                 if(str.equals("LOGIN")){
                     String str1=is.readUTF();
                     Scanner kstr=new Scanner(str1);
                     try{
                     int id=Integer.parseInt(kstr.next());
                     this.id=id;
                     
                     String pass=kstr.next();
                            FileManager filemanager=new FileManager("PasswordFile.txt");
                            if(filemanager.match_password(id,pass)){
                                os.writeUTF("CORRECT");
                            }
                            else{
                                os.writeUTF("WRONG");
                            }
                     }
                     catch(Exception e){os.writeUTF("WRONG");}
                     
                 }
                 else if(str.equals("PRESENT")){
                     Attendance at=new Attendance();
                     at.update_attendance(id);
                     os.writeUTF("yes");
                 }
                 else if(str.equals("MY_PROFILE")){
                     fm.search(id);
                     String profile=ANEMPLOYEE.name+" "+ANEMPLOYEE.designation+" "+ANEMPLOYEE.salary+" "+ANEMPLOYEE.performence+" "+ANEMPLOYEE.birthDay+" "+ANEMPLOYEE.joiningDay+" "+ANEMPLOYEE.contactInfo;
                     os.writeUTF(profile);
                 }
                 else if(str.equals("MYSTAT")){
                     
                     Individual_Attendance iat=new Individual_Attendance();
                     String s1=iat.search(id,iat.f1)+" "+iat.presence(id,iat.f1);
                     String s2=iat.search(id,iat.f2)+" "+iat.presence(id,iat.f2);
                     String s3=iat.search(id,iat.f3)+" "+iat.presence(id,iat.f3);
                     String s4=iat.search(id,iat.f4)+" "+iat.presence(id,iat.f4);
                     String s5=iat.search(id,iat.f5)+" "+iat.presence(id,iat.f5);
                     String s6=iat.search(id,iat.f6)+" "+iat.presence(id,iat.f6);
                     String s7=iat.search(id,iat.f7)+" "+iat.presence(id,iat.f7);
                     String s8=iat.search(id,iat.f8)+" "+iat.presence(id,iat.f8);
                     String s9=iat.search(id,iat.f9)+" "+iat.presence(id,iat.f9);
                     String s10=iat.search(id,iat.f10)+" "+iat.presence(id,iat.f10);
                     String s11=iat.search(id,iat.f11)+" "+iat.presence(id,iat.f11);
                     String s12=iat.search(id,iat.f12)+" "+iat.presence(id,iat.f12);
                     os.writeUTF(s1);
                     os.writeUTF(s2);
                     os.writeUTF(s3);
                     os.writeUTF(s4);
                     os.writeUTF(s5);
                     os.writeUTF(s6);
                     os.writeUTF(s7);
                     os.writeUTF(s8);
                     os.writeUTF(s9);
                     os.writeUTF(s10);
                     os.writeUTF(s11);
                     os.writeUTF(s12);
                     
                     
                 }
                 else if(str.equals("CHANGEPASSWORD")){
                     String oldPass=is.readUTF();
                     String newPass=is.readUTF();
                     FileManager filemanager=new FileManager("PasswordFile.txt");
                     if(filemanager.match_password(id,oldPass)){
                               filemanager.update_password(id, newPass);
                               os.writeUTF("SUCCEED");
                     }
                     else{
                            os.writeUTF("OLD_INCORRECT");
                     }
                 }
            }
           
            //socket.close();
        }catch(Exception e){}
    }
    
    
}