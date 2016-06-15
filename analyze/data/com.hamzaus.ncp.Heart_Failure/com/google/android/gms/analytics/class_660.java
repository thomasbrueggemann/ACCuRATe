package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

// $FF: renamed from: com.google.android.gms.analytics.u
class class_660 {
   // $FF: renamed from: uS com.google.android.gms.analytics.u
   private static final class_660 field_3460 = new class_660();
   // $FF: renamed from: uP java.util.SortedSet
   private SortedSet<class_660.class_1313> field_3461 = new TreeSet();
   // $FF: renamed from: uQ java.lang.StringBuilder
   private StringBuilder field_3462 = new StringBuilder();
   // $FF: renamed from: uR boolean
   private boolean field_3463 = false;

   // $FF: renamed from: cP () com.google.android.gms.analytics.u
   public static class_660 method_3794() {
      return field_3460;
   }

   // $FF: renamed from: a (com.google.android.gms.analytics.u$a) void
   public void method_3795(class_660.class_1313 var1) {
      synchronized(this){}

      try {
         if(!this.field_3463) {
            this.field_3461.add(var1);
            this.field_3462.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(var1.ordinal()));
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: cQ () java.lang.String
   public String method_3796() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cR () java.lang.String
   public String method_3797() {
      synchronized(this){}

      String var2;
      try {
         if(this.field_3462.length() > 0) {
            this.field_3462.insert(0, ".");
         }

         var2 = this.field_3462.toString();
         this.field_3462 = new StringBuilder();
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: u (boolean) void
   public void method_3798(boolean var1) {
      synchronized(this){}

      try {
         this.field_3463 = var1;
      } finally {
         ;
      }

   }

   public static enum class_1313 {
      // $FF: renamed from: uT com.google.android.gms.analytics.u$a
      field_3754,
      // $FF: renamed from: uU com.google.android.gms.analytics.u$a
      field_3755,
      // $FF: renamed from: uV com.google.android.gms.analytics.u$a
      field_3756,
      // $FF: renamed from: uW com.google.android.gms.analytics.u$a
      field_3757,
      // $FF: renamed from: uX com.google.android.gms.analytics.u$a
      field_3758,
      // $FF: renamed from: uY com.google.android.gms.analytics.u$a
      field_3759,
      // $FF: renamed from: uZ com.google.android.gms.analytics.u$a
      field_3760,
      // $FF: renamed from: vA com.google.android.gms.analytics.u$a
      field_3761,
      // $FF: renamed from: vB com.google.android.gms.analytics.u$a
      field_3762,
      // $FF: renamed from: vC com.google.android.gms.analytics.u$a
      field_3763,
      // $FF: renamed from: vD com.google.android.gms.analytics.u$a
      field_3764,
      // $FF: renamed from: vE com.google.android.gms.analytics.u$a
      field_3765,
      // $FF: renamed from: vF com.google.android.gms.analytics.u$a
      field_3766,
      // $FF: renamed from: vG com.google.android.gms.analytics.u$a
      field_3767,
      // $FF: renamed from: vH com.google.android.gms.analytics.u$a
      field_3768,
      // $FF: renamed from: vI com.google.android.gms.analytics.u$a
      field_3769,
      // $FF: renamed from: vJ com.google.android.gms.analytics.u$a
      field_3770,
      // $FF: renamed from: vK com.google.android.gms.analytics.u$a
      field_3771,
      // $FF: renamed from: vL com.google.android.gms.analytics.u$a
      field_3772,
      // $FF: renamed from: vM com.google.android.gms.analytics.u$a
      field_3773,
      // $FF: renamed from: vN com.google.android.gms.analytics.u$a
      field_3774,
      // $FF: renamed from: vO com.google.android.gms.analytics.u$a
      field_3775,
      // $FF: renamed from: vP com.google.android.gms.analytics.u$a
      field_3776,
      // $FF: renamed from: vQ com.google.android.gms.analytics.u$a
      field_3777,
      // $FF: renamed from: vR com.google.android.gms.analytics.u$a
      field_3778,
      // $FF: renamed from: vS com.google.android.gms.analytics.u$a
      field_3779,
      // $FF: renamed from: vT com.google.android.gms.analytics.u$a
      field_3780,
      // $FF: renamed from: vU com.google.android.gms.analytics.u$a
      field_3781,
      // $FF: renamed from: vV com.google.android.gms.analytics.u$a
      field_3782,
      // $FF: renamed from: vW com.google.android.gms.analytics.u$a
      field_3783,
      // $FF: renamed from: vX com.google.android.gms.analytics.u$a
      field_3784,
      // $FF: renamed from: vY com.google.android.gms.analytics.u$a
      field_3785,
      // $FF: renamed from: vZ com.google.android.gms.analytics.u$a
      field_3786,
      // $FF: renamed from: va com.google.android.gms.analytics.u$a
      field_3787,
      // $FF: renamed from: vb com.google.android.gms.analytics.u$a
      field_3788,
      // $FF: renamed from: vc com.google.android.gms.analytics.u$a
      field_3789,
      // $FF: renamed from: vd com.google.android.gms.analytics.u$a
      field_3790,
      // $FF: renamed from: ve com.google.android.gms.analytics.u$a
      field_3791,
      // $FF: renamed from: vf com.google.android.gms.analytics.u$a
      field_3792,
      // $FF: renamed from: vg com.google.android.gms.analytics.u$a
      field_3793,
      // $FF: renamed from: vh com.google.android.gms.analytics.u$a
      field_3794,
      // $FF: renamed from: vi com.google.android.gms.analytics.u$a
      field_3795,
      // $FF: renamed from: vj com.google.android.gms.analytics.u$a
      field_3796,
      // $FF: renamed from: vk com.google.android.gms.analytics.u$a
      field_3797,
      // $FF: renamed from: vl com.google.android.gms.analytics.u$a
      field_3798,
      // $FF: renamed from: vm com.google.android.gms.analytics.u$a
      field_3799,
      // $FF: renamed from: vn com.google.android.gms.analytics.u$a
      field_3800,
      // $FF: renamed from: vo com.google.android.gms.analytics.u$a
      field_3801,
      // $FF: renamed from: vp com.google.android.gms.analytics.u$a
      field_3802,
      // $FF: renamed from: vq com.google.android.gms.analytics.u$a
      field_3803,
      // $FF: renamed from: vr com.google.android.gms.analytics.u$a
      field_3804,
      // $FF: renamed from: vs com.google.android.gms.analytics.u$a
      field_3805,
      // $FF: renamed from: vt com.google.android.gms.analytics.u$a
      field_3806,
      // $FF: renamed from: vu com.google.android.gms.analytics.u$a
      field_3807,
      // $FF: renamed from: vv com.google.android.gms.analytics.u$a
      field_3808,
      // $FF: renamed from: vw com.google.android.gms.analytics.u$a
      field_3809,
      // $FF: renamed from: vx com.google.android.gms.analytics.u$a
      field_3810,
      // $FF: renamed from: vy com.google.android.gms.analytics.u$a
      field_3811,
      // $FF: renamed from: vz com.google.android.gms.analytics.u$a
      field_3812,
      // $FF: renamed from: wa com.google.android.gms.analytics.u$a
      field_3813,
      // $FF: renamed from: wb com.google.android.gms.analytics.u$a
      field_3814,
      // $FF: renamed from: wc com.google.android.gms.analytics.u$a
      field_3815,
      // $FF: renamed from: wd com.google.android.gms.analytics.u$a
      field_3816;

      static {
         class_660.class_1313[] var0 = new class_660.class_1313[]{field_3754, field_3755, field_3756, field_3757, field_3758, field_3759, field_3760, field_3787, field_3788, field_3789, field_3790, field_3791, field_3792, field_3793, field_3794, field_3795, field_3796, field_3797, field_3798, field_3799, field_3800, field_3801, field_3802, field_3803, field_3804, field_3805, field_3806, field_3807, field_3808, field_3809, field_3810, field_3811, field_3812, field_3761, field_3762, field_3763, field_3764, field_3765, field_3766, field_3767, field_3768, field_3769, field_3770, field_3771, field_3772, field_3773, field_3774, field_3775, field_3776, field_3777, field_3778, field_3779, field_3780, field_3781, field_3782, field_3783, field_3784, field_3785, field_3786, field_3813, field_3814, field_3815, field_3816};
      }
   }
}
