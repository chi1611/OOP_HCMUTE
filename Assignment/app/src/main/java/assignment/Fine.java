package assignment;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fine implements Fineable {
    private static final int MONEY_PER_DAY = 5000;

    private double fineAmount;
    private String violationReason;

    public Fine(double fineAmount, String violationReason) {
        this.fineAmount = fineAmount;
        this.violationReason = violationReason;
    }

    @Override
    public double getFineAmount() {
        return fineAmount;
    }

    @Override
    public void setFineAmount(double amount) {
        this.fineAmount = amount;
    }

    @Override
    public String getViolationReason() {
        return violationReason;
    }

    public static double calculateFine(LocalDate dueDate) {

        if (LocalDate.now().isBefore(dueDate)) {
            return 0;
        }

        long lateDays =
                ChronoUnit.DAYS.between(
                        dueDate,
                        LocalDate.now());

        return lateDays * MONEY_PER_DAY;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "fineAmount=" + fineAmount +
                ", violationReason='" + violationReason + '\'' +
                '}';
    }
}