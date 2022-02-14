package com.diegobassay.ip.address.management.domain.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.diegobassay.ip.address.management.domain.model.SubnetModel;
import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;
import com.diegobassay.ip.address.management.controller.SubnetController;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class SubnetModelAssembler extends RepresentationModelAssemblerSupport<SubnetEntity, SubnetModel> {

    @Autowired
    IptableModelAssembler iptableModelAssembler;

    public SubnetModelAssembler() {
        super(SubnetController.class, SubnetModel.class);
    }

    @Override
    public SubnetModel toModel(SubnetEntity entity) {
        SubnetModel subnetModel = instantiateModel(entity);

        subnetModel.setId(entity.getId());
        subnetModel.setName(entity.getName());
        subnetModel.setDescription(entity.getDescription());
        //subnetModel.setIp(iptableModelAssembler.toModel(entity.getIp()));

        return subnetModel;
    }

}