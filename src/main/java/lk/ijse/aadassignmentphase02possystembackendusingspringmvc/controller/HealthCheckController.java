package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/health")
@RestController
public class HealthCheckController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String healthTest(){
        return "Customer Controller is making";
    }

}
