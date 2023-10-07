package tool;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author pcm23
 */
public interface IEmployeeManage {

    void addEmployee();

    void searchEmployee();

    void removeEmployee();

    void updateEmployee() throws FileNotFoundException, IOException;

    void viewAllList();

    void takeOnList();
    
    void resignList();
    
    void doctorList();
    
    void nurseList();
    
    void technicianList();
    
    void writeToFile() throws FileNotFoundException, IOException;
    

}
