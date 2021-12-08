package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.DeviceControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeviceControlRepository extends JpaRepository<DeviceControl, Long>,
  JpaSpecificationExecutor<DeviceControl> {

}
