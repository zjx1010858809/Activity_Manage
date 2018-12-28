package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.situ.filter.loginFilter;
import com.situ.utils.RandomCode;

@SpringBootApplication
@MapperScan("com.situ.mapper")
public class application {

	public static void main(String[] args) {
		new mainWin(args);
		// SpringApplication.run(application.class, args);
	}

	@Bean
	public ServletRegistrationBean imageServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean();
		registration.setServlet(new RandomCode());
		registration.setName("img");
		registration.addUrlMappings("/images/code.jpg");
		return registration;
	}

	@Bean
	public FilterRegistrationBean loginFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new loginFilter());
		registration.addUrlPatterns("/*");
		registration.setName("login");
		registration.setOrder(2);
		return registration;
	}

	// Filter-characterEncodingFilter
	@Bean
	public FilterRegistrationBean characterEncodingFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CharacterEncodingFilter());
		registration.addUrlPatterns("/*");
		registration.setName("characterEncodingFilter");
		registration.addInitParameter("encoding", "UTF-8");
		registration.addInitParameter("forceEncoding", "true");
		registration.setOrder(1);
		return registration;
	}
	// 文件上传
	// @Bean
	// public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
	// TomcatEmbeddedServletContainerFactory tomcat = new
	// TomcatEmbeddedServletContainerFactory();
	// tomcat.addConnectorCustomizers(connector -> {
	// if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
	// //-1 means unlimited
	// ((AbstractHttp11Protocol<?>)
	// connector.getProtocolHandler()).setMaxSwallowSize(-1);
	// }
	// });
	// return tomcat;
	// }
}
