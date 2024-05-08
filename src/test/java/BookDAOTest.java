
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.testng.Assert.*;

public class BookDAOTest {

    private BookDAO bookDAO;

    @BeforeClass
    public void setUp() throws SQLException {
     
            bookDAO = new BookDAO();
        
    }

    @Test
    public void testAddBook() {
        BookController bookController = new BookController(bookDAO, new BookView());
        bookController.addBook("Test Book", "Test Author");

        List<Book> books = bookDAO.getAllBooks();
        boolean bookAdded = false;
        for (Book book : books) {
            if (book.getTitle().equals("Test Book") && book.getAuthor().equals("Test Author")) {
                bookAdded = true;
                break;
            }
        }
        assertTrue(bookAdded);
    }

    

}
