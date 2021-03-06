package controller;

import controller.dto.Response;

import controller.dto.StockDto;
import model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.StockService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 27.11.16.
 */
@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/api/stocks/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<StockDto>> stockGet(@PathVariable Long id) {
        Stock stock = stockService.get(id);
        StockDto stockDto = null;
        if(stock != null)
            stockDto = new StockDto(stock);

        return ResponseEntity.ok(Response.success(stockDto));
    }

    @RequestMapping(value = "/api/stocks", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity stocksPost(@RequestBody Stock stock) {
        stockService.create(stock);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/stocks/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity stocksPut(@PathVariable Long id, @RequestBody Stock stock) {
        stock.setId(id);
        stockService.update(stock);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/stocks", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity stocksDel(@RequestBody Stock stock) {
        stockService.delete(stock);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/stocks", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<StockDto>>> typeList() {
/*        List<TypeTransport> list = typeTransportService.list();
        return ResponseEntity.ok(Response.success(list));*/
        List<Stock> stocks = stockService.list();
        if (stocks != null) {
            List<StockDto> list = new ArrayList<StockDto>(stocks.size());
            for (Stock stock : stocks) {
                list.add(new StockDto(stock));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }

}
