package com.matrix.cloud.common.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.core.annotation.Order;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;


/**   
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* @author matrix 
* @date 2018年1月14日  下午4:11:12
*
* @Copyright: 2018 www.matrix.com Inc. All rights reserved. 
*/  
@WebFilter( filterName = "baseMDCInsertingServletFilter", urlPatterns = "/*", initParams = { @WebInitParam( name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico" ) // 忽略资源
} )
@Order(1)
public class BaseMDCInsertingServletFilter extends MDCInsertingServletFilter
{

}
