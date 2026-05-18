import model.Product;
import model.Category;
public class Main {
    public static void main(String[] args) {
        //bai1----------------------------------------------------------
        System.out.println("Bai 1:");
        // Constructor không tham số
        Book b1 = new Book();
        // Constructor 4 tham số
        Book b2 = new Book("Java Programming", "Ngoc Anh Le", 2025, 250000);
        // Constructor 2 tham số
        Book b3 = new Book("OOP Basics", "Linh Linh");
    // Hiển thị thông tin sách
        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();

        // Giảm giá 10% cho b2
        b2.applyDiscount(10);

        System.out.println("\nSau khi giam gia:");
        b2.displayInfo();

        //BAI2:---------------------------------------------------------------
        System.out.println(" bai 2 :");
        // Constructor không tham số
        Rectangle r1 = new Rectangle();
        // Constructor 1 tham số
        Rectangle r2 = new Rectangle(5);
        // Constructor 2 tham số
        Rectangle r3 = new Rectangle(4, 6);
        // Copy constructor
        Rectangle r4 = new Rectangle(r3);
        // Hiển thị thông tin
        System.out.println("Rectangle 1:");
        r1.display();

        System.out.println("Rectangle 2:");
        r2.display();

        System.out.println("Rectangle 3:");
        r3.display();

        System.out.println("Rectangle 4 (Copy of r3):");
        r4.display();

        r3.scale(2);

        System.out.println("Rectangle 3 after scaling x2:");
        r3.display();
    
    //Bai3:---------------------------------------------------------------
        System.out.println("\nBai 3:");
      // Tạo tài khoản
        BankAccount acc1 =
                new BankAccount("123454543", "Ngoc Anh Le", 5000);
        BankAccount acc2 =
                new BankAccount("273467546", "Linh Linh", 2000);
        // Hiển thị thông tin
        acc1.displayInfo();
        acc2.displayInfo();
        // Nạp tiền
        acc1.deposit(1000);
        // Nạp lỗi
        acc1.deposit(-500);
        // Rút tiền
        acc1.withdraw(2000);
        // Rút quá số dư
        acc1.withdraw(10000);
        // Chuyển tiền
        acc1.transfer(acc2, 1500);
        // Hiển thị lại
        System.out.println("Sau khi giao dich:");

        acc1.displayInfo();
        acc2.displayInfo();

        // Test setter tên
        acc1.setOwnerName("");
        acc1.setOwnerName("Chi Le");
        acc1.displayInfo();

        //BAI4:----------------------------------------------------------------
        System.out.println("\nBai 4:"); 
         // Tạo nhân viên
        Employee e1 = new Employee("Ngoc Anh", 1000);
        Employee e2 = new Employee("Linh Linh", 2000);
        Employee e3 = new Employee("Chi Le", 3000);

        // Hiển thị thông tin
        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();

        // In ID
        System.out.println("ID e1: " + e1.getId());
        System.out.println("ID e2: " + e2.getId());
        System.out.println("ID e3: " + e3.getId());

        // Thông tin thống kê
        System.out.println("\nTong nhan vien: "
                + Employee.getEmployeeCount());
        System.out.println("Tong luong: "
                + Employee.getTotalSalary());
        System.out.println("Luong trung binh: "
                + Employee.getAverageSalary());
        // Đổi lương
        e1.setSalary(5000);
        System.out.println("\nSau khi doi luong e1:");
        System.out.println("Tong luong: "
                + Employee.getTotalSalary());
        System.out.println("Luong trung binh: "
                + Employee.getAverageSalary());

        // Tăng lương
        e2.raiseSalary(10);
        System.out.println("\nSau khi tang luong e2 10%:");
        System.out.println("Tong luong: "
                + Employee.getTotalSalary());
        // Đổi tên công ty
        Employee.changeCompanyName("ANCO Tech");
        System.out.println("\nSau khi doi ten cong ty:");

        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();

        //BAI5:----------------------------------------------------------------
        System.out.println("\nBai 5:");
        // Category
        Category laptop = new Category("Laptop");
        Category phone = new Category("Phone");

        // Tạo sản phẩm
        Product p1 = new Product();
        Product p2 = new Product("IPhone 15", 2000);
        Product p3 = new Product("Macbook", 3000, 10);
        Product p4 = new Product("Dell XPS", 2500,5,laptop);

        // Hiển thị
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();

        // Bán hàng
        p3.sell(2);
        // Nhập hàng
        p4.restock(10);
        // Giảm giá
        p4.applyPromotion(10);
        // Global promotion
        Product[] products = {p1, p2, p3, p4};
        Product.applyGlobalPromotion(products, 5);
        // Ngừng kinh doanh
        p2.discontinue();

        // Báo cáo cửa hàng
        System.out.println("\n Bao cao cua hang:");
        System.out.println(Product.getStoreReport());
        System.out.println("\nTong san pham: "+ Product.getTotalProducts());
        System.out.println("Tong doanh thu: "+ Product.getTotalRevenue());
    }
}