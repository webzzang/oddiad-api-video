package com.exflyer.oddi.app.repository.jpa;

import com.exflyer.oddi.app.models.PartnerTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartnerTagsRepository extends JpaRepository<PartnerTags, Long>, JpaSpecificationExecutor<PartnerTags> {

}
