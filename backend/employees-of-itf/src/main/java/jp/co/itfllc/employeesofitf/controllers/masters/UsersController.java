package jp.co.itfllc.employeesofitf.controllers.masters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    public UsersController() {
    }

    @GetMapping("/list")
    public GetListResponse GetList() {
        return new GetListResponse();
    }

    public record GetListResponse() {
    }
}
