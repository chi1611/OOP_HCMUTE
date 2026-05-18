public class Rectangle {
    double width;
    double height;
    // Constructor không tham số
    Rectangle() {
        width = 1;
        height = 1;
    }
    // Constructor 1 tham số
    Rectangle(double side) {
        width = side;
        height = side;
    }
    // Rectangle(double width) {
    //     this.width = width;
    // }--> Đây là constructor không hợp lệ vì trùng với constructor Rectangle(double side) ở trên

    // Constructor 2 tham số
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    Rectangle(Rectangle r) {
        this.width = r.width;
        this.height = r.height;
    }
    double getArea() {
        return width * height;
    }
    double getPerimeter() {
        return 2 * (width + height);
    }
    boolean isSquare() {
        return width == height;
    }
    void scale(double factor) {
        width *= factor;
        height *= factor;
    }
    void display() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Is Square: " + isSquare());
        System.out.println("----------------------");
    }

}
//Suy nghĩ: tại sao không thể có 2 constructor cùng nhận 1 tham số double? Hãy thử và giải thích lỗi.
//vì:
//Không thể có 2 constructor cùng nhận 1 tham số double vì Java sẽ không biết nên gọi constructor nào 
//khi chúng ta tạo một đối tượng với một giá trị double. 
//Điều này dẫn đến lỗi biên dịch "constructor is ambiguous".
//Khi có hai constructor có cùng kiểu tham số, 
//Java không thể phân biệt được chúng và không biết nên sử dụng constructor nào để khởi tạo đối tượng.
//ví dụ sai :
// Rectangle(double side) {
//     width = side;
//     height = side;
// }
// ----------------------------
// Rectangle(double width) {
//     this.width = width;
// }
// Hai constructor trên đều có dạng: Rectangle(double)
// nên Java không biết phải gọi constructor nào → báo lỗi: constructor Rectangle(double) is already defined