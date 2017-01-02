package hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private GreetingController greetingController;
    
    @Autowired
    private HomeController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    
    @Test
    public void contextLoads() throws Exception {
    	assertThat(greetingController).isNotNull();
    }
    
    
}
