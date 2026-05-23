package assignment03;
import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;
    private ArrayList<BorrowSlip> slips;
    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
        slips = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void addReader(
            Reader reader) {
        readers.add(reader);
    }
    public void addBorrowSlip(
            BorrowSlip slip) {
        slips.add(slip);
    }
    public void searchBook(
            String keyword) {
        for(Book book : books) {
            if(book.getTitle()
                    .toLowerCase()
                    .contains(
                     keyword.toLowerCase())
            ||
            book.getAuthor()
                    .toLowerCase()
                    .contains(
                     keyword.toLowerCase())) {
                System.out.println(
                        book.getTitle());
            }
        }
    }
    public void showOverdueBooks() {
        for(BorrowSlip slip
                : slips) {
            if(slip.isOverdue()) {
                System.out.println(
                  slip.getReader()
                  .getFullName());
            }
        }
    }
    public int countBorrowedBooks(Reader reader) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countBorrowedBooks'");
    }
}
