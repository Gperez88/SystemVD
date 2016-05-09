package com.perezmejia.systemvd.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Guil on 5/7/2016.
 */

public class LoginPageRedirectInterceptor extends HandlerInterceptorAdapter {
    private final String loginUrl = "/login";

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!isInLoginPaths(this.urlPathHelper.getLookupPathForRequest(request)) && !isAuthenticated()) {
            response.setContentType("text/plain");
            sendRedirect(request, response);
            return false;
        } else {
            return true;
        }
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }

        return authentication.isAuthenticated();
    }

    private void sendRedirect(HttpServletRequest request, HttpServletResponse response) {
        String encodedRedirectURL = response.encodeRedirectURL(request.getContextPath() + loginUrl);

        response.setStatus(HttpStatus.TEMPORARY_REDIRECT.value());
        response.setHeader("Location", encodedRedirectURL);
    }

    private boolean isInLoginPaths(final String requestUrl) {
        if (requestUrl.equals(loginUrl)) {
            return true;
        }
        return false;
    }
}
