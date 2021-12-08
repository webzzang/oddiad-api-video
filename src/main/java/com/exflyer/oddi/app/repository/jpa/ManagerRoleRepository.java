package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.ManagerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ManagerRoleRepository extends JpaRepository<ManagerRole, Long>, JpaSpecificationExecutor<ManagerRole> {

}
