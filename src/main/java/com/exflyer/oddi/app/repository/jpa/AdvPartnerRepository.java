package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.AdvPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdvPartnerRepository extends JpaRepository<AdvPartner, Long>, JpaSpecificationExecutor<AdvPartner> {

}
