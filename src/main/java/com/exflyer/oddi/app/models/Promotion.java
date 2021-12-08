package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 프로모션
 */
@Data
@Entity
@ApiModel("프로모션")
@Table(name = "promotion")
public class Promotion implements Serializable {

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
   * 이름
   */
  @ApiModelProperty("이름")
  @Column(name = "name", nullable = false)
  private String name;

  /**
   * 종류(가입, 일반 등)
   */
  @ApiModelProperty("종류(가입, 일반 등)")
  @Column(name = "type", nullable = false)
  private String type;

  /**
   * 할인 종류(정액, 정률)
   */
  @ApiModelProperty("할인 종류(정액, 정률)")
  @Column(name = "discount_type", nullable = false)
  private String discountType;

  /**
   * 할인 금액
   */
  @ApiModelProperty("할인 금액")
  @Column(name = "discount_price", nullable = false)
  private BigDecimal discountPrice;

  /**
   * 내용
   */
  @ApiModelProperty("내용")
  @Column(name = "contents", nullable = false)
  private String contents;

  /**
   * 사용 여부
   */
  @ApiModelProperty("사용 여부")
  @Column(name = "using", nullable = false)
  private Integer using = 1;

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
  @Column(name = "mod_date")
  @ApiModelProperty("변경 날짜")
  private LocalDateTime modDate;

  /**
   * 변경 id
   */
  @Column(name = "mod_id")
  @ApiModelProperty("변경 id")
  private String modId;

}
