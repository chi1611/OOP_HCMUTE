package assignment07;

public class GuestReader extends Reader {

    public GuestReader(String readerId,
                       String fullName,
                       String email) {
        super(readerId, fullName, email, ReaderType.GUEST);
    }

    @Override
    public int getMaxBorrow() {
        return 0;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
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
        return "[KH] " + getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail()
                + " | Doc tai cho, khong co the";
    }
}
