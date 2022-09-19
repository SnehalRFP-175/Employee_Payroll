package com.EmployeePayroll.BridgeLabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.EmployeePayroll.BridgeLabz.EmployeePayrollFilelOService.PAYROLL_FILE_NAME;

public class EmployeePayrollService {
    private List<EmployeePayroll> employeePayrollList;
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO};

    public EmployeePayrollService()
    {
        employeePayrollList = new ArrayList<EmployeePayroll>();
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
            System.out.println("Count:" +entries);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entries;
    }
    public static void main(String[] args) {
        System.out.println("Employee payroll service program Running Successfully...");


        EmployeePayrollService employeePayrollService = new EmployeePayrollService();

        employeePayrollService.countEntries();

        EmployeePayrollFilelOService fileIO = new EmployeePayrollFilelOService();
        List<EmployeePayroll> list = new ArrayList<>();
        list.add(new EmployeePayroll(1,"Snehal", 10000.0));
        list.add(new EmployeePayroll(2,"Pranit", 20000.0));
        list.add(new EmployeePayroll(3,"Prachi", 30000.0));
        list.add(new EmployeePayroll(4,"Puja", 35000.0));

        fileIO.writeDataToFile(list);

    }

    public List<EmployeePayroll> readEmployeePayrollData(IOService dbIo){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id :");
        int id = sc.nextInt();
        System.out.println("Enter employee name : ");
        String name = sc.next();
        System.out.println("Enter employee salary : ");
        double salary = sc.nextDouble();
        return null;
    }


    public void writeEmployeePayrollData(){
        System.out.println("writing employee payroll data on console :");
        System.out.println(employeePayrollList);
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


}
