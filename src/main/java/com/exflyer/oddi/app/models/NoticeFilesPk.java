package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * 공지 파일
 */
@Data
@Embeddable
public class NoticeFilesPk implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 순번
   */
  @ApiModelProperty("순번")
  @Column(name = "notice_seq", nullable = false)
  private Long noticeSeq;

  /**
   * 파일 순번
   */
  @ApiModelProperty("파일 순번")
  @Column(name = "file_seq", nullable = false)
  private Long fileSeq;

}
