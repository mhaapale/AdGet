package adget.android.service.context;

import android.app.Application;
import android.content.Context;

public class AdGetApp extends Application {

	private static Context context;

	public void onCreate() { 
		AdGetApp.context = getApplicationContext();
}

	public static Context getAppContext() { 
		return context;
	}
}