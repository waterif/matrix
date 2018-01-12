package com.matrix.cloud.common.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.core.annotation.Order;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;


@WebFilter( filterName = "baseMDCInsertingServletFilter", urlPatterns = "/*", initParams = { @WebInitParam( name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico" ) // 忽略资源
} )
@Order(1)
public class BaseMDCInsertingServletFilter extends MDCInsertingServletFilter
{

}
