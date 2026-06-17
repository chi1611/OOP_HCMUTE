package assignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Borrowable borrowable;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean returned;

    public BorrowSlip(
            String slipId,
            Reader reader,
            Borrowable borrowable,
            LocalDate borrowDate,
            LocalDate dueDate) {

        this.slipId = slipId;
        this.reader = reader;
        this.borrowable = borrowable;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;

        returned = false;
    }
    
    public double returnBorrow(LocalDate returnDate) {
        returned = true;
        borrowable.returnBook(returnDate.toString());

        if(returnDate.isAfter(dueDate)) {
            long lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);
            return lateDays * 5000;
        }

        return 0;
    }
    
    public boolean isOverdue(LocalDate currentDate) {
        return !returned && currentDate.isAfter(dueDate);
    }
    
    public boolean isReturned() {
        return returned;
    }
    
    public Reader getReader() {
        return reader;
    }
    
    public Borrowable getBorrowable() {
        return borrowable;
    }
    
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
}