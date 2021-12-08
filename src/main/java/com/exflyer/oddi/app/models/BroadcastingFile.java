package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 방송 파일
 */
@Data
@Entity
@ApiModel("방송 파일")
@Table(name = "broadcasting_file")
public class BroadcastingFile implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private BroadcastingFilePk broadcastingFilePk;

  /**
   * 생성 날짜
   */
  @ApiModelProperty("생성 날짜")
  @Column(name = "reg_date")
  private LocalDateTime regDate;

}
