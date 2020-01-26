
package final_project;

import static final_project.HOME_PAGE.viewHome;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        viewHome();
         EmployeeThread e1=new EmployeeThread(3222);
         EmployeeThread e2=new EmployeeThread(3223);
         EmployeeThread e3=new EmployeeThread(3224);
         EmployeeThread e4=new EmployeeThread(3225);
         EmployeeThread e5=new EmployeeThread(3226);
    }
}
