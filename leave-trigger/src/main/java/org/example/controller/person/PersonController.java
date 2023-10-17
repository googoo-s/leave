package org.example.controller.person;

import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;
import org.example.service.person.PersonApplicationService;
import org.example.types.auth.PersonDto;
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
    public Response<?> create(PersonDto personDto) {
        try {
            personApplicationService.create(personDto);
        } catch (ParseException e) {
            log.error("", e);
            return Response.failed(e.getMessage());
        }
        return Response.ok();
    }

    @PutMapping
    public Response<?> update(PersonDto personDTO) {
        try {
            personApplicationService.update(personDTO);
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
    public Response<PersonDto> get(@PathVariable String personId) {
        PersonDto person = personApplicationService.findById(personId);
        return Response.<PersonDto>ok(person);
    }

    @GetMapping("/findFirstApprover")
    public Response<PersonDto> findFirstApprover(@RequestParam String applicantId, @RequestParam int leaderMaxLevel) {
        PersonDto person = personApplicationService.findFirstApprover(applicantId, leaderMaxLevel);
        return Response.ok(person);
    }
}
