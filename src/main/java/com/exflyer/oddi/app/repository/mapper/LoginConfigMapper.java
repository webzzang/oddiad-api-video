package com.exflyer.oddi.app.repository.mapper;

import com.exflyer.oddi.app.share.dto.OddiLoginConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginConfigMapper {

  OddiLoginConfig find();
}
