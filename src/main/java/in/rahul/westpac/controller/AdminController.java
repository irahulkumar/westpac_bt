package in.rahul.westpac.controller;

import in.rahul.westpac.entity.User;
import in.rahul.westpac.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    public final AdminService adminService;

    @RequestMapping("/userDetails/{id}")
    public User getUserDetails(@PathVariable int id){
        return adminService.getUserDetails(id);
    }

}
