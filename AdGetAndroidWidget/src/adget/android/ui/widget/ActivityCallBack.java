package adget.android.ui.widget;

public interface ActivityCallBack<T> {
	void execute(T result);
	void onFailure(String errorMsg);
}