package com.alura.challenge.foro_hub.domain.profile;

import com.alura.challenge.foro_hub.domain.profile.dto.ProfileDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Profile {

    private Long idProfile;
    private String username;

    //Constructors
    public Profile() {
    }

    public Profile(ProfileDTO profileDTO) {
        this.idProfile = profileDTO.id();
        this.username = profileDTO.username();
    }

    //toString

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + idProfile +
                ", username='" + username + '\'' +
                '}';
    }

    //Getters&Setters

    public Long getId() {
        return idProfile;
    }

    public void setId(Long id) {
        this.idProfile = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
