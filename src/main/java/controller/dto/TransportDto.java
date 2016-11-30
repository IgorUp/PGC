package controller.dto;

import model.Transport;

/**
 * Created by igor on 27.11.16.
 */
public class TransportDto {
    private Long id;
    private String height;
    private String width;
    private String capacity;
    private Long numberOfSeats;
    private Long numberOfRemainingPlaces;
    private Long idTypeTransport;
    private TypeTransportDto typeTransportDto;

    public TransportDto() {
    }

    public TransportDto(Transport transport) {
        this.id = transport.getId();
        this.height = transport.getHeight();
        this.width = transport.getWidth();
        this.capacity = transport.getCapacity();
        this.numberOfSeats = transport.getNumberOfSeats();
        this.numberOfRemainingPlaces = transport.getNumberOfRemainingPlaces();
        this.idTypeTransport = transport.getIdTypeTransport();
        this.typeTransportDto = new TypeTransportDto(transport.getTypeTransport());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdTypeTransport() {
        return idTypeTransport;
    }

    public void setIdTypeTransport(Long idTypeTransport) {
        this.idTypeTransport = idTypeTransport;
    }

    public TypeTransportDto getTypeTransportDto() {
        return typeTransportDto;
    }

    public void setTypeTransportDto(TypeTransportDto typeTransportDto) {
        this.typeTransportDto = typeTransportDto;
    }
}
