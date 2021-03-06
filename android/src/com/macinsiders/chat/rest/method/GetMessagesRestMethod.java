package com.macinsiders.chat.rest.method;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import android.content.Context;
import android.util.Log;

import com.macinsiders.chat.resource.Messages;
import com.macinsiders.chat.rest.Request;
import com.macinsiders.chat.rest.method.RestMethodFactory.Method;

public class GetMessagesRestMethod extends AbstractRestMethod<Messages> {

	private static final String TAG = GetMessagesRestMethod.class.getSimpleName();

	private Context mContext;

	private static final String BASE_URI = "http://www.macinsiders.com/chat/?ajax=true";

	/* The id of the most recent message we have */
	private String mNewestId;

	private URI mUri;

	public GetMessagesRestMethod(Context context, String newestId) {
		mContext = context.getApplicationContext();
		mNewestId = newestId;
		mUri = buildUri();
	}

	@Override
	protected Request buildRequest() {
		Request request = new Request(Method.GET, mUri, null, null);
		return request;
	}

	private URI buildUri() {
		String uriString = BASE_URI;
		if (mNewestId != null) {
			uriString += "&lastID=" + mNewestId;
		}
		return URI.create(uriString);
	}

	@Override
	protected Messages parseResponseBody(String responseBody) throws Exception {
                Log.d(TAG, responseBody);
	        // also the serverResponse
	        // TODO Change this to deal with XML data instead of JSON 
		JSONArray messagesArray = new JSONArray(responseBody);

		return new Messages(messagesArray);
	}

	@Override
	protected Context getContext() {
		return mContext;
	}

	@Override
	protected boolean requiresAuthorization() {
		return false;
	}

	@Override
	protected String getLogTag() {
		return TAG;
	}

	@Override
	protected URI getURI() {
		return mUri;
	}

    @Override
    protected Messages parseResponseCookies(Map<String, List<String>> headers) throws Exception {
        // No reason to do anything here yet
        return null;
    }

}
