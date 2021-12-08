package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuGroupRepository extends JpaRepository<MenuGroup, String>, JpaSpecificationExecutor<MenuGroup> {

}
