package assignment06;

public enum ReaderType {

    STUDENT(3),
    LECTURER(5);

    private int maxBorrow;

    ReaderType(
            int maxBorrow) {

        this.maxBorrow =
                maxBorrow;
    }
    public int getMaxBorrow() {

        return maxBorrow;
    }

}