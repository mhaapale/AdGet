package adget.android.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adget.android.servicehelper.to.Advertisement;
import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;


public class AdvertisementService extends IntentService {

	private Map<String,  ServiceCallBack<List<Advertisement>>>  advertisementServiceCallbackMap = new HashMap<String, ServiceCallBack< List<Advertisement>>>();

	public AdvertisementService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static final String GET_SURROUNDING_ADS = null;

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}

	public Map<String,  ServiceCallBack< List<Advertisement> >> getAdvertisementServiceCallbackMap() {
		return advertisementServiceCallbackMap;
	}
	
	  /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
    public class LocalBinder extends Binder {
    	public AdvertisementService getService() {
            return AdvertisementService.this;
        }
    }

}
