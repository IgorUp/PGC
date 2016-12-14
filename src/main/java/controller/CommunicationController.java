package controller;

import controller.dto.Response;
import model.Communication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CommunicationService;

import java.util.List;

/**
 * Created by igor on 20.11.16.
 */
@Controller
public class CommunicationController {

    @Autowired
    private CommunicationService communicationService;

    @RequestMapping(value = "/api/coms/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity comGet(@PathVariable Long id) {
        Communication communication = communicationService.get(id);
        return ResponseEntity.ok(Response.success(communication));
    }

    @RequestMapping(value = "/api/coms", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity comPost(@RequestBody Communication com) {
        communicationService.create(com);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/coms/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity comPut(@PathVariable Long id, @RequestBody Communication com) {
        com.setId(id);
        communicationService.update(com);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/coms", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity comDel(@RequestBody Communication com) {
        communicationService.delete(com);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/coms", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity comList() {
        List<Communication> list = communicationService.list();
        return ResponseEntity.ok(Response.success(list));
    }

}
