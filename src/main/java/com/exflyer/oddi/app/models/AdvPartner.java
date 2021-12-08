package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import lombok.Data;

/**
 * 광고_광고처
 */
@Data
@Entity
@ApiModel("광고_광고처")
@Table(name = "adv_partner")
public class AdvPartner implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private AdvPartnerPk advPartnerPk;

  /**
   * 광고 슬롯
   */
  @ApiModelProperty("광고 슬롯")
  @Column(name = "request_slot", nullable = false)
  private Integer requestSlot;

}
