package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_194;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.internal.class_269;
import com.google.android.gms.internal.class_272;
import com.google.android.gms.internal.class_273;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.class_184;
import com.google.android.gms.plus.internal.class_723;
import com.google.android.gms.plus.internal.class_959;
import com.google.android.gms.plus.internal.d;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.plus.internal.e
public class class_293 extends e<d> {
    private Person alt;
    private final class_959 alu;

    public class_293(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, class_959 var5) {
        super(var1, var2, var3, var4, var5.method_5062());
        this.alu = var5;
    }

    @Deprecated
    public class_293(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, class_959 var4) {
        this(var1, var1.getMainLooper(), new class_291.class_1748(var2), new class_291.class_1752(var3), var4);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String) com.google.android.gms.common.internal.j
    public j method_1843(BaseImplementation.class_1147<People.LoadPeopleResult> var1, int var2, String var3) {
        this.dJ();
        class_293.class_1187 var4 = new class_293.class_1187(var1);

        try {
            class_194 var6 = ((class_184)this.gS()).method_850(var4, 1, var2, -1, var3);
            return var6;
        } catch (RemoteException var7) {
            var4.method_844(DataHolder.method_5982(8), (String)null);
            return null;
        }
    }

    // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
    protected void method_1812(int var1, IBinder var2, Bundle var3) {
        if(var1 == 0 && var3 != null && var3.containsKey("loaded_person")) {
            this.alt = class_272.method_1723(var3.getByteArray("loaded_person"));
        }

        super.method_1812(var1, var2, var3);
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
    public void method_1844(BaseImplementation.class_1147<Moments.LoadMomentsResult> var1, int var2, String var3, Uri var4, String var5, String var6) {
        this.dJ();
        class_293.class_1184 var7;
        if(var1 != null) {
            var7 = new class_293.class_1184(var1);
        } else {
            var7 = null;
        }

        try {
            ((class_184)this.gS()).method_853(var7, var2, var3, var4, var5, var6);
        } catch (RemoteException var9) {
            var7.method_845(DataHolder.method_5982(8), (String)null, (String)null);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.plus.model.moments.Moment) void
    public void method_1845(BaseImplementation.class_1147<Status> var1, Moment var2) {
        this.dJ();
        class_293.class_1183 var3;
        if(var1 != null) {
            var3 = new class_293.class_1183(var1);
        } else {
            var3 = null;
        }

        try {
            class_269 var5 = class_269.method_1700((class_273)var2);
            ((class_184)this.gS()).method_855(var3, var5);
        } catch (RemoteException var6) {
            if(var3 == null) {
                throw new IllegalStateException(var6);
            } else {
                var3.method_846(new Status(8, (String)null, (PendingIntent)null));
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.util.Collection) void
    public void method_1846(BaseImplementation.class_1147<People.LoadPeopleResult> var1, Collection<String> var2) {
        this.dJ();
        class_293.class_1187 var3 = new class_293.class_1187(var1);

        try {
            ((class_184)this.gS()).method_858(var3, new ArrayList(var2));
        } catch (RemoteException var5) {
            var3.method_844(DataHolder.method_5982(8), (String)null);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = this.alu.method_5070();
        var3.putStringArray("request_visible_actions", this.alu.method_5063());
        var1.method_963(var2, 6171000, this.alu.method_5066(), this.alu.method_5065(), this.gR(), this.alu.getAccountName(), var3);
    }

    // $FF: renamed from: bH (android.os.IBinder) com.google.android.gms.plus.internal.d
    protected class_184 method_1847(IBinder var1) {
        return class_184.class_1613.method_5260(var1);
    }

    // $FF: renamed from: cg (java.lang.String) boolean
    public boolean method_1848(String var1) {
        return Arrays.asList(this.gR()).contains(var1);
    }

    public void clearDefaultAccount() {
        this.dJ();

        try {
            this.alt = null;
            ((class_184)this.gS()).clearDefaultAccount();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
    public void method_1849(BaseImplementation.class_1147<People.LoadPeopleResult> var1, String[] var2) {
        this.method_1846(var1, Arrays.asList(var2));
    }

    public String getAccountName() {
        this.dJ();

        try {
            String var2 = ((class_184)this.gS()).getAccountName();
            return var2;
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public Person getCurrentPerson() {
        this.dJ();
        return this.alt;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.plus.service.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1847(var1);
    }

    // $FF: renamed from: k (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1850(BaseImplementation.class_1147<Moments.LoadMomentsResult> var1) {
        this.method_1844(var1, 20, (String)null, (Uri)null, (String)null, "me");
    }

    // $FF: renamed from: l (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1851(BaseImplementation.class_1147<People.LoadPeopleResult> var1) {
        this.dJ();
        class_293.class_1187 var2 = new class_293.class_1187(var1);

        try {
            ((class_184)this.gS()).method_850(var2, 2, 1, -1, (String)null);
        } catch (RemoteException var4) {
            var2.method_844(DataHolder.method_5982(8), (String)null);
        }
    }

    // $FF: renamed from: m (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1852(BaseImplementation.class_1147<Status> var1) {
        this.dJ();
        this.clearDefaultAccount();
        class_293.class_1189 var2 = new class_293.class_1189(var1);

        try {
            ((class_184)this.gS()).method_860(var2);
        } catch (RemoteException var4) {
            var2.method_849(8, (Bundle)null);
        }
    }

    // $FF: renamed from: r (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) com.google.android.gms.common.internal.j
    public j method_1853(BaseImplementation.class_1147<People.LoadPeopleResult> var1, String var2) {
        return this.method_1843(var1, 0, var2);
    }

    public void removeMoment(String var1) {
        this.dJ();

        try {
            ((class_184)this.gS()).removeMoment(var1);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    final class class_1183 extends class_723 {
        private final BaseImplementation.class_1147<Status> alv;

        public class_1183(BaseImplementation.class_1147<Status> var1) {
            this.alv = var2;
        }

        // $FF: renamed from: aB (com.google.android.gms.common.api.Status) void
        public void method_846(Status var1) {
            class_293.this.a(class_293.this.new class_1186(this.alv, var1));
        }
    }

    final class class_1184 extends class_723 {
        private final BaseImplementation.class_1147<Moments.LoadMomentsResult> alv;

        public class_1184(BaseImplementation.class_1147<Moments.LoadMomentsResult> var1) {
            this.alv = var2;
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, java.lang.String) void
        public void method_845(DataHolder var1, String var2, String var3) {
            PendingIntent var4;
            if(var1.method_5998() != null) {
                var4 = (PendingIntent)var1.method_5998().getParcelable("pendingIntent");
            } else {
                var4 = null;
            }

            Status var5 = new Status(var1.getStatusCode(), (String)null, var4);
            DataHolder var6;
            if(!var5.isSuccess() && var1 != null) {
                if(!var1.isClosed()) {
                    var1.close();
                }

                var6 = null;
            } else {
                var6 = var1;
            }

            class_293.this.a(class_293.this.new class_1185(this.alv, var5, var6, var2, var3));
        }
    }

    final class class_1185 extends com/google/android/gms/common/internal/e<d>.d<BaseImplementation.class_1147<Moments.LoadMomentsResult>> implements Moments.LoadMomentsResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_1889;
        // $FF: renamed from: Nq java.lang.String
        private final String field_1890;
        private final String alx;
        private MomentBuffer aly;

        public class_1185(BaseImplementation.class_1147<Moments.LoadMomentsResult> var1, Status var2, DataHolder var3, String var4, String var5) {
            super();
            this.field_1889 = var3;
            this.field_1890 = var5;
            this.alx = var6;
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.common.data.DataHolder) void
        protected void method_2939(BaseImplementation.class_1147<Moments.LoadMomentsResult> var1, DataHolder var2) {
            MomentBuffer var3;
            if(var2 != null) {
                var3 = new MomentBuffer(var2);
            } else {
                var3 = null;
            }

            this.aly = var3;
            var1.method_120(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.aly;
        }

        public String getNextPageToken() {
            return this.field_1890;
        }

        public Status getStatus() {
            return this.field_1889;
        }

        public String getUpdated() {
            return this.alx;
        }

        public void release() {
            if(this.aly != null) {
                this.aly.close();
            }

        }
    }

    final class class_1186 extends com/google/android/gms/common/internal/e<d>.b<BaseImplementation.class_1147<Status>> {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_1862;

        public class_1186(BaseImplementation.class_1147<Status> var1, Status var2) {
            super();
            this.field_1862 = var3;
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2926((BaseImplementation.class_1147)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }

        // $FF: renamed from: n (com.google.android.gms.common.api.BaseImplementation$b) void
        protected void method_2926(BaseImplementation.class_1147<Status> var1) {
            if(var1 != null) {
                var1.method_120(this.field_1862);
            }

        }
    }

    final class class_1187 extends class_723 {
        private final BaseImplementation.class_1147<People.LoadPeopleResult> alv;

        public class_1187(BaseImplementation.class_1147<People.LoadPeopleResult> var1) {
            this.alv = var2;
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String) void
        public void method_844(DataHolder var1, String var2) {
            PendingIntent var3;
            if(var1.method_5998() != null) {
                var3 = (PendingIntent)var1.method_5998().getParcelable("pendingIntent");
            } else {
                var3 = null;
            }

            Status var4 = new Status(var1.getStatusCode(), (String)null, var3);
            DataHolder var5;
            if(!var4.isSuccess() && var1 != null) {
                if(!var1.isClosed()) {
                    var1.close();
                }

                var5 = null;
            } else {
                var5 = var1;
            }

            class_293.this.a(class_293.this.new class_1188(this.alv, var4, var5, var2));
        }
    }

    final class class_1188 extends com/google/android/gms/common/internal/e<d>.d<BaseImplementation.class_1147<People.LoadPeopleResult>> implements People.LoadPeopleResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_1887;
        // $FF: renamed from: Nq java.lang.String
        private final String field_1888;
        private PersonBuffer alz;

        public class_1188(BaseImplementation.class_1147<People.LoadPeopleResult> var1, Status var2, DataHolder var3, String var4) {
            super();
            this.field_1887 = var3;
            this.field_1888 = var5;
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.common.data.DataHolder) void
        protected void method_2938(BaseImplementation.class_1147<People.LoadPeopleResult> var1, DataHolder var2) {
            PersonBuffer var3;
            if(var2 != null) {
                var3 = new PersonBuffer(var2);
            } else {
                var3 = null;
            }

            this.alz = var3;
            var1.method_120(this);
        }

        public String getNextPageToken() {
            return this.field_1888;
        }

        public PersonBuffer getPersonBuffer() {
            return this.alz;
        }

        public Status getStatus() {
            return this.field_1887;
        }

        public void release() {
            if(this.alz != null) {
                this.alz.close();
            }

        }
    }

    final class class_1189 extends class_723 {
        private final BaseImplementation.class_1147<Status> alv;

        public class_1189(BaseImplementation.class_1147<Status> var1) {
            this.alv = var2;
        }

        // $FF: renamed from: h (int, android.os.Bundle) void
        public void method_849(int var1, Bundle var2) {
            PendingIntent var3;
            if(var2 != null) {
                var3 = (PendingIntent)var2.getParcelable("pendingIntent");
            } else {
                var3 = null;
            }

            Status var4 = new Status(var1, (String)null, var3);
            class_293.this.a(class_293.this.new class_1190(this.alv, var4));
        }
    }

    final class class_1190 extends com/google/android/gms/common/internal/e<d>.b<BaseImplementation.class_1147<Status>> {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_1861;

        public class_1190(BaseImplementation.class_1147<Status> var1, Status var2) {
            super();
            this.field_1861 = var3;
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2925((BaseImplementation.class_1147)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }

        // $FF: renamed from: n (com.google.android.gms.common.api.BaseImplementation$b) void
        protected void method_2925(BaseImplementation.class_1147<Status> var1) {
            class_293.this.disconnect();
            if(var1 != null) {
                var1.method_120(this.field_1861);
            }

        }
    }
}
