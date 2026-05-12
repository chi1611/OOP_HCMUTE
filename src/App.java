public class App {
    public static void main(String[] args) {
        
        Book b1 = new Book("sach hoa", "Nguyên", 10000, true);
        Book b2 = new Book("sach sinh hoc", "Trang", 35000, true);
        Book b3 = new Book("sach dia ly", "Linh", 50000, false);

        System.out.println("Thong tin sach: ");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();

        b1.Discount(10);
        b2.Discount(10);
        b3.Discount(10);

        System.out.println("Sau khi giam gia 10%: ");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();
    }
}
