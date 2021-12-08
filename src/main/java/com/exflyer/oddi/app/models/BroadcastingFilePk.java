package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * 방송 파일
 */
@Data
@Embeddable
public class BroadcastingFilePk implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 방송 순번
   */
  @ApiModelProperty("방송 순번")
  @Column(name = "broadcasting_seq", nullable = false)
  private Long broadcastingSeq;

  /**
   * 파일 순번
   */
  @ApiModelProperty("파일 순번")
  @Column(name = "adv_file_seq")
  private Long advFileSeq;

}
