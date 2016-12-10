package controller;

import controller.dto.ClientDto;
import controller.dto.Response;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 5.12.16.
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<Client>> get(@PathVariable Long id) {
        Client client = clientService.get(id);
        return ResponseEntity.ok(Response.success(client));
    }

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity post(@RequestBody Client client) {
        clientService.create(client);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity put(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        clientService.update(client);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/clients", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity del(@RequestBody Client client) {
        clientService.delete(client);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/clientsinfo", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<ClientDto>>> productDtoList() {
/*        List<Product> list = productService.list();
        return ResponseEntity.ok(Response.success(list));*/
        List<Client> clients = clientService.list();

        if (clients != null) {
            List<ClientDto> list = new ArrayList<ClientDto>(clients.size());
            for (Client client : clients) {
                list.add(new ClientDto(client));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/api/clients", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<Client>>> dtoList() {
        List<Client> list = clientService.list();
        return ResponseEntity.ok(Response.success(list));
    }
}
