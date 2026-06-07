package assignment07;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public void showAllBooks() {
        System.out.println("=== DANH SACH SACH ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showAllReaders() {
        System.out.println("=== DANH SACH DOC GIA ===");
        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }

    public void showLateFees(int daysLate) {
        System.out.println("=== PHI PHAT TRE HAN (" + daysLate + " ngay) ===");
        for (Reader r : readers) {
            System.out.printf("%-40s : %,.0f VND%n",
                    r.getFullName(), r.calculateLateFee(daysLate));
        }
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

    public void printAllReaders() {
        System.out.println("===== DANH SACH DOC GIA (" + readers.size() + " nguoi) =====");

        for (Reader r : readers) {
            System.out.println(r.getInfo()); // Dynamic binding: tự gọi đúng lớp con
        }
    }

    public double calculateTotalLateFee(int daysLate) {
        double total = 0;

        for (Reader r : readers) {
            total += r.calculateLateFee(daysLate); // Dynamic binding
        }

        return total;
    }

    public void renewAllCardHolders(List<CardHolder> holders, int months) {
        System.out.println("===== GIA HAN THE CAC DOC GIA CO THE =====");
        for (CardHolder holder : holders) {
            holder.renewCard(months);
        }
    }

    public void printFeeReport(List<Reader> readers, int daysLate) {
        System.out.println("===== FEE REPORT (" + daysLate + " ngay tre) =====");
        for (Reader r : readers) {
            System.out.printf("%-40s : %,.0f VND%n",
                    r.getFullName(), r.calculateLateFee(daysLate));
        }
    }

    public Reader findReaderByName(String keyword) {
        for (Reader r : readers) {
            if (r.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                return r; // Trả về Reader - có thể là bất kỳ lớp con nào
            }
        }

        return null; // Không tìm thấy
    }

    public void printSeniorReaders() {
        System.out.println("====== DOC GIA NGUOI CAO TUOI ======");
        int count = 0;
        for (Reader r : readers) {
            if (r instanceof SeniorReader) { // 1. Kiểm tra kiểu thực tế
                SeniorReader sr = (SeniorReader) r; // 2. Downcast an toàn
                System.out.println(sr.getInfo());
                System.out.println("Ma the NCT: " + sr.getSeniorCardNumber()); // method riêng
                count++;
            }
        }
        if (count == 0) System.out.println("(Chua co doc gia NCT)");
    }

}
