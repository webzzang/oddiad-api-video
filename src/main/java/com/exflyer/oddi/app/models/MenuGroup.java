package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * 메뉴 그룹
 */
@Data
@Entity
@ApiModel("메뉴 그룹")
@Table(name = "menu_group")
public class MenuGroup implements Serializable {

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
  @Column(name = "name")
  @ApiModelProperty("이름")
  private String name;

  /**
   * 아이콘
   */
  @Column(name = "icon")
  @ApiModelProperty("아이콘")
  private String icon;

  /**
   * 사용 여부
   */
  @Column(name = "using")
  @ApiModelProperty("사용 여부")
  private Integer using = 1;

  /**
   * 정렬 번호
   */
  @Column(name = "ordering")
  @ApiModelProperty("정렬 번호")
  private Integer ordering;

}
