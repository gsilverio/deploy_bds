package com.dscatalogGSilverio.dscatalog.services.validation;

import com.dscatalogGSilverio.dscatalog.dto.UserInsertDTO;
import com.dscatalogGSilverio.dscatalog.dto.UserUpdateDTO;
import com.dscatalogGSilverio.dscatalog.entities.User;
import com.dscatalogGSilverio.dscatalog.repositories.UserRepository;
import com.dscatalogGSilverio.dscatalog.resources.exceptions.FieldMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {
    @Autowired
    private UserRepository repository;
    @Autowired
    private HttpServletRequest request;
    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        var uriVARS = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long userId = Long.parseLong(uriVARS.get("id"));

        List<FieldMessage> list = new ArrayList<>();
        User user = repository.findByEmail(dto.getEmail());


       if(user!=null && userId!=user.getId()) {
           list.add(new FieldMessage("email","Email ja existe"));
       }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}