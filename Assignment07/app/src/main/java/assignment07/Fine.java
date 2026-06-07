package assignment07;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fine {
    private static final int MONEY_PER_DAY = 5000;
    public static double calculateFine(
            LocalDate dueDate) {
        if(LocalDate.now()
                .isBefore(dueDate))
            return 0;
        long lateDays =
            ChronoUnit.DAYS.between(
                    dueDate,
                    LocalDate.now());
        return lateDays
                * MONEY_PER_DAY;
    }
}