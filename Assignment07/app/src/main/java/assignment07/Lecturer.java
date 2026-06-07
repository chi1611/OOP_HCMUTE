package assignment07;

public class Lecturer extends CardHolder {
    
    public Lecturer(String readerId,
                    String fullName,
                    String email) {
        super(readerId, fullName, email, ReaderType.LECTURER);
    }

    @Override
    public int getMaxBorrow() {
        return 5;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 1000.0 * daysLate;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }

    @Override
    public String getInfo() {
        return "[GV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
