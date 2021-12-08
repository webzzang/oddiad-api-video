package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 알림
 */
@Data
@Entity
@ApiModel("알림")
@Table(name = "notification")
public class Notification implements Serializable {

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
  @Column(name = "group_seq", nullable = false)
  private Long groupSeq;

  /**
   * 수신자 이름
   */
  @ApiModelProperty("수신자 이름")
  @Column(name = "receive_name", nullable = false)
  private String receiveName;

  /**
   * 수신자 전화 번호
   */
  @ApiModelProperty("수신자 전화 번호")
  @Column(name = "receive_phone_number", nullable = false)
  private String receivePhoneNumber;

  /**
   * 내용
   */
  @ApiModelProperty("내용")
  @Column(name = "contents", nullable = false)
  private String contents;

  /**
   * 발송 시간(즉시 일경우 0)
   */
  @ApiModelProperty("발송 시간(즉시 일경우 0)")
  @Column(name = "send_time", nullable = false)
  private String sendTime;

  /**
   * 이력 순번
   */
  @ApiModelProperty("이력 순번")
  @Column(name = "history_seq")
  private Long historySeq;

  /**
   * 발신자 id
   */
  @ApiModelProperty("발신자 id")
  @Column(name = "sender_id", nullable = false)
  private String senderId;

  /**
   * 발신자 이름
   */
  @ApiModelProperty("발신자 이름")
  @Column(name = "sender_name", nullable = false)
  private String senderName;

  /**
   * 발신자 전화 번호
   */
  @ApiModelProperty("발신자 전화 번호")
  @Column(name = "sender_phone_number")
  private String senderPhoneNumber;

}
