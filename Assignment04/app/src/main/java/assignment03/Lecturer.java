package assignment03;

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
    public String toString() {
        return super.toString().replace("}", "|| cardType='Lecturer'}");
    }
}
