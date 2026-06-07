package assignment07;

import java.util.Arrays;

/*
 * DESIGN RATIONALE
 *
 * 1. Tại sao `DigitalAccount` là abstract class?
 *    => Vì nó cung cấp hành vi chung (requestDownload) và hợp đồng (authenticate, getDownloadLimit)
 *       nhưng chi tiết xác thực và giới hạn phụ thuộc vào loại account, nên để subclass triển khai.
 *
 * 2. Tại sao `GuestAccount`/`LibraryCard` KHÔNG kế thừa `Reader`?
 *    => Vì một `Reader` mô tả người dùng/thực thể có thể mượn sách (IS-A), trong khi `LibraryCard` là một
 *       thực thể sở hữu/thuộc về (HAS-A) hoặc liên kết tới account; dùng composition giữ mối quan hệ rõ ràng.
 *
 * 3. Lợi thế thiết kế hiện tại: dễ mở rộng loại account mới, tách rõ trách nhiệm xác thực và chính sách giới hạn.
 *    Rủi ro/hạn chế: không có quản lý trạng thái tải trong lớp (chỉ kiểm tra theo tham số), cần service để theo dõi.
 */

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        Book b1 = new Book("B001", "Lap trinh Java", "Nguyen Manh", 2022, 10);
        Book b2 = new Book("B002", "CTDL va GT", "Tran Hung", 2021, 5);

        CardHolder sv = new Student("R001", "Le Van C", "c@student.edu");
        CardHolder gv = new Lecturer("R002", "Pham Thi D", "d@uni.edu");
        CardHolder nct = new SeniorReader("R003", "Tran Van C", "c@senior.edu", "CC2024001");
        Reader guest = new GuestReader("R004", "Nguyen Van K", "k@guest.edu");

        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addReader(sv);
        lib.addReader(gv);
        lib.addReader(nct);

        lib.showAllBooks();
        lib.showAllReaders();
        lib.showLateFees(7);

        System.out.println();
        System.out.println("Han muon:");
        Reader[] readers = {sv, gv, nct};
        for (Reader r : readers) {
            System.out.println(r.getFullName() + ": " + r.getMaxBorrow() + " cuon");
        }

        System.out.println();
        System.out.println("--- YEU CAU 2.1: Dynamic binding qua printAllReaders() ---");
        lib.printAllReaders();

        System.out.println();
        System.out.println("--- YEU CAU 2.2: Dynamic binding qua calculateTotalLateFee() ---");
        double total = lib.calculateTotalLateFee(5);
        System.out.printf("Tong phat neu qua han 5 ngay: %.0f VND%n", total);

        System.out.println();
        System.out.println("--- YEU CAU 2.3: Tim kiem va dung dynamic binding tren ket qua ---");
        Reader found = lib.findReaderByName("tran van");
        if (found != null) {
            System.out.println(found.getInfo());
            System.out.println(found.getMaxBorrow() + " cuon - " + found.getFullName());
        }

        System.out.println();
        System.out.println("--- YEU CAU 2.4: Downcast an toan ---");
        lib.printSeniorReaders();

        System.out.println();
        System.out.println("--- YEU CAU 2.5: Dynamic polymorphism qua printFeeReport() ---");
        lib.printFeeReport(Arrays.asList(sv, gv, nct, guest), 4);

        System.out.println();
        System.out.println("--- YEU CAU 2.6: Only CardHolder can renew card ---");
        lib.renewAllCardHolders(Arrays.asList(sv, gv, nct), 1);

        System.out.println();
        System.out.println("--- YEU CAU 1: Template Method demo ---");
        Book refBook = new Book("B003", "Ky thuat lap trinh", "Le Loi", 2023, 2, true);
        BorrowResult borrow1 = sv.processBorrow(b1);
        System.out.println(borrow1.getMessage());
        BorrowResult borrow2 = sv.processBorrow(refBook);
        System.out.println(borrow2.getMessage());
        BorrowResult borrow3 = guest.processBorrow(b2);
        System.out.println(borrow3.getMessage());

        System.out.println();
        System.out.println("--- YEU CAU 2: Strategy Pattern demo ---");
        lib.setFeePolicy(new StandardFeePolicy());
        lib.calculateTotalFee(7);
        lib.setFeePolicy(new CharityFeePolicy());
        lib.calculateTotalFee(7);
        lib.setFeePolicy(new WaivedFeePolicy());
        lib.calculateTotalFee(7);

        System.out.println();
        System.out.println("--- YEU CAU NANG CAO: Librarian composition demo ---");
        Librarian libr = new Librarian("TT01", "Le Thi D", "0904", "Sang", lib);
        Reader sv2 = new Student("SV01", "Nguyen Van A", "a@student.edu");
        Reader nctu = new SeniorReader("CC01", "Le Van C", "c@senior.edu", "CC2024");
        Book book3 = new Book("B01", "Clean Code", "Robert Martin", 2024, 3, false);
        lib.addReader(sv2);
        lib.addReader(nctu);
        lib.addBook(book3);

        libr.processLoan(sv2, book3);
        libr.processLoan(nctu, book3);

        // Dòng dưới phải lỗi compile nếu thêm, vì Librarian không phải Reader:
        // lib.addReader(libr);

        // --- DigitalAccount demo ---
        System.out.println();
        System.out.println("--- DigitalAccount demo ---");

        DigitalAccount studentAcc = new StudentAccount("SA1", "Sinh Vien A", "pw123", 3);
        DigitalAccount lecturerAcc = new LecturerAccount("LA1", "Dr. B", "secret");
        DigitalAccount guestAcc = new GuestAccount("G1", "Guest", "guestpw", 1);

        System.out.println("Student authenticate OK? " + studentAcc.authenticate("pw123"));
        System.out.println("Student attempts:");
        studentAcc.requestDownload(0); // should allow 1/3
        studentAcc.requestDownload(2); // should allow 3/3
        studentAcc.requestDownload(3); // should be denied (limit reached)

        System.out.println();
        System.out.println("Lecturer attempts (no limit):");
        lecturerAcc.requestDownload(100); // unlimited -> allow

        System.out.println();
        System.out.println("Guest attempts:");
        guestAcc.requestDownload(0); // allow 1/1
        guestAcc.requestDownload(1); // deny (limit reached)
    }
}