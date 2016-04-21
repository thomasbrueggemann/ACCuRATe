package org.apache.cordova.filetransfer;

import org.json.JSONException;
import org.json.JSONObject;

public class FileProgressResult {
    private boolean lengthComputable = false;
    private long loaded = 0L;
    private long total = 0L;

    public boolean getLengthComputable() {
        return this.lengthComputable;
    }

    public long getLoaded() {
        return this.loaded;
    }

    public long getTotal() {
        return this.total;
    }

    public void setLengthComputable(boolean var1) {
        this.lengthComputable = var1;
    }

    public void setLoaded(long var1) {
        this.loaded = var1;
    }

    public void setTotal(long var1) {
        this.total = var1;
    }

    public JSONObject toJSONObject() throws JSONException {
        StringBuilder var1 = (new StringBuilder()).append("{loaded:").append(this.loaded).append(",total:").append(this.total).append(",lengthComputable:");
        String var2;
        if(this.lengthComputable) {
            var2 = "true";
        } else {
            var2 = "false";
        }

        return new JSONObject(var1.append(var2).append("}").toString());
    }
}
