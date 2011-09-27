package adget.android.db;

import android.net.Uri;
import android.provider.BaseColumns;

public class AdGetRestStatuses {

	private final static String AUTHORITY = "adget.android.contentprovider";	
    public static final String REST_TRANSACTION_TABLE_NAME = "rest_transaction";      
    public static final String REST_TRANSACTION_TABLE_ID="_ID";

	
	
	public static final class RestTransactionResult implements BaseColumns {
		   // This class cannot be instantiated
        private RestTransactionResult() {}

        /**
         * The content:// style URL for this table
         */
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/"+REST_TRANSACTION_TABLE_NAME);

        /**
         * The MIME type of {@link #CONTENT_URI} providing a directory of notes.
         */
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.note";

        /**
         * The MIME type of a {@link #CONTENT_URI} sub-directory of a single note.
         */
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.note";

        /**
         * The default sort order for this table
         */
        public static final String DEFAULT_SORT_ORDER = "_id DESC";

                
        

        public static final String REST_TRANSACTION_TABLE_RESOURCE="resource";
        /**
         * resource_type= 1>authtoken 2>album 3>photo 4>comment 5>tag
         */
        public static final String REST_TRANSACTION_TABLE_RESOURCE_TYPE="resource_type";
        /**
         *result = xml or json response 
         */
        public static final String REST_TRANSACTION_TABLE_RESULT="result";
        /**
         *      is_http_transaction_running = 1>NONE 2>INPROGRESS 3>DONE
         */
        public static final String REST_TRANSACTION_TABLE_HTTP_TRANSACTION_RUNNING="is_http_transaction_running";
        
        /**
         * last_modified_time=time in long
         */
        public static final String REST_TRANSACTION_TABLE_LAST_MODIFIED_DATE_TIME="last_modified_time";
        /**
         * created_time=time in long
         */
        public static final String REST_TRANSACTION_TABLE_CREATED_DATE_TIME="created_time";
        
        public static final int HTTP_TRANSACTION_RUNNING_NONE = 0;
        public static final int HTTP_TRANSACTION_RUNNING_IN_PROGRESS = 1;
        public static final int HTTP_TRANSACTION_RUNNING_DONE = 2;
        
        
        public static final int RESOURCE_TYPE_AUTH_TOKEN = 0;
        public static final int RESOURCE_TYPE_ALBUM = 1;
        public static final int RESOURCE_TYPE_PHOTO = 2;
        public static final int RESOURCE_TYPE_COMMENT = 3;
        public static final int RESOURCE_TYPE_TAG = 4;
        
        
        public static final int STATUS_GETTING = 0;
        public static final int STATUS_SET_POSTTING = 1;
        public static final int STATUS_CLEAR_POSTTING = 2;
        public static final int STATUS_SET_UPDATING = 3;
        public static final int STATUS_CLEAR_UPDATING = 4;
        public static final int STATUS_SET_DELETING = 5;
	 }
}
