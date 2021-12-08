package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ManagerRepository extends JpaRepository<Manager, String>, JpaSpecificationExecutor<Manager> {


}
