package SpringBootDataElasticSearch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain = true)
@Document(indexName = "hxy",type = "book")
public class Book {
    private Integer id;
    private String bookName;
    private String author;
}
