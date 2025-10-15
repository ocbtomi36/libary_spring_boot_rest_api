package net.myapi.springboot.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "idUser", "name", "email" })
public class UserResponseDto {

    private Integer idUser;
    private String name;
    private String email;

    public UserResponseDto(){}

    public UserResponseDto(Integer idUser, String name, String email) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
