package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.VocFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VocFileRepository extends JpaRepository<VocFile, Long>, JpaSpecificationExecutor<VocFile> {

}
