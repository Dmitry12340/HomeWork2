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

        students.stream().forEach(System.out::println);

        // Основная логика стрима
        Optional<Integer> yearOfFoundBook = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYearPublication() > 2000)
                .limit(3)
                .map(Book::getYearPublication)
                .reduce((first, second) -> second);

        //System.out.println(yearOfFoundBook.map(String::valueOf).orElse("Книга отсутствует"));
    }
}