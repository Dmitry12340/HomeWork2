import java.util.Objects;

public class Book {
    private String title;
    private int pages;
    private int yearPublication;

    public Book(String title, int pages, int yearPublication) {
        this.title = title;
        this.pages = pages;
        this.yearPublication = yearPublication;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", yearPublication=" + yearPublication +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && yearPublication == book.yearPublication && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, yearPublication);
    }
}
