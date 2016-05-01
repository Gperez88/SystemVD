package com.perezmejia.systemvd.helper.template;

import org.springframework.util.Assert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * Created by gperez on 4/26/2016.
 */
public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {

    private static final String BLANK_TEMPLATE = "blank";
    private static final String DEFAULT_TEMPLATE = "/secured/templates/default";
    private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";
    private static final String DEFAULT_SCRIPT_ATTRIBUTE_NAME = "script";

    private String defaultTemplate = DEFAULT_TEMPLATE;
    private String viewAttributeName = DEFAULT_VIEW_ATTRIBUTE_NAME;
    private String scriptAttributeName = DEFAULT_SCRIPT_ATTRIBUTE_NAME;

    public void setDefaultTemplate(String defaultTemplate) {
        Assert.hasLength(defaultTemplate);
        this.defaultTemplate = defaultTemplate;
    }

    public void setViewAttributeName(String viewAttributeName) {
        Assert.hasLength(defaultTemplate);
        this.viewAttributeName = viewAttributeName;
    }

    public void setScriptAttributeName(String scriptAttributeName) {
        Assert.hasLength(defaultTemplate);
        this.scriptAttributeName = scriptAttributeName;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.hasView()) {
            return;
        }

        String originalViewName = modelAndView.getViewName();
        if (isRedirectOrForward(originalViewName)) {
            return;
        }

        String layoutName = getLayoutName(handler);
        String scriptName = getScriptName(handler);

        if (layoutName != null) {
            modelAndView.setViewName(layoutName);
            modelAndView.addObject(this.viewAttributeName, originalViewName);
        }

        modelAndView.addObject(this.scriptAttributeName, scriptName);
    }

    private boolean isRedirectOrForward(String viewName) {
        return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
    }

    private String getLayoutName(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Layout layout = getMethodOrTypeAnnotation(handlerMethod, Layout.class);
        if (layout == null) {
            return this.defaultTemplate;
        } else if (layout.value().equals(BLANK_TEMPLATE)) {
            return null;
        } else {
            return layout.value();
        }
    }

    private String getScriptName(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Script script = getMethodOrTypeAnnotation(handlerMethod, Script.class);
        if (script == null) {
            return null;
        } else {
            return script.value();
        }
    }

    private <A extends Annotation> A getMethodOrTypeAnnotation(HandlerMethod handlerMethod, Class<A> annotationType) {
        A annotation = handlerMethod.getMethodAnnotation(annotationType);
        if (annotation == null) {
            return handlerMethod.getBeanType().getAnnotation(annotationType);
        }
        return annotation;
    }

}