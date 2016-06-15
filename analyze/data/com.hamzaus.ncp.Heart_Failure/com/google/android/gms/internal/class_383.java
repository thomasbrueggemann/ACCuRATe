package com.google.android.gms.internal;

import com.google.android.gms.internal.aj;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.bp;
import com.google.android.gms.internal.bv;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_196;
import com.google.android.gms.internal.class_197;
import com.google.android.gms.internal.class_201;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.ey;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.eg
public final class class_383 {
   public final int errorCode;
   // $FF: renamed from: nK com.google.android.gms.internal.bm
   public final class_201 field_1709;
   // $FF: renamed from: nL com.google.android.gms.internal.bv
   public final class_11 field_1710;
   // $FF: renamed from: nM java.lang.String
   public final String field_1711;
   // $FF: renamed from: nN com.google.android.gms.internal.bp
   public final class_197 field_1712;
   // $FF: renamed from: nr java.util.List
   public final List<String> field_1713;
   // $FF: renamed from: ns java.util.List
   public final List<String> field_1714;
   // $FF: renamed from: nv long
   public final long field_1715;
   public final int orientation;
   // $FF: renamed from: ow com.google.android.gms.internal.ey
   public final class_369 field_1716;
   // $FF: renamed from: pV com.google.android.gms.internal.aj
   public final class_182 field_1717;
   // $FF: renamed from: pY java.lang.String
   public final String field_1718;
   // $FF: renamed from: qc long
   public final long field_1719;
   // $FF: renamed from: qd boolean
   public final boolean field_1720;
   // $FF: renamed from: qe long
   public final long field_1721;
   // $FF: renamed from: qf java.util.List
   public final List<String> field_1722;
   // $FF: renamed from: qi java.lang.String
   public final String field_1723;
   // $FF: renamed from: rv org.json.JSONObject
   public final JSONObject field_1724;
   // $FF: renamed from: rw com.google.android.gms.internal.bn
   public final class_196 field_1725;
   // $FF: renamed from: rx com.google.android.gms.internal.am
   public final class_172 field_1726;
   // $FF: renamed from: ry long
   public final long field_1727;
   // $FF: renamed from: rz long
   public final long field_1728;

   public class_383(aj var1, ey var2, List<String> var3, int var4, List<String> var5, List<String> var6, int var7, long var8, String var10, boolean var11, bm var12, bv var13, String var14, bn var15, bp var16, long var17, am var19, long var20, long var22, long var24, String var26, JSONObject var27) {
      this.field_1717 = var1;
      this.field_1716 = var2;
      List var28;
      if(var3 != null) {
         var28 = Collections.unmodifiableList(var3);
      } else {
         var28 = null;
      }

      this.field_1713 = var28;
      this.errorCode = var4;
      List var29;
      if(var5 != null) {
         var29 = Collections.unmodifiableList(var5);
      } else {
         var29 = null;
      }

      this.field_1714 = var29;
      List var30;
      if(var6 != null) {
         var30 = Collections.unmodifiableList(var6);
      } else {
         var30 = null;
      }

      this.field_1722 = var30;
      this.orientation = var7;
      this.field_1715 = var8;
      this.field_1718 = var10;
      this.field_1720 = var11;
      this.field_1709 = var12;
      this.field_1710 = var13;
      this.field_1711 = var14;
      this.field_1725 = var15;
      this.field_1712 = var16;
      this.field_1721 = var17;
      this.field_1726 = var19;
      this.field_1719 = var20;
      this.field_1727 = var22;
      this.field_1728 = var24;
      this.field_1723 = var26;
      this.field_1724 = var27;
   }
}
