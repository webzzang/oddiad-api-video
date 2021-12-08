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
 * voc
 */
@Data
@Entity
@ApiModel("voc")
@Table(name = "voc")
public class Voc implements Serializable {

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
   * 회원 id
   */
  @ApiModelProperty("회원 id")
  @Column(name = "member_id", nullable = false)
  private String memberId;

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
   * 등록날짜
   */
  @ApiModelProperty("등록날짜")
  @Column(name = "reg_date", nullable = false)
  private LocalDateTime regDate;

  /**
   * 답변
   */
  @ApiModelProperty("답변")
  @Column(name = "answer")
  private String answer;

  /**
   * 답변 생성 날짜
   */
  @ApiModelProperty("답변 생성 날짜")
  @Column(name = "answer_reg_date")
  private LocalDateTime answerRegDate;

  /**
   * 답변 생성 id
   */
  @ApiModelProperty("답변 생성 id")
  @Column(name = "answer_reg_id")
  private String answerRegId;

}
