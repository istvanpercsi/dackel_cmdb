package de.percsi.products.dackelcmdb.api.json.controler;

import de.percsi.products.dackelcmdb.api.json.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api/test")
public class GreetingController{

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

    @GetMapping("/greeting2/{name}")
    public Greeting greeting2(@PathVariable(name = "name") String name) {
        return  new Greeting(counter.incrementAndGet(), String.format(template,name));
    }

}
