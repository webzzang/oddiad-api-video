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
 * 역활 메뉴
 */
@Data
@Entity
@ApiModel("역활 메뉴")
@Table(name = "role_menu")
public class RoleMenu implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private RoleMenuPk roleMenuPk;

  /**
   * 생성 권한
   */
  @ApiModelProperty("생성 권한")
  @Column(name = "reg_authority", nullable = false)
  private Integer regAuthority;

  /**
   * 조회 권한
   */
  @ApiModelProperty("조회 권한")
  @Column(name = "search_authority", nullable = false)
  private Integer searchAuthority;

  /**
   * 수정 권한
   */
  @ApiModelProperty("수정 권한")
  @Column(name = "mod_authority", nullable = false)
  private Integer modAuthority;

  /**
   * 삭제 권한
   */
  @ApiModelProperty("삭제 권한")
  @Column(name = "del_authority", nullable = false)
  private Integer delAuthority;

  /**
   * 생성 날짜
   */
  @Column(name = "reg_date")
  @ApiModelProperty("생성 날짜")
  private LocalDateTime regDate;

  /**
   * 생성 id
   */
  @Column(name = "reg_id")
  @ApiModelProperty("생성 id")
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

}
