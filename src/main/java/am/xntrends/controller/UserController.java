package am.xntrends.controller;

import am.xntrends.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String user (@PathVariable(value = "id") Long id) {

        Gson gson = new Gson();

        return gson.toJson(userService.findById(id));

    }

}