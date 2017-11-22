
package com.kimtd.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Lazy(false)
@Component("springUtils")
public final class SpringUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	private SpringUtils() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		Assert.hasText(name);

		return applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> type) {
		Assert.notNull(type);

		return applicationContext.getBean(type);
	}

	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);

		return applicationContext.getBean(name, type);
	}





}