package com.exflyer.oddi.app.sample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SampleMybatisMapperDao {

  @Select("select now() as now")
  MybatisDto nowByMapper();

}
