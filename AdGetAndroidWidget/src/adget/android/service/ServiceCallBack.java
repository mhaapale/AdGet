package adget.android.service;

public interface ServiceCallBack<T> {
	void onServiceComplete(T result);
	void onFailure(String errorMsg);
}
