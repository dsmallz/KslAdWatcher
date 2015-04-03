package com.dsmallwood.kslclassifieds.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public abstract interface LoginService
  extends RemoteService
{
  public abstract LoginInfo login(String paramString);
}


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.client.LoginService
 * JD-Core Version:    0.7.0.1
 */