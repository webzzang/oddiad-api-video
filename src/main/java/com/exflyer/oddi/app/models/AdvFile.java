package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 광고 파일
 */
@Data
@Entity
@ApiModel("광고 파일")
@Table(name = "adv_file")
public class AdvFile implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 순번
   */
  @Id
  @ApiModelProperty("순번")
  @Column(name = "seq", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  /**
   * 광고 순번
   */
  @ApiModelProperty("광고 순번")
  @Column(name = "adv_seq", nullable = false)
  private Long advSeq;

  /**
   * 파일 순번
   */
  @ApiModelProperty("파일 순번")
  @Column(name = "file_url", nullable = false)
  private String fileUrl;

  /**
   * 수정 날짜
   */
  @ApiModelProperty("수정 날짜")
  @Column(name = "reg_date", nullable = false)
  private LocalDateTime regDate;

  /**
   * 썸네일 url
   */
  @ApiModelProperty("썸네일 url")
  @Column(name = "thumnail_url", nullable = false)
  private String thumnailUrl;

  /**
   * 종류(doc, image, video)
   */
  @Column(name = "type", nullable = false)
  @ApiModelProperty("종류(doc, image, video)")
  private String type;

  /**
   * 파일 순번
   */
  @Column(name = "file_seq")
  @ApiModelProperty("파일 순번")
  private Long fileSeq;

}
