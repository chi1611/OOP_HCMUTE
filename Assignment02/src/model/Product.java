package model;
import util.ProductValidator;
public class Product {
    // Thuộc tính
    private String productCode;
    private String name;
    private double price;
    private int quantity;
    private Category category;
    private boolean discontinued = false;

    // Static
    private static int counter = 1;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;
    // Constructor không tham số
    public Product() {
        this("Unknown", 0, 0);
    }
    // Constructor 2 tham số
    public Product(String name, double price) {
        this(name, price, 0);
    }
    // Constructor 3 tham số
    public Product(String name, double price, int quantity) {
        // Tạo mã tự động
        this.productCode =
                String.format("P-%04d", counter);
        counter++;

        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            this.price = 0;
        }
        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
        totalProducts++;
    }
    // Constructor có category
    public Product(String name,double price,int quantity,Category category) {
        this(name, price, quantity);
        this.category = category;
    }
    // Getter
    public String getProductCode() {
        return productCode;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public Category getCategory() {
        return category;
    }
    // Setter
    public void setName(String name) {
        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Ten khong hop le!");
        }
    }

    public void setPrice(double price) {
        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            System.out.println("Gia khong hop le!");
        }
    }
    public void setQuantity(int quantity) {
        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            System.out.println("So luong khong hop le!");
        }
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    // Bán hàng
    public void sell(int amount) {
        if (discontinued) {
            System.out.println("San pham da ngung kinh doanh!");
            return;
        }
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            totalRevenue += amount * price;
            System.out.println("Ban thanh cong "
                    + amount + " san pham");
        } else {
            System.out.println("Khong du hang hoac so luong sai!");
        }
    }
    // Nhập hàng
    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println("Nhap them " + amount + " san pham");
        } else {
            System.out.println("So luong nhap phai > 0");
        }
    }
    // Giảm giá
    public void applyPromotion(double discountPercent) {
        if (discountPercent > 0
                && discountPercent <= 100) {
            price -= price * discountPercent / 100;
        }
    }
    // Static giảm giá toàn bộ
    public static void applyGlobalPromotion(
            Product[] products,
            double discountPercent) {
        for (Product p : products) {
            p.applyPromotion(discountPercent);
        }
    }
    // Ngừng kinh doanh
    public void discontinue() {

        /*
         * Không giảm totalProducts
         * vì totalProducts đại diện tổng sản phẩm từng được tạo
         * chứ không phải số sản phẩm đang bán
         */

        discontinued = true;

        System.out.println(productCode
                + " da ngung kinh doanh");
    }

    // Hiển thị
    public void displayInfo() {
        System.out.println("Code: " + productCode);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        if (category != null) {
            System.out.println("Category: "
                    + category.getCategoryName());
        }
        System.out.println("----------------------");
    }
    // Static method
    public static int getTotalProducts() {
        return totalProducts;
    }
    public static double getTotalRevenue() {
        return totalRevenue;
    }
    public static String getStoreReport() {
        return "Tong san pham: "
                + totalProducts
                + "\nTong doanh thu: "
                + totalRevenue;
    }
}