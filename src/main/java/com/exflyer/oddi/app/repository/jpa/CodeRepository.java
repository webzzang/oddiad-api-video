package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CodeRepository extends JpaRepository<Code, String>, JpaSpecificationExecutor<Code> {

}
