package com.diegobassay.ip.address.management.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diegobassay.ip.address.management.domain.entity.SubnetEntity;
import java.util.Optional;
import java.util.List;

@Repository
public interface SubnetRepository extends PagingAndSortingRepository<SubnetEntity, Long> {

    @Query(value = "SELECT s FROM SubnetEntity s WHERE s.id = :idSubnet")
    Optional<SubnetEntity> findById(@Param("idSubnet") Long idSubnet);

    @Query(value = "SELECT s FROM SubnetEntity s")
    Iterable<SubnetEntity> findAll();
    
}