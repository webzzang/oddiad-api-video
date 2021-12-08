package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.BroadcastingFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BroadcastingFileRepository extends JpaRepository<BroadcastingFile, Long>,
  JpaSpecificationExecutor<BroadcastingFile> {

}
