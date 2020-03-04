package com.nyubin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogoutService {
    /**
     *Логаут пользователя
     */
    String logoutPage(HttpServletRequest request, HttpServletResponse response);
}
