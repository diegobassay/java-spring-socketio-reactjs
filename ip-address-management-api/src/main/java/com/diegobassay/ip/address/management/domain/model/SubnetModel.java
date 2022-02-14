package com.diegobassay.ip.address.management.domain.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "subnets", itemRelation = "subnet")
@JsonInclude(Include.NON_NULL)
public class SubnetModel extends RepresentationModel<SubnetModel> {

    Long id;

    String name;

    String description;

    String createdAt;

    IptableModel ip;


}
