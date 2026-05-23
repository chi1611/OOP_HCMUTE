package assignment03;
public class Reader {
    private String readerId;
    private String fullName;
    private String email;
    private ReaderType type;

    public Reader(String readerId,
                  String fullName,
                  String email,
                  ReaderType type) 
                  {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.type = type;
    }
    public int getMaxBorrow() {
        return type.getMaxBorrow();
    }
    public String getFullName() {
        return fullName;
    }
    public ReaderType getType() {
        return type;
    }
}
