package org.example.controller.person;

import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.person.entity.Person;
import org.example.service.person.PersonApplicationService;
import org.example.types.auth.PersonDTO;
import org.example.types.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    PersonApplicationService personApplicationService;

    @PostMapping
    public Response<?> create(PersonDTO personDTO) {
        try {
            personApplicationService.create(PersonAssembler.toDO(personDTO));
            return Response.ok();
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
    }

    @PutMapping
    public Response<?> update(PersonDTO personDTO) {
        try {
            personApplicationService.update(PersonAssembler.toDO(personDTO));
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
        return Response.ok();
    }

    @DeleteMapping("/{personId}")
    public Response<?> delete(@PathVariable String personId) {
        personApplicationService.deleteById(personId);
        return Response.ok();
    }

    @GetMapping("/{personId}")
    public Response get(@PathVariable String personId) {
        Person person = personApplicationService.findById(personId);
        return Response.ok(PersonAssembler.toDTO(person));
    }

    @GetMapping("/findFirstApprover")
    public Response findFirstApprover(@RequestParam String applicantId, @RequestParam int leaderMaxLevel) {
        Person person = personApplicationService.findFirstApprover(applicantId, leaderMaxLevel);
        return Response.ok(PersonAssembler.toDTO(person));
    }
}
