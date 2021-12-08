package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * 파트너 태그
 */
@Data
@Embeddable
public class PartnerTagsPk implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 파트너 순번
   */
  @ApiModelProperty("파트너 순번")
  @Column(name = "partner_seq", nullable = false)
  private Long partnerSeq;

  /**
   * 태그 순번
   */
  @ApiModelProperty("태그 순번")
  @Column(name = "tag_seq", nullable = false)
  private Long tagSeq;


}
