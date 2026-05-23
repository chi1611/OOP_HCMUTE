package assignment03;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        // System.out.println(new App().getGreeting());
        Library library =
                new Library();

        Book book =
                new Book(
                        "B01",
                        "Lap Trinh Java OOP",
                        "NGOC ANH",
                        2022,
                        10);

        Reader reader =
                new Reader(
                        "R01",
                        "Le Linh Chi",
                        "chi@gmail.com",
                        ReaderType.STUDENT);

        Librarian librarian =
                new Librarian();

        library.addBook(book);
        library.addReader(reader);
        // Vượt quá giới hạn mượn
        librarian.borrowBook("P02", reader, book, library);
        librarian.borrowBook("P03", reader, book, library);
        librarian.borrowBook("P04", reader, book, library);
        // Mượn sách
        librarian.borrowBook(
                "P01",
                reader,
                book,
                library);

        // Tìm sách
        library.searchBook("java");
    }
}