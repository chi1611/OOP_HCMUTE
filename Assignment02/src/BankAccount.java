public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    // Constructor
    // Constructor
    BankAccount(String accountNumber, String ownerName, double balance) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance < 0) {
            System.out.println("So du khong hop le. Gan balance = 0");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }
    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public double getBalance() {
        return balance;
    }
    // Setter cho ownerName
    public void setOwnerName(String ownerName) {

        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
        } else {
            System.out.println("Ten chu tai khoan khong hop le!");
        }
    }
     /*
     * Không viết setter cho accountNumber
     * Vì số tài khoản là duy nhất và không nên thay đổi
     */

     // Nạp tiền
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nap tien thanh cong: " + amount);
        } else {
            System.out.println("So tien nap phai > 0");
        }
    }
    // Rút tiền
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien rut phai > 0");
        } else if (amount > balance) {
            System.out.println("Khong du so du de rut!");
        } else {
            balance -= amount;
            System.out.println("Rut tien thanh cong: " + amount);
        }
    }
    // Chuyển tiền
    public void transfer(BankAccount other, double amount) {
        if (amount <= 0) {
            System.out.println("So tien chuyen phai > 0");
        } else if (amount > balance) {
            System.out.println("Khong du so du de chuyen!");
        } else {
            this.balance -= amount;
            other.balance += amount;

            System.out.println("Chuyen " + amount + " thanh cong");
        }
    }
    // Hiển thị thông tin
    public void displayInfo() {
        // Lấy 4 ký tự cuối
        String hiddenAccount =
                "****" + accountNumber.substring(accountNumber.length() - 4);

        System.out.println("So tai khoan: " + hiddenAccount);
        System.out.println("Chu tai khoan: " + ownerName);
        System.out.println("So du: " + balance);
        System.out.println("----------------------");
    }
}
