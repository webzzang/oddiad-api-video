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
 * 배너
 */
@Data
@Entity
@ApiModel("배너")
@Table(name = "banner")
public class Banner implements Serializable {

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
   * 종류(web, device)
   */
  @ApiModelProperty("종류(web, device)")
  @Column(name = "type", nullable = false)
  private String type;

  /**
   * 위치 코드(우측, 상단, 하단, 팝업)
   */
  @ApiModelProperty("위치 코드(우측, 상단, 하단, 팝업)")
  @Column(name = "location_code", nullable = false)
  private String locationCode;

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
  @Column(name = "image_path", nullable = false)
  private String imagePath;

  /**
   * 사용 여부
   */
  @ApiModelProperty("사용 여부")
  @Column(name = "using", nullable = false)
  private Integer using;

  /**
   * 노출 시작 날짜
   */
  @ApiModelProperty("노출 시작 날짜")
  @Column(name = "expo_start_date", nullable = false)
  private String expoStartDate;

  /**
   * 노출 종료 날짜
   */
  @ApiModelProperty("노출 종료 날짜")
  @Column(name = "expo_end_date", nullable = false)
  private String expoEndDate;

  /**
   * 메모
   */
  @Column(name = "memo")
  @ApiModelProperty("메모")
  private String memo;

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

  /**
   * 라우터 링크
   */
  @ApiModelProperty("라우터 링크")
  @Column(name = "router_link")
  private String routerLink;

  /**
   * 버튼 이름
   */
  @ApiModelProperty("버튼 이름")
  @Column(name = "button_name")
  private String buttonName;

}
