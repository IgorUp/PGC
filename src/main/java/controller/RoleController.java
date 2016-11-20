package controller;

import controller.dto.Response;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.RoleService;

/**
 * Created by igor on 20.11.16.
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity roleGet(@PathVariable String id) {
        Role role = roleService.get(id);
        return ResponseEntity.ok(Response.success(role));
    }

    @RequestMapping(value = "/api/roles/{id}", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity rolePost(@PathVariable String id, @RequestBody Role role) {
        role.setId_role(id);
        roleService.create(role);
        return ResponseEntity.ok(Response.success());
    }

}
