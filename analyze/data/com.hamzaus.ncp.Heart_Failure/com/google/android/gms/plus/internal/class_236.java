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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_287;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.internal.class_289;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hh;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.class_145;
import com.google.android.gms.plus.internal.class_579;
import com.google.android.gms.plus.internal.class_677;
import com.google.android.gms.plus.internal.d;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.plus.internal.e
public class class_236 extends hc<d> {
   private Person abG;
   private final class_677 abH;

   public class_236(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, class_677 var5) {
      super(var1, var2, var3, var4, var5.method_3937());
      this.abH = var5;
   }

   @Deprecated
   public class_236(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, class_677 var4) {
      this(var1, var1.getMainLooper(), new class_234.class_909(var2), new class_234.class_913(var3), var4);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, java.lang.String) com.google.android.gms.internal.hh
   public hh method_1479(class_797.class_1206<People.LoadPeopleResult> var1, int var2, String var3) {
      this.ci();
      class_236.class_891 var4 = new class_236.class_891(var1);

      try {
         class_33 var6 = ((class_145)this.fo()).method_731(var4, 1, var2, -1, var3);
         return var6;
      } catch (RemoteException var7) {
         var4.method_725(DataHolder.method_4552(8), (String)null);
         return null;
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1446(int var1, IBinder var2, Bundle var3) {
      if(var1 == 0 && var3 != null && var3.containsKey("loaded_person")) {
         this.abG = class_288.method_1931(var3.getByteArray("loaded_person"));
      }

      super.method_1446(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, java.lang.String, android.net.Uri, java.lang.String, java.lang.String) void
   public void method_1480(class_797.class_1206<Moments.LoadMomentsResult> var1, int var2, String var3, Uri var4, String var5, String var6) {
      this.ci();
      class_236.class_888 var7;
      if(var1 != null) {
         var7 = new class_236.class_888(var1);
      } else {
         var7 = null;
      }

      try {
         ((class_145)this.fo()).method_734(var7, var2, var3, var4, var5, var6);
      } catch (RemoteException var9) {
         var7.method_726(DataHolder.method_4552(8), (String)null, (String)null);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.plus.model.moments.Moment) void
   public void method_1481(class_797.class_1206<Status> var1, Moment var2) {
      this.ci();
      class_236.class_887 var3;
      if(var1 != null) {
         var3 = new class_236.class_887(var1);
      } else {
         var3 = null;
      }

      try {
         class_289 var5 = class_289.method_1941((class_287)var2);
         ((class_145)this.fo()).method_736(var3, var5);
      } catch (RemoteException var6) {
         if(var3 == null) {
            throw new IllegalStateException(var6);
         } else {
            var3.method_727(new Status(8, (String)null, (PendingIntent)null));
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.util.Collection) void
   public void method_1482(class_797.class_1206<People.LoadPeopleResult> var1, Collection<String> var2) {
      this.ci();
      class_236.class_891 var3 = new class_236.class_891(var1);

      try {
         ((class_145)this.fo()).method_739(var3, new ArrayList(var2));
      } catch (RemoteException var5) {
         var3.method_725(DataHolder.method_4552(8), (String)null);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      Bundle var3 = this.abH.method_3945();
      var3.putStringArray("request_visible_actions", this.abH.method_3938());
      var1.method_160(var2, 5077000, this.abH.method_3941(), this.abH.method_3940(), this.fn(), this.abH.getAccountName(), var3);
   }

   // $FF: renamed from: bn (android.os.IBinder) com.google.android.gms.plus.internal.d
   protected class_145 method_1483(IBinder var1) {
      return class_145.class_1149.method_4057(var1);
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.plus.service.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.plus.internal.IPlusService";
   }

   // $FF: renamed from: by (java.lang.String) boolean
   public boolean method_1484(String var1) {
      return Arrays.asList(this.fn()).contains(var1);
   }

   public void clearDefaultAccount() {
      this.ci();

      try {
         this.abG = null;
         ((class_145)this.fo()).clearDefaultAccount();
      } catch (RemoteException var2) {
         throw new IllegalStateException(var2);
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, java.lang.String[]) void
   public void method_1485(class_797.class_1206<People.LoadPeopleResult> var1, String[] var2) {
      this.method_1482(var1, Arrays.asList(var2));
   }

   public String getAccountName() {
      this.ci();

      try {
         String var2 = ((class_145)this.fo()).getAccountName();
         return var2;
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public Person getCurrentPerson() {
      this.ci();
      return this.abG;
   }

   // $FF: renamed from: k (com.google.android.gms.common.api.a$d) void
   public void method_1486(class_797.class_1206<Moments.LoadMomentsResult> var1) {
      this.method_1480(var1, 20, (String)null, (Uri)null, (String)null, "me");
   }

   // $FF: renamed from: l (com.google.android.gms.common.api.a$d) void
   public void method_1487(class_797.class_1206<People.LoadPeopleResult> var1) {
      this.ci();
      class_236.class_891 var2 = new class_236.class_891(var1);

      try {
         ((class_145)this.fo()).method_731(var2, 2, 1, -1, (String)null);
      } catch (RemoteException var4) {
         var2.method_725(DataHolder.method_4552(8), (String)null);
      }
   }

   // $FF: renamed from: m (com.google.android.gms.common.api.a$d) void
   public void method_1488(class_797.class_1206<Status> var1) {
      this.ci();
      this.clearDefaultAccount();
      class_236.class_893 var2 = new class_236.class_893(var1);

      try {
         ((class_145)this.fo()).method_741(var2);
      } catch (RemoteException var4) {
         var2.method_730(8, (Bundle)null);
      }
   }

   // $FF: renamed from: r (com.google.android.gms.common.api.a$d, java.lang.String) com.google.android.gms.internal.hh
   public hh method_1489(class_797.class_1206<People.LoadPeopleResult> var1, String var2) {
      return this.method_1479(var1, 0, var2);
   }

   public void removeMoment(String var1) {
      this.ci();

      try {
         ((class_145)this.fo()).removeMoment(var1);
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1483(var1);
   }

   final class class_887 extends class_579 {
      private final class_797.class_1206<Status> abI;

      public class_887(class_797.class_1206<Status> var1) {
         this.abI = var2;
      }

      // $FF: renamed from: am (com.google.android.gms.common.api.Status) void
      public void method_727(Status var1) {
         class_236.this.a(class_236.this.new class_890(this.abI, var1));
      }
   }

   final class class_888 extends class_579 {
      private final class_797.class_1206<Moments.LoadMomentsResult> abI;

      public class_888(class_797.class_1206<Moments.LoadMomentsResult> var1) {
         this.abI = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, java.lang.String) void
      public void method_726(DataHolder var1, String var2, String var3) {
         PendingIntent var4;
         if(var1.method_4563() != null) {
            var4 = (PendingIntent)var1.method_4563().getParcelable("pendingIntent");
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

         class_236.this.a(class_236.this.new class_889(this.abI, var5, var6, var2, var3));
      }
   }

   final class class_889 extends com/google/android/gms/internal/hc<d>.d<class_797.class_1206<Moments.LoadMomentsResult>> implements Moments.LoadMomentsResult {
      // $FF: renamed from: HP java.lang.String
      private final String field_1975;
      private final String abK;
      private MomentBuffer abL;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_1976;

      public class_889(class_797.class_1206<Moments.LoadMomentsResult> var1, Status var2, DataHolder var3, String var4, String var5) {
         super();
         this.field_1976 = var3;
         this.field_1975 = var5;
         this.abK = var6;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.common.data.DataHolder) void
      protected void method_2661(class_797.class_1206<Moments.LoadMomentsResult> var1, DataHolder var2) {
         MomentBuffer var3;
         if(var2 != null) {
            var3 = new MomentBuffer(var2);
         } else {
            var3 = null;
         }

         this.abL = var3;
         var1.method_673(this);
      }

      public MomentBuffer getMomentBuffer() {
         return this.abL;
      }

      public String getNextPageToken() {
         return this.field_1975;
      }

      public Status getStatus() {
         return this.field_1976;
      }

      public String getUpdated() {
         return this.abK;
      }

      public void release() {
         if(this.abL != null) {
            this.abL.close();
         }

      }
   }

   final class class_890 extends com/google/android/gms/internal/hc<d>.b<class_797.class_1206<Status>> {
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_1939;

      public class_890(class_797.class_1206<Status> var1, Status var2) {
         super();
         this.field_1939 = var3;
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2646((class_797.class_1206)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.a$d) void
      protected void method_2646(class_797.class_1206<Status> var1) {
         if(var1 != null) {
            var1.method_673(this.field_1939);
         }

      }
   }

   final class class_891 extends class_579 {
      private final class_797.class_1206<People.LoadPeopleResult> abI;

      public class_891(class_797.class_1206<People.LoadPeopleResult> var1) {
         this.abI = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String) void
      public void method_725(DataHolder var1, String var2) {
         PendingIntent var3;
         if(var1.method_4563() != null) {
            var3 = (PendingIntent)var1.method_4563().getParcelable("pendingIntent");
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

         class_236.this.a(class_236.this.new class_892(this.abI, var4, var5, var2));
      }
   }

   final class class_892 extends com/google/android/gms/internal/hc<d>.d<class_797.class_1206<People.LoadPeopleResult>> implements People.LoadPeopleResult {
      // $FF: renamed from: HP java.lang.String
      private final String field_1973;
      private PersonBuffer abM;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_1974;

      public class_892(class_797.class_1206<People.LoadPeopleResult> var1, Status var2, DataHolder var3, String var4) {
         super();
         this.field_1974 = var3;
         this.field_1973 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.common.data.DataHolder) void
      protected void method_2660(class_797.class_1206<People.LoadPeopleResult> var1, DataHolder var2) {
         PersonBuffer var3;
         if(var2 != null) {
            var3 = new PersonBuffer(var2);
         } else {
            var3 = null;
         }

         this.abM = var3;
         var1.method_673(this);
      }

      public String getNextPageToken() {
         return this.field_1973;
      }

      public PersonBuffer getPersonBuffer() {
         return this.abM;
      }

      public Status getStatus() {
         return this.field_1974;
      }

      public void release() {
         if(this.abM != null) {
            this.abM.close();
         }

      }
   }

   final class class_893 extends class_579 {
      private final class_797.class_1206<Status> abI;

      public class_893(class_797.class_1206<Status> var1) {
         this.abI = var2;
      }

      // $FF: renamed from: h (int, android.os.Bundle) void
      public void method_730(int var1, Bundle var2) {
         PendingIntent var3;
         if(var2 != null) {
            var3 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var3 = null;
         }

         Status var4 = new Status(var1, (String)null, var3);
         class_236.this.a(class_236.this.new class_894(this.abI, var4));
      }
   }

   final class class_894 extends com/google/android/gms/internal/hc<d>.b<class_797.class_1206<Status>> {
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_1938;

      public class_894(class_797.class_1206<Status> var1, Status var2) {
         super();
         this.field_1938 = var3;
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2645((class_797.class_1206)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.a$d) void
      protected void method_2645(class_797.class_1206<Status> var1) {
         class_236.this.disconnect();
         if(var1 != null) {
            var1.method_673(this.field_1938);
         }

      }
   }
}
