package com.bootcamp.operation.service;
import com.bootcamp.operation.entity.OperationEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface OperationService {

    //interfaz para listar todas las operaciones
    public Flux<OperationEntity> getAll();

    //interfaz para listar operaciones por su codigo
    public Mono<OperationEntity>getByOperationNumber(String opeNumber);

    //interfaz para registrar nueva operacion
    public Mono<OperationEntity> registerOperation(OperationEntity EntOpe);
}
