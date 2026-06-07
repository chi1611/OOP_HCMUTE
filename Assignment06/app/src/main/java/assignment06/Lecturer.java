package assignment06;

public class Lecturer extends Reader {
    
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
    public String getInfo() {
        return "[GV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
