package assignment07;

public class Book {
      // Attributes
    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;
    private boolean referenceOnly;

    // Constructor
    public Book(String bookId,
                String title,
                String author,
                int publishYear,
                int quantity) {

        this(bookId, title, author, publishYear, quantity, false);
    }

    public Book(String bookId,
                String title,
                String author,
                int publishYear,
                int quantity,
                boolean referenceOnly) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.referenceOnly = referenceOnly;
    }

    // Getter & Setter
    public String getBookId() {
        return bookId;
    }
    public void setBookId(
            String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(
            String title) {

        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(
            String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(
            int publishYear) {
        this.publishYear =
                publishYear;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(
            int quantity) {
        this.quantity = quantity;
    }

    public boolean isReferenceOnly() {
        return referenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        this.referenceOnly = referenceOnly;
    }

    // Business methods
    public boolean isAvailable() {
        return quantity > 0;
    }
    public void decreaseQuantity() {
        if(quantity > 0)
            quantity--;
    }
    public void increaseQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", quantity=" + quantity +
                ", ref=" + referenceOnly +
                '}';
    }
}