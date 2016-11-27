package controller;

import controller.dto.ProductDto;
import controller.dto.Response;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 24.11.16.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/api/products/{id}", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<ProductDto>> productGet(@PathVariable String id) {
/*        Product product = productService.get(id);
        return ResponseEntity.ok(Response.success(product));*/
        Product product = productService.get(id);
        ProductDto productDto = null;
        if(product != null)
            productDto = new ProductDto(product);

        return ResponseEntity.ok(Response.success(productDto));
    }

    @RequestMapping(value = "/api/products/{id}", method = RequestMethod.POST)
    @ResponseBody
    private ResponseEntity productPost(@RequestBody Product product) {
        productService.create(product);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/products/{id}", method = RequestMethod.PUT)
    @ResponseBody
    private ResponseEntity productPut(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        productService.update(product);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.DELETE)
    @ResponseBody
    private ResponseEntity productDel(@RequestBody Product product) {
        productService.delete(product);
        return ResponseEntity.ok(Response.success());
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Response<List<ProductDto>>> productList() {
/*        List<Product> list = productService.list();
        return ResponseEntity.ok(Response.success(list));*/
        List<Product> products = productService.list();

        if (products != null) {
            List<ProductDto> list = new ArrayList<ProductDto>(products.size());
            for (Product product : products) {
                list.add(new ProductDto(product));
            }

            return ResponseEntity.ok(Response.success(list));
        }
        return new ResponseEntity(Response.error("Nothing found"), HttpStatus.NOT_FOUND);
    }
    }
