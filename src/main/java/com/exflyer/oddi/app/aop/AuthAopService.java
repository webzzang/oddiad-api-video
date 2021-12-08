package com.exflyer.oddi.app.aop;

import com.exflyer.oddi.app.annotaions.MenuCheckApi;
import com.exflyer.oddi.app.enums.CrudOperation;
import com.exflyer.oddi.app.enums.ApiResponseCodes;
import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.repository.mapper.RoleMenuMapper;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthAopService {

  @Autowired
  private RoleMenuMapper roleMenuMapper;

  public void checkAvailableMenu(ProceedingJoinPoint joinPoint, String managerId) throws ApiException {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();

    MenuCheckApi managerApiAnnotation = method.getAnnotation(MenuCheckApi.class);

    CrudOperation operation = managerApiAnnotation.operation();
    String menuCode = managerApiAnnotation.menuCode();
    boolean accessAble = false;
    Boolean createAction = false, readAction = false, updateAction = false, deleteAction = false;
    if (operation == CrudOperation.CREATE) {
      accessAble = roleMenuMapper.isCreateActionAccessAble(managerId, menuCode);
    } else if (operation == CrudOperation.READ) {
      accessAble = roleMenuMapper.isReadActionAccessAble(managerId, menuCode);
    } else if (operation == CrudOperation.UPDATE) {
      accessAble = roleMenuMapper.isUpdateActionAccessAble(managerId, menuCode);
    } else if (operation == CrudOperation.DELETE) {
      accessAble = roleMenuMapper.isDeleteActionAccessAble(managerId, menuCode);
    } else {
      throw new ApiException(ApiResponseCodes.AUTHENTIFICATION);
    }

    if (!accessAble) {
      throw new ApiException(ApiResponseCodes.AUTHENTIFICATION);
    }
  }


}
