package assignment;

import java.util.List;

public interface Searchable {
    public List<Book> searchByTitle(String kw);
    public List<Book> searchByAuthor(String kw);

    static String normalizeKeyword(String str) {
        return str.trim().toLowerCase();
    }
}