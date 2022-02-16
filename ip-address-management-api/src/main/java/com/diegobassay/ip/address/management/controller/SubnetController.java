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
import com.diegobassay.ip.address.management.service.SubnetService;


import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Tag(name = "SubnetEndpoint", description = "")
@RestController
@RequestMapping("/network")
public class SubnetController {

    static final Logger LOG = LoggerFactory.getLogger(SubnetController.class);

    @Autowired
    SubnetService subnetService;

    @Operation(summary = "Find a specific subnet by your ID" )
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<SubnetModel> getSubnetById(@Parameter(description = "id of subnet") @PathVariable(value = "id") Long id){

        SubnetModel sb = subnetService.findModelById(id);
        return ResponseEntity.ok(sb);

    }

    @Operation(summary = "Update a specific subnet")
    @PutMapping(value = "/{id}", consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<SubnetModel> update(@PathVariable(value = "id") Long id, @ParameterObject @RequestBody @Valid SubnetModel model){
        SubnetModel subnetModel = subnetService.update(id, model);
        return new ResponseEntity<>(subnetModel, HttpStatus.OK);
    }

    @Operation(summary = "Create a new subnet")
    @PostMapping(consumes = { "application/json", "application/xml", "application/x-yaml" },
                 produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<SubnetModel> create(@ParameterObject @RequestBody @Valid SubnetModel model){
        SubnetModel subnetModel = subnetService.create(model);
        return new ResponseEntity<>(subnetModel, HttpStatus.CREATED);
    }

    @Operation(summary = "Find all subnets" )
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<CollectionModel<SubnetModel>> findAll() {
        CollectionModel<SubnetModel> allSubnets = subnetService.findAll();


        System.out.println("@@@@@@@@@@@@@@@@@@@@@");

        System.out.println(allSubnets);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@");



        return new ResponseEntity<>(allSubnets, HttpStatus.OK);
    }

    @Operation(summary = "Delete a specific subnet by your ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        subnetService.delete(id);
        return ResponseEntity.ok().build();
    }

}
