package com.diegobassay.ip.address.management.controller.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ip_table")
public class IptableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotEmpty
    @Column(name = "ip")
    String code;

    @NotEmpty
    @Column(name = "device")
    String description;

    @Column(name = "created_at")
    String createdAt;

    @OneToOne(mappedBy = "ip")
    private SubnetEntity subnet;

}
