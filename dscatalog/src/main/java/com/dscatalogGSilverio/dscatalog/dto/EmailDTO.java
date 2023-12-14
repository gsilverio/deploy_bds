package com.dscatalogGSilverio.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {
    @NotBlank
    @Email(message = "Email inválido")
    private String email;

    public EmailDTO(){

    }
    public EmailDTO(String email){
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

}
