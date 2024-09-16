package org.example;
import org.example.book.Book;
import org.example.car.Car;
import org.example.clock.Clock;
import org.example.point.Point;
import org.example.student.Student;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println("1. Book");
        book.setName("Tutorial");
        book.setAuthor("Academic");
        book.setYear(1990);
        book.display();

        Student student = new Student();
        System.out.println("2. Student");
        student.setName("Ivan Ivanov");
        student.setRecordBook(564777);
        student.setAverage(4.7);
        student.print();;

        Point point = new Point(0,0);
        System.out.println("3. Point. Сдвигаем на 2 вверх и вправо, на 1 вниз и влево");
        point.moveUp();
        point.moveUp();
        point.moveDown();
        point.moveLeft();
        point.moveRight();
        point.moveRight();
        point.result();

        Clock clock = new Clock(23,59,59);
        System.out.println("3. Clock. Увеличиваем на 2 секунды");
        clock.tick();
        clock.tick();
        clock.readTime();

        Car car = new Car("Audi", "S1", 2000);
        System.out.println(car);
        car.drive(10);
        car.start();
        car.drive(50);
        car.stop();
        car.drive(20);
    }
}