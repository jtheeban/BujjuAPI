package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // @RequestMapping("/greeting/{name}")
    @RequestMapping(value="/greeting/{name}", method={RequestMethod.POST,RequestMethod.GET})
    public Greeting greeting(@PathVariable("name") String name, @RequestParam("test") String test) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name + test));
    }
}