package org.example.springweb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   private List<User> users = new ArrayList<>();


   @PostMapping
   public  ResponseEntity<User>  addUser(@RequestBody User user) {
       users.add(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);

   }


    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                return ResponseEntity.status(200).body(users.get(i));
            }
        }
        return ResponseEntity.status(404).body(null);
    }


    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
       users.remove(user);
       return ResponseEntity.status(200).body(user);
    }


    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
       for (int i = 0; i < users.size(); i++) {
           if (users.get(i).getId() == user.getId()){
               users.set(i, user);
           }
       }
       return ResponseEntity.status(200).body(user);
    }

    // До реализовать методы удаления юзера изменения и замены и получения всех юзеров

}
