import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Dmitry", Arrays.asList(new Book("java course", 240, 2020),
                    new Book("Accounting", 250, 2012), new Book("Machine learning", 270, 2022),
                    new Book("Psychology", 300, 1999), new Book("Plant Breeding", 270, 2000))),

            new Student("Edward", Arrays.asList(new Book("The Great Gatsby", 180, 1925),
                    new Book("To Kill a Mockingbird", 281, 1960), new Book("Pride and Prejudice", 432, 1813),
                    new Book("The Catcher in the Rye", 277, 1951), new Book("Moby Dick", 585, 1851))),

            new Student("Roma", Arrays.asList(new Book("Brave New World", 268, 1932),
                    new Book("The Picture of Dorian Gray", 254, 1890), new Book("Fahrenheit 451", 158, 1953),
                    new Book("Jane Eyre", 400, 1847), new Book("Plant Breeding", 270, 2000)))
        );

        Optional<Integer> yearOptional = students.stream()
                //.peek(System.out::println) // вывод каждого студента
                .flatMap(s -> s.getBooks().stream()) // получение книг
                //.peek(System.out::println)
                //.sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages())) // сортировка по количеству страниц
                //.peek(System.out::println)
                //.distinct() // оставляем уникальные книги
                //.peek(System.out::println)
                //.filter(b -> b.getYearPublication() > 2000) // фильтруем книги после 2000 года
                //.peek(System.out::println)
                //.limit(3) // ограничиваем до 3 элементов
                .map(Book::getYearPublication) // получаем годы выпуска
                .findAny(); // возвращаем Optional от книги

        // выводим год выпуска найденной книги, либо сообщение об отсутствии
        System.out.println(yearOptional.map(Object::toString).orElse("Книга отсутствует"));
    }
}