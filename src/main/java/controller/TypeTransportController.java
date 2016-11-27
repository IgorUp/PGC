package controller;

import controller.dto.Response;
import controller.dto.TypeTransportDto;
import dao.TypeTransportDao;
import model.TypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TypeTransportService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Controller
public class TypeTransportController {

    @Autowired
    private TypeTransportService typeTransportService;

    @RequestMapping(value = "/api/typetransports/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<TypeTransportDto>> typeGet(@PathVariable Long id) {
        TypeTransport typeTransport = typeTransportService.get(id);
        TypeTransportDto typeTransportDto = null;
        if(typeTransport != null)
            typeTransportDto = new TypeTransportDto(typeTransport);

        return ResponseEntity.ok(Response.success(typeTransportDto));
    }

    @RequestMapping(value = "/api/typetransports", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity typePost(@RequestBody TypeTransport typeTransport) {
        typeTransportService.create(typeTransport);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/typetransports/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity typePut(@PathVariable Long id, @RequestBody TypeTransport typeTransport) {
        typeTransport.setId(id);
        typeTransportService.update(typeTransport);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/typetransports", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity typeDel(@RequestBody TypeTransport typeTransport) {
        typeTransportService.delete(typeTransport);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/typetransports", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<TypeTransportDto>>> typeList() {
/*        List<TypeTransport> list = typeTransportService.list();
        return ResponseEntity.ok(Response.success(list));*/
        List<TypeTransport> typeTransports = typeTransportService.list();
        if (typeTransports != null) {
            List<TypeTransportDto> list = new ArrayList<TypeTransportDto>(typeTransports.size());
            for (TypeTransport typeTransport : typeTransports) {
                list.add(new TypeTransportDto(typeTransport));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }

}
