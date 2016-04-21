package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_491;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_18;
import com.google.android.gms.internal.class_339;
import com.google.android.gms.internal.id;

// $FF: renamed from: com.google.android.gms.internal.ib
public final class class_303 extends e<id> {
    // $FF: renamed from: Dd java.lang.String
    private final String field_912;

    public class_303(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
        super(var1, var2, var3, var4, var6);
        this.field_912 = (String)class_1090.method_5685(var5);
    }

    // $FF: renamed from: I (android.os.IBinder) com.google.android.gms.internal.id
    protected class_18 method_2038(IBinder var1) {
        return class_18.class_1488.method_3902(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2039(BaseImplementation.class_1147<AppStateManager.StateListResult> var1) {
        try {
            ((class_18)this.gS()).method_121(new class_303.class_1704(var1));
        } catch (RemoteException var3) {
            Log.w("AppStateClient", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int) void
    public void method_2040(BaseImplementation.class_1147<AppStateManager.StateDeletedResult> var1, int var2) {
        try {
            ((class_18)this.gS()).method_126(new class_303.class_1702(var1), var2);
        } catch (RemoteException var4) {
            Log.w("AppStateClient", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String, byte[]) void
    public void method_2041(BaseImplementation.class_1147<AppStateManager.StateResult> var1, int var2, String var3, byte[] var4) {
        try {
            ((class_18)this.gS()).method_123(new class_303.class_1706(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            Log.w("AppStateClient", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, byte[]) void
    public void method_2042(BaseImplementation.class_1147<AppStateManager.StateResult> param1, int param2, byte[] param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_961(var2, 6171000, this.getContext().getPackageName(), this.field_912, this.gR());
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_2043(BaseImplementation.class_1147<Status> var1) {
        try {
            ((class_18)this.gS()).method_125(new class_303.class_1708(var1));
        } catch (RemoteException var3) {
            Log.w("AppStateClient", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, int) void
    public void method_2044(BaseImplementation.class_1147<AppStateManager.StateResult> var1, int var2) {
        try {
            ((class_18)this.gS()).method_122(new class_303.class_1706(var1), var2);
        } catch (RemoteException var4) {
            Log.w("AppStateClient", "service died");
        }
    }

    // $FF: renamed from: c (java.lang.String[]) void
    protected void method_1816(String... var1) {
        int var2 = 0;

        boolean var3;
        for(var3 = false; var2 < var1.length; ++var2) {
            if(var1[var2].equals("https://www.googleapis.com/auth/appstate")) {
                var3 = true;
            }
        }

        class_1090.method_5676(var3, String.format("App State APIs requires %s to function.", new Object[] {"https://www.googleapis.com/auth/appstate"}));
    }

    // $FF: renamed from: fq () int
    public int method_2045() {
        try {
            int var3 = ((class_18)this.gS()).method_128();
            return var3;
        } catch (RemoteException var4) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    // $FF: renamed from: fr () int
    public int method_2046() {
        try {
            int var3 = ((class_18)this.gS()).method_129();
            return var3;
        } catch (RemoteException var4) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.appstate.service.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_2038(var1);
    }

    private static final class class_1702 extends class_339 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<AppStateManager.StateDeletedResult> field_1201;

        public class_1702(BaseImplementation.class_1147<AppStateManager.StateDeletedResult> var1) {
            this.field_1201 = (BaseImplementation.class_1147)class_1090.method_5681(var1, "Result holder must not be null");
        }

        // $FF: renamed from: e (int, int) void
        public void method_133(int var1, int var2) {
            Status var3 = new Status(var1);
            this.field_1201.method_120(new class_303.class_1703(var3, var2));
        }
    }

    private static final class class_1703 implements AppStateManager.StateDeletedResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4225;
        // $FF: renamed from: Df int
        private final int field_4226;

        public class_1703(Status var1, int var2) {
            this.field_4225 = var1;
            this.field_4226 = var2;
        }

        public int getStateKey() {
            return this.field_4226;
        }

        public Status getStatus() {
            return this.field_4225;
        }
    }

    private static final class class_1704 extends class_339 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<AppStateManager.StateListResult> field_1200;

        public class_1704(BaseImplementation.class_1147<AppStateManager.StateListResult> var1) {
            this.field_1200 = (BaseImplementation.class_1147)class_1090.method_5681(var1, "Result holder must not be null");
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder) void
        public void method_132(DataHolder var1) {
            this.field_1200.method_120(new class_303.class_1705(var1));
        }
    }

    private static final class class_1705 extends class_491 implements AppStateManager.StateListResult {
        // $FF: renamed from: Dg com.google.android.gms.appstate.AppStateBuffer
        private final AppStateBuffer field_2003;

        public class_1705(DataHolder var1) {
            super(var1);
            this.field_2003 = new AppStateBuffer(var1);
        }

        public AppStateBuffer getStateBuffer() {
            return this.field_2003;
        }
    }

    private static final class class_1706 extends class_339 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<AppStateManager.StateResult> field_1199;

        public class_1706(BaseImplementation.class_1147<AppStateManager.StateResult> var1) {
            this.field_1199 = (BaseImplementation.class_1147)class_1090.method_5681(var1, "Result holder must not be null");
        }

        // $FF: renamed from: a (int, com.google.android.gms.common.data.DataHolder) void
        public void method_131(int var1, DataHolder var2) {
            this.field_1199.method_120(new class_303.class_1707(var1, var2));
        }
    }

    private static final class class_1707 extends class_491 implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {
        // $FF: renamed from: Df int
        private final int field_2001;
        // $FF: renamed from: Dg com.google.android.gms.appstate.AppStateBuffer
        private final AppStateBuffer field_2002;

        public class_1707(int var1, DataHolder var2) {
            super(var2);
            this.field_2001 = var1;
            this.field_2002 = new AppStateBuffer(var2);
        }

        // $FF: renamed from: fs () boolean
        private boolean method_3001() {
            return this.CM.getStatusCode() == 2000;
        }

        public AppStateManager.StateConflictResult getConflictResult() {
            return this.method_3001()?this:null;
        }

        public AppStateManager.StateLoadedResult getLoadedResult() {
            if(this.method_3001()) {
                this = null;
            }

            return this;
        }

        public byte[] getLocalData() {
            return this.field_2002.getCount() == 0?null:this.field_2002.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.field_2002.getCount() == 0?null:this.field_2002.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.field_2002.getCount() == 0?null:this.field_2002.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.field_2001;
        }

        public void release() {
            this.field_2002.close();
        }
    }

    private static final class class_1708 extends class_339 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_1198;

        public class_1708(BaseImplementation.class_1147<Status> var1) {
            this.field_1198 = (BaseImplementation.class_1147)class_1090.method_5681(var1, "Holder must not be null");
        }

        // $FF: renamed from: fp () void
        public void method_134() {
            Status var1 = new Status(0);
            this.field_1198.method_120(var1);
        }
    }
}
