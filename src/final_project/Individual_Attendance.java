package final_project;
import static final_project.Attendance.folder;
import static final_project.view_Attendance.folder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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



public class Individual_Attendance {
        public static String folder="";
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
       synchronized static int search2(int id,File f) throws IOException
    {
        //File f1=new File(f);
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        Scanner kr=new Scanner(f);
        String str="hellow";
        int lineNo=0;
        while(kr.hasNextLine()){
            lineNo++;
            str=kr.nextLine();
            Scanner k=new Scanner(str);
            int word=k.nextInt();
            if(word==id){
                fr.close();
                br.close();
                return lineNo;
            }
        }
            fr.close();
            br.close();
              return -1;      
        }
       synchronized public static int presence(int id,File f) throws FileNotFoundException, IOException
        {
        //File f1=new File("attendance_"+str_mon+".txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int lineNo=search2(id,f);
        if(lineNo==-1) return -1;
        for(int i=0;i<lineNo-1;i++)
        {
            String str=br.readLine();
        }
        String str1=br.readLine();
        Scanner k=new Scanner(str1);
        String str_id=k.next();
        int count=0;
        for(int i=0;i<31;i++)
        {
            count+=k.nextInt();
        }
        return count;
        
        }
    
    
       static int cnt2=0; 

        synchronized static String search(int id,File f) throws IOException
        {
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        Scanner kr=new Scanner(f);
        String str="hellow";
        int lineNo=0;
        while(kr.hasNextLine()){
            lineNo++;
            str=kr.nextLine();
            Scanner k=new Scanner(str);
            int word=k.nextInt();
            if(word==id){
                fr.close();
                br.close();
                return str;
            }
        }
        fr.close();
        br.close();
          return "";      
    }
}