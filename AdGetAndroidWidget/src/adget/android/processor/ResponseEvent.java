package adget.android.processor;

public interface ResponseEvent<T> {

	public String getEventSource();
	public T getResult();
	public String getErrorMsg();

}
