package profiles;

import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import profiles.controller.PersonController;
import profiles.models.Person;
import profiles.service.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class, secure = false)
public class PersonControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService service;

    Person p = new Person("Hello","Som", "chak", 21);
    String exampleCourseJson = "{\"id\":\"Hello\", \"firstname\":\"Som\", \"lastname\":\"Chak\", \"age\":\"20\"}";

    @Test
    public void getByFirstNameTest() throws Exception{
        Mockito.when(service.getByFirstName(Mockito.anyString())).thenReturn(p);
        RequestBuilder builder = MockMvcRequestBuilders.post("/get?firstname=Som")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(builder).andReturn();
        String received = result.getResponse().getContentAsString();
        System.out.println(received);
        String expected = "{id:Hello,firstname:Som,lastname:chak,age:21}";
        JSONAssert.assertEquals(expected, received, false);
    }
}
