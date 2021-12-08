package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationRepository extends JpaRepository<Notification, Long>,
  JpaSpecificationExecutor<Notification> {

}
