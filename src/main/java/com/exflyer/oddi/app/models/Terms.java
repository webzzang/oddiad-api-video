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
 * 약관
 */
@Data
@Entity
@ApiModel("약관")
@Table(name = "terms")
public class Terms implements Serializable {

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
   * 그룹 순번
   */
  @ApiModelProperty("그룹 순번")
  @Column(name = "group_seq")
  private Long groupSeq;

  /**
   * 제목
   */
  @Column(name = "title")
  @ApiModelProperty("제목")
  private String title;

  /**
   * 내용
   */
  @ApiModelProperty("내용")
  @Column(name = "contents")
  private String contents;

  /**
   * 생성 날짜
   */
  @ApiModelProperty("생성 날짜")
  @Column(name = "reg_date", nullable = false)
  private LocalDateTime regDate;

  /**
   * 생성 id
   */
  @ApiModelProperty("생성 id")
  @Column(name = "reg_id", nullable = false)
  private String regId;

  /**
   * 변경 날짜
   */
  @ApiModelProperty("변경 날짜")
  @Column(name = "mod_date", nullable = false)
  private LocalDateTime modDate;

  /**
   * 변경 id
   */
  @ApiModelProperty("변경 id")
  @Column(name = "mod_id", nullable = false)
  private String modId;

}
