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
 * 공지
 */
@Data
@Entity
@ApiModel("공지")
@Table(name = "notice")
public class Notice implements Serializable {

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
   * 카테고리 코드
   */
  @ApiModelProperty("카테고리 코드")
  @Column(name = "category_code", nullable = false)
  private String categoryCode;

  /**
   * 제목
   */
  @ApiModelProperty("제목")
  @Column(name = "title", nullable = false)
  private String title;

  /**
   * 내용
   */
  @ApiModelProperty("내용")
  @Column(name = "contents", nullable = false)
  private String contents;

  /**
   * 노출 여부
   */
  @ApiModelProperty("노출 여부")
  @Column(name = "expo", nullable = false)
  private Integer expo = 1;

  /**
   * 상단 위치 여부
   */
  @ApiModelProperty("상단 위치 여부")
  @Column(name = "top_location", nullable = false)
  private Integer topLocation = 0;

  /**
   * 등록 날짜
   */
  @ApiModelProperty("등록 날짜")
  @Column(name = "reg_date", nullable = false)
  private LocalDateTime regDate;

  /**
   * 등록 id
   */
  @ApiModelProperty("등록 id")
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
