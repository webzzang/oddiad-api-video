package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.DeviceStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeviceStateHistoryRepository extends JpaRepository<DeviceStateHistory, Long>,
  JpaSpecificationExecutor<DeviceStateHistory> {

}
