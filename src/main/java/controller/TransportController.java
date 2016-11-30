package controller;

import controller.dto.Response;
import controller.dto.TransportDto;
import model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TransportService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Controller
public class TransportController {

    @Autowired
    private TransportService transportService;

    @RequestMapping(value = "/api/transports/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<TransportDto>> transportGet(@PathVariable Long id) {
        Transport transport = transportService.get(id);
        TransportDto transportDto = null;
        if(transport != null)
            transportDto = new TransportDto(transport);

        return ResponseEntity.ok(Response.success(transportDto));
    }

    @RequestMapping(value = "/api/transports", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity transportPost(@RequestBody Transport transport) {
        transportService.create(transport);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/transports/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity transportPut(@PathVariable Long id, @RequestBody Transport transport) {
        transport.setId(id);
        transportService.update(transport);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/transports", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity transportDel(@RequestBody Transport transport) {
        transportService.delete(transport);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/transports", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<TransportDto>>> transportList() {
/*        List<TypeTransport> list = typeTransportService.list();
        return ResponseEntity.ok(Response.success(list));*/
        List<Transport> transports = transportService.list();
        if (transports != null) {
            List<TransportDto> list = new ArrayList<TransportDto>(transports.size());
            for (Transport transport : transports) {
                list.add(new TransportDto(transport));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }
}
