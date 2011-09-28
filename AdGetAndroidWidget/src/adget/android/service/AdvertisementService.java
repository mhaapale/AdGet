package adget.android.service;

 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adget.android.processor.AdGetProcessor;
import adget.android.processor.ProcessorCallBack;
import adget.android.processor.ProcessorEvent;
import adget.android.processor.ResponseEvent;
import adget.android.servicehelper.to.Advertisement;
import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;



public class AdvertisementService extends IntentService {

	private Map<String,  ServiceCallBack<List<Advertisement>>>  advertisementServiceCallbackMap = new HashMap<String, ServiceCallBack< List<Advertisement>>>();
    private IBinder localBinder = new LocalBinder();

	public static final String GET_SURROUNDING_ADS = null;

    
	public AdvertisementService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("Service Invoked");
		AdGetProcessor processor = new AdGetProcessor();
		int opCode = intent.getExtras().getInt("opCode");

		processor.executeRestMethod(opCode,  new ProcessorCallBack<ResponseEvent>() {
			@Override
			public void onSuccess(ResponseEvent event) {
				ServiceCallBack callback = advertisementServiceCallbackMap.get(event.getEventSource());
				callback.onServiceComplete(event.getResult());
				
			}

			@Override
			public void onFailure(ResponseEvent event) {
				// TODO Auto-generated method stub
				
			}


/*
			@Override
			public void onFailure(ResponseEvent< >event) {
				// TODO Auto-generated method stub
				if(advertisementServiceCallbackMap.containsKey(event.getEventSource())){
					advertisementServiceCallbackMap.get(event.getEventSource()).onFailure(event.getErrorMsg());
					synchronized (advertisementServiceCallbackMap) {
						advertisementServiceCallbackMap.remove(event.getEventSource());
					}	
				}

				System.out.println("Err msg provider = "+event.getErrorMsg());
			}

			@Override
			public void onSuccess(ResponseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Response provider insert= "+event.getResult());
				if(advertisementServiceCallbackMap.containsKey(event.getEventSource())){
					advertisementServiceCallbackMap.get(event.getEventSource()).onServiceComplete(event.getResult());
					synchronized (advertisementServiceCallbackMap) {
						advertisementServiceCallbackMap.remove(event.getEventSource());
					}	
				}				
			}
	*/		
		});
		
	
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		//super.startService(intent);
		
		return localBinder;
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
