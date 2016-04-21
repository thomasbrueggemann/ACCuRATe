package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.auth.api.GoogleAuthApiRequestCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleAuthApiRequest implements SafeParcelable {
    public static final GoogleAuthApiRequestCreator CREATOR = new GoogleAuthApiRequestCreator();
    public static final String DEFAULT_SCOPE_PREFIX = "oauth2:";
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int VERSION_CODE = 1;
    // $FF: renamed from: DA byte[]
    byte[] field_3608;
    // $FF: renamed from: DB long
    long field_3609;
    // $FF: renamed from: Dt java.lang.String
    String field_3610;
    // $FF: renamed from: Du android.os.Bundle
    Bundle field_3611;
    // $FF: renamed from: Dv java.lang.String
    String field_3612;
    // $FF: renamed from: Dw java.util.List
    List<String> field_3613;
    // $FF: renamed from: Dx java.lang.String
    String field_3614;
    // $FF: renamed from: Dy int
    int field_3615;
    // $FF: renamed from: Dz android.os.Bundle
    Bundle field_3616;
    String name;
    String version;
    final int versionCode;
    // $FF: renamed from: yR java.lang.String
    String field_3617;

    GoogleAuthApiRequest(int var1, String var2, String var3, String var4, String var5, Bundle var6, String var7, List<String> var8, String var9, int var10, Bundle var11, byte[] var12, long var13) {
        this.versionCode = var1;
        this.name = var2;
        this.version = var3;
        this.field_3610 = var4;
        this.field_3617 = var5;
        this.field_3611 = var6;
        this.field_3612 = var7;
        this.field_3613 = var8;
        this.field_3614 = var9;
        this.field_3615 = var10;
        this.field_3616 = var11;
        this.field_3608 = var12;
        this.field_3609 = var13;
    }

    public GoogleAuthApiRequest(String var1, String var2, String var3) {
        this.versionCode = 1;
        this.name = var1;
        this.method_4037(var2);
        this.field_3610 = var3;
        this.field_3611 = new Bundle();
        this.field_3613 = new ArrayList();
        this.field_3614 = "oauth2:";
        this.field_3616 = new Bundle();
        this.field_3608 = new byte[0];
    }

    public GoogleAuthApiRequest(String var1, String var2, String var3, int var4) {
        this.versionCode = 1;
        this.name = var1;
        this.method_4037(var2);
        this.setPath(var3);
        this.method_4036(var4);
        this.field_3611 = new Bundle();
        this.field_3613 = new ArrayList();
        this.field_3614 = "oauth2:";
        this.field_3616 = new Bundle();
        this.field_3608 = new byte[0];
    }

    // $FF: renamed from: T (int) void
    private void method_4036(int var1) {
        if(var1 >= 0 && var1 <= 7) {
            this.field_3615 = var1;
        } else {
            throw new IllegalArgumentException("Invalid HTTP method.");
        }
    }

    // $FF: renamed from: ay (java.lang.String) void
    private void method_4037(String var1) {
        if(var1.charAt(0) >= 48 && var1.charAt(0) <= 57) {
            var1 = "v" + var1;
        }

        this.version = var1;
    }

    private void setPath(String var1) {
        if(var1.charAt(0) == 47) {
            var1 = var1.substring(1);
        }

        if(var1.charAt(-1 + var1.length()) == 47) {
            var1 = var1.substring(0, -1 + var1.length());
        }

        this.field_3617 = var1;
    }

    public void addParameter(String var1, String var2) {
        if(!this.field_3611.containsKey(var1)) {
            ArrayList var3 = new ArrayList();
            var3.add(var2);
            this.field_3611.putStringArrayList(var1, var3);
        } else {
            this.field_3611.getStringArrayList(var1).add(var2);
        }
    }

    public void addScope(String var1) {
        this.field_3613.add(var1);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.field_3612;
    }

    public String getApiId() {
        return this.field_3610;
    }

    public String getFullScope() {
        String var1 = this.getScope();
        return var1 == null?null:this.field_3614 + var1;
    }

    public String getHeader(String var1) {
        return this.field_3616.getString(var1);
    }

    public Bundle getHeaders() {
        return this.field_3616;
    }

    public Map<String, String> getHeadersAsMap() {
        HashMap var1 = new HashMap();
        Iterator var2 = this.field_3616.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, this.field_3616.getString(var3));
        }

        return var1;
    }

    public byte[] getHttpBody() {
        return this.field_3608;
    }

    public JSONObject getHttpBodyAsJson() throws JSONException {
        try {
            JSONObject var1 = new JSONObject(new String(this.field_3608, "UTF-8"));
            return var1;
        } catch (UnsupportedEncodingException var3) {
            Log.e("GoogleAuthApiRequest", "Unsupported encoding error.");
            return null;
        }
    }

    public int getHttpMethod() {
        return this.field_3615;
    }

    public String getName() {
        return this.name;
    }

    public Bundle getParameters() {
        return this.field_3611;
    }

    public Map<String, List<String>> getParametersAsMap() {
        HashMap var1 = new HashMap();
        Iterator var2 = this.field_3611.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.put(var3, this.field_3611.getStringArrayList(var3));
        }

        return var1;
    }

    public String getPath() {
        return this.field_3617;
    }

    public String getScope() {
        if(this.field_3613.size() == 0) {
            return null;
        } else {
            StringBuffer var1 = new StringBuffer();

            for(int var2 = 0; var2 < this.field_3613.size(); ++var2) {
                var1.append((String)this.field_3613.get(var2));
                if(var2 != -1 + this.field_3613.size()) {
                    var1.append(" ");
                }
            }

            return var1.toString();
        }
    }

    public long getTimeout() {
        return this.field_3609;
    }

    public String getVersion() {
        return this.version;
    }

    public void putHeader(String var1, String var2) {
        this.field_3616.putString(var1, var2);
    }

    public void setAccountName(String var1) {
        this.field_3612 = var1;
    }

    public void setHttpBody(String var1) {
        try {
            this.field_3608 = var1.getBytes("UTF-8");
        } catch (UnsupportedEncodingException var3) {
            Log.e("GoogleAuthApiRequest", "Unsupported encoding error.");
        }
    }

    public void setTimeout(long var1) {
        this.field_3609 = var1;
    }

    public String toString() {
        return "{ API: " + this.name + "/" + this.version + ", Scope: " + this.getFullScope() + ", Account: " + this.getAccountName() + " }";
    }

    public void writeToParcel(Parcel var1, int var2) {
        GoogleAuthApiRequestCreator.method_3181(this, var1, var2);
    }
}
