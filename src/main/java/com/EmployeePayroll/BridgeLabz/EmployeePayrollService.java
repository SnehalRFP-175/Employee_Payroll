package com.EmployeePayroll.BridgeLabz;

import com.EmployeePayroll.BridgeLabz.EmployeePayroll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {


    private List<EmployeePayroll>employeelist;

    public EmployeePayrollService( List<EmployeePayroll>employeelist)
    {
        this.employeelist = employeelist;
    }

    public static boolean deleteFiles(File contentsToDelete) {
        File[] allContents = contentsToDelete.listFiles();
        if (allContents != null){
            for (File file : allContents){
                deleteFiles(file);
            }
        }
        return contentsToDelete.delete();
    }

    public void readEmployeeData()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();


        System.out.println("Enter Employee Name:");
        String name = sc.next();


        System.out.println("Enter Employee Salary:");
        double salary = sc.nextInt();

        employeelist.add(new EmployeePayroll(id, name, salary));
    }

    public void WriteEmployeeData()
    {
        System.out.println("Employee Data: "+employeelist);
    }


    public static void main(String a[])
    {
        ArrayList<EmployeePayroll>employeelist = new ArrayList<>();
        EmployeePayrollService empService = new EmployeePayrollService(employeelist);
        empService.readEmployeeData();
        empService.WriteEmployeeData();

    }
}
