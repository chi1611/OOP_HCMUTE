package assignment07;

import java.time.LocalDate;

public class LibraryCard {
    private final String cardId;
    private final String linkedAccountId; // có thể null nếu chưa liên kết
    private final LocalDate issuedOn;
    private boolean active;

    public LibraryCard(String cardId, String linkedAccountId, LocalDate issuedOn, boolean active) {
        this.cardId = cardId;
        this.linkedAccountId = linkedAccountId;
        this.issuedOn = issuedOn;
        this.active = active;
    }

    public String getCardId() {
        return cardId;
    }

    public String getLinkedAccountId() {
        return linkedAccountId;
    }

    public LocalDate getIssuedOn() {
        return issuedOn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Kiểm tra thẻ có hợp lệ cho tài khoản hay không
    public boolean isValidFor(DigitalAccount account) {
        if (!active) return false;
        if (linkedAccountId == null) return true; // thẻ chung
        return linkedAccountId.equals(account.getAccountId());
    }

    @Override
    public String toString() {
        return "LibraryCard{" + "cardId='" + cardId + '\'' + ", linkedAccountId='" + linkedAccountId + '\'' + ", issuedOn=" + issuedOn + ", active=" + active + '}';
    }
}
