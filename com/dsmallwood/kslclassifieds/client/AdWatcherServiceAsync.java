package com.dsmallwood.kslclassifieds.client;

import com.dsmallwood.kslclassifieds.shared.AdWatcherDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

public abstract interface AdWatcherServiceAsync
{
  public abstract void addAdWatcher(AdWatcherDTO paramAdWatcherDTO, AsyncCallback<String> paramAsyncCallback)
    throws IllegalArgumentException;
  
  public abstract void getAdWatcherList(AsyncCallback<ArrayList<AdWatcherDTO>> paramAsyncCallback);
  
  public abstract void removeAdWatcherListItem(String paramString, AsyncCallback<Void> paramAsyncCallback);
  
  public abstract void editAdWatcherListItem(String paramString, AdWatcherDTO paramAdWatcherDTO, AsyncCallback<Void> paramAsyncCallback);
}


/* Location:           C:\Code\KslAdWatcher\WEB-INF\classes\
 * Qualified Name:     com.dsmallwood.kslclassifieds.client.AdWatcherServiceAsync
 * JD-Core Version:    0.7.0.1
 */