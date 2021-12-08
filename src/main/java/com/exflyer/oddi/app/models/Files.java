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
 * 파일
 */
@Data
@Entity
@ApiModel("파일")
@Table(name = "files")
public class Files implements Serializable {

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
   * s3_file_key
   */
  @ApiModelProperty("s3_file_key")
  @Column(name = "s3_file_key", nullable = false)
  private String s3FileKey;

  /**
   * s3_bucket
   */
  @ApiModelProperty("s3_bucket")
  @Column(name = "s3_bucket", nullable = false)
  private String s3Bucket;

  /**
   * 경로
   */
  @ApiModelProperty("경로")
  @Column(name = "path", nullable = false)
  private String path;

  /**
   * 수정 날짜
   */
  @ApiModelProperty("수정 날짜")
  @Column(name = "reg_date", nullable = false)
  private LocalDateTime regDate;

  /**
   * 변경 날짜
   */
  @ApiModelProperty("변경 날짜")
  @Column(name = "mod_date", nullable = false)
  private LocalDateTime modDate;

  /**
   * 이름
   */
  @Column(name = "name")
  @ApiModelProperty("이름")
  private String name;

  /**
   * 확장자
   */
  @ApiModelProperty("확장자")
  @Column(name = "extension", nullable = false)
  private String extension;

  /**
   * 종류(S3, Local 등)
   */
  @Column(name = "type")
  @ApiModelProperty("종류(S3, Local 등)")
  private String type;

}
