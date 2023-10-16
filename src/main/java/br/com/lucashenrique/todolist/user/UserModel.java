package br.com.lucashenrique.todolist.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity(name ="tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;



    @Column(unique = true)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    private String password;


@CreationTimestamp
    private LocalDateTime createAt;


}
