package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 파트너 태그
 */
@Data
@Entity
@ApiModel("파트너 태그")
@Table(name = "partner_tags")
public class PartnerTags implements Serializable {

  private static final long serialVersionUID = 1L;


  @EmbeddedId
  private PartnerTagsPk partnerTagsPk;
  /**
   * 생성 날짜
   */
  @ApiModelProperty("생성 날짜")
  @Column(name = "reg_date", nullable = false)
  private LocalDateTime regDate;

}
