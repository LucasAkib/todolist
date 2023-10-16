package br.com.lucashenrique.todolist.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* Modificador
* Public
* Private
* Protected
*
*/

@RestController
@RequestMapping("/users")

public class UserController {
/*
* String (Texto)
* Integer (Numero inteiro)
* Double (Números 0.0000)'
* Float (Números 0.000)
* Char ( A C)
* Date (data)
* Void
*
*
* body requisição
*
 */

    @Autowired
    private IUserRepository userRepository;
@PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel){
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if(user != null){
        System.out.println("Usuário já existe");
        //status erro
        //status Code
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
    }


    var  passwordHashred = BCrypt.withDefaults()
            .hashToString(12 , userModel.getPassword().toCharArray());


    userModel.setPassword(passwordHashred);

    var  userCreated = this.userRepository.save(userModel);
      return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }

}
