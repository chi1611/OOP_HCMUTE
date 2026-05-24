package assignment03;
import java.time.LocalDate;
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

    public void addBook(
            Book book) {

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

    // Đếm sách đang mượn
    public int countBorrowingBooks(
            Reader reader) {

        int count = 0;

        for(BorrowSlip slip
                : slips) {

            if(slip.getReader()
                    .equals(reader)

            &&

            !slip.isReturned()) {

                count++;
            }
        }

        return count;
    }

    // Tìm gần đúng
    public void searchBook(
            String keyword) {

        keyword =
            keyword.toLowerCase();

        for(Book book
                : books) {

            if(book.getTitle()
                    .toLowerCase()
                    .contains(keyword)

            ||

            book.getAuthor()
                    .toLowerCase()
                    .contains(keyword)) {

                System.out.println(
                        book.getTitle());
            }
        }
    }

    // Phiếu quá hạn
    public void showOverdueBooks(
            LocalDate currentDate) {

        for(BorrowSlip slip
                : slips) {

            if(slip.isOverdue(
                    currentDate)) {

                System.out.println(

                    slip.getReader()
                    .getFullName()

                    + " - "

                    + slip.getBook()
                    .getTitle()
                );
            }
        }
    }

    // Sách mượn nhiều nhất
    public Book getMostBorrowedBook() {

        Book result = null;

        int max = 0;

        for(Book book
                : books) {

            int count = 0;

            for(BorrowSlip slip
                    : slips) {

                if(slip.getBook()
                        .equals(book)) {

                    count++;
                }
            }

            if(count > max) {

                max = count;
                result = book;
            }
        }

        return result;
    }

    // Độc giả mượn nhiều nhất
    public Reader getTopReader() {

        Reader result = null;

        int max = 0;

        for(Reader reader
                : readers) {

            int count = 0;

            for(BorrowSlip slip
                    : slips) {

                if(slip.getReader()
                        .equals(reader)) {

                    count++;
                }
            }

            if(count > max) {

                max = count;
                result = reader;
            }
        }

        return result;
    }

}
