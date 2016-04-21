package org.apache.cordova.filetransfer;

import org.json.JSONException;
import org.json.JSONObject;

public class FileUploadResult {
    private long bytesSent = 0L;
    private String objectId = null;
    private String response = null;
    private int responseCode = -1;

    public long getBytesSent() {
        return this.bytesSent;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getResponse() {
        return this.response;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setBytesSent(long var1) {
        this.bytesSent = var1;
    }

    public void setObjectId(String var1) {
        this.objectId = var1;
    }

    public void setResponse(String var1) {
        this.response = var1;
    }

    public void setResponseCode(int var1) {
        this.responseCode = var1;
    }

    public JSONObject toJSONObject() throws JSONException {
        return new JSONObject("{bytesSent:" + this.bytesSent + ",responseCode:" + this.responseCode + ",response:" + JSONObject.quote(this.response) + ",objectId:" + JSONObject.quote(this.objectId) + "}");
    }
}
