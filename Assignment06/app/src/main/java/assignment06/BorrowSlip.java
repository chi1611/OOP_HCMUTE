package assignment06;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean returned;

    public BorrowSlip(
            String slipId,
            Reader reader,
            Book book,
            LocalDate borrowDate,
            LocalDate dueDate) {

        this.slipId = slipId;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;

        returned = false;
    }
public double returnBook(
        LocalDate returnDate) {

    returned = true;

    book.increaseQuantity();

    if(returnDate.isAfter(
            dueDate)) {

        long lateDays =

            ChronoUnit.DAYS.between(
                dueDate,
                returnDate);

        return lateDays * 5000;
    }

    return 0;
}
    public boolean isOverdue(
            LocalDate currentDate) {

        return !returned

            &&

            currentDate
            .isAfter(dueDate);
    }
    public boolean isReturned() {

        return returned;
    }
    public Reader getReader() {

        return reader;
    }
    public Book getBook() {

        return book;
    }
    public LocalDate getDueDate() {

        return dueDate;
    }
}