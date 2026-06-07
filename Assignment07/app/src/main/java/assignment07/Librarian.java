package assignment07;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Thiết kế đúng: Librarian KHÔNG nên kế thừa Reader.
 * Librarian là nhân sự thư viện, còn Reader là người mượn sách.
 * Kế thừa sẽ buộc Librarian phải override các method vô nghĩa như
 * calculateLateFee() hoặc getMaxBorrow(), và có thể khiến Librarian
 * bị thêm nhầm vào danh sách readers.
 */
public class Librarian {

    private String employeeId;
    private String fullName;
    private String phone;
    private String shift;
    private Library library;

    public Librarian(String employeeId,
                     String fullName,
                     String phone,
                     String shift,
                     Library library) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.phone = phone;
        this.shift = shift;
        this.library = library;
    }

    public String getFullName() {
        return fullName;
    }

    public void processLoan(Reader reader, Book book) {
        System.out.println("[Thu thu " + fullName + "] Xu ly cho muon:");
        BorrowResult result = reader.processBorrow(book);
        System.out.println("  Ket qua: " + result.getMessage());
        if (result.isSuccess()) {
            BorrowSlip slip = new BorrowSlip(
                    "SL" + System.currentTimeMillis(),
                    reader,
                    book,
                    getCurrentDate(),
                    getCurrentDate().plusDays(7)
            );
            library.addBorrowSlip(slip);
        }
    }

    public void processReturn(BorrowSlip slip) {
        long daysLate = ChronoUnit.DAYS.between(slip.getDueDate(), getCurrentDate());
        if (daysLate > 0) {
            double fee = slip.getReader().calculateLateFee((int) daysLate);
            System.out.printf("Phat qua han %d ngay: %.0f VND%n", daysLate, fee);
        }
        slip.getBook().increaseQuantity();
        library.removeBorrowSlip(slip);
    }

    private LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}