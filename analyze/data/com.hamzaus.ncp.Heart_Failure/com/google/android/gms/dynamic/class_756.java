package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.class_156;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;

// $FF: renamed from: com.google.android.gms.dynamic.h
public final class class_756 extends class_156.class_1035 {
   // $FF: renamed from: FS android.support.v4.app.Fragment
   private Fragment field_4110;

   private class_756(Fragment var1) {
      this.field_4110 = var1;
   }

   // $FF: renamed from: a (android.support.v4.app.Fragment) com.google.android.gms.dynamic.h
   public static class_756 method_4326(Fragment var0) {
      return var0 != null?new class_756(var0):null;
   }

   // $FF: renamed from: c (com.google.android.gms.dynamic.d) void
   public void method_869(class_157 var1) {
      View var2 = (View)class_741.method_4177(var1);
      this.field_4110.registerForContextMenu(var2);
   }

   // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
   public void method_870(class_157 var1) {
      View var2 = (View)class_741.method_4177(var1);
      this.field_4110.unregisterForContextMenu(var2);
   }

   // $FF: renamed from: gD () com.google.android.gms.dynamic.d
   public class_157 method_871() {
      return class_741.method_4178(this.field_4110.getActivity());
   }

   // $FF: renamed from: gE () com.google.android.gms.dynamic.c
   public class_156 method_872() {
      return method_4326(this.field_4110.getParentFragment());
   }

   // $FF: renamed from: gF () com.google.android.gms.dynamic.d
   public class_157 method_873() {
      return class_741.method_4178(this.field_4110.getResources());
   }

   // $FF: renamed from: gG () com.google.android.gms.dynamic.c
   public class_156 method_874() {
      return method_4326(this.field_4110.getTargetFragment());
   }

   public Bundle getArguments() {
      return this.field_4110.getArguments();
   }

   public int getId() {
      return this.field_4110.getId();
   }

   public boolean getRetainInstance() {
      return this.field_4110.getRetainInstance();
   }

   public String getTag() {
      return this.field_4110.getTag();
   }

   public int getTargetRequestCode() {
      return this.field_4110.getTargetRequestCode();
   }

   public boolean getUserVisibleHint() {
      return this.field_4110.getUserVisibleHint();
   }

   public class_157 getView() {
      return class_741.method_4178(this.field_4110.getView());
   }

   public boolean isAdded() {
      return this.field_4110.isAdded();
   }

   public boolean isDetached() {
      return this.field_4110.isDetached();
   }

   public boolean isHidden() {
      return this.field_4110.isHidden();
   }

   public boolean isInLayout() {
      return this.field_4110.isInLayout();
   }

   public boolean isRemoving() {
      return this.field_4110.isRemoving();
   }

   public boolean isResumed() {
      return this.field_4110.isResumed();
   }

   public boolean isVisible() {
      return this.field_4110.isVisible();
   }

   public void setHasOptionsMenu(boolean var1) {
      this.field_4110.setHasOptionsMenu(var1);
   }

   public void setMenuVisibility(boolean var1) {
      this.field_4110.setMenuVisibility(var1);
   }

   public void setRetainInstance(boolean var1) {
      this.field_4110.setRetainInstance(var1);
   }

   public void setUserVisibleHint(boolean var1) {
      this.field_4110.setUserVisibleHint(var1);
   }

   public void startActivity(Intent var1) {
      this.field_4110.startActivity(var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.field_4110.startActivityForResult(var1, var2);
   }
}
