package final_project;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class view_Attendance {
    public static String folder="";
    static void read(JTable tab,File f1)throws IOException{
        //File f1=new File(fileName);
        Scanner k=new Scanner(f1);
        int cnt=0;
        while(k.hasNext()){
            String str=k.next();
           
            int idx=cnt/32;
            tab.setValueAt(str, idx+1, cnt%32);
             cnt++;
        }
        k.close();
    }
    
       static File f1=new File(folder+"attendance_Jan.txt");
       static File f2=new File(folder+"attendance_Feb.txt");
       static File f3=new File(folder+"attendance_Mar.txt");
       static File f4=new File(folder+"attendance_Apr.txt");
       static File f5=new File(folder+"attendance_May.txt");
       static File f6=new File(folder+"attendance_Jun.txt");
       static File f7=new File(folder+"attendance_Jul.txt");
       static File f8=new File(folder+"attendance_Aug.txt");
       static File f9=new File(folder+"attendance_Sep.txt");
       static File f10=new File(folder+"attendance_Oct.txt");
       static File f11=new File(folder+"attendance_Nov.txt");
       static File f12=new File(folder+"attendance_Dec.txt");
       public static JPanel panel1;
       public static JPanel panel2;
       public static JPanel panel3;
       public static JPanel panel4;
       public static JPanel panel5;
       public static JPanel panel6;
       public static JPanel panel7;
       public static JPanel panel8;
       public static JPanel panel9;
       public static JPanel panel10;
       public static JPanel panel11;
       public static JPanel panel12;
       public static Container p; 
       public static String Name(String str){//jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec
           if(str.charAt(11)=='J'&&str.charAt(12)=='a')return "January";
           else if(str.charAt(11)=='F'&&str.charAt(12)=='e')return "February";
           else if(str.charAt(11)=='M'&&str.charAt(13)=='r')return "March";
           else if(str.charAt(11)=='A'&&str.charAt(12)=='p')return "April";
           if(str.charAt(11)=='M'&&str.charAt(13)=='y')return "May";
           if(str.charAt(11)=='J'&&str.charAt(12)=='u'&&str.charAt(13)=='n')return "June";
           if(str.charAt(11)=='J'&&str.charAt(13)=='l')return "July";
           if(str.charAt(11)=='A'&&str.charAt(12)=='u')return "August";
           if(str.charAt(11)=='S'&&str.charAt(12)=='e')return "September";
           if(str.charAt(11)=='O'&&str.charAt(12)=='c')return "October";
           if(str.charAt(11)=='N'&&str.charAt(12)=='o')return "November";
           if(str.charAt(11)=='D'&&str.charAt(12)=='e')return "December";
           else return "-1";
       }
        public static void view_Attendance_list(File f)throws IOException{
        JFrame frame=new JFrame();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        panel6=new JPanel();
        panel7=new JPanel();
        panel8=new JPanel();
        panel9=new JPanel();
        panel10=new JPanel();
        panel11=new JPanel();
        panel12=new JPanel();
        frame.setBackground(Color.PINK);
        frame.setBounds(10,10,1170,700);
        frame.setBackground(Color.PINK);
       // p=frame.getContentPane();
        if(f.getName().equals("attendance_Jan.txt")){p=panel1;}
        if(f.getName().equals("attendance_Feb.txt")){p=panel2;}
        if(f.getName().equals("attendance_Mar.txt")){p=panel3;}
        if(f.getName().equals("attendance_Apr.txt")){p=panel4;}
        if(f.getName().equals("attendance_May.txt")){p=panel5;}
        if(f.getName().equals("attendance_Jun.txt")){p=panel6;}
        if(f.getName().equals("attendance_Jul.txt")){p=panel7;}
        if(f.getName().equals("attendance_Aug.txt")){p=panel8;}
        if(f.getName().equals("attendance_Sep.txt")){p=panel9;}
        if(f.getName().equals("attendance_Oct.txt")){p=panel10;}
        if(f.getName().equals("attendance_Nov.txt")){p=panel11;}
        if(f.getName().equals("attendance_Dec.txt")){p=panel12;}
        p.setLayout(null);
        JButton exit=new JButton("BACK");
        exit.setBounds(10,10,100,40);
        exit.setBackground(Color.GREEN);
        exit.setForeground(Color.red);
        JButton next=new JButton("NEXT");
        JButton previous=new JButton("PREVIOUS");
        next.setBounds(1000, 30, 80, 40);
        previous.setBounds(850, 30, 130, 40);
        
        ScrollPane sp=new ScrollPane();
        JTable tab=new JTable(100,32);
        tab.setRowHeight(50);
        tab.setValueAt("ID:",0,0);
        for(int i=1;i<32;i++)
        {
            tab.setValueAt("Day "+(i), 0, i);
        }
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        Date da=cal.getTime();
        String mon=da.toString();
    
        Scanner u=new Scanner(mon);
        String str_mon=u.next();
        str_mon=u.next();
        //read(tab,"attendance_"+str_mon+".txt");
        
        read(tab,f);
      //  char ara[]=new char[20];
       // ara=f.getName().toCharArray();
       // String str=new String(ara,11,13);
        JLabel pageTitle=new JLabel("MSS's EMPLOYEE");
        //System.out.println(f.getName());
        JLabel nam=new JLabel("Attendance of month :"+Name(f.getName()));
        nam.setBackground(Color.yellow);
        nam.setBounds(410,10, 400, 100);
        pageTitle.setBackground(Color.YELLOW);
        pageTitle.setBounds(200, 10,400, 80);
        sp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp.add(tab);
        sp.setBounds(0, 100,1150, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        p.add(pageTitle);
        p.add(sp);
        p.add(nam);
        p.add(exit);
        p.add(next);
        p.add(previous);
        p.setBackground(Color.PINK);
        
        
      //  frame.setVisible(true);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Container con=HOME_PAGE.home.getContentPane();
                con.setVisible(false);
                HOME_PAGE.home.remove(con);
                HOME_PAGE.home.setContentPane(HOME_PAGE.panel);
                HOME_PAGE.panel.setVisible(true);
                
            }
        }
    );
     //   System.out.println("I am here");
        Container con=HOME_PAGE.home.getContentPane();
        con.setVisible(false);
        HOME_PAGE.home.remove(con);
        HOME_PAGE.home.setContentPane(p);
        p.setVisible(true);
        //System.out.println(f.getName());
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            String str1=f.getName();
            if(str1.equals("attendance_Jan.txt")){
                try {
                    view_Attendance_list(f2);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Feb.txt")){
                try {
                    view_Attendance_list(f3);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Mar.txt")){
                try {
                    view_Attendance_list(f4);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Apr.txt")){
                try {
                    view_Attendance_list(f5);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_May.txt")){
                try {
                    view_Attendance_list(f6);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Jun.txt")){
                try {
                    view_Attendance_list(f7);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Jul.txt")){
                try {
                    view_Attendance_list(f8);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Aug.txt")){
                try {
                    view_Attendance_list(f9);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Sep.txt")){
                try {
                    view_Attendance_list(f10);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Oct.txt")){
                try {
                    view_Attendance_list(f11);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Nov.txt")){
                try {
                    view_Attendance_list(f12);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
            
        });
        previous.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            String str1=f.getName();
            if(str1.equals("attendance_Dec.txt")){
                try {
                    view_Attendance_list(f11);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Feb.txt")){
                try {
                    view_Attendance_list(f1);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Mar.txt")){
                try {
                    view_Attendance_list(f2);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Apr.txt")){
                try {
                    view_Attendance_list(f3);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_May.txt")){
                try {
                    view_Attendance_list(f4);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Jun.txt")){
                try {
                    view_Attendance_list(f5);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Jul.txt")){
                try {
                    view_Attendance_list(f6);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Aug.txt")){
                try {
                    view_Attendance_list(f7);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Sep.txt")){
                try {
                    view_Attendance_list(f8);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Oct.txt")){
                try {
                    view_Attendance_list(f9);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(str1.equals("attendance_Nov.txt")){
                try {
                    view_Attendance_list(f10);
                    
                   // read(tab,f2);
                } catch (IOException ex) {
                    Logger.getLogger(view_Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
            
        });
    }
    public static void main(String[] args) throws IOException {
       
        
       view_Attendance_list(f1);
        
    }
}
