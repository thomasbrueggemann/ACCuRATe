package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.class_266;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    // $FF: renamed from: RR int
    private final int field_5368;
    // $FF: renamed from: RS int
    private int field_5369;
    // $FF: renamed from: RT int
    private final int field_5370;
    // $FF: renamed from: RU java.util.List
    private final List<DataBuffer<T>> field_5371;
    // $FF: renamed from: RV android.view.LayoutInflater
    private final LayoutInflater field_5372;
    // $FF: renamed from: RW boolean
    private boolean field_5373;
    private final Context mContext;

    public DataBufferAdapter(Context var1, int var2) {
        this(var1, var2, 0, (List)(new ArrayList()));
    }

    public DataBufferAdapter(Context var1, int var2, int var3) {
        this(var1, var2, var3, (List)(new ArrayList()));
    }

    public DataBufferAdapter(Context var1, int var2, int var3, List<DataBuffer<T>> var4) {
        this.field_5373 = true;
        this.mContext = var1;
        this.field_5369 = var2;
        this.field_5368 = var2;
        this.field_5370 = var3;
        this.field_5371 = var4;
        this.field_5372 = (LayoutInflater)var1.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context var1, int var2, int var3, DataBuffer... var4) {
        this(var1, var2, var3, Arrays.asList(var4));
    }

    public DataBufferAdapter(Context var1, int var2, List<DataBuffer<T>> var3) {
        this(var1, var2, 0, (List)var3);
    }

    public DataBufferAdapter(Context var1, int var2, DataBuffer... var3) {
        this(var1, var2, 0, (List)Arrays.asList(var3));
    }

    // $FF: renamed from: a (int, android.view.View, android.view.ViewGroup, int) android.view.View
    private View method_6022(int var1, View var2, ViewGroup var3, int var4) {
        View var5;
        if(var2 == null) {
            var5 = this.field_5372.inflate(var4, var3, false);
        } else {
            var5 = var2;
        }

        TextView var8;
        label30: {
            TextView var10;
            label29: {
                TextView var7;
                try {
                    if(this.field_5370 == 0) {
                        var10 = (TextView)var5;
                        break label29;
                    }

                    var7 = (TextView)var5.findViewById(this.field_5370);
                } catch (ClassCastException var11) {
                    class_266.method_1683("DataBufferAdapter", var11, "You must supply a resource ID for a TextView");
                    throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", var11);
                }

                var8 = var7;
                break label30;
            }

            var8 = var10;
        }

        Object var9 = this.getItem(var1);
        if(var9 instanceof CharSequence) {
            var8.setText((CharSequence)var9);
            return var5;
        } else {
            var8.setText(var9.toString());
            return var5;
        }
    }

    public void append(DataBuffer<T> var1) {
        this.field_5371.add(var1);
        if(this.field_5373) {
            this.notifyDataSetChanged();
        }

    }

    public void clear() {
        Iterator var1 = this.field_5371.iterator();

        while(var1.hasNext()) {
            ((DataBuffer)var1.next()).release();
        }

        this.field_5371.clear();
        if(this.field_5373) {
            this.notifyDataSetChanged();
        }

    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        Iterator var1 = this.field_5371.iterator();

        int var2;
        for(var2 = 0; var1.hasNext(); var2 += ((DataBuffer)var1.next()).getCount()) {
            ;
        }

        return var2;
    }

    public View getDropDownView(int var1, View var2, ViewGroup var3) {
        return this.method_6022(var1, var2, var3, this.field_5369);
    }

    public T getItem(int var1) throws CursorIndexOutOfBoundsException {
        Iterator var2 = this.field_5371.iterator();

        int var5;
        for(int var3 = var1; var2.hasNext(); var3 -= var5) {
            DataBuffer var4 = (DataBuffer)var2.next();
            var5 = var4.getCount();
            if(var5 > var3) {
                try {
                    Object var7 = var4.get(var3);
                    return var7;
                } catch (CursorIndexOutOfBoundsException var8) {
                    throw new CursorIndexOutOfBoundsException(var1, this.getCount());
                }
            }
        }

        throw new CursorIndexOutOfBoundsException(var1, this.getCount());
    }

    public long getItemId(int var1) {
        return (long)var1;
    }

    public View getView(int var1, View var2, ViewGroup var3) {
        return this.method_6022(var1, var2, var3, this.field_5368);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.field_5373 = true;
    }

    public void setDropDownViewResource(int var1) {
        this.field_5369 = var1;
    }

    public void setNotifyOnChange(boolean var1) {
        this.field_5373 = var1;
    }
}
