package final_project; 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 *
 *
 * @author User
 */
import java.util.*;
import java.io.*;


public class Attendance {
    String name;
    public static String folder="";
    Attendance()
    {
    }
    GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
   // cal.getDiffence();
    Date da=cal.getTime();
    String dat=da.toString();
    String mon=da.toString();
    synchronized int search(int id,File f1) throws IOException
    {
       // cal.
     //   Scanner u=new Scanner(mon);
       // String str_mon=u.next();
       // str_mon=u.next();//C:\Users\Asus\Documents\NetBeansProjects\FINAL_PROJECT_ME\src\final_project\
        //System.out.println(str_mon);
      //  File f2=new File(folder+f1.getName());
        FileReader fr=new FileReader(f1);
        BufferedReader br=new BufferedReader(fr);
        Scanner kr=new Scanner(f1);
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
    
    synchronized void update_attendance(int id) throws IOException
    {
        int month[]={31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner u=new Scanner(mon);
        String str_mon=u.next();
        str_mon=u.next();
        File f=new File(folder+"attendance_"+str_mon+".txt");
        int lineNo=search(id,f);
        if(lineNo==-1) return;
        File f2=new File(folder+"attendance1.txt");
        File f3=new File(folder+"attendance2.txt");
        File f1=new File(folder+"attendance_"+str_mon+".txt");
        FileReader fr1=new FileReader(f1);
        BufferedReader br1=new BufferedReader(fr1);
        FileWriter fw2=new FileWriter(f2);
        BufferedWriter bw2=new BufferedWriter(fw2);
        FileWriter fw3=new FileWriter(f3);
        BufferedWriter bw3=new BufferedWriter(fw3);
        for(int i=0;i<lineNo-1;i++)
        {
            String str=br1.readLine();
            bw2.write(str);
            bw2.newLine();
        }
        bw2.close();
        fw2.close();
        Scanner v=new Scanner(dat);
        String datte=v.next();
        datte=v.next();
        int day=v.nextInt();
        String str1=br1.readLine();
        Scanner k=new Scanner(str1);
        
        String str2=k.next();
        //if(present==1) attendance++;
        for(int i=1;i<day;i++){
        str2+=" "+k.next();
        }
        int attendance=k.nextInt();
        //String str3=k.next();
        //str2+=k.next()+" "+k.next();
         attendance=1;
         str2+=" "+attendance;
        while(k.hasNext()){
        str2+=" "+k.next();
        }
        bw3.write(str2);
        bw3.newLine();
        while(br1.ready())
        {
            String str=br1.readLine();
            bw3.write(str);
            bw3.newLine();
        }
        bw3.close();
        fw3.close();
        fr1.close();
        br1.close();
        
        FileReader fr2=new FileReader(f2);
        BufferedReader br2=new BufferedReader(fr2);
        FileReader fr3=new FileReader(f3);
        BufferedReader br3=new BufferedReader(fr3);
        FileWriter fw1=new FileWriter(f1);
        BufferedWriter bw1=new BufferedWriter(fw1);
        while(br2.ready())
        {
            String str=br2.readLine();
            bw1.write(str);
            bw1.newLine();
        }
        while(br3.ready())
        {
            String str=br3.readLine();
            bw1.write(str);
            bw1.newLine();
            
        }
        bw1.close();
        fw1.close();
        fr2.close();
        fr3.close();
        br3.close();
        br2.close();
        
       //System.out.println(dat);
        
    }
    void delete_employee_atf(int id){
        
    }
    synchronized void delete_employee_attendance(int id,File f1) throws IOException
    {
        //System.out.println(f1.getName());
       // Scanner u=new Scanner(mon);
        //String str_mon=u.next();
        //str_mon=u.next();
        
        int lineNo=search(id,f1);
        if(lineNo==-1) return;
        File f2=new File(folder+"attendance1.txt");
        File f3=new File(folder+"attendance2.txt");
        //File f1=new File(folder+"attendance_"+str_mon+".txt");
        FileReader fr1=new FileReader(f1);
        BufferedReader br1=new BufferedReader(fr1);
        FileWriter fw2=new FileWriter(f2);
        BufferedWriter bw2=new BufferedWriter(fw2);
        FileWriter fw3=new FileWriter(f3);
        BufferedWriter bw3=new BufferedWriter(fw3);
        for(int i=0;i<lineNo-1;i++)
        {
            String str=br1.readLine();
            bw2.write(str);
            bw2.newLine();
        }
        bw2.close();
        fw2.close();
        br1.readLine();
        while(br1.ready())
        {
            String str=br1.readLine();
            bw3.write(str);
            bw3.newLine();
        }
        bw3.close();
        fw3.close();
        fr1.close();
        br1.close();
        
        FileReader fr2=new FileReader(f2);
        BufferedReader br2=new BufferedReader(fr2);
        FileReader fr3=new FileReader(f3);
        BufferedReader br3=new BufferedReader(fr3);
        FileWriter fw1=new FileWriter(f1);
        BufferedWriter bw1=new BufferedWriter(fw1);
        while(br2.ready())
        {
            String str=br2.readLine();
            bw1.write(str);
            bw1.newLine();
        }
        while(br3.ready())
        {
            String str=br3.readLine();
            bw1.write(str);
            bw1.newLine();
            
        }
        bw1.close();
        fw1.close();
        fr2.close();
        fr3.close();
        br3.close();
        br2.close();
    
    }
    synchronized void add_employee_attendance(int id,File f1) throws IOException
    {
        Scanner u=new Scanner(mon);
        String str_mon=u.next();
        str_mon=u.next();
        
        //File f1=new File("attendance_"+str_mon+".txt");
        
        FileWriter fw=new FileWriter(f1,true);
        BufferedWriter bw=new BufferedWriter(fw);
        
        String s="";
                s+=id;
        for(int i=0;i<31;i++)
        {
            s+=" 0";
        }
        bw.write(s);
        bw.newLine();
        bw.close();
        fw.close();   
    }
      synchronized void delete_employee(int id) throws IOException{
       Attendance a1=new Attendance();
       File f1=new File(folder+"attendance_Jan.txt");
       File f2=new File(folder+"attendance_Feb.txt");
       File f3=new File(folder+"attendance_Mar.txt");
       File f4=new File(folder+"attendance_Apr.txt");
       File f5=new File(folder+"attendance_May.txt");
       File f6=new File(folder+"attendance_Jun.txt");
       File f7=new File(folder+"attendance_Jul.txt");
       File f8=new File(folder+"attendance_Aug.txt");
       File f9=new File(folder+"attendance_Sep.txt");
       File f10=new File(folder+"attendance_Oct.txt");
       File f11=new File(folder+"attendance_Nov.txt");
       File f12=new File(folder+"attendance_Dec.txt");
       
     //  a1.update_attendance(11);
      // a1.delete_employee_attendance(15);
       a1.delete_employee_attendance(id,f1);
       a1.delete_employee_attendance(id,f2);
       a1.delete_employee_attendance(id,f3);
       a1.delete_employee_attendance(id,f4);
       a1.delete_employee_attendance(id,f5);
       a1.delete_employee_attendance(id,f6);
       a1.delete_employee_attendance(id,f7);
       a1.delete_employee_attendance(id,f8);
       a1.delete_employee_attendance(id,f9);
       a1.delete_employee_attendance(id,f10);
       a1.delete_employee_attendance(id,f11);
       a1.delete_employee_attendance(id,f12);
    }
    synchronized void add_employee(int id) throws IOException{
       Attendance a1=new Attendance();
       File f1=new File(folder+"attendance_Jan.txt");
       File f2=new File(folder+"attendance_Feb.txt");
       File f3=new File(folder+"attendance_Mar.txt");
       File f4=new File(folder+"attendance_Apr.txt");
       File f5=new File(folder+"attendance_May.txt");
       File f6=new File(folder+"attendance_Jun.txt");
       File f7=new File(folder+"attendance_Jul.txt");
       File f8=new File(folder+"attendance_Aug.txt");
       File f9=new File(folder+"attendance_Sep.txt");
       File f10=new File(folder+"attendance_Oct.txt");
       File f11=new File(folder+"attendance_Nov.txt");
       File f12=new File(folder+"attendance_Dec.txt");
       
     //  a1.update_attendance(11);
      // a1.delete_employee_attendance(15);
       a1.add_employee_attendance(id,f1);
       a1.add_employee_attendance(id,f2);
       a1.add_employee_attendance(id,f3);
       a1.add_employee_attendance(id,f4);
       a1.add_employee_attendance(id,f5);
       a1.add_employee_attendance(id,f6);
       a1.add_employee_attendance(id,f7);
       a1.add_employee_attendance(id,f8);
       a1.add_employee_attendance(id,f9);
       a1.add_employee_attendance(id,f10);
       a1.add_employee_attendance(id,f11);
       a1.add_employee_attendance(id,f12);
    }
    public static void main(String[] args) throws IOException {
       Attendance a1=new Attendance();
       File f1=new File(folder+"attendance_Jan.txt");
       File f2=new File(folder+"attendance_Feb.txt");
       File f3=new File(folder+"attendance_Mar.txt");
       File f4=new File(folder+"attendance_Apr.txt");
       File f5=new File(folder+"attendance_May.txt");
       File f6=new File(folder+"attendance_Jun.txt");
       File f7=new File(folder+"attendance_Jul.txt");
       File f8=new File(folder+"attendance_Aug.txt");
       File f9=new File(folder+"attendance_Sep.txt");
       File f10=new File(folder+"attendance_Oct.txt");
       File f11=new File(folder+"attendance_Nov.txt");
       File f12=new File(folder+"attendance_Dec.txt");
       
       a1.update_attendance(11);
     //  a1.delete_employee_attendance(15);
       a1.add_employee_attendance(16,f1);
       a1.add_employee_attendance(16,f2);
       a1.add_employee_attendance(16,f3);
       a1.add_employee_attendance(16,f4);
       a1.add_employee_attendance(16,f5);
       a1.add_employee_attendance(16,f6);
       a1.add_employee_attendance(16,f7);
       a1.add_employee_attendance(16,f8);
       a1.add_employee_attendance(16,f9);
       a1.add_employee_attendance(16,f10);
       a1.add_employee_attendance(16,f11);
       a1.add_employee_attendance(16,f12);
       
       a1.update_attendance(15);
       
       
    }
}
