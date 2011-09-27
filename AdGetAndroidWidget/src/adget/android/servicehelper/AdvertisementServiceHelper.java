package adget.android.servicehelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import adget.android.service.AdvertisementService;
import android.content.Intent;


public class AdvertisementServiceHelper {

	private static AdvertisementServiceHelper me;
	private Map<UUID, Intent> mPendingReqs = new HashMap<UUID, Intent>();
	
	private AdvertisementServiceHelper() {
		
	}

	public static AdvertisementServiceHelper getInstance() {
		if ( me != null)
			me = new AdvertisementServiceHelper();
		return me;
	}
	
	public UUID getNearbyAdvertisers( ) {
		UUID requestId = UUID.randomUUID();
		Intent intent = new Intent();
		intent.setAction("adget.android.service.location");
		mPendingReqs .put(requestId, intent);

		
		Intent newinIntent = new Intent(context, AdvertisementService.class);
        context.startService(newinIntent);

		
	/*	
		Thread t = new Thread(){
			public void run(){
			getApplicationContext().bindService(
			        new Intent(getApplicationContext(), AdvertisementService.class),
			        serviceConnection,
			        Context.BIND_AUTO_CREATE
			    );
			}
			};
			t.start();
*/
		
			
			
		return requestId;
		
	}
}
