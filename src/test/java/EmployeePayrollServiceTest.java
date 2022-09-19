

import com.EmployeePayroll.BridgeLabz.EmployeePayroll;
import com.EmployeePayroll.BridgeLabz.EmployeePayrollService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class EmployeePayrollServiceTest {
    @Test
    public void given3EmployeesWhenWrittenToFile_shouldMatchEmployeeEntries(){
        EmployeePayrollService fileIo = new EmployeePayrollService();
        List<EmployeePayroll> list = new ArrayList<>();
        list.add(new EmployeePayroll(1,"Snehal", 10000.0));
        list.add(new EmployeePayroll(2,"Pranit", 20000.0));
        list.add(new EmployeePayroll(3,"Prachi", 30000.0));
        list.add(new EmployeePayroll(4,"Puja", 35000.0));


    }

    public void givenEmployeePayrollData_ShouldMatchEmployeeCount()
    {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayroll> employeePayrolls = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(4,employeePayrolls.size());
    }
}
