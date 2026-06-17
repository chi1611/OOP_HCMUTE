package assignment;

public class Student extends CardHolder {
    
    public Student(String readerId,
                   String fullName,
                   String email) {
        super(readerId, fullName, email, ReaderType.STUDENT);
    }

    @Override
    public int getMaxBorrow() {
        return 3;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 2000.0 * daysLate;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        // Simplified Book class no longer tracks referenceOnly status
        // All books can be borrowed by students
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }

    @Override
    public String getInfo() {
        return "[SV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
