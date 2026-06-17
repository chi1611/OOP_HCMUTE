package assignment;

public abstract class CardHolder extends Reader {

    public CardHolder(String readerId,
                      String fullName,
                      String email,
                      ReaderType type) {
        super(readerId, fullName, email, type);
    }

    public void renewCard(int months) {
        System.out.println("Gia han the " + months + " thang cho: " + getFullName());
    }
}
