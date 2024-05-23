package kok.spring21.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
    protected Class<?>[] getRootConfigClasses(){
		return new Class[]{SecurityConfig.class};
    }
	@Override
    protected Class<?>[] getServletConfigClasses(){
		return new Class[]{SpringConfig.class};
    }
	@Override
    protected String[] getServletMappings(){
		return new String[] {"/"};
    }
}
