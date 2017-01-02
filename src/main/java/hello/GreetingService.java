package hello;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hello World";
    }    
    public String greetWithAnException() throws Exception{
        throw new Exception("fail");
    }
}
