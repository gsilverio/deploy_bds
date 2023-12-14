package com.dscatalogGSilverio.dscatalog.resources;
/* Resource = Controllers */

import com.dscatalogGSilverio.dscatalog.dto.*;
import com.dscatalogGSilverio.dscatalog.entities.User;
import com.dscatalogGSilverio.dscatalog.services.AuthService;
import com.dscatalogGSilverio.dscatalog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="/auth")
public class AuthResource {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService service;
    @Transactional
    @PostMapping(value = "/recover-token")
    public ResponseEntity<Void> createRecoverToken(@Valid @RequestBody EmailDTO body){

        authService.createRecoverToken(body);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping(value = "/new-password")
    public ResponseEntity<Void> saveNewPassword(@Valid @RequestBody NewPasswordDTO body){
        authService.saveNewPassword(body);
        return ResponseEntity.noContent().build();
    }

}
