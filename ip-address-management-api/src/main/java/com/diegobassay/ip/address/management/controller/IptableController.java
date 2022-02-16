package com.diegobassay.ip.address.management.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;

import org.springframework.stereotype.Component;
import com.diegobassay.ip.address.management.domain.entity.*;
import com.diegobassay.ip.address.management.domain.model.*;
import com.diegobassay.ip.address.management.service.IptableService;

import org.springframework.stereotype.Repository;

@Component
@RestController
@RequestMapping("/ip")
public class IptableController {

    static final Logger LOG = LoggerFactory.getLogger(IptableController.class);
    @Autowired
    IptableService iptableService;

    @Operation(summary = "Update a specific iptable")
    @PutMapping(value = "/{id}", consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<IptableModel> update(@PathVariable(value = "id") Long id, @ParameterObject @RequestBody @Valid IptableModel model){
        IptableModel iptableModel = iptableService.update(id, model);
        return new ResponseEntity<>(iptableModel, HttpStatus.OK);
    }

    @Operation(summary = "Create a new iptable")
    @PostMapping(consumes = { "application/json", "application/xml", "application/x-yaml" },
                 produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<IptableModel> create(@ParameterObject @RequestBody @Valid IptableModel model){
        IptableModel iptableModel = iptableService.create(model);
        return new ResponseEntity<>(iptableModel, HttpStatus.CREATED);
    }

    @Operation(summary = "Find all iptables" )
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<CollectionModel<IptableModel>> findAll() {
        CollectionModel<IptableModel> allSubnets = iptableService.findAll();
        return new ResponseEntity<>(allSubnets, HttpStatus.OK);
    }

    @Operation(summary = "Delete a specific iptable by your ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        iptableService.delete(id);
        return ResponseEntity.ok().build();
    }
}
