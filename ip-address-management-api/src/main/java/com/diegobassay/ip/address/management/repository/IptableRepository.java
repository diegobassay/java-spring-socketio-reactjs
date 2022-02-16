package com.diegobassay.ip.address.management.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.diegobassay.ip.address.management.domain.entity.IptableEntity;
import java.util.Optional;
import java.util.List;

@Repository
public interface IptableRepository extends PagingAndSortingRepository<IptableEntity, Long> {
    
    @Query(value = "SELECT i FROM IptableEntity i WHERE i.id = :idIptable")
    Optional<IptableEntity> findById(@Param("idIptable") Long idIptable);

    @Query(value = "SELECT i FROM IptableEntity i")
    Iterable<IptableEntity> findAll();
    
}