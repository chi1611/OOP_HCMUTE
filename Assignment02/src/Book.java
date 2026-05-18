public class Book {
    String title;
    String author;
    int year;
    double price;

      Book() {
        title = "Unknown";
        author = "Unknown";
        year = 2000;
        price = 0;
    }
    Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000;
    }
    void displayInfo() {
        System.out.println("Sach: " + title);
        System.out.println("Tac Gia: " + author);
        System.out.println("Nam:" + year);
        System.out.println("Gia: " + price);
    }
    //giam gia 10%
    void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }
}
