package com.sor.CCRM.repository;

import com.sor.CCRM.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // Add custom query methods if needed
}
