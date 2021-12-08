package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.LiveStreaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LiveStreamingRepository extends JpaRepository<LiveStreaming, Long>,
  JpaSpecificationExecutor<LiveStreaming> {

}
