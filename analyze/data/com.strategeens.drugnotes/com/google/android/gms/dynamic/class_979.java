package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.class_197;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;

// $FF: renamed from: com.google.android.gms.dynamic.b
public final class class_979 extends class_197.class_1372 {
   // $FF: renamed from: TG android.app.Fragment
   private Fragment field_4249;

   private class_979(Fragment var1) {
      this.field_4249 = var1;
   }

   // $FF: renamed from: a (android.app.Fragment) com.google.android.gms.dynamic.b
   public static class_979 method_5471(Fragment var0) {
      return var0 != null?new class_979(var0):null;
   }

   // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
   public void method_1067(class_198 var1) {
      View var2 = (View)class_960.method_5292(var1);
      this.field_4249.registerForContextMenu(var2);
   }

   // $FF: renamed from: e (com.google.android.gms.dynamic.d) void
   public void method_1068(class_198 var1) {
      View var2 = (View)class_960.method_5292(var1);
      this.field_4249.unregisterForContextMenu(var2);
   }

   public Bundle getArguments() {
      return this.field_4249.getArguments();
   }

   public int getId() {
      return this.field_4249.getId();
   }

   public boolean getRetainInstance() {
      return this.field_4249.getRetainInstance();
   }

   public String getTag() {
      return this.field_4249.getTag();
   }

   public int getTargetRequestCode() {
      return this.field_4249.getTargetRequestCode();
   }

   public boolean getUserVisibleHint() {
      return this.field_4249.getUserVisibleHint();
   }

   public class_198 getView() {
      return class_960.method_5293(this.field_4249.getView());
   }

   public boolean isAdded() {
      return this.field_4249.isAdded();
   }

   public boolean isDetached() {
      return this.field_4249.isDetached();
   }

   public boolean isHidden() {
      return this.field_4249.isHidden();
   }

   public boolean isInLayout() {
      return this.field_4249.isInLayout();
   }

   public boolean isRemoving() {
      return this.field_4249.isRemoving();
   }

   public boolean isResumed() {
      return this.field_4249.isResumed();
   }

   public boolean isVisible() {
      return this.field_4249.isVisible();
   }

   // $FF: renamed from: jf () com.google.android.gms.dynamic.d
   public class_198 method_1069() {
      return class_960.method_5293(this.field_4249.getActivity());
   }

   // $FF: renamed from: jg () com.google.android.gms.dynamic.c
   public class_197 method_1070() {
      return method_5471(this.field_4249.getParentFragment());
   }

   // $FF: renamed from: jh () com.google.android.gms.dynamic.d
   public class_198 method_1071() {
      return class_960.method_5293(this.field_4249.getResources());
   }

   // $FF: renamed from: ji () com.google.android.gms.dynamic.c
   public class_197 method_1072() {
      return method_5471(this.field_4249.getTargetFragment());
   }

   public void setHasOptionsMenu(boolean var1) {
      this.field_4249.setHasOptionsMenu(var1);
   }

   public void setMenuVisibility(boolean var1) {
      this.field_4249.setMenuVisibility(var1);
   }

   public void setRetainInstance(boolean var1) {
      this.field_4249.setRetainInstance(var1);
   }

   public void setUserVisibleHint(boolean var1) {
      this.field_4249.setUserVisibleHint(var1);
   }

   public void startActivity(Intent var1) {
      this.field_4249.startActivity(var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.field_4249.startActivityForResult(var1, var2);
   }
}
