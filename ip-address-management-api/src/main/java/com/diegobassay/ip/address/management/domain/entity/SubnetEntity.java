package com.diegobassay.ip.address.management.controller.domain.entity;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.CascadeType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subnet")
public class SubnetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotEmpty
    @Column(name = "name")
    String code;

    @NotEmpty
    @Column(name = "description")
    String description;

    @Column(name = "created_at")
    String createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iptable_id", referencedColumnName = "id")
    IptableEntity ip;

}
