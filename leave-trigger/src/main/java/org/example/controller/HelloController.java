package org.example.controller;

/**
 * @author
 */

import lombok.extern.slf4j.Slf4j;
import org.example.types.common.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@RequestMapping("/")
@Slf4j
public class HelloController {

    @GetMapping
    public Response<String> hello() {
        return Response.<String>ok("hello,leave");
    }
}
