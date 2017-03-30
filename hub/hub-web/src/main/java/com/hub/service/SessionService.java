package com.hub.service;

import com.hub.model.User;

/**
 * @author mixueqiang
 * @since Jul 1, 2016
 */
public interface SessionService {

  void destorySession(String sessionId);

  User signinWithCookie(String sessionId);

  User signinWithDeviceId(String deviceId);

  void storeSession(long userId, String sessionId);

}
