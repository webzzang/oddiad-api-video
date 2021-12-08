package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.DeviceState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeviceStateRepository extends JpaRepository<DeviceState, String>,
  JpaSpecificationExecutor<DeviceState> {

}
