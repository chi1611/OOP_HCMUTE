package assignment06;

public class GuestAccount extends DigitalAccount {
    private final int dailyLimit;

    public GuestAccount(String accountId, String displayName, String credential, int dailyLimit) {
        super(accountId, displayName, credential);
        this.dailyLimit = dailyLimit;
    }

    @Override
    public boolean authenticate(String credential) {
        return this.credential != null && this.credential.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return dailyLimit;
    }
}
