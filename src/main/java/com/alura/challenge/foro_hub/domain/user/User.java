package com.alura.challenge.foro_hub.domain.user;


import com.alura.challenge.foro_hub.domain.profile.Profile;
import com.alura.challenge.foro_hub.domain.user.dto.UserDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "users")
@Entity(name = "User")
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String names;
    private String email;
    private String password;
    @Embedded
    private Profile profile;

    //Constructors

    public User() {
    }

    public User(UserDTO userDTO) {
        this.names = userDTO.names();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.profile = new Profile(userDTO.profile());
    }

    //toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }

    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
