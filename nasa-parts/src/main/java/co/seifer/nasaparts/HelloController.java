package co.seifer.nasaparts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")

public class HelloController {
    @GetMapping("/hello")
        public String hello() {
            return "Hello World! 123";
        }
    @GetMapping("/bye")
    public String bye() {
        return "Bye cruel World! 123";
    }
    
}
