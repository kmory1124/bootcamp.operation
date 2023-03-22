package com.bootcamp.operation.controller;

import com.bootcamp.operation.entity.OperationEntity;
import com.bootcamp.operation.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//anotacion para indicar la url de acceso será localhost:puerto/Client/
@RequestMapping(value="/Operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    //se expone controler para obtener todas las operaciones
    @GetMapping(value = "/ListAll")
    public Flux<OperationEntity> ListAll(){
        return operationService.getAll();
    }

    //se expone controller para listar operaciones por numero de operacion
    @GetMapping(value = "/getByOperationNumber/{operationNumber}")
    public Mono<OperationEntity> getByOperationNumber(@PathVariable("operationNumber") String operationNumber){
        return operationService.getByOperationNumber(operationNumber);
    }

    //se expone controller para registrar operacion
    @PostMapping(value = "/registerOperation")
    public Mono<OperationEntity> registerOperation(@RequestBody OperationEntity Aco){
        return operationService.registerOperation(Aco);
    }

}
