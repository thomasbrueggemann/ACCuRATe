package com.google.android.gms.internal;

// $FF: renamed from: com.google.android.gms.internal.ii
public enum class_326 {
   // $FF: renamed from: EA com.google.android.gms.internal.ii
   field_833("ServiceDisabled"),
   // $FF: renamed from: EB com.google.android.gms.internal.ii
   field_834("ServiceUnavailable"),
   // $FF: renamed from: EC com.google.android.gms.internal.ii
   field_835("CaptchaRequired"),
   // $FF: renamed from: ED com.google.android.gms.internal.ii
   field_836("NetworkError"),
   // $FF: renamed from: EE com.google.android.gms.internal.ii
   field_837("UserCancel"),
   // $FF: renamed from: EF com.google.android.gms.internal.ii
   field_838("PermissionDenied"),
   // $FF: renamed from: EG com.google.android.gms.internal.ii
   @Deprecated
   field_839("DeviceManagementRequiredOrSyncDisabled"),
   // $FF: renamed from: EH com.google.android.gms.internal.ii
   field_840("DeviceManagementInternalError"),
   // $FF: renamed from: EI com.google.android.gms.internal.ii
   field_841("DeviceManagementSyncDisabled"),
   // $FF: renamed from: EJ com.google.android.gms.internal.ii
   field_842("DeviceManagementAdminBlocked"),
   // $FF: renamed from: EK com.google.android.gms.internal.ii
   field_843("DeviceManagementAdminPendingApproval"),
   // $FF: renamed from: EL com.google.android.gms.internal.ii
   field_844("DeviceManagementStaleSyncRequired"),
   // $FF: renamed from: EM com.google.android.gms.internal.ii
   field_845("DeviceManagementDeactivated"),
   // $FF: renamed from: EN com.google.android.gms.internal.ii
   field_846("DeviceManagementRequired"),
   // $FF: renamed from: EO com.google.android.gms.internal.ii
   field_847("ClientLoginDisabled"),
   // $FF: renamed from: EP com.google.android.gms.internal.ii
   field_848("NeedPermission"),
   // $FF: renamed from: EQ com.google.android.gms.internal.ii
   field_849("WeakPassword"),
   // $FF: renamed from: ER com.google.android.gms.internal.ii
   field_850("ALREADY_HAS_GMAIL"),
   // $FF: renamed from: ES com.google.android.gms.internal.ii
   field_851("BadRequest"),
   // $FF: renamed from: ET com.google.android.gms.internal.ii
   field_852("BadUsername"),
   // $FF: renamed from: EU com.google.android.gms.internal.ii
   field_853("LoginFail"),
   // $FF: renamed from: EV com.google.android.gms.internal.ii
   field_854("NotLoggedIn"),
   // $FF: renamed from: EW com.google.android.gms.internal.ii
   field_855("NoGmail"),
   // $FF: renamed from: EX com.google.android.gms.internal.ii
   field_856("RequestDenied"),
   // $FF: renamed from: EY com.google.android.gms.internal.ii
   field_857("ServerError"),
   // $FF: renamed from: EZ com.google.android.gms.internal.ii
   field_858("UsernameUnavailable"),
   // $FF: renamed from: Er com.google.android.gms.internal.ii
   field_859("Ok"),
   // $FF: renamed from: Es com.google.android.gms.internal.ii
   field_860("BadAuthentication"),
   // $FF: renamed from: Et com.google.android.gms.internal.ii
   field_861("InvalidSecondFactor"),
   // $FF: renamed from: Eu com.google.android.gms.internal.ii
   field_862("NotVerified"),
   // $FF: renamed from: Ev com.google.android.gms.internal.ii
   field_863("TermsNotAgreed"),
   // $FF: renamed from: Ew com.google.android.gms.internal.ii
   field_864("Unknown"),
   // $FF: renamed from: Ex com.google.android.gms.internal.ii
   field_865("UNKNOWN_ERR"),
   // $FF: renamed from: Ey com.google.android.gms.internal.ii
   field_866("AccountDeleted"),
   // $FF: renamed from: Ez com.google.android.gms.internal.ii
   field_867("AccountDisabled"),
   // $FF: renamed from: Fa com.google.android.gms.internal.ii
   field_868("DeletedGmail"),
   // $FF: renamed from: Fb com.google.android.gms.internal.ii
   field_869("SocketTimeout"),
   // $FF: renamed from: Fc com.google.android.gms.internal.ii
   field_870("ExistingUsername"),
   // $FF: renamed from: Fd com.google.android.gms.internal.ii
   field_871("NeedsBrowser"),
   // $FF: renamed from: Fe com.google.android.gms.internal.ii
   field_872("GPlusOther"),
   // $FF: renamed from: Ff com.google.android.gms.internal.ii
   field_873("GPlusNickname"),
   // $FF: renamed from: Fg com.google.android.gms.internal.ii
   field_874("GPlusInvalidChar"),
   // $FF: renamed from: Fh com.google.android.gms.internal.ii
   field_875("GPlusInterstitial"),
   // $FF: renamed from: Fi com.google.android.gms.internal.ii
   field_876("ProfileUpgradeError"),
   // $FF: renamed from: Fj com.google.android.gms.internal.ii
   field_877("INVALID_SCOPE");

   // $FF: renamed from: Fk java.lang.String
   public static String field_878;
   // $FF: renamed from: Fl java.lang.String
   public static String field_879;
   // $FF: renamed from: Fm java.lang.String
   private final String field_881;

   static {
      class_326[] var0 = new class_326[]{field_859, field_860, field_861, field_862, field_863, field_864, field_865, field_866, field_867, field_833, field_834, field_835, field_836, field_837, field_838, field_839, field_840, field_841, field_842, field_843, field_844, field_845, field_846, field_847, field_848, field_849, field_850, field_851, field_852, field_853, field_854, field_855, field_856, field_857, field_858, field_868, field_869, field_870, field_871, field_872, field_873, field_874, field_875, field_876, field_877};
      field_878 = "Error";
      field_879 = "status";
   }

   private class_326(String var3) {
      this.field_881 = var3;
   }

   // $FF: renamed from: fO () java.lang.String
   public String method_2283() {
      return this.field_881;
   }
}
