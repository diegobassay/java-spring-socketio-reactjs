package com.diegobassay.ip.address.management.domain.entity;
import com.diegobassay.ip.address.management.domain.model.SubnetModel;

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
import lombok.Builder;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subnet")
public class SubnetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotEmpty
    @Column(name = "name")
    String name;

    @NotEmpty
    @Column(name = "description")
    String description;

    @Column(name = "created_at")
    String createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iptable_id", referencedColumnName = "id")
    IptableEntity ip;


    public static SubnetEntity toEntity(SubnetModel model) {
        if(model == null)
            return null;

        return SubnetEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .build();
    }

}
