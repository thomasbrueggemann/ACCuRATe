package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.class_156;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;

// $FF: renamed from: com.google.android.gms.dynamic.b
public final class class_755 extends class_156.class_1035 {
   // $FF: renamed from: Mg android.app.Fragment
   private Fragment field_4109;

   private class_755(Fragment var1) {
      this.field_4109 = var1;
   }

   // $FF: renamed from: a (android.app.Fragment) com.google.android.gms.dynamic.b
   public static class_755 method_4325(Fragment var0) {
      return var0 != null?new class_755(var0):null;
   }

   // $FF: renamed from: c (com.google.android.gms.dynamic.d) void
   public void method_869(class_157 var1) {
      View var2 = (View)class_741.method_4177(var1);
      this.field_4109.registerForContextMenu(var2);
   }

   // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
   public void method_870(class_157 var1) {
      View var2 = (View)class_741.method_4177(var1);
      this.field_4109.unregisterForContextMenu(var2);
   }

   // $FF: renamed from: gD () com.google.android.gms.dynamic.d
   public class_157 method_871() {
      return class_741.method_4178(this.field_4109.getActivity());
   }

   // $FF: renamed from: gE () com.google.android.gms.dynamic.c
   public class_156 method_872() {
      return method_4325(this.field_4109.getParentFragment());
   }

   // $FF: renamed from: gF () com.google.android.gms.dynamic.d
   public class_157 method_873() {
      return class_741.method_4178(this.field_4109.getResources());
   }

   // $FF: renamed from: gG () com.google.android.gms.dynamic.c
   public class_156 method_874() {
      return method_4325(this.field_4109.getTargetFragment());
   }

   public Bundle getArguments() {
      return this.field_4109.getArguments();
   }

   public int getId() {
      return this.field_4109.getId();
   }

   public boolean getRetainInstance() {
      return this.field_4109.getRetainInstance();
   }

   public String getTag() {
      return this.field_4109.getTag();
   }

   public int getTargetRequestCode() {
      return this.field_4109.getTargetRequestCode();
   }

   public boolean getUserVisibleHint() {
      return this.field_4109.getUserVisibleHint();
   }

   public class_157 getView() {
      return class_741.method_4178(this.field_4109.getView());
   }

   public boolean isAdded() {
      return this.field_4109.isAdded();
   }

   public boolean isDetached() {
      return this.field_4109.isDetached();
   }

   public boolean isHidden() {
      return this.field_4109.isHidden();
   }

   public boolean isInLayout() {
      return this.field_4109.isInLayout();
   }

   public boolean isRemoving() {
      return this.field_4109.isRemoving();
   }

   public boolean isResumed() {
      return this.field_4109.isResumed();
   }

   public boolean isVisible() {
      return this.field_4109.isVisible();
   }

   public void setHasOptionsMenu(boolean var1) {
      this.field_4109.setHasOptionsMenu(var1);
   }

   public void setMenuVisibility(boolean var1) {
      this.field_4109.setMenuVisibility(var1);
   }

   public void setRetainInstance(boolean var1) {
      this.field_4109.setRetainInstance(var1);
   }

   public void setUserVisibleHint(boolean var1) {
      this.field_4109.setUserVisibleHint(var1);
   }

   public void startActivity(Intent var1) {
      this.field_4109.startActivity(var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.field_4109.startActivityForResult(var1, var2);
   }
}
