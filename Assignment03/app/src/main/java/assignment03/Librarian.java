package assignment03;
import java.time.LocalDate;
public class Librarian {

    public BorrowSlip borrowBook(
            String slipId,
            Reader reader,
            Book book) {

        if(!book.isAvailable()) {
            return null;
        }

        book.decreaseQuantity();
        return new BorrowSlip(
                slipId,
                reader,
                book,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );
    }
    public double returnBook(
            BorrowSlip slip) {

        slip.getBook()
                .increaseQuantity();
        return Fine.calculateFine(
                slip.getDueDate());
    }
}