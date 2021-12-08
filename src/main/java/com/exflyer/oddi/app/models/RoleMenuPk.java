package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 * 역활 메뉴
 */
@Data
@Embeddable
public class RoleMenuPk implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 메뉴 id
   */
  @ApiModelProperty("메뉴 id")
  @Column(name = "menu_id", nullable = false)
  private String menuId;

  /**
   * 역활 순번
   */
  @ApiModelProperty("역활 순번")
  @Column(name = "role_seq", nullable = false)
  private Long roleSeq;


}
