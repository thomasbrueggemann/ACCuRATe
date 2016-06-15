package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.game.Acls;

public final class AclsImpl implements Acls {
   // $FF: renamed from: K (com.google.android.gms.common.api.Status) com.google.android.gms.games.internal.game.Acls$LoadAclResult
   private static Acls.LoadAclResult method_5337(final Status var0) {
      return new Acls.LoadAclResult() {
         public Status getStatus() {
            return var0;
         }

         public void release() {
         }
      };
   }

   private abstract static class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult> {
      // $FF: renamed from: M (com.google.android.gms.common.api.Status) com.google.android.gms.games.internal.game.Acls$LoadAclResult
      public Acls.LoadAclResult method_1370(Status var1) {
         return AclsImpl.method_5337(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1370(var1);
      }
   }

   private abstract static class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Status> {
      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1372(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1372(var1);
      }
   }
}
