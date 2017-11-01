package com.mit.app;

import javax.servlet.DispatcherType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 
 * @author TinnyLe
 *
 */

@SpringBootApplication
@Lazy
@ComponentScan(basePackages = { "com.mit.app", "com.mit.controllers" })
public class Application {
	public static Environment EnvConfig;
	public static ApplicationContext AppCtx;
	@Value("${site.prefix}")
	private String sitePrefix;
	@Value("${site.resources.path}")
	private String resourcesPath;
	@Value("${site.resources}")
	private String resources;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EnvConfig = ctx.getEnvironment();
		AppCtx = ctx;
		System.out.println("Start server");
	}

	@Bean
	public MultipartResolver multiPartResolver() {
		return new CommonsMultipartResolver();
	}

//	@Bean
//	public SessionManager sessionGenerator() {
//		SessionManager sessionGenerator = new SessionManagerImpl();
//		return sessionGenerator;
//	}
//
//	@Bean
//	public StringRedisSerializer stringRedisSerializer() {
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		return stringRedisSerializer;
//	}
//
//	@Bean
//	public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer() {
//		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer = new GenericJackson2JsonRedisSerializer();
//		return genericJackson2JsonRedisJsonSerializer;
//	}
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory,
//			StringRedisSerializer stringRedisSerializer,
//			GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer) {
//		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(connectionFactory);
//		redisTemplate.setExposeConnection(true);
//		redisTemplate.setKeySerializer(stringRedisSerializer);
//		redisTemplate.setValueSerializer(genericJackson2JsonRedisJsonSerializer);
//		redisTemplate.afterPropertiesSet();
//		return redisTemplate;
//	}
//
//	@Bean
//	public Cache cache(RedisTemplate<String, Object> redisTemplate) {
//		Cache cache = new RedisCache(redisTemplate);
//		return cache;
//	}

	@Bean
	public FilterRegistrationBean swaggerFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new MyUrlRewriteFilter());
		registration.addUrlPatterns("/swagger/*");
		registration.addUrlPatterns(sitePrefix + "/*");
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setOrder(2);
		return registration;
	}

//	@Bean
//	public FilterRegistrationBean registrationLogging() {
//		Filter filter = new LoggingFilter();
//		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//		registration.addUrlPatterns("/*");
//		registration.setDispatcherTypes(DispatcherType.REQUEST);
//		registration.setOrder(3);
//		return registration;
//	}
//
//	@Bean
//	public FilterRegistrationBean authenticationRequest(SessionManagerImpl sessionManager) {
//		SiteAuthenticationFilter<UserSession> filter = new SiteAuthenticationFilter<>(sessionManager);
//		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//		registration.addUrlPatterns("/*");
//		registration.addInitParameter("excludePatterns", StringUtils.join(new String[]{sitePrefix + "/index", sitePrefix + "/product", sitePrefix + "/login", sitePrefix + "/register", sitePrefix + "/contactus", resourcesPath, "/favicon.ico", "/swagger", }, ","));
//		registration.addInitParameter("profileClass", Profile.class.getSimpleName());
//		registration.addInitParameter("unauthUri", sitePrefix + "/login");
//		registration.setDispatcherTypes(DispatcherType.REQUEST);
//		registration.setOrder(1);
//		return registration;
//	}

}
