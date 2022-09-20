

import java.util.Scanner;

public class Employee implements IEmployee {
    private String empId;
    private String empName;
    private float rate;
    private float salary;
    private String address;
    private boolean sex;

    public Employee() {
    }

    public Employee(String empId, String empName, float rate, float salary, String address, boolean sex) {
        this.empId = empId;
        this.empName = empName;
        this.rate = rate;
        this.salary = salary;
        this.address = address;
        this.sex = sex;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("nhap vao ma nhan vien: ");
        do {
            this.empId = sc.nextLine();
            if (this.empId.length()==5){
                if (this.empId.charAt(0)=='E'){
                    break;
                }else {
                    System.out.println("vui long nhap  ma nhan vien bat dau la ki tu E");
                }
            }else {
                System.out.println("vui long nhap ma nhan vien gom 5 ki tu");
            }
        }while (true);
        System.out.println("nhap he so luong cua nhan vien: ");
        do {
            try {
                this.rate =Float.parseFloat(sc.nextLine());
                if (this.rate>=0.65F){
                    break;
                }else {
                    System.err.println("vui long nhap so lown hown 0,65");
                }
            }catch (Exception ex){
                System.err.println("vui long nhap he so luong la mot so thuc");
            }
        }while (true);
        System.out.println("nhap dia chi nhan vien");
        this.address = sc.nextLine();
        System.out.println("nhap vao gioi tinh cua nhan vien");
        int choice;
        do {
            System.out.println("1.Nam");
            System.out.println("2.Nu");
            System.out.println("lua chon cua ban");
            do {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                }catch (Exception ex) {
                    System.err.println("vui long chon 1 hoac 2");
                }
            }while (true);
            switch (choice) {
                case 1:
                    this.sex = true;
                    break;
                case 2:
                    this.sex = false;
                    break;
                default:
                    System.err.println("vui long chon 1 hoac 2");
            }
        }while (choice!=1 && choice!=2);
    }

    @Override
    public void displayData() {
        String gender="Nu";
        if (this.sex){
            gender ="Nam";
        }
        System.out.printf("Ma NV: %s- Ten NV: %s -he so luong: %s \n",this.empId,this.empName,this.rate);
        System.out.printf("Luong NV: %.2f- dia chi: %s - gioi tinh: %s \n",this.salary,this.address,gender);
    }
    public void calculateSalary(){
        this.salary = this.rate*BASIC_SALARY;
    }
}