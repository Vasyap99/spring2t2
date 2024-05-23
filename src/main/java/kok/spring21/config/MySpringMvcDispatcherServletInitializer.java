package kok.spring21.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
    protected Class<?>[] getRootConfigClasses(){
		return null;
    }
	@Override
    protected Class<?>[] getServletConfigClasses(){
		return new Class[]{SpringConfig.class,SecurityConfig.class};
    }
	@Override
    protected String[] getServletMappings(){
		return new String[] {"/"};
    }
}
