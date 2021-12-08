package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.NotificationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationGroupRepository extends JpaRepository<NotificationGroup, Long>,
  JpaSpecificationExecutor<NotificationGroup> {

}
