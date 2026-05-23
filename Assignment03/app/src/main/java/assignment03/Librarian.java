package assignment03;
import java.time.LocalDate;

public class Librarian {

    public BorrowSlip borrowBook(
            String slipId,
            Reader reader,
            Book book,
            Library library) {

        // Kiểm tra kho
        if (!book.isAvailable()) {

            System.out.println(
                "Book out of stock");

            return null;
        }

        // Kiểm tra giới hạn mượn
        int currentBorrow =

            library.countBorrowingBooks(
                    reader);

        if (currentBorrow >=
                reader.getMaxBorrow()) {

            System.out.println(
                "Borrow limit exceeded");

            return null;
        }

        // Trừ kho
        book.decreaseQuantity();

        BorrowSlip slip =
            new BorrowSlip(
                slipId,
                reader,
                book,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
            );

        library.addBorrowSlip(slip);

        return slip;
    }

    public void returnBook(
            BorrowSlip slip) {

        double fine =
                slip.returnBook();

        System.out.println(
            "Fine: "
            + fine
            + " VND");
    }
}