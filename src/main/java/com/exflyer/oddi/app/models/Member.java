package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 회원(광고주) 정보
 */
@Data
@Entity
@Table(name = "member")
@ApiModel("회원(광고주) 정보")
public class Member implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * id
   */
  @Id
  @ApiModelProperty("id")
  @Column(name = "id", nullable = false)
  private String id;

  /**
   * 이름
   */
  @ApiModelProperty("이름")
  @Column(name = "name", nullable = false)
  private String name;

  /**
   * 비밀번호
   */
  @ApiModelProperty("비밀번호")
  @Column(name = "password", nullable = false)
  private String password;

  /**
   * 전화번호
   */
  @ApiModelProperty("전화번호")
  @Column(name = "phone_number")
  private String phoneNumber;

  /**
   * 수신 동의
   */
  @ApiModelProperty("수신 동의")
  @Column(name = "receive_consent", nullable = false)
  private Integer receiveConsent = 0;

  /**
   * 약관 동의 여부
   */
  @ApiModelProperty("약관 동의 여부")
  @Column(name = "terms_consent", nullable = false)
  private Integer termsConsent = 0;

  /**
   * 인증 코드
   */
  @ApiModelProperty("인증 코드")
  @Column(name = "auth_code", nullable = false)
  private String authCode;

  /**
   * 가입 날짜
   */
  @ApiModelProperty("가입 날짜")
  @Column(name = "signup_date", nullable = false)
  private LocalDateTime signupDate;

  /**
   * 변경 날짜
   */
  @ApiModelProperty("변경 날짜")
  @Column(name = "mod_date", nullable = false)
  private LocalDateTime modDate;

  /**
   * 대표
   */
  @Column(name = "ceo")
  @ApiModelProperty("대표")
  private String ceo;

  /**
   * 사업자 등록증 번호
   */
  @ApiModelProperty("사업자 등록증 번호")
  @Column(name = "business_license_number")
  private String businessLicenseNumber;

  /**
   * 사업자 등록증 파일
   */
  @ApiModelProperty("사업자 등록증 파일")
  @Column(name = "business_license_file")
  private Long businessLicenseFile;

  /**
   * 휴면 여부
   */
  @ApiModelProperty("휴면 여부")
  @Column(name = "sleep", nullable = false)
  private Integer sleep = 0;

}
