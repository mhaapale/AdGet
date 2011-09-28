package adget.android.processor;

public interface ProcessorCallBack <T> {
	void onSuccess(T event);
	void onFailure(T event);
}
