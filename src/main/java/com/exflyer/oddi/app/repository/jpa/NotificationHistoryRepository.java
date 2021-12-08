package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.NotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationHistoryRepository extends JpaRepository<NotificationHistory, Long>,
  JpaSpecificationExecutor<NotificationHistory> {

}
