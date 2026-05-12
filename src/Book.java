public class Book {
    private String title;
    private String author;
    private Double price;
    private boolean inStock;
    public Book(String title, String author, double price, boolean inStock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }
    public void printInfo() {
        System.out.println("Tieu de: " + title);
        System.out.println("Tac gia: " + author);
        System.out.println("Gia: " + price);
        System.out.println("Con hang: " + inStock);
        System.out.println("----------------------");
    }
    public void Discount(double percent) {
        price = price - (price * percent / 100);
    }

}
