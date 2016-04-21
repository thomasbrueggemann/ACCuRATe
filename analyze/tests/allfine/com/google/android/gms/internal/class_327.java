package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

// $FF: renamed from: com.google.android.gms.internal.ix
public final class class_327 {
    // $FF: renamed from: a (android.graphics.Bitmap) android.graphics.Bitmap
    public static Bitmap method_2243(Bitmap var0) {
        if(var0 == null) {
            return null;
        } else {
            int var1 = var0.getWidth();
            int var2 = var0.getHeight();
            int var3;
            int var4;
            if(var1 >= var2) {
                var4 = var1 / 2 - var2 / 2;
                var3 = 0;
            } else {
                var3 = var2 / 2 - var1 / 2;
                var2 = var1;
                var4 = 0;
            }

            Bitmap var5 = Bitmap.createBitmap(var2, var2, Config.ARGB_8888);
            Canvas var6 = new Canvas(var5);
            Paint var7 = new Paint(1);
            var7.setColor(-16777216);
            var6.drawCircle((float)(var2 / 2), (float)(var2 / 2), (float)(var2 / 2), var7);
            var7.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            var6.drawBitmap(var0, (float)var4, (float)var3, var7);
            return var5;
        }
    }

    // $FF: renamed from: a (android.graphics.drawable.Drawable) android.graphics.Bitmap
    private static Bitmap method_2244(Drawable var0) {
        if(var0 == null) {
            return null;
        } else if(var0 instanceof BitmapDrawable) {
            return ((BitmapDrawable)var0).getBitmap();
        } else {
            Bitmap var1 = Bitmap.createBitmap(var0.getIntrinsicWidth(), var0.getIntrinsicHeight(), Config.ARGB_8888);
            Canvas var2 = new Canvas(var1);
            var0.setBounds(0, 0, var2.getWidth(), var2.getHeight());
            var0.draw(var2);
            return var1;
        }
    }

    // $FF: renamed from: a (android.content.res.Resources, android.graphics.drawable.Drawable) android.graphics.drawable.Drawable
    public static Drawable method_2245(Resources var0, Drawable var1) {
        return new BitmapDrawable(var0, method_2243(method_2244(var1)));
    }
}
