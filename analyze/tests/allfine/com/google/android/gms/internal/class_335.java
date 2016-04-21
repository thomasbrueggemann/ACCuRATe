package com.google.android.gms.internal;

// $FF: renamed from: com.google.android.gms.internal.if
public enum class_335 {
    // $FF: renamed from: DC com.google.android.gms.internal.if
    field_1143("Ok"),
    // $FF: renamed from: DD com.google.android.gms.internal.if
    field_1144("BadAuthentication"),
    // $FF: renamed from: DE com.google.android.gms.internal.if
    field_1145("InvalidSecondFactor"),
    // $FF: renamed from: DF com.google.android.gms.internal.if
    field_1146("NotVerified"),
    // $FF: renamed from: DG com.google.android.gms.internal.if
    field_1147("TermsNotAgreed"),
    // $FF: renamed from: DH com.google.android.gms.internal.if
    field_1148("Unknown"),
    // $FF: renamed from: DI com.google.android.gms.internal.if
    field_1149("UNKNOWN_ERR"),
    // $FF: renamed from: DJ com.google.android.gms.internal.if
    field_1150("AccountDeleted"),
    // $FF: renamed from: DK com.google.android.gms.internal.if
    field_1151("AccountDisabled"),
    // $FF: renamed from: DL com.google.android.gms.internal.if
    field_1152("ServiceDisabled"),
    // $FF: renamed from: DM com.google.android.gms.internal.if
    field_1153("ServiceUnavailable"),
    // $FF: renamed from: DN com.google.android.gms.internal.if
    field_1154("CaptchaRequired"),
    // $FF: renamed from: DO com.google.android.gms.internal.if
    field_1155("NetworkError"),
    // $FF: renamed from: DP com.google.android.gms.internal.if
    field_1156("UserCancel"),
    // $FF: renamed from: DQ com.google.android.gms.internal.if
    field_1157("PermissionDenied"),
    // $FF: renamed from: DR com.google.android.gms.internal.if
    @Deprecated
    field_1158("DeviceManagementRequiredOrSyncDisabled"),
    // $FF: renamed from: DS com.google.android.gms.internal.if
    field_1159("DeviceManagementInternalError"),
    // $FF: renamed from: DT com.google.android.gms.internal.if
    field_1160("DeviceManagementSyncDisabled"),
    // $FF: renamed from: DU com.google.android.gms.internal.if
    field_1161("DeviceManagementAdminBlocked"),
    // $FF: renamed from: DV com.google.android.gms.internal.if
    field_1162("DeviceManagementAdminPendingApproval"),
    // $FF: renamed from: DW com.google.android.gms.internal.if
    field_1163("DeviceManagementStaleSyncRequired"),
    // $FF: renamed from: DX com.google.android.gms.internal.if
    field_1164("DeviceManagementDeactivated"),
    // $FF: renamed from: DY com.google.android.gms.internal.if
    field_1165("DeviceManagementRequired"),
    // $FF: renamed from: DZ com.google.android.gms.internal.if
    field_1166("ClientLoginDisabled"),
    // $FF: renamed from: Ea com.google.android.gms.internal.if
    field_1167("NeedPermission"),
    // $FF: renamed from: Eb com.google.android.gms.internal.if
    field_1168("WeakPassword"),
    // $FF: renamed from: Ec com.google.android.gms.internal.if
    field_1169("ALREADY_HAS_GMAIL"),
    // $FF: renamed from: Ed com.google.android.gms.internal.if
    field_1170("BadRequest"),
    // $FF: renamed from: Ee com.google.android.gms.internal.if
    field_1171("BadUsername"),
    // $FF: renamed from: Ef com.google.android.gms.internal.if
    field_1172("LoginFail"),
    // $FF: renamed from: Eg com.google.android.gms.internal.if
    field_1173("NotLoggedIn"),
    // $FF: renamed from: Eh com.google.android.gms.internal.if
    field_1174("NoGmail"),
    // $FF: renamed from: Ei com.google.android.gms.internal.if
    field_1175("RequestDenied"),
    // $FF: renamed from: Ej com.google.android.gms.internal.if
    field_1176("ServerError"),
    // $FF: renamed from: Ek com.google.android.gms.internal.if
    field_1177("UsernameUnavailable"),
    // $FF: renamed from: El com.google.android.gms.internal.if
    field_1178("DeletedGmail"),
    // $FF: renamed from: Em com.google.android.gms.internal.if
    field_1179("SocketTimeout"),
    // $FF: renamed from: En com.google.android.gms.internal.if
    field_1180("ExistingUsername"),
    // $FF: renamed from: Eo com.google.android.gms.internal.if
    field_1181("NeedsBrowser"),
    // $FF: renamed from: Ep com.google.android.gms.internal.if
    field_1182("GPlusOther"),
    // $FF: renamed from: Eq com.google.android.gms.internal.if
    field_1183("GPlusNickname"),
    // $FF: renamed from: Er com.google.android.gms.internal.if
    field_1184("GPlusInvalidChar"),
    // $FF: renamed from: Es com.google.android.gms.internal.if
    field_1185("GPlusInterstitial"),
    // $FF: renamed from: Et com.google.android.gms.internal.if
    field_1186("ProfileUpgradeError"),
    // $FF: renamed from: Eu com.google.android.gms.internal.if
    field_1187("INVALID_SCOPE");

    // $FF: renamed from: Ev java.lang.String
    public static String field_1188;
    // $FF: renamed from: Ew java.lang.String
    public static String field_1189;
    // $FF: renamed from: Ex java.lang.String
    private final String field_1191;

    static {
        class_335[] var0 = new class_335[]{field_1143, field_1144, field_1145, field_1146, field_1147, field_1148, field_1149, field_1150, field_1151, field_1152, field_1153, field_1154, field_1155, field_1156, field_1157, field_1158, field_1159, field_1160, field_1161, field_1162, field_1163, field_1164, field_1165, field_1166, field_1167, field_1168, field_1169, field_1170, field_1171, field_1172, field_1173, field_1174, field_1175, field_1176, field_1177, field_1178, field_1179, field_1180, field_1181, field_1182, field_1183, field_1184, field_1185, field_1186, field_1187};
        field_1188 = "Error";
        field_1189 = "status";
    }

    private class_335(String var3) {
        this.field_1191 = var3;
    }

    // $FF: renamed from: ft () java.lang.String
    public String method_2306() {
        return this.field_1191;
    }
}
