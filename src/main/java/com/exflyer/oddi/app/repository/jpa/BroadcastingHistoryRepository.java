package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.BroadcastingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BroadcastingHistoryRepository extends JpaRepository<BroadcastingHistory, Long>,
  JpaSpecificationExecutor<BroadcastingHistory> {

}
