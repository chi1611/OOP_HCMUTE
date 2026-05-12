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

        //BAI2
        Rectangle r1 = new Rectangle(5, 10);
        Rectangle r2 = new Rectangle(7, 7);

        System.out.println("Rectangle 1:");
        System.out.println("Dien Tich: " + r1.dienTich());
        System.out.println("Chu Vi: " + r1.chuVi());
        System.out.println("La Hinh Vuong: " + r1.laHinhVuong());

        System.out.println();

        System.out.println("Rectangle 2:");
        System.out.println("Dien Tich: " + r2.dienTich());
        System.out.println("Chu Vi: " + r2.chuVi());
        System.out.println("La Hinh Vuong: " + r2.laHinhVuong());
        System.out.println();

        //bai 3
        Circle[] circles = {
            new Circle(2),
            new Circle(3),
            new Circle(8),
            new Circle(4),
            new Circle(6)
        };
        double totalArea = 0;
        for (Circle c : circles) {
            totalArea += c.area();
        }

        System.out.println("Tong dien tich cua 5 hinht tron la: " + totalArea);
    }
}
