package assignment;

/**
 * Borrowable interface defines the contract for items that can be borrowed from the library.
 * Includes constants for borrowing rules, abstract methods, a default method for fine calculation,
 * and a static utility method for validation.
 */
public interface Borrowable {

    // Constants
    int MAX_BORROW_DAYS    = 14;       // Số ngày mượn tối đa
    double FINE_PER_DAY   = 5000.0;   // Phạt 5,000 VND/ngày trễ

    // Abstract methods
    void borrowBy(String readerId, String date);  // Mượn bởi độc giả
    void returnBook(String date);                  // Trả sách
    boolean isAvailable();                         // Còn trống không?
    String getBorrowerId();                        // Ai đang mượn?
    String getId();                                // Lấy ID của vật dụng
    String getTitle();                             // Lấy tiêu đề của vật dụng

    // Default method
    default double calculateFine(int daysOverdue) {
        if (daysOverdue <= 0) return 0.0;
        return daysOverdue * FINE_PER_DAY;
    }

    // Static method
    static boolean isValidBorrowDuration(int days) {
        return days > 0 && days <= MAX_BORROW_DAYS;
    }
}

