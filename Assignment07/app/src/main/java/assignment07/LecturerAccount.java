package assignment07;

public class LecturerAccount extends DigitalAccount {

    public LecturerAccount(String accountId, String displayName, String credential) {
        super(accountId, displayName, credential);
    }

    @Override
    public boolean authenticate(String credential) {
        return this.credential != null && this.credential.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return -1; // không giới hạn
    }
}
