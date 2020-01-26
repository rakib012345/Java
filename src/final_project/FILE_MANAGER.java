    
package final_project;
import java.util.*;
import java.io.*;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;


class ANEMPLOYEE{
    public static String name;
    public static int id;
    public static String designation;
    public static int salary; 
    public static String performence;
    public static String birthDay;
    public static String joiningDay;
    public static String contactInfo;
}
class FileManager{
    String name;
    Map<Integer,Integer> attendence_map=new TreeMap<>();
    //int attendance=0;
    FileManager(String name)
    {
        this.name=name;
    }
    
    
    
    synchronized void insert_employee(int id,String employee_name,String designation,int salary,String performance,String BirthDay,String JoiningDay,String ContactInfo) throws IOException
    {
        File f2=new File(name);
        FileWriter fw=new FileWriter(f2,true);
        BufferedWriter bw=new BufferedWriter(fw);
        
        String s=id+" "+employee_name+" "+designation+" "+salary+" "+performance+" "+BirthDay+" "+JoiningDay+" "+ContactInfo;
        Attendance at=new Attendance();
        at.add_employee(id);
        FileManager fm=new FileManager("PasswordFile.txt");//C:\Users\Asus\Documents\NetBeansProjects\FINAL_PROJECT_ME\src\final_project\PasswordFile.txt
        fm.insert_employee_in_password_file(id,"password"+id);
        bw.write(s);
        bw.newLine();
        bw.close();
        fw.close();
    }
    
    
    synchronized void insert_employee_in_password_file(int id,String password) throws IOException{//for passwordfile only
        File f2=new File(name);
        FileWriter fw=new FileWriter(f2,true);
        BufferedWriter bw=new BufferedWriter(fw);
        
        String s=id+" "+password;
        bw.write(s);
        bw.newLine();
        bw.close();
        fw.close();
    }
    
        synchronized int search(int id) throws IOException
    {
        File f1=new File(name);
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
                ANEMPLOYEE.id=id;
                ANEMPLOYEE.name=k.next();
                ANEMPLOYEE.designation=k.next();
                ANEMPLOYEE.salary=k.nextInt();
                ANEMPLOYEE.performence=k.next();
                ANEMPLOYEE.birthDay=k.next();
                ANEMPLOYEE.joiningDay=k.next();
                ANEMPLOYEE.contactInfo=k.next();
                fr.close();
                br.close();
                return lineNo;
            }
        }
        fr.close();
        br.close();
          return -1;      
    }
    synchronized int search_in_password_file(int id) throws IOException//for password file only
    {
        File f1=new File(name);
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
//                ANEMPLOYEE.id=id;
//                ANEMPLOYEE.name=k.next();
//                ANEMPLOYEE.designation=k.next();
//                ANEMPLOYEE.salary=k.nextInt();
//                ANEMPLOYEE.performence=k.next();
//                ANEMPLOYEE.attendence=k.nextInt();
//                ANEMPLOYEE.port=k.nextInt();
                fr.close();
                br.close();
                return lineNo;
            }
        }
        fr.close();
        br.close();
          return -1;      
    }
    
    
       synchronized void delete_employee_in_password_file(int id) throws IOException//for password file only
    {
        int lineNo=search_in_password_file(id);
        if(lineNo==-1) return;
        attendence_map.remove(id);
        File f2=new File("helper1.txt");
        File f3=new File("helper2.txt");
        File f1=new File(name);
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
    synchronized void delete_employee(int id) throws IOException
    {
        int lineNo=search(id);
        
        if(lineNo==-1) return;
        FileManager fm=new FileManager("PasswordFile.txt");//C:\Users\Asus\Documents\NetBeansProjects\FINAL_PROJECT_ME\src\final_project\PasswordFile.txt
        fm.delete_employee_in_password_file(id);
        Attendance at=new Attendance();
        at.delete_employee(id);
    //    attendence_map.remove(id);
        File f2=new File("helper1.txt");
        File f3=new File("helper2.txt");
        File f1=new File(name);
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
    
    
    synchronized void update_employee(int id,String designation,int salarY,String performence,String birthDay,String contactInfo) throws IOException
    {
        int lineNo=search(id);
        if(lineNo==-1) return;
        File f2=new File("helper1.txt");
        File f3=new File("helper2.txt");
        File f1=new File(name);
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
        String str1=br1.readLine();
        Scanner k=new Scanner(str1);
        String str2=k.next()+" "+k.next()+" "+designation+" "+salarY+" ";
        
        String str3=k.next()+k.next()+k.next()+k.next();
        str2+=performence+" "+birthDay+" "+k.next()+" "+contactInfo;
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
        
    }
    
    
        
    synchronized boolean match_password(int id,String password) throws IOException//for password file only
    {
        int lineNo=search_in_password_file(id);
        if(lineNo==-1) return false;
        File f2=new File("helper1.txt");
        File f3=new File("helper2.txt");
        File f1=new File(name);
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
        String str1=br1.readLine();
        Scanner k=new Scanner(str1);
        String idt=k.next();
        String pass=k.next();
        fr1.close();
        br1.close();
        fw3.close();
        bw3.close();
        if(pass.equals(password))return true;
        else return false;
        
    }
    
    synchronized void update_password(int id,String password) throws IOException//for password file only
    {
        int lineNo=search_in_password_file(id);
        if(lineNo==-1) return;
        File f2=new File("helper1.txt");
        File f3=new File("helper2.txt");
        File f1=new File(name);
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
        String str1=br1.readLine();
        Scanner k=new Scanner(str1);
        
        //if(present==1) attendance++;
        String str2=id+" "+password;
        int attendance=k.nextInt();
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
        
    }
    
}
    
public class FILE_MANAGER {
    static int dayy=0;
    
    
    
    
}





class WORKER extends Thread{
    String name;
    int id;
    String designation;
    int salary;
    String fileName;
    int isAttendenceGiven=0;
    WORKER(String name,int id,String designation,int salary,String fileName){
        this.name=name;
        this.id=id;
        this.salary=salary;
        this.designation=designation;
        this.fileName=fileName;
        this.start();
    }
    public void run(){
        try{
            FileManager filemanager=new FileManager("PasswordFile.txt");
            filemanager.update_password(22,"xd20");
        }
        catch(IOException e){
            System.out.println("IO Exception occoured");
        }
    }
}


