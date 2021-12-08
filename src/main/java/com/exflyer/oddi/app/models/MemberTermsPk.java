package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * 고객 약관 동의
 */
@Data
@Embeddable
public class MemberTermsPk implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 회원 id
   */
  @ApiModelProperty("회원 id")
  @Column(name = "member_id", nullable = false)
  private String memberId;

  /**
   * 약관 그룹 순번
   */
  @ApiModelProperty("약관 그룹 순번")
  @Column(name = "terms_group_seq", nullable = false)
  private Long termsGroupSeq;

}
