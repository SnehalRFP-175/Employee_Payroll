package com.EmployeePayroll.BridgeLabz;

public class EmployeePayroll {
    public int Id;
    public String name;
    public double salary;

    public EmployeePayroll(Integer Id, String name, Double salary)
    {
        this.Id = Id;
        this.name = name;
        this.salary =salary;
    }


    public  String toString()
    {
        return "ID:"+Id+
                "\t Name:"+name+
                "\t Salary:"+salary;
    }

}
