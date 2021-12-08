package com.exflyer.oddi.app.models;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 공지 파일
 */
@Data
@Entity
@ApiModel("공지 파일")
@Table(name = "notice_files")
public class NoticeFiles implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private NoticeFilesPk noticeFilesPk;

  private LocalDateTime regDate;

}
