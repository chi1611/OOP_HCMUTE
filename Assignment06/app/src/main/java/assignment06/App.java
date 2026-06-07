package assignment06;

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

        Reader sv = new Student("R001", "Le Van C", "c@student.edu");
        Reader gv = new Lecturer("R002", "Pham Thi D", "d@uni.edu");

        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addReader(sv);
        lib.addReader(gv);

        lib.showAllBooks();
        lib.showAllReaders();
        lib.showLateFees(7);

        System.out.println();
        System.out.println("Han muon:");
        Reader[] readers = {sv, gv};
        for (Reader r : readers) {
            System.out.println(r.getFullName() + ": " + r.getMaxBorrow() + " cuon");
        }

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