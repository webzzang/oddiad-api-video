package com.exflyer.oddi.app.aop;


import com.exflyer.oddi.app.enums.ApiResponseCodes;
import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.jwt.dto.JwtVerifyResult;
import com.exflyer.oddi.app.jwt.service.JwtService;
import com.exflyer.oddi.app.models.Manager;
import com.exflyer.oddi.app.repository.jpa.ManagerRepository;
import com.exflyer.oddi.app.repository.mapper.RoleMenuMapper;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class AuthAop {

  public static final int SYSTEM_MANAGER = 1;
  @Autowired
  private JwtService jwtService;

  @Autowired
  private ManagerRepository managerRepository;

  @Autowired
  private RoleMenuMapper roleMenuMapper;

  @Autowired
  private AuthAopService authAopService;

  /**
   *
   */
  @Around("@annotation(com.exflyer.oddi.app.annotaions.MenuCheckApi)")
  public Object validManagerToken(ProceedingJoinPoint joinPoint) throws Throwable {

    return createMethodArgs(joinPoint, true);
  }

  private Object createMethodArgs(ProceedingJoinPoint joinPoint, boolean needValidCheckMenu) throws Throwable {
    String accessToken = extractAccessToken();
    JwtVerifyResult jwtVerifyResult = jwtService.verify(accessToken);
    Manager manager = managerRepository.findById(jwtVerifyResult.getId()).orElseGet(null);
    if (manager == null) {
      throw new ApiException(ApiResponseCodes.AUTHENTIFICATION);
    }

    // 시스템 관리자이거나 메뉴 체크 권한이 필요한 요청(ManagerSkipValidMenuApi)
    if (manager.getRoleSeq() != SYSTEM_MANAGER && needValidCheckMenu) {
      authAopService.checkAvailableMenu(joinPoint, jwtVerifyResult.getId());
    }
    AopValidManager aopValidManager = new AopValidManager(jwtVerifyResult);

    // API or Controller 에 인증 된 사용자 정보 전달
    Object[] args = setApiMethodArgs(joinPoint, aopValidManager);

    return joinPoint.proceed(args);
  }

  /**
   * 인증이 필요 없는 API 일 경우
   */
  @Around("@annotation(com.exflyer.oddi.app.annotaions.MenuCheckSkipApi)")
  public Object validateSkipAdmin(ProceedingJoinPoint joinPoint) throws Throwable {
    return createMethodArgs(joinPoint, false);
  }

  private String extractAccessToken() throws ApiException {
    HttpServletRequest request = getHttpServletRequest();
    String accessTokenHeader = request.getHeader("x-access-token");
    if (StringUtils.isBlank(accessTokenHeader)) {
      log.info(">>>> accessTokenHeader blank");
      throw new ApiException(ApiResponseCodes.AUTHENTIFICATION);
    }
    return accessTokenHeader;
  }

  private Object[] setApiMethodArgs(ProceedingJoinPoint joinPoint, AopValidManager aopValidManager) {

    return Arrays.stream(joinPoint.getArgs())
      .map(
        data -> {
          if (data instanceof AopValidManager) {
            data = aopValidManager;
          }
          return data;
        })
      .toArray();
  }

  private HttpServletRequest getHttpServletRequest() {
    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  }

}
