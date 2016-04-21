package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.class_822;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {
    PendingResult<Status> deleteData(GoogleApiClient var1, DataDeleteRequest var2);

    PendingResult<Status> insertData(GoogleApiClient var1, DataSet var2);

    PendingResult<DataReadResult> readData(GoogleApiClient var1, DataReadRequest var2);

    public static class ViewIntentBuilder {
        // $FF: renamed from: KS long
        private long field_4844;
        // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
        private final DataType field_4845;
        // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
        private DataSource field_4846;
        // $FF: renamed from: Sr long
        private long field_4847;
        // $FF: renamed from: Ss java.lang.String
        private String field_4848;
        private final Context mContext;

        public ViewIntentBuilder(Context var1, DataType var2) {
            this.mContext = var1;
            this.field_4845 = var2;
        }

        // $FF: renamed from: i (android.content.Intent) android.content.Intent
        private Intent method_5473(Intent var1) {
            if(this.field_4848 != null) {
                Intent var2 = (new Intent(var1)).setPackage(this.field_4848);
                ResolveInfo var3 = this.mContext.getPackageManager().resolveActivity(var2, 0);
                if(var3 != null) {
                    String var4 = var3.activityInfo.name;
                    var2.setComponent(new ComponentName(this.field_4848, var4));
                    return var2;
                }
            }

            return var1;
        }

        public Intent build() {
            boolean var1 = true;
            boolean var2;
            if(this.field_4844 > 0L) {
                var2 = var1;
            } else {
                var2 = false;
            }

            class_1090.method_5676(var2, "Start time must be set");
            if(this.field_4847 <= this.field_4844) {
                var1 = false;
            }

            class_1090.method_5676(var1, "End time must be set and after start time");
            Intent var3 = new Intent("vnd.google.fitness.VIEW");
            var3.setType(DataType.getMimeType(this.field_4846.getDataType()));
            var3.putExtra("vnd.google.fitness.start_time", this.field_4844);
            var3.putExtra("vnd.google.fitness.end_time", this.field_4847);
            class_822.method_4296(this.field_4846, var3, "vnd.google.fitness.data_source");
            return this.method_5473(var3);
        }

        public HistoryApi.ViewIntentBuilder setDataSource(DataSource var1) {
            boolean var2 = var1.getDataType().equals(this.field_4845);
            Object[] var3 = new Object[] {var1, this.field_4845};
            class_1090.method_5684(var2, "Data source %s is not for the data type %s", var3);
            this.field_4846 = var1;
            return this;
        }

        public HistoryApi.ViewIntentBuilder setPreferredApplication(String var1) {
            this.field_4848 = var1;
            return this;
        }

        public HistoryApi.ViewIntentBuilder setTimeInterval(long var1, long var3, TimeUnit var5) {
            this.field_4844 = var5.toMillis(var1);
            this.field_4847 = var5.toMillis(var3);
            return this;
        }
    }
}
