package hello;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Every Controller in the project is put under test. 
 * @AutoConfigureMockMvc puts all the Controllers under test
 *  
 * @WebMvcTest(HomeController.class) puts only the defined controller under test   
 * @author id809201 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    
    /*
     * Test Greeting Controller
     */
    @Test
    public void shouldReturnGreetWorld() throws Exception {
    	this.mockMvc.perform(get("/greeting"))
    	.andDo(print()).andExpect(status().isOk())
    	.andExpect(content().string(containsString("Greet world")));
    }
    

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World")));        
    }
    
    @Test
    public void shouldReturnOk() throws Exception {
    	mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnHelloWorld() throws Exception {
    	mockMvc.perform(get("/")).andExpect(content().string("Hello World"));
    }
}
