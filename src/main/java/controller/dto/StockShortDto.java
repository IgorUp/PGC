package controller.dto;

import model.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by igor on 4.12.16.
 */
public class StockShortDto {
    private Long id;
    private String name;
    private String address;
    private Long numberOfSeats;
    private Long numberOfRemainingPlaces;
    private Long numberOfSectors;
    private String height;
    private String width;
    private String capacity;
    private TypeStockDto typeStock;
    private List<ProductShortDto> productShortDtos;

    public StockShortDto() {
    }

    public StockShortDto(Stock stock) {
        this.id = stock.getId();
        this.name = stock.getName();
        this.address = stock.getAddress();
        this.numberOfSeats = stock.getNumberOfSeats();
        this.numberOfRemainingPlaces = stock.getNumberOfRemainingPlaces();
        this.numberOfSectors = stock.getNumberOfSectors();
        this.height = stock.getHeight();
        this.width = stock.getWidth();
        this.capacity = stock.getCapacity();
        this.typeStock = new TypeStockDto(stock.getTypeStock());
        this.productShortDtos = new ArrayList<>(stock.getProducts().size());
        this.productShortDtos.addAll(stock.getProducts().stream().map(ProductShortDto::new).collect(Collectors.toList()));
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getNumberOfRemainingPlaces() {
        return numberOfRemainingPlaces;
    }

    public void setNumberOfRemainingPlaces(Long numberOfRemainingPlaces) {
        this.numberOfRemainingPlaces = numberOfRemainingPlaces;
    }

    public Long getNumberOfSectors() {
        return numberOfSectors;
    }

    public void setNumberOfSectors(Long numberOfSectors) {
        this.numberOfSectors = numberOfSectors;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public TypeStockDto getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(TypeStockDto typeStock) {
        this.typeStock = typeStock;
    }

    public List<ProductShortDto> getProductShortDtos() {
        return productShortDtos;
    }

    public void setProductShortDtos(List<ProductShortDto> productShortDtos) {
        this.productShortDtos = productShortDtos;
    }
}
