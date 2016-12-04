package controller.dto;

import model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by igor on 24.11.16.
 */
public class ProductDto {
    private Long id;
    private String name;
    private Long productCol;
    private Date date;
    private List<StockDto> stockDtos;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.productCol = product.getProductCol();
        this.date = product.getDate();
        this.stockDtos = new ArrayList<>(product.getStocks().size());
        this.stockDtos.addAll(product.getStocks().stream().map(StockDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductCol() {
        return productCol;
    }

    public void setProductCol(Long productCol) {
        this.productCol = productCol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<StockDto> getStockDtos() {
        return stockDtos;
    }

    public void setStockDtos(List<StockDto> stockDtos) {
        this.stockDtos = stockDtos;
    }
}
