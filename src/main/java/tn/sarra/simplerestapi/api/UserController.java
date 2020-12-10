package tn.sarra.simplerestapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.sarra.simplerestapi.entities.User;
import tn.sarra.simplerestapi.repositories.UserRepository;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/users")
    @ResponseBody
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/users")
    @ResponseBody
    public List<User> findAll()
    {
        return userRepository.findAll();
    }


    @PutMapping("/users/{user_id}")
    @ResponseBody
    public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject)
    {
        User user = userRepository.getOne(userId);
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



    @DeleteMapping("/users/{user_id}")
    @ResponseBody
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    @ResponseBody
    public User findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.getOne(userId);
    }
}
