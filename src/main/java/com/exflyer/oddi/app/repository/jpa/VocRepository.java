package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Voc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VocRepository extends JpaRepository<Voc, Long>, JpaSpecificationExecutor<Voc> {

}
