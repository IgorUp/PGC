package controller;

import controller.dto.Response;
import controller.dto.TypeStockDto;
import dao.TypeStockDao;
import model.TypeStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TypeStockService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Controller
public class TypeStockController {

    @Autowired
    private TypeStockService typeStockService;

    @RequestMapping(value = "/api/typestocks/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<TypeStockDto>> typeGet(@PathVariable String id) {
        TypeStock typeStock = typeStockService.get(id);
        TypeStockDto typeStockDto = null;
        if(typeStock != null)
            typeStockDto = new TypeStockDto(typeStock);

        return ResponseEntity.ok(Response.success(typeStockDto));
    }

    @RequestMapping(value = "/api/typestocks", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity typePost(@RequestBody TypeStock typeStock) {
        typeStockService.create(typeStock);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/typestocks/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity typePut(@PathVariable String id, @RequestBody TypeStock typeStock) {
        typeStock.setId(id);
        typeStockService.update(typeStock);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/typestocks", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity typeDel(@RequestBody TypeStock typeStock) {
        typeStockService.delete(typeStock);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/typestocks", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<TypeStockDto>>> typeList() {
/*        List<TypeTransport> list = typeTransportService.list();
        return ResponseEntity.ok(Response.success(list));*/
        List<TypeStock> typeStocks = typeStockService.list();
        if (typeStocks != null) {
            List<TypeStockDto> list = new ArrayList<TypeStockDto>(typeStocks.size());
            for (TypeStock typeStock : typeStocks) {
                list.add(new TypeStockDto(typeStock));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }

}
