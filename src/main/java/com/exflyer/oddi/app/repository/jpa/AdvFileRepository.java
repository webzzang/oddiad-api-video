package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.AdvFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdvFileRepository extends JpaRepository<AdvFile, String>, JpaSpecificationExecutor<AdvFile> {

}
