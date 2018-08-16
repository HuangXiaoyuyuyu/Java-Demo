package SpringBootDataElasticSearch.reposity;

import SpringBootDataElasticSearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface BookReposity extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findByNameLike(String name);
}
