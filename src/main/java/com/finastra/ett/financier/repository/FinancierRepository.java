package com.finastra.ett.financier.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.ett.financier.model.*;


@Repository
public interface FinancierRepository extends JpaRepository<Financier, Long>{
    
}
