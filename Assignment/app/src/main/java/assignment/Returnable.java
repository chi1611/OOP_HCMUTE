package assignment;

import java.time.LocalDate;

public interface Returnable {

    void confirmReturn(String date);

    String getReturnDate();

    boolean isReturned();

    default boolean isLate(String dueDate) {
        return LocalDate.now().isAfter(LocalDate.parse(dueDate));
    }
}