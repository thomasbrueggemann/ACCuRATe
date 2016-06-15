package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.auth.AccountChangeEventCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

public class AccountChangeEvent implements SafeParcelable {
   public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
   // $FF: renamed from: DZ java.lang.String
   final String field_4270;
   // $FF: renamed from: Ef int
   final int field_4271;
   // $FF: renamed from: Eg long
   final long field_4272;
   // $FF: renamed from: Eh int
   final int field_4273;
   // $FF: renamed from: Ei int
   final int field_4274;
   // $FF: renamed from: Ej java.lang.String
   final String field_4275;

   AccountChangeEvent(int var1, long var2, String var4, int var5, int var6, String var7) {
      this.field_4271 = var1;
      this.field_4272 = var2;
      this.field_4270 = (String)class_335.method_2311(var4);
      this.field_4273 = var5;
      this.field_4274 = var6;
      this.field_4275 = var7;
   }

   public AccountChangeEvent(long var1, String var3, int var4, int var5, String var6) {
      this.field_4271 = 1;
      this.field_4272 = var1;
      this.field_4270 = (String)class_335.method_2311(var3);
      this.field_4273 = var4;
      this.field_4274 = var5;
      this.field_4275 = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof AccountChangeEvent)) {
            return false;
         }

         AccountChangeEvent var2 = (AccountChangeEvent)var1;
         if(this.field_4271 != var2.field_4271 || this.field_4272 != var2.field_4272 || !class_336.equal(this.field_4270, var2.field_4270) || this.field_4273 != var2.field_4273 || this.field_4274 != var2.field_4274 || !class_336.equal(this.field_4275, var2.field_4275)) {
            return false;
         }
      }

      return true;
   }

   public String getAccountName() {
      return this.field_4270;
   }

   public String getChangeData() {
      return this.field_4275;
   }

   public int getChangeType() {
      return this.field_4273;
   }

   public int getEventIndex() {
      return this.field_4274;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_4271), Long.valueOf(this.field_4272), this.field_4270, Integer.valueOf(this.field_4273), Integer.valueOf(this.field_4274), this.field_4275};
      return class_336.hashCode(var1);
   }

   public String toString() {
      String var1 = "UNKNOWN";
      switch(this.field_4273) {
      case 1:
         var1 = "ADDED";
         break;
      case 2:
         var1 = "REMOVED";
         break;
      case 3:
         var1 = "RENAMED_FROM";
         break;
      case 4:
         var1 = "RENAMED_TO";
      }

      return "AccountChangeEvent {accountName = " + this.field_4270 + ", changeType = " + var1 + ", changeData = " + this.field_4275 + ", eventIndex = " + this.field_4274 + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      AccountChangeEventCreator.method_1504(this, var1, var2);
   }
}
