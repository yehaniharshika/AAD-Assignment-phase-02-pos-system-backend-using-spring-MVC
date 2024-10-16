package lk.ijse.aadassignmentphase02possystembackendusingspringmvc;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.config.WebAppConfig;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //01. create Application context using AbstractAnnotationConfigDispatcherServletInitializer

    //02. register of application context
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    //02. register of application context
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    //03. Create Dispatcher servlet(use default mapping for this)
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //multipart form data handle karana configuration-meka demmama thamai ek weda karanne@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String tempDir = System.getProperty("java.io.tmpdir");
        registration.setMultipartConfig(new MultipartConfigElement(tempDir));
    }
}