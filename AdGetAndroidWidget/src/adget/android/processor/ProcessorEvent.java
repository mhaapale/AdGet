package adget.android.processor;

public interface ProcessorEvent<T> {
	public String getEventSource();
	public T getResult();
	public String getErrorMsg();
}
