package final_project;

import final_project.HOME_PAGE;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.JButton;
public class EMPLOYEE_LIST {
    public static Container p;
    synchronized static void read(JTable tab,String fileName)throws IOException{
        File f1=new File(fileName);
        Scanner k=new Scanner(f1);
        int cnt=0;
        while(k.hasNext()){
            String str=k.next();
            int idx=cnt/8;
           if(cnt%8==1){
                tab.setValueAt(str.replace('_', ' '), idx+1, cnt%8);
           }
           else{
              //  if(idx>100)tab.addRow();
            tab.setValueAt(str, idx+1, cnt%8);
           }
             cnt++;
        }
        k.close();
    }
        
        synchronized static void viewList()throws IOException{
       // JFrame frame=new JFrame();
       // frame.setBackground(Color.PINK);
       // frame.setBounds(10,10,1170,700);
      //  frame.setBackground(Color.PINK);
        p=new JPanel();
        //frame.setContentPane(p);
        
        p.setLayout(null);
        JButton exit=new JButton("BACK");
        exit.setBounds(10,10,100,40);
        exit.setBackground(Color.GREEN);
        exit.setForeground(Color.red);
        ScrollPane sp=new ScrollPane();
        JTable tab=new JTable(100,8);
        tab.setValueAt("ID:",0,0);
        tab.setValueAt("NAME",0,1);
        tab.setValueAt("DESIDNATION",0,2);
        tab.setValueAt("SALARY",0,3);
        tab.setValueAt("PERFORMENCE",0,4);
        tab.setValueAt("BIRTH DAY",0,5);
        tab.setValueAt("JOINING DAY",0,6);
        tab.setValueAt("CONTACT INFO",0,7);
        tab.setRowHeight(50);
        read(tab,"EMPLOYEE_LIST.txt");
        JLabel pageTitle=new JLabel("MSS's EMPLOYEE");
        pageTitle.setBackground(Color.YELLOW);
        pageTitle.setBounds(200, 10,400, 80);
        sp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp.add(tab);
        sp.setBounds(0, 100,1150, 500);
    //    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        p.add(pageTitle);
        p.add(sp);
        p.add(exit);
        p.setBackground(Color.PINK);
      //  frame.setVisible(true);
        exit.addActionListener(new ActionListener(){
            synchronized public void actionPerformed(ActionEvent e){
                //try{
                    //frame.dispose();
                    p.setVisible(false);
                    HOME_PAGE.home.remove(p);
                    HOME_PAGE.home.setContentPane(HOME_PAGE.panel);
                    HOME_PAGE.panel.setVisible(true);
                    
                
                //}catch(IOException s){}
                
            }
        }
    );
    }
        public static void main(String[] args) throws IOException{
        viewList();
    }
   
}