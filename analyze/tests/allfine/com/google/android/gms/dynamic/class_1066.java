package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_205;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.dynamic.h
public final class class_1066 extends class_205.class_1416 {
    // $FF: renamed from: Lt android.support.v4.app.Fragment
    private Fragment field_5093;

    private class_1066(Fragment var1) {
        this.field_5093 = var1;
    }

    // $FF: renamed from: a (android.support.v4.app.Fragment) com.google.android.gms.dynamic.h
    public static class_1066 method_5584(Fragment var0) {
        return var0 != null?new class_1066(var0):null;
    }

    // $FF: renamed from: d (com.google.android.gms.dynamic.d) void
    public void method_1059(class_206 var1) {
        View var2 = (View)class_1046.method_5436(var1);
        this.field_5093.registerForContextMenu(var2);
    }

    // $FF: renamed from: e (com.google.android.gms.dynamic.d) void
    public void method_1060(class_206 var1) {
        View var2 = (View)class_1046.method_5436(var1);
        this.field_5093.unregisterForContextMenu(var2);
    }

    public Bundle getArguments() {
        return this.field_5093.getArguments();
    }

    public int getId() {
        return this.field_5093.getId();
    }

    public boolean getRetainInstance() {
        return this.field_5093.getRetainInstance();
    }

    public String getTag() {
        return this.field_5093.getTag();
    }

    public int getTargetRequestCode() {
        return this.field_5093.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.field_5093.getUserVisibleHint();
    }

    public class_206 getView() {
        return class_1046.method_5437(this.field_5093.getView());
    }

    public boolean isAdded() {
        return this.field_5093.isAdded();
    }

    public boolean isDetached() {
        return this.field_5093.isDetached();
    }

    public boolean isHidden() {
        return this.field_5093.isHidden();
    }

    public boolean isInLayout() {
        return this.field_5093.isInLayout();
    }

    public boolean isRemoving() {
        return this.field_5093.isRemoving();
    }

    public boolean isResumed() {
        return this.field_5093.isResumed();
    }

    public boolean isVisible() {
        return this.field_5093.isVisible();
    }

    // $FF: renamed from: iu () com.google.android.gms.dynamic.d
    public class_206 method_1061() {
        return class_1046.method_5437(this.field_5093.getActivity());
    }

    // $FF: renamed from: iv () com.google.android.gms.dynamic.c
    public class_205 method_1062() {
        return method_5584(this.field_5093.getParentFragment());
    }

    // $FF: renamed from: iw () com.google.android.gms.dynamic.d
    public class_206 method_1063() {
        return class_1046.method_5437(this.field_5093.getResources());
    }

    // $FF: renamed from: ix () com.google.android.gms.dynamic.c
    public class_205 method_1064() {
        return method_5584(this.field_5093.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean var1) {
        this.field_5093.setHasOptionsMenu(var1);
    }

    public void setMenuVisibility(boolean var1) {
        this.field_5093.setMenuVisibility(var1);
    }

    public void setRetainInstance(boolean var1) {
        this.field_5093.setRetainInstance(var1);
    }

    public void setUserVisibleHint(boolean var1) {
        this.field_5093.setUserVisibleHint(var1);
    }

    public void startActivity(Intent var1) {
        this.field_5093.startActivity(var1);
    }

    public void startActivityForResult(Intent var1, int var2) {
        this.field_5093.startActivityForResult(var1, var2);
    }
}
