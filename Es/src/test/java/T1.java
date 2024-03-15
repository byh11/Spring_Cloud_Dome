import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class T1 {

    private RestHighLevelClient client;


    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() throws IOException {
        client=new RestHighLevelClient(RestClient.builder("http://localhost:9200"));
        CreateIndexRequest request = new CreateIndexRequest("stu");
        request.source("{\n" +
                "  \"mappings\":{\n" +
                "    \"properties\":{\n" +
                "      \"name\":{\n" +
                "        \"type\":\"keyword\"\n" +
                "        \n" +
                "      },\n" +
                "      \"mes\":{\n" +
                "        \"type\":\"text\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "}", XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
        client.close();
    }


    @BeforeEach
    public void before() {
        System.out.println(1);
        client=new RestHighLevelClient(RestClient.builder("http://localhost:9200"));
    }

    @AfterEach
    public void after() throws IOException {
        client.close();
    }
}
