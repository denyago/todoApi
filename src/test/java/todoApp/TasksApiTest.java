package todoApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TasksApiTest {

    private MockRestServiceServer mockServer;

    @Autowired
    private RestTemplate restTemplete;

    @org.junit.Before
    public void setUp() throws Exception {
        this.mockServer = MockRestServiceServer.createServer(restTemplete);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testEmptyTasksList(){
        this.mockServer.expect(requestTo("/api/tasks.json"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess("{}", MediaType.APPLICATION_JSON));
    }
}