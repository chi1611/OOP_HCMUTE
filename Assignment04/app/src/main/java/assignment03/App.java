package assignment03;

public class App {

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        Library library =
                new Library();

        // Tạo sách
        Book book1 =
                new Book(
                        "B01",
                        "Lap Trinh Java OOP",
                        "NGOC ANH",
                        2022,
                        10);

        Book book2 =
                new Book(
                        "B02",
                        "Database",
                        "Tran Van A",
                        2023,
                        5);

        Book book3 =
                new Book(
                        "B03",
                        "Spring Boot Guide",
                        "Nguyen Ba C",
                        2024,
                        8);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Tạo độc giả
        Student student1 =
                new Student(
                        "R01",
                        "Le Linh Chi",
                        "chi@gmail.com");

        Student student2 =
                new Student(
                        "R02",
                        "Hoang Minh Duc",
                        "duc@gmail.com");

        Lecturer lecturer1 =
                new Lecturer(
                        "R03",
                        "Dr. Tran Van Binh",
                        "binh@university.edu");

        Lecturer lecturer2 =
                new Lecturer(
                        "R04",
                        "Prof. Le Thi Huong",
                        "huong@university.edu");

        library.addReader(student1);
        library.addReader(student2);
        library.addReader(lecturer1);
        library.addReader(lecturer2);

        System.out.println(
                "===== DANH SACH BOOK =====");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println();
        System.out.println(
                "===== DANH SACH DOC GIA =====");
        System.out.println(student1);
        System.out.println(
                "Max borrow: " + student1.getMaxBorrow());

        System.out.println();
        System.out.println(student2);
        System.out.println(
                "Max borrow: " + student2.getMaxBorrow());

        System.out.println();
        System.out.println(lecturer1);
        System.out.println(
                "Max borrow: " + lecturer1.getMaxBorrow());

        System.out.println();
        System.out.println(lecturer2);
        System.out.println(
                "Max borrow: " + lecturer2.getMaxBorrow());
        }
}