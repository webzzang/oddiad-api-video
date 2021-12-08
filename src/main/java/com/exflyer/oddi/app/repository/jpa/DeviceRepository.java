package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DeviceRepository extends JpaRepository<Device, String>, JpaSpecificationExecutor<Device> {

}
