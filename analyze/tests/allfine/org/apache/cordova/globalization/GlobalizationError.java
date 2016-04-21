package org.apache.cordova.globalization;

import org.json.JSONException;
import org.json.JSONObject;

public class GlobalizationError extends Exception {
    public static final String FORMATTING_ERROR = "FORMATTING_ERROR";
    public static final String PARSING_ERROR = "PARSING_ERROR";
    public static final String PATTERN_ERROR = "PATTERN_ERROR";
    public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
    private static final long serialVersionUID = 1L;
    int error = 0;

    public GlobalizationError() {
    }

    public GlobalizationError(String var1) {
        if(var1.equalsIgnoreCase("FORMATTING_ERROR")) {
            this.error = 1;
        } else {
            if(var1.equalsIgnoreCase("PARSING_ERROR")) {
                this.error = 2;
                return;
            }

            if(var1.equalsIgnoreCase("PATTERN_ERROR")) {
                this.error = 3;
                return;
            }
        }

    }

    public int getErrorCode() {
        return this.error;
    }

    public String getErrorString() {
        switch(this.error) {
            case 0:
                return "UNKNOWN_ERROR";
            case 1:
                return "FORMATTING_ERROR";
            case 2:
                return "PARSING_ERROR";
            case 3:
                return "PATTERN_ERROR";
            default:
                return "";
        }
    }

    public JSONObject toJson() {
        JSONObject var1 = new JSONObject();

        try {
            var1.put("code", this.getErrorCode());
            var1.put("message", this.getErrorString());
            return var1;
        } catch (JSONException var3) {
            return var1;
        }
    }
}
