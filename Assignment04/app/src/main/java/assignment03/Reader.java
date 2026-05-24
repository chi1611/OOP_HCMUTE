package assignment03;

public class Reader {
    private String readerId;
    private String fullName;
    private String email;
    private ReaderType type;

    public Reader(String readerId,
                  String fullName,
                  String email,
                  ReaderType type) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.type = type;
    }

    // Getters
    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ReaderType getType() {
        return type;
    }

    public void setType(ReaderType type) {
        this.type = type;
    }

    public int getMaxBorrow() {
        return 0;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId='" + readerId + '\'' +
                "|| fullName='" + fullName + '\'' +
                "|| email='" + email + '\'' +
                '}';
    }
}
