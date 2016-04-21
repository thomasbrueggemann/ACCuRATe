package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_205;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.dynamic.b
public final class class_1065 extends class_205.class_1416 {
    // $FF: renamed from: Sj android.app.Fragment
    private Fragment field_5092;

    private class_1065(Fragment var1) {
        this.field_5092 = var1;
    }

    // $FF: renamed from: a (android.app.Fragment) com.google.android.gms.dynamic.b
    public static class_1065 method_5583(Fragment var0) {
        return var0 != null?new class_1065(var0):null;
    }

    // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
    public void method_1059(class_206 var1) {
        View var2 = (View)class_1046.method_5436(var1);
        this.field_5092.registerForContextMenu(var2);
    }

    // $FF: renamed from: e (com.google.android.gms.dynamic.d) void
    public void method_1060(class_206 var1) {
        View var2 = (View)class_1046.method_5436(var1);
        this.field_5092.unregisterForContextMenu(var2);
    }

    public Bundle getArguments() {
        return this.field_5092.getArguments();
    }

    public int getId() {
        return this.field_5092.getId();
    }

    public boolean getRetainInstance() {
        return this.field_5092.getRetainInstance();
    }

    public String getTag() {
        return this.field_5092.getTag();
    }

    public int getTargetRequestCode() {
        return this.field_5092.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.field_5092.getUserVisibleHint();
    }

    public class_206 getView() {
        return class_1046.method_5437(this.field_5092.getView());
    }

    public boolean isAdded() {
        return this.field_5092.isAdded();
    }

    public boolean isDetached() {
        return this.field_5092.isDetached();
    }

    public boolean isHidden() {
        return this.field_5092.isHidden();
    }

    public boolean isInLayout() {
        return this.field_5092.isInLayout();
    }

    public boolean isRemoving() {
        return this.field_5092.isRemoving();
    }

    public boolean isResumed() {
        return this.field_5092.isResumed();
    }

    public boolean isVisible() {
        return this.field_5092.isVisible();
    }

    // $FF: renamed from: iu () com.google.android.gms.dynamic.d
    public class_206 method_1061() {
        return class_1046.method_5437(this.field_5092.getActivity());
    }

    // $FF: renamed from: iv () com.google.android.gms.dynamic.c
    public class_205 method_1062() {
        return method_5583(this.field_5092.getParentFragment());
    }

    // $FF: renamed from: iw () com.google.android.gms.dynamic.d
    public class_206 method_1063() {
        return class_1046.method_5437(this.field_5092.getResources());
    }

    // $FF: renamed from: ix () com.google.android.gms.dynamic.c
    public class_205 method_1064() {
        return method_5583(this.field_5092.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean var1) {
        this.field_5092.setHasOptionsMenu(var1);
    }

    public void setMenuVisibility(boolean var1) {
        this.field_5092.setMenuVisibility(var1);
    }

    public void setRetainInstance(boolean var1) {
        this.field_5092.setRetainInstance(var1);
    }

    public void setUserVisibleHint(boolean var1) {
        this.field_5092.setUserVisibleHint(var1);
    }

    public void startActivity(Intent var1) {
        this.field_5092.startActivity(var1);
    }

    public void startActivityForResult(Intent var1, int var2) {
        this.field_5092.startActivityForResult(var1, var2);
    }
}
