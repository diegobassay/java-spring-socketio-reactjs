package com.diegobassay.ip.address.management.domain.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.diegobassay.ip.address.management.domain.model.IptableModel;
import com.diegobassay.ip.address.management.domain.entity.IptableEntity;
import com.diegobassay.ip.address.management.controller.IptableController;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class IptableModelAssembler extends RepresentationModelAssemblerSupport<IptableEntity, IptableModel> {


    //@Autowired
    //SubnetModelAssembler subnetModelAssembler;

    public IptableModelAssembler() {
        super(IptableController.class, IptableModel.class);
    }

    @Override
    public IptableModel toModel(IptableEntity entity) {
        IptableModel ipModel = instantiateModel(entity);

        ipModel.setId(entity.getId());
        ipModel.setCode(entity.getCode());
        ipModel.setDescription(entity.getDescription());
        //ipModel.setSubnet(subnetModelAssembler.toModel(entity.getSubnet()));

        return ipModel;

    }

}