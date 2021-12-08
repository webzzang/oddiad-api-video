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
 * 파트너
 */
@Data
@Entity
@ApiModel("파트너")
@Table(name = "partner")
public class Partner implements Serializable {

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
   * 종류(오디존, 지하철)
   */
  @Column(name = "type")
  @ApiModelProperty("종류(오디존, 지하철)")
  private String type;

  /**
   * 매장 이름
   */
  @ApiModelProperty("매장 이름")
  @Column(name = "mall_name")
  private String mallName;

  /**
   * 주소
   */
  @Column(name = "addr")
  @ApiModelProperty("주소")
  private String addr;

  /**
   * 상세 주소
   */
  @ApiModelProperty("상세 주소")
  @Column(name = "detail_addr")
  private String detailAddr;

  /**
   * 소유자 이름
   */
  @ApiModelProperty("소유자 이름")
  @Column(name = "owner_name")
  private String ownerName;

  /**
   * 소유자 전화 번호
   */
  @ApiModelProperty("소유자 전화 번호")
  @Column(name = "owner_phone_number")
  private String ownerPhoneNumber;

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
   * 이름
   */
  @ApiModelProperty("이름")
  @Column(name = "mod_id", nullable = false)
  private String modId;

  /**
   * 설명
   */
  @ApiModelProperty("설명")
  @Column(name = "description")
  private String description;

  /**
   * 이미지 경로
   */
  @ApiModelProperty("이미지 경로")
  @Column(name = "image_path")
  private String imagePath;

  /**
   * 라이브 스트리밍 노출 여부
   */
  @ApiModelProperty("라이브 스트리밍 노출 여부")
  @Column(name = "live_streaming_expo")
  private Integer liveStreamingExpo;

  /**
   * 운영 여부
   */
  @ApiModelProperty("운영 여부")
  @Column(name = "operation")
  private Integer operation;

  /**
   * 메모
   */
  @Column(name = "memo")
  @ApiModelProperty("메모")
  private String memo;

  /**
   * 총 슬롯
   */
  @ApiModelProperty("총 슬롯")
  @Column(name = "total_slot", nullable = false)
  private Integer totalSlot;

  /**
   * 슬롯당 노출 시간
   */
  @ApiModelProperty("슬롯당 노출 시간")
  @Column(name = "slot_video_time", nullable = false)
  private BigDecimal slotVideoTime;

  /**
   * 슬롯당 금액
   */
  @ApiModelProperty("슬롯당 금액")
  @Column(name = "slot_price", nullable = false)
  private BigDecimal slotPrice;

  /**
   * 운영 요일
   */
  @ApiModelProperty("운영 요일")
  @Column(name = "operation_week")
  private String operationWeek;

  /**
   * 운영 시작 시간
   */
  @ApiModelProperty("운영 시작 시간")
  @Column(name = "operation_start_time")
  private String operationStartTime;

  /**
   * 운영 종료 시간
   */
  @ApiModelProperty("운영 종료 시간")
  @Column(name = "operation_end_time")
  private String operationEndTime;

  /**
   * 일 노출 카운트
   */
  @ApiModelProperty("일 노출 카운트")
  @Column(name = "day_expo_count", nullable = false)
  private Integer dayExpoCount;

  /**
   * 지하철 노선
   */
  @ApiModelProperty("지하철 노선")
  @Column(name = "subway_line")
  private String subwayLine;

  /**
   * 위치(지하철 광고 위치)
   */
  @Column(name = "location")
  @ApiModelProperty("위치(지하철 광고 위치)")
  private String location;

  /**
   * 화면(지하철 광고 화면)
   */
  @Column(name = "display")
  @ApiModelProperty("화면(지하철 광고 화면)")
  private String display;

}
