package com.bootcamp.operation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
//anotacion para ahorrar codigo de constructor con 1 parametro
@AllArgsConstructor
//anotacion para ahorrar codigo de constructor sin parametros
@NoArgsConstructor
//anotacion que indica que se utilizará para mapear a la collection "Operation" de la bd mongo
@Document(collection = "Operation")
public class OperationEntity {
    @Id
    private String id;
    private String documentNumber;
    private String operationNumber;
    private String numberAccountOrigin;
    private String numberAccountDestination;
    private String operationType;
    private Double amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private  Date modifyDate;
}
