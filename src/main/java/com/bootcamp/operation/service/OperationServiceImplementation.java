package com.bootcamp.operation.service;

import com.bootcamp.operation.entity.OperationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.bootcamp.operation.repository.OperationRepository;


import java.util.Date;
@Service
public class OperationServiceImplementation implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    //implementacion para listar todas las operaciones
    @Override
    public Flux<OperationEntity> getAll() {
        return operationRepository.findAll();
    }

    //implementacion para buscar operaciones por su codigo
    @Override
    public Mono<OperationEntity>getByOperationNumber(String opeNumber){
        return operationRepository.findAll().filter(x -> x.getOperationNumber()!=null && x.getOperationNumber().equals(opeNumber)).next();
    }

    //implementacion para registrar operationes por codigo
    @Override
    public Mono<OperationEntity> registerOperation(OperationEntity EntOpe) {
        EntOpe.setCreateDate(new Date());
        return getByOperationNumber(EntOpe.getOperationNumber())
                .switchIfEmpty(operationRepository.save(EntOpe));
    }


}
