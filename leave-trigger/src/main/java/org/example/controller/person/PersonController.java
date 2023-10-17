package org.example.controller.person;

import lombok.extern.slf4j.Slf4j;
import org.example.service.person.PersonApplicationService;
import org.example.types.common.Response;
import org.example.types.person.ro.ChangeLeaderRo;
import org.example.types.person.ro.CreatePersonRo;
import org.example.types.person.vo.LeaderLineVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Response<?> create(CreatePersonRo createPersonRo) {
        personApplicationService.create(createPersonRo);
        return Response.ok();
    }

    @PostMapping("/{personId}")
    public Response<?> changeLeader(
            @PathVariable(value = "personId") Integer personId,
            @RequestBody ChangeLeaderRo changeLeaderRo) {
        personApplicationService.changeLeader(personId, changeLeaderRo.getLeaderId());
        return Response.ok();
    }

    @GetMapping("/{personId}/getLeaderLine")
    public Response<List<LeaderLineVo>> getLeaderLine(
            @PathVariable(value = "personId") Integer personId) {
        List<LeaderLineVo> list = personApplicationService.getLeaderLine(personId);
        return Response.<List<LeaderLineVo>>ok(list);
    }
}
