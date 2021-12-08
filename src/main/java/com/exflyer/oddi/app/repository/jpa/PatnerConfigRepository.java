package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.PartnerConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PatnerConfigRepository extends JpaRepository<PartnerConfig, Integer>,
  JpaSpecificationExecutor<PartnerConfig> {

}
