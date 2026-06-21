package assignment;

public interface Fineable {

    double getFineAmount();
    void setFineAmount(double amount);
    String getViolationReason();
    default double calculateTotalFine(int daysLate) {
        return getFineAmount() * daysLate;
    }

    static boolean isValidFine(double amount) {
        return amount >= 0;
    }
}