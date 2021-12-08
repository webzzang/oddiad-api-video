package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.PartnerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartnerRequestRepository extends JpaRepository<PartnerRequest, Long>,
  JpaSpecificationExecutor<PartnerRequest> {

}
