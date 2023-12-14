package com.dscatalogGSilverio.dscatalog.dto;

import com.dscatalogGSilverio.dscatalog.services.validation.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
    private static final long serialVersionUID=1L;

    @Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String password;
    UserInsertDTO(){
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
