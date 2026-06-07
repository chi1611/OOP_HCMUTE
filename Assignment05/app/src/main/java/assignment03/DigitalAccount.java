package assignment03;

public abstract class DigitalAccount {
    protected String accountId;
    protected String displayName;
    protected String credential;

    public DigitalAccount(String accountId, String displayName, String credential) {
        this.accountId = accountId;
        this.displayName = displayName;
        this.credential = credential;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public abstract boolean authenticate(String credential);
    public abstract int getDownloadLimit();

    // Phương thức chung: kiểm tra giới hạn và thực hiện tải
    public boolean requestDownload(int downloadsToday) {
        int limit = getDownloadLimit();
        if (limit == -1 || downloadsToday < limit) { // -1 = không giới hạn
            System.out.println("Tai xuong thanh cong: "
                    + (downloadsToday + 1) + "/" + (limit == -1 ? "∞" : limit));
            return true;
        }
        System.out.println("Da dat gioi han tai xuong hom nay!");
        return false;
    }
}
