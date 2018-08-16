package SpringBootDataElasticSearch;

import SpringBootDataElasticSearch.bean.Book;
import SpringBootDataElasticSearch.reposity.BookReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataElasticsearchApplicationTests {

    @Resource
    private BookReposity bookReposity;

    @Test
    public void contextLoads() {
        Book book = new Book().setId(1).setBookName("Java").setAuthor("Sun");
        bookReposity.index(book);
    }

    @Test
    public void searchByLike() {
        List<Book> a = bookReposity.findByNameLike("a");
        for (Book book:a) {
            System.out.println(book);
        }
    }

}
