public class Employee {
    private int id;
    private String name;
    private double salary;
    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName= "TechCorp";
    private static double totalSalary = 0;

      // Constructor
    Employee(String name, double salary) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.salary = salary;
        employeeCount++;
        totalSalary += salary;
    }
     // getter
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    // setter cho namee
    public void setName(String name) {
        this.name = name;
    }
    // setter cho salary
    public void setSalary(double salary) {
        // Trừ lương cũ
        totalSalary -= this.salary;
        // Gán lương mới
        this.salary = salary;
        // Cộng lương mới
        totalSalary += salary;
    }
    // Tăng lương theo %
    public void raiseSalary(double percent) {
        double increase = salary * percent / 100;
        totalSalary -= salary;
        salary += increase;
        totalSalary += salary;
    }
    // Static method
    public static int getEmployeeCount() {
        return employeeCount;
    }
    public static double getTotalSalary() {
        return totalSalary;
    }
    public static double getAverageSalary() {
        // Nếu chưa có nhân viên nào vẫn chạy được
        // vì đây là static method
        // Không cần tạo object để gọi

        if (employeeCount == 0) {
            return 0;
        }
        return totalSalary / employeeCount;
    }
    // Đổi tên công ty
    public static void changeCompanyName(String newName) {
        companyName = newName;
    }
    // Hiển thị thông tin
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Company: " + companyName);
        System.out.println("----------------------");
    }
}
