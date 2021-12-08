package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 파트너 설정
 */
@Data
@Entity
@ApiModel("파트너 설정")
@Table(name = "partner_config")
public class PartnerConfig implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 슬롯 카운트
   */
  @Id
  @ApiModelProperty("슬롯 카운트")
  @Column(name = "slot_count", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer slotCount;

  /**
   * 슬롯 영상 시간
   */
  @ApiModelProperty("슬롯 영상 시간")
  @Column(name = "slot_video_time")
  private BigDecimal slotVideoTime;

  /**
   * 디자인 요청 여부
   */
  @ApiModelProperty("디자인 요청 여부")
  @Column(name = "design_request")
  private Integer designRequest;

  /**
   * 화면 분할(1, 2, 3분할)
   */
  @Column(name = "display_div")
  @ApiModelProperty("화면 분할(1, 2, 3분할)")
  private Integer displayDiv;

  /**
   * 측면 화면 서비스 코드
   */
  @ApiModelProperty("측면 화면 서비스 코드")
  @Column(name = "side_display_service_code")
  private String sideDisplayServiceCode;

  /**
   * 하단 화면 서비스 코드
   */
  @ApiModelProperty("하단 화면 서비스 코드")
  @Column(name = "bottom_display_service_code")
  private String bottomDisplayServiceCode;

  /**
   * 기본 광고 파일 순번
   */
  @ApiModelProperty("기본 광고 파일 순번")
  @Column(name = "default_adv_file_seq")
  private Long defaultAdvFileSeq;

  /**
   * 종류(오디존, 지하철)
   */
  @Column(name = "type")
  @ApiModelProperty("종류(오디존, 지하철)")
  private String type;

}
