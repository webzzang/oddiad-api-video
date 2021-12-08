package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Adv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdvRepository extends JpaRepository<Adv, Long>, JpaSpecificationExecutor<Adv> {

}
