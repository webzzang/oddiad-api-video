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
 * 알림_group
 */
@Data
@Entity
@ApiModel("알림_group")
@Table(name = "notification_group")
public class NotificationGroup implements Serializable {

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
   * 대상 코드(전체, 광고주, 커스텀 등))
   */
  @Column(name = "target_code")
  @ApiModelProperty("대상 코드(전체, 광고주, 커스텀 등))")
  private String targetCode;

  /**
   * 내용
   */
  @ApiModelProperty("내용")
  @Column(name = "contents")
  private String contents;

  /**
   * 광고 메세지 여부
   */
  @Column(name = "adv_message")
  @ApiModelProperty("광고 메세지 여부")
  private Integer advMessage;

  /**
   * 발송 시간(즉시 일경우 0)
   */
  @Column(name = "send_time")
  @ApiModelProperty("발송 시간(즉시 일경우 0)")
  private String sendTime;

  /**
   * 자동 여부
   */
  @ApiModelProperty("자동 여부")
  @Column(name = "auto", nullable = false)
  private Integer auto = 0;

  /**
   * 성공 카운트
   */
  @ApiModelProperty("성공 카운트")
  @Column(name = "success_count")
  private BigDecimal successCount;

  /**
   * 실패 카운트
   */
  @ApiModelProperty("실패 카운트")
  @Column(name = "fail_count")
  private BigDecimal failCount;

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

}
