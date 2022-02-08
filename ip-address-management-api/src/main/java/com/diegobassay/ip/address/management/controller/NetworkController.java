package com.diegobassay.ip.address.management.controller;

import java.util.Arrays;
import java.util.List;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Component;

@Component
@Api(value = "NetworkEndpoint")
@RestController
@RequestMapping("/network")
public class NetworkController {

    static final Logger LOG = LoggerFactory.getLogger(NetworkController.class);

    @ApiOperation(value = "Find a specific subnet by your ID" )
    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<List<String>> getSubnetById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(Arrays.asList("127.0.0.1", "127.0.0.2"));
    }



}
