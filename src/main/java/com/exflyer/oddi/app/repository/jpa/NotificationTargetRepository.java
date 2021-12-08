package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.NotificationTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationTargetRepository extends JpaRepository<NotificationTarget, Long>,
  JpaSpecificationExecutor<NotificationTarget> {

}
