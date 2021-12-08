package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.LiveSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LiveScheduleRepository extends JpaRepository<LiveSchedule, Long>,
  JpaSpecificationExecutor<LiveSchedule> {

}
