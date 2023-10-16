package org.example.controller.auth;

import javax.annotation.Resource;
import org.example.service.auth.LoginApplicationService;
import org.example.types.auth.PersonDTO;
import org.example.types.common.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    LoginApplicationService loginApplicationService;

    @PostMapping("/login")
    public Response<?> login(PersonDTO personDTO) {
        try {
            loginApplicationService.login(PersonAssembler.toDO(personDTO));
            return Response.ok();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
