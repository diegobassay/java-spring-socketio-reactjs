package com.diegobassay.ip.address.management.domain.entity;
import com.diegobassay.ip.address.management.domain.model.IptableModel;

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

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ip_table")
public class IptableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotEmpty
    @Column(name = "ip")
    String ip;

    @NotEmpty
    @Column(name = "device")
    String device;

    @Column(name = "created_at")
    String createdAt;

    @OneToOne(mappedBy = "ip")
    private SubnetEntity subnet;

    public static IptableEntity toEntity(IptableModel model) {
        if(model == null)
            return null;

        return IptableEntity.builder()
                .id(model.getId())
                .ip(model.getIp())
                .device(model.getDevice())
                .createdAt(model.getCreatedAt())
                .build();
    }

}
