package com.diegobassay.ip.address.management.service;

import com.diegobassay.ip.address.management.repository.IptableRepository;
import org.springframework.hateoas.CollectionModel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;

import com.diegobassay.ip.address.management.domain.model.IptableModel;
import com.diegobassay.ip.address.management.domain.assembler.IptableModelAssembler;
import com.diegobassay.ip.address.management.domain.entity.IptableEntity;

import java.util.Optional;


@Service
public class IptableService {
    @Autowired
    IptableRepository iptableRepository;
    
    @Autowired
    IptableModelAssembler iptableModelAssembler;

    public IptableModel findModelById(Long id) { 
    	IptableEntity entity = iptableRepository.findById(id) 
    			.orElseThrow(() -> new RuntimeException("No records found for this ip id")); 
    	return iptableModelAssembler.toModel(entity); 
    }	

    public IptableModel update(Long id, IptableModel model) {
        IptableEntity entity = iptableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No records found for this ip id"));
        entity.setIp(model.getIp());
        entity.setDevice(model.getDevice());
        entity.setCreatedAt(model.getCreatedAt());
        return iptableModelAssembler.toModel(iptableRepository.save(entity));
    }

    public IptableModel create(IptableModel model) {
        IptableEntity entity = IptableEntity.toEntity(model);
        IptableEntity ipSaved = iptableRepository.save(entity);
        return iptableModelAssembler.toModel(ipSaved);
    }

    public CollectionModel<IptableModel> findAll() {
        Iterable<IptableEntity> list = iptableRepository.findAll();
        return iptableModelAssembler.toCollectionModel(list);
    }

    public IptableModel delete(Long id) {
        Optional<IptableEntity> entity = iptableRepository.findById(id);
        IptableModel model = iptableModelAssembler.toModel(entity.get());
        iptableRepository.delete(entity.get());
        return model;
    }

}