package assignment;

public abstract class Reader {
    private String readerId;
    private String fullName;
    private String email;
    private ReaderType type;
    protected int currentBorrowCount;

    public Reader(String readerId,
                  String fullName,
                  String email,
                  ReaderType type) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.type = type;
        this.currentBorrowCount = 0;
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

    public int getCurrentBorrowCount() {
        return currentBorrowCount;
    }

    public int getMaxBorrowLimit() {
        return getMaxBorrow();
    }

    // NOTE: Nếu `renewCard()` được khai báo trong lớp `Reader`, mọi lớp con của Reader đều
    // phải hỗ trợ hành vi này. GuestReader không có thẻ thư viện nên không thể thực hiện
    // renewCard() một cách hợp lệ. Đây là vi phạm LSP: một subtype không thể thay thế
    // superclass mà không làm hỏng các đoạn code phụ thuộc vào hợp đồng của superclass.

    public abstract int getMaxBorrow();

    public abstract double calculateLateFee(int daysLate);

    public final BorrowResult processBorrow(Borrowable borrowable) {
        if (!checkBorrowQuota()) {
            return new BorrowResult(false,
                    "Da dat gioi han muon: " + getMaxBorrowLimit() + " cuon");
        }

        if (borrowable instanceof Book) {
            Book book = (Book) borrowable;
            if (!checkSpecialCondition(book)) {
                return new BorrowResult(false, getSpecialConditionMessage());
            }
        }

        if (!borrowable.isAvailable()) {
            return new BorrowResult(false, "Sach hien tai het hang: " + borrowable.getTitle());
        }

        currentBorrowCount++;
        onBorrowSuccess(borrowable);

        return new BorrowResult(true, "Muon thanh cong: " + borrowable.getTitle());
    }

    private boolean checkBorrowQuota() {
        return currentBorrowCount < getMaxBorrowLimit();
    }

    protected abstract boolean checkSpecialCondition(Book book);

    protected abstract String getSpecialConditionMessage();

    protected void onBorrowSuccess(Borrowable borrowable) {
        System.out.println(getFullName() + " muon: " + borrowable.getTitle());
    }

    public String getInfo() {
        return getReaderId() + " | " + getFullName()
                + " | Email: " + getEmail();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
