package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_21;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_344;
import com.google.android.gms.internal.class_350;
import com.google.android.gms.internal.class_713;
import com.google.android.gms.internal.class_729;
import com.google.android.gms.internal.class_730;
import com.google.android.gms.internal.class_731;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jr;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.class_181;
import com.google.android.gms.plus.internal.class_680;
import com.google.android.gms.plus.internal.class_874;
import com.google.android.gms.plus.internal.d;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.plus.internal.e
public class class_285 extends jl<d> {
   private Person anG;
   private final class_874 anH;

   public class_285(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, class_874 var5) {
      super(var1, var2, var3, var4, var5.method_4924());
      this.anH = var5;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String) com.google.android.gms.internal.jr
   public jr method_1819(BaseImplementation.class_1058<People.LoadPeopleResult> var1, int var2, String var3) {
      this.dS();
      class_285.class_1111 var4 = new class_285.class_1111(var1);

      try {
         class_21 var6 = ((class_181)this.hw()).method_896(var4, 1, var2, -1, var3);
         return var6;
      } catch (RemoteException var7) {
         var4.method_884(DataHolder.method_5824(8), (String)null);
         return null;
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1790(int var1, IBinder var2, Bundle var3) {
      if(var1 == 0 && var3 != null && var3.containsKey("loaded_person")) {
         this.anG = class_730.method_4245(var3.getByteArray("loaded_person"));
      }

      super.method_1790(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
   public void method_1820(BaseImplementation.class_1058<Moments.LoadMomentsResult> var1, int var2, String var3, Uri var4, String var5, String var6) {
      this.dS();
      class_285.class_1108 var7;
      if(var1 != null) {
         var7 = new class_285.class_1108(var1);
      } else {
         var7 = null;
      }

      try {
         ((class_181)this.hw()).method_899(var7, var2, var3, var4, var5, var6);
      } catch (RemoteException var9) {
         var7.method_885(DataHolder.method_5824(8), (String)null, (String)null);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.plus.model.moments.Moment) void
   public void method_1821(BaseImplementation.class_1058<Status> var1, Moment var2) {
      this.dS();
      class_285.class_1107 var3;
      if(var1 != null) {
         var3 = new class_285.class_1107(var1);
      } else {
         var3 = null;
      }

      try {
         class_731 var5 = class_731.method_4247((class_729)var2);
         ((class_181)this.hw()).method_901(var3, var5);
      } catch (RemoteException var6) {
         if(var3 == null) {
            throw new IllegalStateException(var6);
         } else {
            var3.method_886(new Status(8, (String)null, (PendingIntent)null));
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.util.Collection) void
   public void method_1822(BaseImplementation.class_1058<People.LoadPeopleResult> var1, Collection<String> var2) {
      this.dS();
      class_285.class_1111 var3 = new class_285.class_1111(var1);

      try {
         ((class_181)this.hw()).method_904(var3, new ArrayList(var2));
      } catch (RemoteException var5) {
         var3.method_884(DataHolder.method_5824(8), (String)null);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = this.anH.method_4923();
      var3.putStringArray("request_visible_actions", this.anH.method_4916());
      var3.putString("auth_package", this.anH.method_4918());
      var1.method_138(var2, (new class_344(2)).method_2361(this.anH.method_4919()).method_2359(class_350.method_2430(this.anH.getAccountName())).method_2360(class_713.method_4186(this.hv())).method_2362(var3));
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.plus.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.plus.internal.IPlusService";
   }

   // $FF: renamed from: bN (android.os.IBinder) com.google.android.gms.plus.internal.d
   protected class_181 method_1823(IBinder var1) {
      return class_181.class_1509.method_5117(var1);
   }

   // $FF: renamed from: cj (java.lang.String) boolean
   public boolean method_1824(String var1) {
      return Arrays.asList(this.hv()).contains(var1);
   }

   public void clearDefaultAccount() {
      this.dS();

      try {
         this.anG = null;
         ((class_181)this.hw()).clearDefaultAccount();
      } catch (RemoteException var2) {
         throw new IllegalStateException(var2);
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
   public void method_1825(BaseImplementation.class_1058<People.LoadPeopleResult> var1, String[] var2) {
      this.method_1822(var1, Arrays.asList(var2));
   }

   public String getAccountName() {
      this.dS();

      try {
         String var2 = ((class_181)this.hw()).getAccountName();
         return var2;
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public Person getCurrentPerson() {
      this.dS();
      return this.anG;
   }

   // $FF: renamed from: j (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1826(BaseImplementation.class_1058<Moments.LoadMomentsResult> var1) {
      this.method_1820(var1, 20, (String)null, (Uri)null, (String)null, "me");
   }

   // $FF: renamed from: k (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1827(BaseImplementation.class_1058<People.LoadPeopleResult> var1) {
      this.dS();
      class_285.class_1111 var2 = new class_285.class_1111(var1);

      try {
         ((class_181)this.hw()).method_896(var2, 2, 1, -1, (String)null);
      } catch (RemoteException var4) {
         var2.method_884(DataHolder.method_5824(8), (String)null);
      }
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1823(var1);
   }

   // $FF: renamed from: l (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1828(BaseImplementation.class_1058<Status> var1) {
      this.dS();
      this.clearDefaultAccount();
      class_285.class_1113 var2 = new class_285.class_1113(var1);

      try {
         ((class_181)this.hw()).method_906(var2);
      } catch (RemoteException var4) {
         var2.method_889(8, (Bundle)null);
      }
   }

   // $FF: renamed from: q (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) com.google.android.gms.internal.jr
   public jr method_1829(BaseImplementation.class_1058<People.LoadPeopleResult> var1, String var2) {
      return this.method_1819(var1, 0, var2);
   }

   public void removeMoment(String var1) {
      this.dS();

      try {
         ((class_181)this.hw()).removeMoment(var1);
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   final class class_1107 extends class_680 {
      private final BaseImplementation.class_1058<Status> anI;

      public class_1107(BaseImplementation.class_1058<Status> var1) {
         this.anI = var2;
      }

      // $FF: renamed from: aA (com.google.android.gms.common.api.Status) void
      public void method_886(Status var1) {
         class_285.this.a(class_285.this.new class_1110(this.anI, var1));
      }
   }

   final class class_1108 extends class_680 {
      private final BaseImplementation.class_1058<Moments.LoadMomentsResult> anI;

      public class_1108(BaseImplementation.class_1058<Moments.LoadMomentsResult> var1) {
         this.anI = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, java.lang.String) void
      public void method_885(DataHolder var1, String var2, String var3) {
         PendingIntent var4;
         if(var1.method_5837() != null) {
            var4 = (PendingIntent)var1.method_5837().getParcelable("pendingIntent");
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

         class_285.this.a(class_285.this.new class_1109(this.anI, var5, var6, var2, var3));
      }
   }

   final class class_1109 extends com/google/android/gms/internal/jl<d>.d<BaseImplementation.class_1058<Moments.LoadMomentsResult>> implements Moments.LoadMomentsResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_2853;
      // $FF: renamed from: OB java.lang.String
      private final String field_2854;
      private final String anK;
      private MomentBuffer anL;

      public class_1109(BaseImplementation.class_1058<Moments.LoadMomentsResult> var1, Status var2, DataHolder var3, String var4, String var5) {
         super();
         this.field_2853 = var3;
         this.field_2854 = var5;
         this.anK = var6;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.common.data.DataHolder) void
      protected void method_3752(BaseImplementation.class_1058<Moments.LoadMomentsResult> var1, DataHolder var2) {
         MomentBuffer var3;
         if(var2 != null) {
            var3 = new MomentBuffer(var2);
         } else {
            var3 = null;
         }

         this.anL = var3;
         var1.method_110(this);
      }

      // $FF: renamed from: b (java.lang.Object, com.google.android.gms.common.data.DataHolder) void
      // $FF: synthetic method
      protected void method_3750(Object var1, DataHolder var2) {
         this.method_3752((BaseImplementation.class_1058)var1, var2);
      }

      public MomentBuffer getMomentBuffer() {
         return this.anL;
      }

      public String getNextPageToken() {
         return this.field_2854;
      }

      public Status getStatus() {
         return this.field_2853;
      }

      public String getUpdated() {
         return this.anK;
      }

      public void release() {
         if(this.anL != null) {
            this.anL.close();
         }

      }
   }

   final class class_1110 extends com/google/android/gms/internal/jl<d>.b<BaseImplementation.class_1058<Status>> {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_2848;

      public class_1110(BaseImplementation.class_1058<Status> var1, Status var2) {
         super();
         this.field_2848 = var3;
      }

      // $FF: renamed from: g (java.lang.Object) void
      // $FF: synthetic method
      protected void method_3743(Object var1) {
         this.method_3749((BaseImplementation.class_1058)var1);
      }

      // $FF: renamed from: hx () void
      protected void method_3744() {
      }

      // $FF: renamed from: m (com.google.android.gms.common.api.BaseImplementation$b) void
      protected void method_3749(BaseImplementation.class_1058<Status> var1) {
         if(var1 != null) {
            var1.method_110(this.field_2848);
         }

      }
   }

   final class class_1111 extends class_680 {
      private final BaseImplementation.class_1058<People.LoadPeopleResult> anI;

      public class_1111(BaseImplementation.class_1058<People.LoadPeopleResult> var1) {
         this.anI = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String) void
      public void method_884(DataHolder var1, String var2) {
         PendingIntent var3;
         if(var1.method_5837() != null) {
            var3 = (PendingIntent)var1.method_5837().getParcelable("pendingIntent");
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

         class_285.this.a(class_285.this.new class_1112(this.anI, var4, var5, var2));
      }
   }

   final class class_1112 extends com/google/android/gms/internal/jl<d>.d<BaseImplementation.class_1058<People.LoadPeopleResult>> implements People.LoadPeopleResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_2851;
      // $FF: renamed from: OB java.lang.String
      private final String field_2852;
      private PersonBuffer anM;

      public class_1112(BaseImplementation.class_1058<People.LoadPeopleResult> var1, Status var2, DataHolder var3, String var4) {
         super();
         this.field_2851 = var3;
         this.field_2852 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.common.data.DataHolder) void
      protected void method_3751(BaseImplementation.class_1058<People.LoadPeopleResult> var1, DataHolder var2) {
         PersonBuffer var3;
         if(var2 != null) {
            var3 = new PersonBuffer(var2);
         } else {
            var3 = null;
         }

         this.anM = var3;
         var1.method_110(this);
      }

      // $FF: renamed from: b (java.lang.Object, com.google.android.gms.common.data.DataHolder) void
      // $FF: synthetic method
      protected void method_3750(Object var1, DataHolder var2) {
         this.method_3751((BaseImplementation.class_1058)var1, var2);
      }

      public String getNextPageToken() {
         return this.field_2852;
      }

      public PersonBuffer getPersonBuffer() {
         return this.anM;
      }

      public Status getStatus() {
         return this.field_2851;
      }

      public void release() {
         if(this.anM != null) {
            this.anM.close();
         }

      }
   }

   final class class_1113 extends class_680 {
      private final BaseImplementation.class_1058<Status> anI;

      public class_1113(BaseImplementation.class_1058<Status> var1) {
         this.anI = var2;
      }

      // $FF: renamed from: h (int, android.os.Bundle) void
      public void method_889(int var1, Bundle var2) {
         PendingIntent var3;
         if(var2 != null) {
            var3 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var3 = null;
         }

         Status var4 = new Status(var1, (String)null, var3);
         class_285.this.a(class_285.this.new class_1114(this.anI, var4));
      }
   }

   final class class_1114 extends com/google/android/gms/internal/jl<d>.b<BaseImplementation.class_1058<Status>> {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_2847;

      public class_1114(BaseImplementation.class_1058<Status> var1, Status var2) {
         super();
         this.field_2847 = var3;
      }

      // $FF: renamed from: g (java.lang.Object) void
      // $FF: synthetic method
      protected void method_3743(Object var1) {
         this.method_3748((BaseImplementation.class_1058)var1);
      }

      // $FF: renamed from: hx () void
      protected void method_3744() {
      }

      // $FF: renamed from: m (com.google.android.gms.common.api.BaseImplementation$b) void
      protected void method_3748(BaseImplementation.class_1058<Status> var1) {
         class_285.this.disconnect();
         if(var1 != null) {
            var1.method_110(this.field_2847);
         }

      }
   }
}
