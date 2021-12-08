package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.NoticeFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoticeFilesRepository extends JpaRepository<NoticeFiles, Long>, JpaSpecificationExecutor<NoticeFiles> {

}
