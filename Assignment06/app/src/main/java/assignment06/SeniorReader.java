package assignment06;

public class SeniorReader extends CardHolder {

    private String seniorCardNumber;

    public SeniorReader(String readerId,
                        String fullName,
                        String email,
                        String seniorCardNumber) {
        super(readerId, fullName, email, ReaderType.SENIOR);
        this.seniorCardNumber = seniorCardNumber;
    }

    public String getSeniorCardNumber() {
        return seniorCardNumber;
    }

    public void setSeniorCardNumber(String seniorCardNumber) {
        this.seniorCardNumber = seniorCardNumber;
    }

    @Override
    public int getMaxBorrow() {
        return Integer.MAX_VALUE;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0;
    }

    @Override
    public String getInfo() {
    //    Khi sử dụng super.getInfo(), 
    //    chương trình sẽ thực hiện đúng phương thức getInfo() của lớp Reader 
    //    mà không xét đến việc lớp con có ghi đè (override) phương thức đó hay không. 
    //    Do đó đây là cơ chế static binding, không phải dynamic binding (đa hình).
        return super.getInfo() + " [NCT - MIEN PHAT]";
    }
}
