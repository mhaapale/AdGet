package adget.android.servicehelper;

import java.util.List;

import adget.android.callback.AdvertisementServiceCallBack;
import adget.android.service.AdvertisementService;
import adget.android.service.AdvertisementService.LocalBinder;
import adget.android.service.ServiceCallBack;
import adget.android.service.context.AdGetApp;
import adget.android.servicehelper.to.Advertisement;
import adget.android.ui.widget.ActivityCallBack;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.IBinder;

public class AdvertisementServiceHelper {
	private static AdvertisementServiceHelper me;
	private Context context = AdGetApp.getAppContext();
	
	public static AdvertisementServiceHelper getInstance(){
        if(me == null){
                me = new AdvertisementServiceHelper();
        }
        return me;
}
//	public List<Advertisement> getSurroundingAdvertisements(Location location);

	public void getSurroundingAdvertisements(final ActivityCallBack< List<Advertisement> > callback) {
		final Intent authenticateUserIntent = new Intent(context, AdvertisementService.class);
/*		authenticateUserIntent.putExtra("authToken",authToken);
		authenticateUserIntent.putExtra("opCode",PicasaDroidService.DELETE_ALBUM);
		authenticateUserIntent.putExtra("etag",etag);
		authenticateUserIntent.putExtra("albumId",albumId);
	*/	
		final StringBuffer resourceBfr = new StringBuffer();
//		resourceBfr.append(authToken).append(";").append(albumId).append(";").append(etag).append(";").append(PicasaDroid.RestTransactionResult.RESOURCE_TYPE_ALBUM).append(";").append(PicasaDroidService.DELETE_ALBUM);
		
		bindToService(resourceBfr.toString(),authenticateUserIntent,new  ServiceCallBack< List<Advertisement> >() {
			@Override
			public void onServiceComplete(List<Advertisement> result) {
				// TODO Auto-generated method stub
			System.out.println("Service Completed returned num of ads: ="+result.size());	
			callback.execute(result);
			}

			@Override
			public void onFailure(String errorMsg) {
				// TODO Auto-generated method stub
				callback.onFailure(errorMsg);
			}
			
			
		});     
}
	
	
	
	private int isRequestPending(String request){
		ContentResolver cr = AdGetApp.getAppContext().getContentResolver();
		Cursor cursor = cr.query(PicasaDroid.RestTransactionResult.PICASADROID_CONTENT_URI, new String[] {PicasaDroid.RestTransactionResult._ID}, PicasaDroid.RestTransactionResult.REST_TRANSACTION_TABLE_RESOURCE+"=? and "+PicasaDroid.RestTransactionResult.REST_TRANSACTION_TABLE_HTTP_TRANSACTION_RUNNING+" != "+PicasaDroid.RestTransactionResult.HTTP_TRANSACTION_RUNNING_DONE , new String[] {request}, PicasaDroid.RestTransactionResult.DEFAULT_SORT_ORDER);
		int requestId = -1;
		if (cursor.moveToFirst()) {
	        requestId = cursor.getInt(cursor.getColumnIndex(PicasaDroid.RestTransactionResult._ID));
	        
	    }
		cursor.close();
		return requestId;	 
	}

	private void  bindToService(final String resource,final Intent intent,final  ServiceCallBack< List<Advertisement> > serviceCallback){

		context.bindService(intent, new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				 LocalBinder binder = (LocalBinder) service;
		            if(!binder.getService().getAdvertisementServiceCallbackMap().containsKey(resource))
		            {
		            	binder.getService().getAdvertisementServiceCallbackMap().put(resource, serviceCallback);	
		            	context.startService(intent);       
		            
		            }	
			}
		}, context.BIND_AUTO_CREATE);
		
	}
}

