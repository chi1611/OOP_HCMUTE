package assignment07;

public enum ReaderType {

    GUEST(0),
    STUDENT(3),
    LECTURER(5),
    SENIOR(Integer.MAX_VALUE);

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