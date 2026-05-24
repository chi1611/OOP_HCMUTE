package assignment03;

import java.time.LocalDate;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        Library library =
                new Library();

        // Tạo sách
        Book book1 =
                new Book(
                        "B01",
                        "Lap Trinh Java OOP",
                        "NGOC ANH",
                        2022,
                        10);

        Book book2 =
                new Book(
                        "B02",
                        "Database",
                        "Tran Van A",
                        2023,
                        5);

        library.addBook(book1);
        library.addBook(book2);

        // Tạo độc giả
        Reader reader1 =
                new Reader(
                        "R01",
                        "Le Linh Chi",
                        "chi@gmail.com",
                        ReaderType.STUDENT);

        Reader reader2 =
                new Reader(
                        "R02",
                        "Minh Nhi",
                        "nhi@gmail.com",
                        ReaderType.LECTURER);

        library.addReader(reader1);
        library.addReader(reader2);

        Librarian librarian =
                new Librarian();

        System.out.println(
                "===== MUON SACH =====");

        BorrowSlip slip1 =
                librarian.borrowBook(
                        "P01",
                        reader1,
                        book1,
                        library);

        BorrowSlip slip2 =
                librarian.borrowBook(
                        "P02",
                        reader1,
                        book1,
                        library);

        BorrowSlip slip3 =
                librarian.borrowBook(
                        "P03",
                        reader1,
                        book2,
                        library);

        // vượt giới hạn sinh viên
        librarian.borrowBook(
                "P04",
                reader1,
                book2,
                library);

        System.out.println();

        System.out.println(
                "===== TIM SACH =====");

        library.searchBook(
                "java");

        System.out.println();

        System.out.println(
                "===== PHIEU QUA HAN =====");

        library.showOverdueBooks(
                LocalDate.now()
                        .plusDays(10));

        System.out.println();

        System.out.println(
                "===== TRA SACH =====");

        librarian.returnBook(slip1);

        System.out.println();

        System.out.println(
                "===== THONG KE =====");

        System.out.println(
                "Most borrowed book: "
                +
                library
                .getMostBorrowedBook()
                .getTitle());

        System.out.println(
                "Top reader: "
                +
                library
                .getTopReader()
                .getFullName());

    }
}