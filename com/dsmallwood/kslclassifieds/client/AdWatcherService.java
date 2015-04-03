package com.dsmallwood.kslclassifieds.client;

import com.dsmallwood.kslclassifieds.shared.AdWatcherDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

@RemoteServiceRelativePath("addAdWatcher")
public abstract interface AdWatcherService
  extends RemoteService
{
  public abstract String addAdWatcher(AdWatcherDTO paramAdWatcherDTO)
    throws IllegalArgumentException;
  
  public abstract ArrayList<AdWatcherDTO> getAdWatcherList();
  
  public abstract void removeAdWatcherListItem(String paramString);
  
  public abstract void editAdWatcherListItem(String paramString, AdWatcherDTO paramAdWatcherDTO);
}


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.client.AdWatcherService
 * JD-Core Version:    0.7.0.1
 */