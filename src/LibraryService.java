import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private static final LibraryService INSTANCE = new LibraryService();
    private final List<Book> books = new ArrayList<>();
    private final BorrowRequestHandler borrowRequestHandler;

    private LibraryService() {
        BorrowRequestHandler librarian = new Librarian();
        librarian.setNext(new Manager()).setNext(new Director());
        borrowRequestHandler = librarian;
    }

    public static LibraryService getInstance() {
        return INSTANCE;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title, User user) {
        borrowBook(title, user, 7);
    }

    public void borrowBook(String title, User user, int requestedDays) {
        if (findBook(title) == null) {
            System.out.println("Book not found: " + title);
            return;
        }

        if (requestedDays <= 0) {
            System.out.println("Requested days must be greater than zero.");
            return;
        }

        borrowRequestHandler.handle(new BorrowRequest(title, user, requestedDays), this);
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book not found.");
        }
    }

    public void completeBorrow(BorrowRequest request) {
        Book book = findBook(request.getBookTitle());
        if (book != null) {
            book.borrowBook(request.getUser());
        } else {
            System.out.println("Book not found.");
        }
    }
}
