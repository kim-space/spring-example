package com.kimtd.advice;

import com.kimtd.datasource.DataSourceSwitcher;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class DataSourceAdvice implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice {

    private static final String splite_comm = ",";

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAdvice.splite_comm);

    private String persistenceMethodPrefix;


    /* 判断当前方法是否为持久化方法*/
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("当前数据源 "+ DataSourceSwitcher.getDataSource());
        if (this.isPersitenceMethod(method.getName())){
            LOGGER.info("当前为之久化操作，切换主数据源 {}",method.getName());
            DataSourceSwitcher.setMaster();
        }else {
            DataSourceSwitcher.setSlave();
            LOGGER.info("切换从数据源 {}",method.getName());
        }
    }

    //是否为持久化方法
    private Boolean isPersitenceMethod(String methodName){
        Boolean flag = false;
        if (StringUtils.isNotBlank(methodName) && StringUtils.isNotBlank(this.getPersistenceMethodPrefix())){
            final String[] prefixes = this.getPersistenceMethodPrefix().split(splite_comm);
            for (String prefix : prefixes){
                if (methodName.startsWith(prefix)){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

    }

    //异常Advice
    public void afterThrowing(Method method, Object[] os, Object
            target, Exception e){
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("切换主从数据库异常！已默认切换到slave!", e);
        }
    }

    public String getPersistenceMethodPrefix() {
        return persistenceMethodPrefix;
    }

    public void setPersistenceMethodPrefix(String persistenceMethodPrefix) {
        this.persistenceMethodPrefix = persistenceMethodPrefix;
    }

}
