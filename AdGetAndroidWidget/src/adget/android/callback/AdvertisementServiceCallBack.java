package adget.android.callback;

public interface AdvertisementServiceCallBack<T> {
	void onServiceComplete(T result);
	void onFailure(String errorMsg);
}
