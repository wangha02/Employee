
import java.util.*;

public class Main {
    static List<Employee> listEmployees = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("************Menu****************");
            System.out.println("1. nhap thong tin cac nhan vien");
            System.out.println("2. tinh luong cac nhan vien");
            System.out.println("3. hien thi cac nhan vien ");
            System.out.println("4. tim cac nhan vien theo ki tu bat dau ");
            System.out.println("5. sap xep nhan vien theo luong giam dan");
            System.out.println("6. thoat ");
            int choice ;
            do {
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                }catch (Exception ex){
                    System.out.println("lua chon cua ban phai la kieu so nguyen, vui long nap lai");
                }
            }while (true);
            switch (choice) {
                case 1:
                    Main.inputData(sc);
                    break;
                case 2:
                    Main.calculateSalary();
                    break;
                case 3:
                    Main.displayData();
                    break;
                case 4:
                    Main.searchEmpByName(sc);
                    break;
                case 5:
                    Main.sortEmpBySalary();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("vui long tu 1 den 6");
            }
        } while (true);
    }
    public static void inputData(Scanner sc) {
        System.out.println("nhap vao so nha vien can nhap thong tin: ");
        int cnt;
        do {
            try {
                cnt = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex){
                System.err.println("vui logn nhap so nhaan vien la 1 so nguyen");
            }
        }while (true);
        for (int i = 0; i < cnt; i++) {
            Employee emp = new Employee();
            System.out.println("nhap ten nhan vien");
            String empName;
            do {
                empName = sc.nextLine();
                if (empName.length() >= 6 && empName.length() <= 30) {
                    //duy nhat
                    boolean checkExists = false;
                    for (Employee employee : listEmployees) {
                        if (employee.getEmpName().equals(empName)) {
                            checkExists = true;
                            break;
                        }
                    }
                    if (!checkExists) {
                        break;
                    } else {
                        System.err.println("ten nhan vien da ton tai vui long nhap lai");
                    }
                } else {
                    System.out.println("vui long nhap nhan vien tu 6 den 30 ki tu");
                }
            } while (true);
            emp.setEmpName(empName);
            emp.inputData(sc);
            listEmployees.add(emp);
        }
    }
    public static void calculateSalary(){
        for (Employee emp :listEmployees){
            emp.calculateSalary();
        }
        System.out.println("da tinh xong luong nhan vien");
    }
    public static void displayData(){
        for (Employee emp :listEmployees){
            emp.displayData();
        }
    }
    public static void searchEmpByName(Scanner sc){
        System.out.println("nhap vao ten nhan vien can tim");
        String strSearch = sc.nextLine();
        boolean checkExists = false;
        for (Employee emp :listEmployees){
            if (emp.getEmpName().contains(strSearch)){
                emp.displayData();
                checkExists = true;
            }else if (!checkExists){
                System.out.println("khong ton tai nhan vien nao trong danh sach");
            }
        }
    }
    public static void sortEmpBySalary(){
        Collections.sort(listEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() > o2.getSalary()){
                    return -1;
                } else if (o1.getSalary() == o2.getSalary()) {
                    return 0;
                }else {
                    return 1;
                }

            }
        });
        System.out.println("da sap xep theo ki tu giam dan");
    }

}