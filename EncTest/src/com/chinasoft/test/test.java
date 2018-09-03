package com.chinasoft.test;

/**
 * @author: zhaowanyue
 * @date: 2018/9/3
 * @description:
 */
abstract class Employee
{
    String name;
    double basic;
    String address;

    Employee()// 无参构造方法
    {

    }

    Employee(String str, double sal, String addr)// 有参构造方法
    {
        name = str;
        basic = sal;
        address = addr;
    }

    // 定义该抽象方法来计算薪资总额
    abstract double totalAmount();

    // 定义方法kouchu来基于天数计算要从基本薪资中扣除的部分
    double kouchu(int leave, double basic)
    {
        double lessPay;
        if(leave <= 5)
        {
            lessPay = 0.25 * basic;
        }
        else
        {
            lessPay = 0.5 * basic;
        }
        return lessPay;
    }

    void show()
    {
        System.out.println("姓名:\t\t\t" + name);
        System.out.println("地址:\t\t\t" + address);
        System.out.println("薪资:\t\t\t" + basic);
    }
}

/**
 * 这个类是Employee类的子类
 * @version 1.0 2005年5月25日
 * @author 阿堂
 */

class Manager extends Employee
{
    String department;

    Manager()
    {

    }

    Manager(String str, double sal, String addr, String dept)
    {
        super(str, sal, addr);
        department = dept;
    }

    // 重写父类的totalAmount方法
    double totalAmount()
    {
        double houseRentAllowance = 0.08 * basic;
        double dearnessAllowance = 0.3 * basic;
        int medicalAllowance = 1500;
        double totalAmount = basic + houseRentAllowance + dearnessAllowance + medicalAllowance;
        return totalAmount;
    }

    void show()
    {
        super.show();
        System.out.println("部门:\t\t\t" + department);
        System.out.println("工资总额：\t\t" + this.totalAmount());
        System.out.println("净工资:\t\t\t" + (this.totalAmount() - this.kouchu(5, 5500.65)));
    }

}

class Director extends Employee
{
    double transportAllowance;

    Director()
    {

    }

    Director(String str, double sal, String addr, double allowance)
    {
        super(str, sal, addr);
        transportAllowance = allowance;
    }

    // 重写父类的totalAmount方法
    double totalAmount()
    {
        double houseRentAllowance = 0.2 * basic;
        double dearnessAllowance = 0.5 * basic;
        int medicalAllowance = 4500;
        int entertainmentAllowance = 5000;
        double totalAmount = basic + houseRentAllowance + dearnessAllowance + medicalAllowance
                + entertainmentAllowance + transportAllowance;
        return totalAmount;
    }

    void show()
    {
        super.show();
        System.out.println("工资总额：\t\t" + this.totalAmount());
        System.out.println("净工资:\t\t\t" + (this.totalAmount() - this.kouchu(5, 32400.0)));
    }
}

public class test
{
    test()
    {

    }

    public static void main(String[] args)
    {
        Manager mgrobj = new Manager("Henry", 5500.65, "Sydney", "会计部");
        System.out.println("\n经理详细信息");
        System.out.println("--------------------------------");
        mgrobj.show();
        Director dirobj = new Director("Stephen", 32400.00, "New York", 8000);
        System.out.println("\n\n董事详细信息");
        System.out.println("----------------------------------");
        dirobj.show();
    }

}

