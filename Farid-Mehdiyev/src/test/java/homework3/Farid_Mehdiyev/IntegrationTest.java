package homework3.Farid_Mehdiyev;


import homework3.Farid_Mehdiyev.TestRepository;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();

    private String url = "http://localhost";

    private static TestRestTemplate testRestTemplate;

    @Autowired
    private TestRepository testRepository;

    @BeforeAll
    public static void init(){
        testRestTemplate = new TestRestTemplate();
    }

    @BeforeEach
    public void setUp(){
        url = url.concat(":").concat(port+"").concat("/cars");
    }



    @AfterEach
    public void tearDown(){
        testRepository.deleteAll();
    }


    @Test
    @Sql(statements = "INSERT INTO Cars(car_Type, car_Year, pet_Description) VALUES('test','test','test')"
            ,executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void listCars(){
        List actualCars = testRestTemplate.getForObject(url, List.class);
        assertEquals(5,actualCars.size());
        assertEquals(5,testRepository.findAll().size());
    }

    @Test
    public void getCarsById() throws Exception{
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);


        ResponseEntity<String> response = testRestTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":1,\"carType\":\"Mercedes-Benz\",\"caryear\":\"2014\",\"carDescription\":\"Non-AMG\"}";


        JSONAssert.assertEquals(expected, response.getBody(), false);
    }





}
