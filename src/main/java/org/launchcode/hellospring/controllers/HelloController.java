package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at /hello
/*    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // Handles request at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //  /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";

    }

    //  /hello/greetingform
    @GetMapping("greetingform")
    public String greetingForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='/hello' method='post'>" +
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='italian'>Italian</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String aName, String lang) {
        String greeting = "";

        if (lang.equals("english")) {
            greeting = "Hello";
        } else if (lang.equals("french")) {
            greeting = "Bonjour";
        } else if (lang.equals("german")) {
            greeting = "Hallo";
        } else if (lang.equals("spanish")) {
            greeting = "Hola";
        } else if (lang.equals("italian")) {
            greeting = "Bonjourno";
        }

        return greeting + ", " + aName +"!";
    }

}
