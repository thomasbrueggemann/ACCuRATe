package com.google.android.gms.appindexing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.List;

public interface AppIndexApi {
    PendingResult<Status> view(GoogleApiClient var1, Activity var2, Intent var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6);

    PendingResult<Status> view(GoogleApiClient var1, Activity var2, Uri var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6);

    PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Intent var3);

    PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Uri var3);

    public static final class AppIndexingLink {
        public final Uri appIndexingUrl;
        public final int viewId;
        public final Uri webUrl;

        public AppIndexingLink(Uri var1, Uri var2, View var3) {
            this.appIndexingUrl = var1;
            this.webUrl = var2;
            this.viewId = var3.getId();
        }
    }
}
