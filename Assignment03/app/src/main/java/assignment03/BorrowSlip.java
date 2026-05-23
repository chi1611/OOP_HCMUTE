package assignment03;

import java.time.LocalDate;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
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
    }

    public boolean isOverdue() {

        return LocalDate.now()
                .isAfter(dueDate);
    }

    public LocalDate getDueDate() {

        return dueDate;
    }

    public Reader getReader() {
        return reader;
    }
    public Book getBook() {
        return book;
    }
}