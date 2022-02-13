package com.diegobassay.ip.address.management.controller.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "iptables", itemRelation = "iptable")
@JsonInclude(Include.NON_NULL)
public class IptableModel extends RepresentationModel<IptableModel> {

    Long id;

    String code;

    String description;

    String createdAt;

    SubnetModel subnet;

}
