package assignment07;

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
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sach tham khao chi doc tai cho — sinh vien khong duoc mang ve";
    }

    @Override
    public String getInfo() {
        return "[SV] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Han muon: " + getMaxBorrow() + " cuon";
    }
}
