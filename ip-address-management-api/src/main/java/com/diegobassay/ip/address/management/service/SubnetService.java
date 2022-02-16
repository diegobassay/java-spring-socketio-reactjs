package com.diegobassay.ip.address.management.service;

import com.diegobassay.ip.address.management.repository.SubnetRepository;
import org.springframework.hateoas.CollectionModel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;

import com.diegobassay.ip.address.management.domain.model.SubnetModel;
import com.diegobassay.ip.address.management.domain.assembler.SubnetModelAssembler;
import com.diegobassay.ip.address.management.domain.entity.IptableEntity;

import java.util.Optional;


@Service
public class SubnetService {
    @Autowired
    SubnetRepository repository;
    
    @Autowired
    SubnetModelAssembler subnetModelAssembler;

    public SubnetModel findModelById(Long id) { 
    	SubnetEntity entity = repository.findById(id) 
    			.orElseThrow(() -> new RuntimeException("No records found for this Subnet ID")); 
    	return subnetModelAssembler.toModel(entity); 
    }	

    public SubnetModel update(Long id, SubnetModel model) {
        SubnetEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No records found for this Subnet ID"));

        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setCreatedAt(model.getCreatedAt());
        entity.setIp(IptableEntity.toEntity(model.getIp()));
        return subnetModelAssembler.toModel(repository.save(entity));
    }

    public SubnetModel create(SubnetModel model) {
        SubnetEntity entity = SubnetEntity.toEntity(model);
        try{
        entity.setCreatedAt(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date()));
        } catch(Exception e){System.out.println("error");}
        SubnetEntity subnetSaved = repository.save(entity);
        return subnetModelAssembler.toModel(subnetSaved);
    }

    public CollectionModel<SubnetModel> findAll() {
        Iterable<SubnetEntity> list = repository.findAll();
        return subnetModelAssembler.toCollectionModel(list);
    }

    public SubnetModel delete(Long id) {
        
        Optional<SubnetEntity> entity = repository.findById(id);
        SubnetModel model = subnetModelAssembler.toModel(entity.get());
        repository.delete(entity.get());
        return model;
    }

}