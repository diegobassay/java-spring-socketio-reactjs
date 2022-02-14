package com.diegobassay.ip.address.management.service;

import com.diegobassay.ip.address.management.repository.SubnetRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;

import com.diegobassay.ip.address.management.domain.model.SubnetModel;
import com.diegobassay.ip.address.management.domain.assembler.SubnetModelAssembler;


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

}