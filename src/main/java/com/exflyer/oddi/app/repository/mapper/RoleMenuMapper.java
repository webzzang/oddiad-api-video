package com.exflyer.oddi.app.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMenuMapper {

  boolean isCreateActionAccessAble(@Param("managerId") String managerId, @Param("menuCode") String menuCode);

  boolean isReadActionAccessAble(@Param("managerId") String managerId, @Param("menuCode") String menuCode);

  boolean isUpdateActionAccessAble(@Param("managerId") String managerId, @Param("menuCode") String menuCode);

  boolean isDeleteActionAccessAble(@Param("managerId") String managerId, @Param("menuCode") String menuCode);
}
