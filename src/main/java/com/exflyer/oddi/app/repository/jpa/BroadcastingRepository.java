package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Broadcasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BroadcastingRepository extends JpaRepository<Broadcasting, Long>,
  JpaSpecificationExecutor<Broadcasting> {

}
