package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.class_443;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.internal.class_275;
import com.google.android.gms.internal.class_282;
import com.google.android.gms.internal.class_351;
import com.google.android.gms.internal.class_353;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public final class GooglePlayServicesUtil {
   // $FF: renamed from: CS byte[][]
   static final byte[][] field_3478;
   // $FF: renamed from: CT byte[][]
   static final byte[][] field_3479;
   // $FF: renamed from: CU byte[][]
   static final byte[][] field_3480;
   // $FF: renamed from: CV byte[][]
   static final byte[][] field_3481;
   // $FF: renamed from: CW byte[][]
   static final byte[][] field_3482;
   // $FF: renamed from: CX byte[][]
   static final byte[][] field_3483;
   // $FF: renamed from: CY byte[][]
   static final byte[][] field_3484;
   // $FF: renamed from: CZ byte[][]
   static final byte[][] field_3485;
   // $FF: renamed from: Da byte[][]
   private static final byte[][] field_3486;
   // $FF: renamed from: Db byte[][]
   private static final byte[][] field_3487;
   // $FF: renamed from: Dc boolean
   public static boolean field_3488;
   // $FF: renamed from: Dd boolean
   public static boolean field_3489;
   // $FF: renamed from: De int
   private static int field_3490;
   // $FF: renamed from: Df java.lang.Object
   private static final Object field_3491;
   public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
   public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 5077000;
   public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

   static {
      byte[][] var0 = new byte[][]{method_3835("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u001e\u0017\r080821231334Z\u0017\r360107231334Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000«V.\u0000Ø;¢\b®\n\u0096o\u0012N)Ú\u0011ò«VÐ\u008fXâÌ©\u0013\u0003é·TÓrö@§\u001b\u001dË\u0013\tgbNFV§wj\u0092\u0019=²å¿·$©\u001ew\u0018\u008b\u000ejG¤;3Ù`\u009bw\u00181EÌß{.XftÉáV[\u001fLjYU¿òQ¦=«ùÅ\\\'\"\"Rèuäø\u0015Jd_\u0089qhÀ±¿Æ\u0012ê¿xWi»4ªy\u0084Ü~.¢vL®\u0083\u0007ØÁqT×î_d¥\u001aD¦\u0002ÂI\u0005AWÜ\u0002Í_\\\u000eUûï\u0085\u0019ûã\'ð±Q\u0016\u0092Å o\u0019Ñ\u0083\u0085õÄÛÂÖ¹?hÌ)yÇ\u000e\u0018«\u0093\u0086k;ÕÛ\u0089\u0099U*\u000e;L\u0099ßXû\u0091\u008bíÁ\u0082º5à\u0003Á´±\rÒD¨î$ÿý38r«R!\u0098^Ú°ü\r\u000b\u0014[j¡\u0092\u0085\u008ey\u0002\u0001\u0003£\u0081Ù0\u0081Ö0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Ç}\u008cÂ!\u0017V%\u009a\u007fÓ\u0082ßkã\u0098ä×\u0086¥0\u0081¦\u0006\u0003U\u001d#\u0004\u0081\u009e0\u0081\u009b\u0080\u0014Ç}\u008cÂ!\u0017V%\u009a\u007fÓ\u0082ßkã\u0098ä×\u0086¥¡x¤v0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android\u0082\t\u0000Âà\u0087FdJ0\u008d0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0082\u0001\u0001\u0000mÒRÎï\u00850,6\nªÎ\u0093\u009bÏòÌ©\u0004»]z\u0016aø®F²\u0099B\u0004ÐÿJhÇí\u001aS\u001eÄYZb<æ\u0007c±g)zzãW\u0012Ä\u0007ò\bðË\u0010\u0094)\u0012M{\u0010b\u0019À\u0084Ê>³ù\u00ad_¸qï\u0092&\u009a\u008bâ\u008bñmDÈÙ \u008el²ð\u0005»?âË\u0096D~\u0086\u008es\u0010v\u00adE³?`\tê\u0019Áaæ&Aª\u0099\'\u001dýR(ÅÅ\u0087\u0087]Û\u007fE\'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\u000b\u0010q§Ä@ðþ\u009e \u001c¶\'ÊgCiÐ\u0084½/Ù\u0011ÿ\u0006Í¿,ú\u0010Ü\u000f\u0089:ãWb\u0091\u0090HÇïÆLqD\u0017\u0083B÷\u0005\u0081ÉÞW:õ[9\r×ý¹A\u00861\u0089]_u\u009f0\u0011&\u0087ÿb\u0014\u0010Ài0\u008a"), method_3835("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u00000\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r080415233656Z\u0017\r350901233656Z0\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000ÖÎ.\b\n¿â1MÑ\u008d³ÏÓ\u0018\\´=3ú\ftá½¶ÑÛ\u0089\u0013ö,\\9ßVøF\u0081=e¾ÀóÊBk\u0007Å¨íZ9\u0090ÁgçkÉ\u0099¹\'\u0089K\u008f\u000b\"\u0000\u0019\u0094©)\u0015årÅm*0\u001b£oÅü\u0011:ÖË\u009et5¡m#«}úîáeäß\u001f\n\u008d½§\n\u0086\u009dQlN\u009d\u0005\u0011\u0096Ê|\fU\u007f\u0017[ÃuùHÅj®\u0086\b\u009b¤O\u008a¦¤Ý\u009a}¿,\n5\"\u0082\u00ad\u0006¸Ì\u0018^±Uyîøm\b\u000b\u001da\u0089Àù¯\u0098±ÂëÑ\u0007êE«Ûh£Ç\u0083\u008a^T\u0088ÇlSÔ\u000b\u0012\u001dç»Ó\u000eb\f\u0018\u008aáªaÛ¼\u0087Ý<d_/UóÔÃuì@p©?qQØ6pÁj\u0097\u001a¾^òÑ\u0018\u0090á¸®ó)\u008cðf¿\u009eláD¬\u009aèm\u001c\u001b\u000f\u0002\u0001\u0003£\u0081ü0\u0081ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u008d\u001cÅ¾\u0095LC<a\u0086:\u0015°L¼\u0003òOà²0\u0081É\u0006\u0003U\u001d#\u0004\u0081Á0\u0081¾\u0080\u0014\u008d\u001cÅ¾\u0095LC<a\u0086:\u0015°L¼\u0003òOà²¡\u0081\u009a¤\u0081\u00970\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com\u0082\t\u0000Õ\u0085¸l}ÓNõ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u0019Ó\fñ\u0005ûx\u0092?L\r}Ò##=@\u0096zÏÎ\u0000\b\u001d[×ÆéÖí k\u000e\u0011 \u0095\u0006Al¢D\u0093\u0099\u0013ÒkJ àõ$ÊÒ»\\nL¡\u0001j\u0015\u0091n¡ì]ÉZ^:\u0001\u00006ô\u0092HÕ\u0010\u009b¿.\u001ea\u0081\u0086g:;åm¯\u000bw±Â)ãÂUãèL\u0090]#\u0087ïº\tËñ; +NZ\"É2cHJ#Òü)ú\u009f\u00199u\u00973¯Øª\u0016\u000fB\u0096ÂÐ\u0016>\u0081\u0082\u0085\u009cfCéÁ\u0096/ Á\u008333[À\u0090ÿ\u009ak\"ÞÑ\u00adDB)¥9©Nï\u00ad«ÐeÎÒK>QåÝ{fx{ï\u0012þ\u0097û¤\u0084Ä#ûOøÌIL\u0002ðõ\u0005\u0016\u0012ÿe)9>\u008eFêÅ»!òwÁQª_*¦\'Ñè\u009d§\n¶\u00035iÞ;\u0098\u0097¿ÿ|©Ú>\u0012Cö\u000b")};
      field_3478 = var0;
      byte[][] var1 = new byte[][]{method_3835("0\u0082\u0002R0\u0082\u0001»\u0002\u0004I4\u0098~0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u00000p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown0\u001e\u0017\r081202020758Z\u0017\r360419020758Z0p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown0\u0081\u009f0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0081\u008d\u00000\u0081\u0089\u0002\u0081\u0081\u0000\u009fH\u0003\u0019\u0090ù±G&8N\u0004SÑ\u008f\u008c\u000b¿\u008dÇ{%\u0004¤± |LlDº¼\u0000\u00adÆa\u000f¦¶«-¨\u000e3òîñk&£ö¸[\u009aúÊ\u0090\u009fû¾³ôÉO~\u0081\"§\u0098àë§\\í=Ò)úseô\u0015\u0016AZ©Áa}Õ\u0083Î\u0019ºè »Ø\u0085ü\u0017©´½&@\u0080Q!ªÛ\u0093wÞ´\u0000\u00138\u0014\u0018\u0088.Å\"\u0082üX\r\u0002\u0003\u0001\u0000\u00010\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0081\u0081\u0000@\u0086f\u009eÖ1ÚC\u0084ÝÐaÒ&às¹\u008cÄ¹\u009døµä¾\u009e<¾\u0097P\u001e\u0083ß\u001co©YÀÎ`\\OÒ¬m\u001c\u0084ÎÞ Glº±\u009bèò :ÿw\u0017\u00ade-\u008fÌ\u0089\u0007\bÑ!m¨DWY&IàéÓÄ»Lõ\u008d¡\u009d±ÔüA¼¹XOdæ_A\r\u0005)ý[h\u0083\u008c\u0014\u001d\n\u009bÑÛ\u0011\u0091Ë*\r÷\u0090ê\f±-³¤"), method_3835("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000\u0084~OòÖµÞ\u008e0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r100120010135Z\u0017\r370607010135Z0\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000Ø(q|6Ñ\u0017\u000fÔM\n{\u000f\u0007\u0011&è[¿ß3°4`\u0000Z\u0094Ìûe¥Û ²Cß`±\u0091¿\u009d\u0006ß\u001d\u008a\\\n3âÑcõ\u0013ß\u001d\"SAê<3y\"è\\\u0002ì4ÎÙL¸\u0007#¦#ÿK¯û´åïæw;>¢¾¸¼²\u0002gÏç\u0085Q\u001f\u0083.ù\u0087«u\u0094þ\u001e)Ï¼M\b:\u001f\u0012R\u0000ws\u0096ò\u0016[i{\u0000£ Á:Ì0\u008a\u0093ò!cÁn\u009c=J²\u0014\u009f6LEÀC\u00142p9ñÚ\t`\u0093ñ³ü\u0018¶V\u0010\u0095Æ\"_Ç\u0010+\u0098|o\u0013¤]$ãàÅN\u0085\u009dgã[g\b\'\u0013ÒÖðWÝ4WÑ\u009fÄþ\u008dÝì\u008c:O?\u0097#\u0005\u0019§\n(64¬5\u0081£J½¡}\u0084Z\n\t\u0085ûø\u0006\u000b\u0003j\'x`\u0081cú\f7¹çò¡\u000ev¼w\u0002\u0001\u0003£\u0081ü0\u0081ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u009b\u001770\u0081É\u0006\u0003U\u001d#\u0004\u0081Á0\u0081¾\u0080\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u009b\u00177¡\u0081\u009a¤\u0081\u00970\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com\u0082\t\u0000\u0084~OòÖµÞ\u008e0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000L>§e}&æ»×\u0011\f\u008f\u0019ß\u001f\u008d¡\t}3\u0086\u000fiÞ¿ÊÛF£~\u0087å³\u000f»4{\u001cuU¼»<\u0099T\u0014\u0080F\u0096_\u009cy*\u0002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\u0006.@nÎ\u0018\u0006\f`I\u008dü6\u009f\'\u0011q\u0098åoË¡Ræ\u0005\u008dÎ\u0094ÎY\u001fÄô©\u0098+3ºØ\u0019mwoU·Ð\u001aÏ1Ý×\fì·\u0089xv\u0006e\u0010ùI¥RJ11³ËeAÏ\u008b5B\u000e¼ÄR%Y\u0096?Bfi\u0005rfbO³\u0098ÏÛR\u0017\u0088\u001d\u0011\u001cn\u0003F\u0016øQ!\u0018Ð¢¦\u009d\u0013×\u0092ðÍ\u0011ÛÕ\u008e#\u0083ZT¥JÂQçÒ,Dj?î\u0014\u0012\u0010éDGK@c\u0007»&\u0084+OkÓU\u0082\u001cs\u0096Qÿ¢`[\u0005â$\u0095×\u0015Øz\u0091ö")};
      field_3479 = var1;
      byte[][] var2 = new byte[][]{method_3835("0\u0082\u0002§0\u0082\u0002e \u0003\u0002\u0001\u0002\u0002\u0004P\u0005|B0\u000b\u0006\u0007*\u0086HÎ8\u0004\u0003\u0005\u0000071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u001e\u0017\r120717145250Z\u0017\r220715145250Z071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u0082\u0001·0\u0082\u0001,\u0006\u0007*\u0086HÎ8\u0004\u00010\u0082\u0001\u001f\u0002\u0081\u0081\u0000ý\u007fS\u0081\u001du\u0012)RßJ\u009c.ìäçö\u0011·R<ïD\u0000Ã\u001e?\u0080¶Q&iE]@\"QûY=\u008dXú¿Åõº0öË\u009bUl×\u0081;\u0080\u001d4oòf`·k\u0099P¥¤\u009f\u009fè\u0004{\u0010\"ÂO»©×þ·Æ\u001bø;WçÆ¨¦\u0015\u000f\u0004û\u0083öÓÅ\u001eÃ\u00025T\u0013Z\u0016\u00912öuó®+a×*ïò\"\u0003\u0019\u009dÑH\u0001Ç\u0002\u0015\u0000\u0097`P\u008f\u0015#\u000bÌ²\u0092¹\u0082¢ë\u0084\u000bðX\u001cõ\u0002\u0081\u0081\u0000÷á \u0085Ö\u009b=ÞË¼«\\6¸W¹y\u0094¯»ú:ê\u0082ùWL\u000b=\u0007\u0082gQYW\u008eºÔYOæq\u0007\u0010\u0081\u0080´I\u0016q#èL(\u0016\u0013·Ï\t2\u008cÈ¦á<\u0016z\u008bT|\u008d(à£®\u001e+³¦u\u0091n£\u007f\u000bú!5bñûbz\u0001$;Ì¤ñ¾¨Q\u0090\u0089¨\u0083ßáZå\u009f\u0006\u0092\u008bf^\u0080{U%d\u0001L;þÏI*\u0003\u0081\u0084\u0000\u0002\u0081\u0080jÑ\u001b×ÕfÒzô9À.Ah¬ýE´¾\u0085¼\u0099\u008c{\u009b\u008e\u001cwTi?\u008c\rB\u008a¤üá\u0010\u0084\u00818BO¦\u008cÑ0RNïöñ78c\u0082/¦7)\u008bþMF ¸feîðA\u00179\u0001\u0003[\u001c\u0080j£\u0018\u0018\r0:¨Ì\u009eY#àjo«úuh<E;²\u0007w|òýçÏ±\u009b\u001408\u0014ª\u001d÷´=[\"+W\u0006´\u008b\u00940\u000b\u0006\u0007*\u0086HÎ8\u0004\u0003\u0005\u0000\u0003/\u00000,\u0002\u0014\tÒÑ°G\u0002)µ¾Ò\u0090&aÑ\u0012òpÅæ\u001d\u0002\u0014gP\u0002\u0006§\u0080Pºx®Ç\u0017O\u0016\u0004\u007f\u0084ê¢÷")};
      field_3480 = var2;
      byte[][] var3 = new byte[][]{method_3835("0\u0082\u0004L0\u0082\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000¨Í\u0017É=¥Ù\u00900\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010653Z\u0017\r380809010653Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000Ã\u000f\u0088\u00adÙ´\u0092\tj,XjZ\u009a\u00805kú\u0002iXøÿ\f]úõ\u009fI&\u008aØpÞè!¥>\u001f[\u0017\u000fÉbE£É\u0082§ËE\'\u0005;ã^4ó\u0096ÒK\"\u0091ì\fR\u008dn&\u0092teàhuêb\u001f\u007fù\u008c@ã4[ I\u0007Ì\u0093Tt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/\u008fàb\u001f\u0091\u008d\u001f5¨$\u0089%,o¦¶3\u0092§hk>Ha-\u0006©ÏoI¿ñ\u001d]\u0096(\u009c\u009dþ\u0014¬WbC\u0096\u0097Ý)êý¹\u0081\rã&5\u0013©\u0005¬\u008e\u008e¯ \u0090~Fu\nZ·¿\u009aw&/G°?Z<nm{Q4?iÇ÷%÷\u000bÌ\u001bJÕ\u0092%\u000bpZ\u0086æè>â®7þW\u0001¼½²oîýÿö\u000fj[ßµ¶G\u0093\u0002\u0001\u0003£\u0081Ü0\u0081Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\frà\u008cÉm0\u0081©\u0006\u0003U\u001d#\u0004\u0081¡0\u0081\u009e\u0080\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\frà\u008cÉm¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\u0082\t\u0000¨Í\u0017É=¥Ù\u00900\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000¤pÇ(áÓ\u001b\u0006Ù¯jçhµe\u0004lW\u0080k\u0098CrI1×]L¡\f2\u0015 Ó<Ïí*¦Tb#L\u009eù¶ù\u0010Ìgk\u0099Ë\u007f\u0098\u0095ÖÀgcWO»x3\u0012uÜ\\ó\u008fº©\u0018×\u0093\u008c\u0005\u001fû¢\u00adèó\u0003ÍèÙæ\u008a\u0004\u008d\u001fÛ\u009e|\u009f*I²\"Æ\u008fÿB+ñUi¸^îí°J£\bsÛæK\u009c\u009etøòÂöÄ\u0001$ª¨Ñx\r\u0018Q+T\nÝ(³éX\u0019q¤\u0017\rØhÏ_1äG\u0012²Â;µ\u00107×ï\u009f\u0087¦å½³^,ëk°\"cl\u0017¥j\u0096¼zP%\u008c\u000bÒí{1UZ\u0018E.\u00172\u001a\rR\u0083\u008c\u0082ö?t-tÿyXj\\»\u007f¯q\u0098¨KÏtC\u0010éé\'Y\u007f\u0000¢=Ð\u0006`\u0080\f\"8Ù\u000b/³rßÛºu½\u0085."), method_3835("0\u0082\u0004L0\u0082\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000Þv\u0095\u0004\u001dvPÀ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010324Z\u0017\r380809010324Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000æÿ=ïé*¡\rqë\u000f¦@\u008bÀ6·âCîíh¦¤v=Ç¥*1u|ÚÆ\u001få\u0010»sÇ\u0016ä\u0000\u0001\u0004&[4\u007fÎÎôÄ+ñá7\u009dÐ¨vð(\"\u007f»Áù½Õ×\u0013²ö©5£yÒË©Éo\u0092ÒÐx|\u0011ñë\u0019T\u0080\b¦ r³K\u0091\u0083lú\ná\'g\u0080é\u0000u0\u0016i\u0086¡\u001c\u009cïFÎ÷Ç\u0004\u0080mÞ\u00941û`(M\u0012\n°çÞ\u001dc?\u0007h}F\u008cQ\u0013\u009aÿýÆ¼\u009a |©\u0004¸¾\u001d ª{N\u0097uoC`d\u0088¾\\®<hè»yBÍõ\u0016\u0007É0¢üÚe[uÐu\u009cº\u0089\u00ad\u0006ç9½\u000b¢\u009b\u001f@B\u0096ÂÀ¨Z\u0084\u007fZ°ÐgÆÃì\u009cI! B¬c§å;Tle´`\u0080´ãæ\u0080â>\u001fwÏçöÞtK\u001ae\u0002\u0001\u0003£\u0081Ü0\u0081Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014¢è\u0090d°]\b\u0086\\4Û\u0093\n\u009d\u0084\u0000P\u0011zì0\u0081©\u0006\u0003U\u001d#\u0004\u0081¡0\u0081\u009e\u0080\u0014¢è\u0090d°]\b\u0086\\4Û\u0093\n\u009d\u0084\u0000P\u0011zì¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\u0082\t\u0000Þv\u0095\u0004\u001dvPÀ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u00007q\u0087\fè|<Rê\u0084\u0089\u00920ÆébÙKM_\u0012\u0093Â]\u0088&\u0015Aý\u0090µU]\u0012\u0085Îó¸1,?]ö\u0091¨ªàL¹\u0081³\u0005ä\'ý\u001d-\u009e\u0019\u0087áÒ\u0090xñ<\u0084R\u0099\u000f\u0018!\u0098\u0002cØÔ½6Q\u0093HØØº&Ø¹\u009f¿\tõý>»\u000e£ÂðÉ7o\u001e\u001fÊvó¦¤\u0005B\u009d\b\u001bu*z\u0090·Vé«DÚA«Èáèø\u008aÂu\u008d§CûsæPq\u009aW\u0084\fËkzÝ!¹\u009fÆ\u0081äVá\u0087,\"=\\\u0007JßUö«Ú&\u008c-\u008bdê\n\u0088EîÍ\u0096\u008f\u0092´\u0093\u0012~uÇSÃÿ0ËÆxµ\u001c\u009fR\u0096\u0014rñ}¢\n\rÆ\'J¢F44Á©¶\u0014ßi}\u008fõÊ\u0081\u0001ç¢\\}³û\u0005]eV\u009c\u0004°\u001d8\u009c«ºW³¡p>ÂçJ\u0088Ó4")};
      field_3481 = var3;
      byte[][] var4 = new byte[][]{method_3835("0\u0082\u0005a0\u0082\u0003K\u0002\u0006\u0001D\u009e\u0091\u0096Ó0\u000b\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u00050v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u001e\u0017\r140307220225Z\u0017\r380119031407Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u0082\u0002\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0002\u000f\u00000\u0082\u0002\n\u0002\u0082\u0002\u0001\u0000º<\u007f9\u000bþY\u008ab¼ü\u008b<\u0094Æ\'Z\u0099\u0015íÜÝ7:Uj\u0099\u000bâýC÷\u009f\u0018³\u0001Ò@\'ãr\u007f\tÎýâ\u009c|&°\u008a Þ6}\u001aßãN§\u008f®7ó\u0090õà&rzN\b(;ïvøöC¼\u0015\'6 H?É·\u0091«R<ó½\u0086{f-*\'L\u0000Ø\u0090ç\u009d\u0011è°&_í©uÜÈåB\u0099\u0089\u008e\u0090\u0013jbq\u008c.\u000b/9yQÛ$±W¡¿çÅkÎJ8\u000b%ú¹&c>¨\u0094\u00048à¶\u0094\u000b¹\u009e\u0089~.ú\u0005<2)\u009bÙao¤½\u0096\u0082!{7C\u001fÍØ\u0082í!§òðF\u007fà\u0095\u001c¼Z\u0098bãJ\u0015káZ\u0017ÿ\u0002\u0017\u0098dDÖ\u0013±\u001e×_\u0083\u0080\u0018î´ý\u0094ä\u008fZã\u001cä¯¤68¶\u0097,\u0085\\ÒÛ\n\u0001Ä2a(äÅ\u0019z¾¬ÌmÂè\u00ad¤B_\u000f\u0090Õ¥¥X$a¿x\u0011á.Î\u000eê\u0006\u0003?\u0096T9íàqÿÄl òß¾##:\u007fdÁÎ\t\u00ad¡ËÎkö¼¢.\u009b\u0098\u009cJÀÉj\u009dluOì\u0018qØ{\u0010\u0098Á Þ`¼}wÞ0ÕN¸GÎk\u0012|\u0019\u001e§\u0093o\nFÁFó6¹4êºZ_\u001c\u0003d·R\u0096UD2Pýcªå{ë«à&?\t\bM\u0019D\u0006\f:Ù»º\u007fyôÞ<+-7º³\rK¹\u0011ÜQià¯\u0095RôÓ\u008e=³òË\u0080\u001cR\u0002Rpa¿\u0001°BÐ~\u0089ä\u008f\u0011©ª \'ðD\u0095\u009eÚ(ÅÝØSW§\u001e9»\u0082Q³Wëor\u0018üÌ\u0017\u0018\u0081¦0gF1àU\u00949\u001azg\u009aòZ b\u0001Ö\"¸Ð\tÝ\u0011Õ\u0006¢\u0003\u000f$\'®gØ\u001b47yy\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0003\u0082\u0002\u0001\u0000¤Ä\u0096\u00964aÈ\u00955¥±\nÍ\u0001$7j\u0089Ú\'C\u009d¬0\u0003Hg\u000b +\u00adã?/º*\u0007d\u0003µ\u000bèqÊ*²\u009b¾½»Ä\u0006Û\t9AÉ\u008c\u0017j\u000eFÿ\u0090ÿ\u0000\u0016\u0016\u0004D\u0080nÜ\u0082á0þ\u0010\u0086\u001eã\u0005\u009d·~=\u009d©¢\u00ad4©Ò´Ú\u001b&ýZ[p\u001cÕlþédzä\u0014;\u0097¦|\u0002\u0080e±\u007f\u009e\u0014ò2¥ï\u0017ád¡I\u0017\u0092\u0096\u0094\u001c0½Z6«øóBÈã¯¼oICs\u0007}j\u009c\u0011×9\"\rZ×µ\u0019/\u009b\u001cþ\u0096\u008fJr±¸Tuàé\u0088¾hr\u0088fe±+ôîÃ\"VTõáò+\u008bëU\u008e¾fw\u008bÖ_\t\u0091-ù^\u0080\u009dþï\u000fÇêÊ]\u000e¾\u001dA\u0004\u001fç Ë2\u009b0~9.\u0013\u0097ñ 9Ti0\u0084\u008b\u007f\u0002\u0017@\u0089-öÇ rçß8ºÃ×\"5oæT\u007fj|W\u008aßgÉ=+5\u0088\u0093T5ðù¡\u0013Î-ìÍm¡\u009dÃKA\u0082ì®Ö ëR\u00850%Åà\u0004ì´Q¼EáHZÌ6\u007f¶I\u0092¯YLU\u001b\u000bÉ8ËÖ\u001aÕgY\u0090 ÷:eá©È¤\u0088Û¬\u0083\u001eë\u0091\u008f\f\u0092)\t^ÞA\u0005{<®êN\u0016Å¹EK\u0092âY\u008a\u0011´\u0094¢\u001f?z¿\u0083Àgô\u0018.\u0098A\u009b¤ä\u0093\u008a4\u0080ð\u0086/í¯WrJU3W\u008fÚ_³ÍüùT\u0080\u007fÿØÉQwçu\u0004¦B¾\\Û á\u0000eü|h\u0012\u009cí\'³¨\u0004×¤ÍÙ\fÓìË\u0005¨È\u008a`\u009aÐV N´\u008a\u001e\u0005\u0095ý9\\\u001f§{³\u001d¥$4^\n½N\u0001µ\u0006\u0082OêºBÓ-Ô\u0092g>ÏÀ\u0017\u009d\u0086\u001d&éÍ\\FïÐ"), method_3835("0\u0082\u0003¿0\u0082\u0002§ \u0003\u0002\u0001\u0002\u0002\t\u0000Ú\u0098ÃÙ\u0015sÓï0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u001e\u0017\r140307220118Z\u0017\r410723220118Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000Ü\u001doK(í80\u0014²\u009c\u0082öÚÿÓ\u001dÞ{\u008c\u001ec\b@e\u000bX±e£j®¶,qS\u0095.\u0004E\t¯\u0082\u001f\u0094º\u009fO\u0018dÃ§µÖSÌ\u0000\u0015\u009d\u0000\u0010áåfú7ªÿ\u00186]®{J\u0085Ý±ó\u0083ÌGp¢>\u0095b\u0091þµrÁi1Z¯Nôê¥®\u0086\u001fÍÖçåêÔ1\u0013tFF\f|(û2,\u0092\u0095\\\\z¨\u0095wÃp?\u0097à\u0098·~¶ n¬krê \u00ad!\n°*\u001fÜüvbttA©?<ê\u008a\u0016ô\u008c\u0097\"Áã2A2~ÂÉ÷01.\u008d\u001bïî)\u000bE\u001a4\u0089,¬ï[\u0014rÖÙ~ùT(Ì\u008aÕï\u0004¸Äñõ\rÒBÕ]rXf\u0085P[^K\u001b\u001eY\u00ad\u008c\u001d\u0085/ \u0082H\u0015g;ÆæC)ìÄêÔÛ\u0084d©k1\u0083\u009f\u009fÛÉ\u0007\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u0084\u0085G\u0010\u0084¤<³êø?«!b \u0095\u0000Î,z0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014\u0084\u0085G\u0010\u0084¤<³êø?«!b \u0095\u0000Î,z0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u00079b\u000b¢}*\u000fT\u0088C\u00ad\u001b`\u008e\u001c)Ù\u0001(\u0081êü?Ö(__bj\u0097>ðWæ\u0097î²¬\\¢æ\u0005Ê=3õ\u0090\u0099k\u008b\u00002ÄGæP\u000f%½\u0017Êù\u0095\u00039\u0083@ÈîlÜµ;íä±òHçÐ \u0099\u009e\u0081çÊê¥2ÏÚ\u0099þJ¥í@@ND÷[ïÒ\u007fÊÛ5¸²\u001b\u0094xF^\u0017\"òzû+\u000bn\u0015\u008eDÄ«\fOe{\u0019×}\u008fSÉÏ¹î-OE¶Tà\u0012¼\u008dé\u0081äÂâÃÓ\u009eQ\u0093\u0003Ø®M,ÁÈb\u008dxW®u?\u001d{\u0002£§\u0005xÆ\u0005ã\u0005\u001cl\u001d©I\u001aÎ\u0013»\u0088Ð}\u0081}Ô\u0094&Q\u0097\u0084®\u0096\u0095¤G5\r\u0089ë@^\u0090ò«óf®/ÊXÒö¿\u001d¿K\u001cH\u009eà \u0001TßÏ\u0002%\u0012õ¡Ç\"\u009es\u001dãðGÖø")};
      field_3482 = var4;
      byte[][] var5 = new byte[][]{method_3835("0\u0082\u0003m0\u0082\u0002W\u0002\u0006\u0001=døÖ³0\u000b\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u00050|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\u0013\u000eGlass Platform0\u001e\u0017\r130313181742Z\u0017\r380119031407Z0|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\u0013\u000eGlass Platform0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000¡3¦Òi¯Ø6ã®Ü-¤\u00ad\u008e9¿øâ\u0019æH3´\u0018µ\u0084=5lì\u0014¸\u009eG\u0097F´\u0098\u000b\u008f\u0083ß\u001eB¡þôÑ\u0091õ×B\fÀ\u0085Ø\u009b+çÚe\tÄ¯?ÛÎ/PTïìçA©é\u0091RZ\u0013#\u0003ÿÎ\u0089\u0015D¦\u008c9»ÊØt¯ ¼¼õ\u0016ö\u008fYÚ7Á\u00ad\u009e/è£ÄZæ\u001e\u0086Ê\u008b¨W¢\u0005C9í¿o\u0096ð@nÂ\u0081A½\buq\u0089c).\u008as©)\u0004ù=ìk½@c¼¥>y¸\u0096©Cp|¹üA;X\u000f0ðGE´õ7\u009f\u00ad§æ\u0087\u0081\u008f\u001aÿüw\u000bNÓ<>\u0081<ttb\u001ez\u00adÔw\u00ad\u0005ÜuL\u0084\r3\rÁXõæá\u0087õ¢`<Q&¬Bô\u0018Û xF)à\u0085\r§ë\u0006\u00925Ù\u0098ºGµE\fZ¢dØ\u008a/\u0095\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0003\u0082\u0001\u0001\u0000\u0086è\u0015JôØôu°ã[ðÒR\u0006c\bLÏÑ\u0086r%éKþÁJ\u001f¾7ErpÀ\u0085ÿVöVÁP\u007f\u0089éË¹Ùl\u0087\u001c;\u000b¡æ<êõÔæ«\u0099C*Ü±\u0097\u0013Wòc´\u0082è\u0096\u0088Í®Ð¼\u008bp}ó\u0016í.©¶VxÔMþíä/°#¯cc±NSÄ\u0081B\u008d²+\u0086ø\u0093«\u008dÀ¿i\u0087\u0089\u0005÷ó[(\u0012Kæ\u0098c\u001dF\f9_5éu«FÞ\f?ß0Ï\u000f\u0007ÙE\u00ad}Ç¨d;ICà.&[\u0010\u008btÕùKùX\u0085ìÚúªoÅ¾¨Ìfý!»\u0090²nÏ\u009aeéø.µ{gìÁéx·Ú\'\u0017\u0088æÖ\u001dç\u0080¦l!¿ÂY¶ÞÉ½zµòÓÛÅ\u0013\u0005Ú\u009fÚ¨ïâ)<¢\u0017:ì#\u0084\b`pNw\u0093\u0085ÉÀ¦b0§"), method_3835("0\u0082\u0003É0\u0082\u0002± \u0003\u0002\u0001\u0002\u0002\t\u0000Ãi \u00adßt\u009dÇ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\f\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\f\u000eGlass Platform0\u001e\u0017\r130226205628Z\u0017\r400714205628Z0|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\f\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\f\u000eGlass Platform0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000¯\u0092ÊGêä\u0092Ð;\u001e\bà\t\u0097w¢ø\u0006Æ¢\u0017\u001dí§[pâ:¢ñ¹¿h\u008c¥/?v,¾Æ:\bÑBZÃ\u001bé2m\u0001\u001e|\u0006Î¡ÈJëp?Ð9\u0097*1\u0006²}\u0098\u0004^|áT\u0004K\"Ê¥\u001d[õù±$â\"ºsA-ÔY0h\u0082,Fg1°Y¯¦¤èÝ?^µ\u007f@øº\u0011](G@)×\u001f1å»°ê^0 ä\u0086uµ¤ý4\u0017\nÔ.ØPë9T,+éµm5\u008f\u0092þ¶²¨\u00984iúKæ+È¤|è\u0000\u0003l®ðõ3sÉX\u0015¸ÊÙs[¿·\u0000e\u0084h¾mæw\u0010-E¿¶9z\u0094\u009f:\u001f\u0001%¸\u0015\u0005\u008f\u0005·«Ý\u0088\u0093Â`\u001f~ñX\u0096Õ(á\u00ad;pmhE\u000f%:\u0013íyÀ\u0002l¨\u0084\u0013\u0011Õ\u008fË\u0093\u0084ß·\u0002\u0001\u0003£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014óSB\u001f\u000fÍ{#j_\u0084µ\u001ffWc\u0019Ð{\u008f0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014óSB\u001f\u000fÍ{#j_\u0084µ\u001ffWc\u0019Ð{\u008f0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000©\u0090X±/\u0007ï\u0014}CÅ=ÂÉèá\u0001¥b\bfF\u0091¼\u0004·\u001d÷yxÜ!\u0089/ü|\u0003ú¯Y%;è\u0095õ2Â_]uºæïº´XRp(hk\u0001B\'¥A·C§³/\u008a4Ñ[Yô \u0015X%ý¼\u009eì>ÒtÎìÇ\u0001Ë«[Ug\"3wn÷ä´â\u0001R\u000eFÕEI\\\u0014Ày\u00ad}\u001fý\u009cã¢±Ê\u001bQ[ +7[÷/\u008a6\u000fó\u0097\u0095-\u0082\u00ad`S:Ú×Å~#dRE¥ºÊÊBTý!³d\u009b!_\u0004vòé\u0086I\u0019÷\u0088W \u008b\u0013Xv\nF!î\u0003UÙ»@h\u000fÚó±\u008e¨\u008d\u0090f\u0004+Ë@\u00853àw,Öãª\u001e\u0083 Æñ\u0002\u0004úå[£áÙßëÔ@Uü\u0007¨æ\u00ad\u008d;Ô\u00117ö/_f£÷\u0018$õO({Úø?")};
      field_3483 = var5;
      byte[][] var6 = new byte[][]{method_3835("0\u0082\u0003Á0\u0082\u0002© \u0003\u0002\u0001\u0002\u0002\t\u0000é\u0005DY+\u0084P\u00820\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u001e\u0017\r140527043400Z\u0017\r411012043400Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000Ðu\u009bk\u0017*HI*Õî\u0092>r~ë`\"¬Ø\b»W\fE\u0097CÚ\u009bCÄaåçb\u001c\u009d\u0005\n]ç¢\u0098½\u000f\f\u0002`ÿ\u008e\u0093âr\u0082]ØHH\u0081$\u001a\u0006î\u0092f¬+ýá\u009fÞ\r\u008a\tE\u009dWËÇ\"ne\u008d\u0094¿)\u001d\u000få-¨ÑR\u0092g\u00937ìj\u000e.7ù³ÎÓ\u009cÓÙå°\tªY\u0088Û!VÈÊ#u´\u001cfö9\n-\u000e\u000e\u0098IÁxt\t\u009fÀÙ%_\u0098\u0098ËÅY\u0012\u001b\u0086O\u0095ò\u009e\u008bâ-±ât\u001a\u0000\u0098ÚIYôa\u0097n\u00ad\u000e\u0012m\u0093\u0097ÀKeð\u0098ï\u000f¼BzÔ\u009d2ÏOïM:d`ÊÄ\u0095÷rXê-è½\u008a@¿\u0007ó?`]}Wf¾z!ò\u009eJ\',ªX¥9\\Íÿ&}\u000bÔò~D\u007f-É¼ÄJ\u0014dW§\u008a:J½!_w\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014³ÌD*Ûè6xð\u0082[4q4¬c\u001e` \u00930\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014³ÌD*Ûè6xð\u0082[4q4¬c\u001e` \u00930\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u0096\u0087+ù\u0098\u001bqéèî\u0002[Ué<â¨R\u0017%¡ª\u0019\u0010Bï\u00ad6¸) É\u001b\'\u001fãûi\u0099D3\u0013gú¦&\u0081¤\u0092â(\u001dì¥ßÌÝ\u0003ÆBªñ{tÜ\u007f&ü\u0085^P½OLââ\u008b\u001bkûìë\u001bÝ\u0098\u0098påÿÈ[þ\u007f²A\u0019D\'3ôÐÚMc<^¾å\u0085\u0083\n\u001f\u0086\u0014?E£ÏÎ@®Ða\u007fÕ+\u0007¹b¼fÑ\u0098_>ÔùÖÆH²\u00118Ê\u009e\u0081ú\u0099þ\u0091vôÜ»å\"¢l.Õ\b¦·\táW\u007f*P¯SÑ\u0006\u0081:\u00171½\u0017\u0086\u0086i[GÙ\u0087¡4!g\u0081.\fp\u001cÊÎ¶\u0016g5.IaÁ\f×JD6y+\u00926N5³\u0010 _+\u0014²hsbK7èi:\u001c´í3oVáØ zé\u0002³>9\u000eQ²\u0097Ê4@\"\u009c\u0085"), method_3835("0\u0082\u0003Á0\u0082\u0002© \u0003\u0002\u0001\u0002\u0002\t\u0000ÐTãÎÛÎ\u0004\u008b0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u001e\u0017\r140603192622Z\u0017\r411019192622Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\f\nmediashell0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000µ\u001f{°\u008b\u008cìÎp4cÎÓ\u001d4\u0090r\u0084¬¶©£õ?ßÐæ\u0086#ð={4]\u001fõ\"Øízeå3´â>ñ@k}Õ\u0095\u0014h\u001d>vÎÐe\u0005óM#\u0011_\u0000WG6I-h\u008c\u008eÏ|¶Ø|§uÂeÞ!\u001f\u00ad\u0092pg\b\u008fø¯1,í3.Çgb\bà/{í{4f¡2\u0005tu²\u008agm¸q\u001cvà\u0082;Ì7¤c\u0005(#ä_\u0082*rN8\'\u0010&\u0007oTÂéÈ¹ÿ#\u007fA\u0094z/Èµ s®\t_\u001e\u009e«ÜJ\u009aÎzó\u0097%\u0003s\u0003d\u0012Ôñó,(\u0092\u0092Lâ¾\u008dý\u008a_öè\u008cÃ\u0011äÎ\u001bTgH\u0092û\u0086ý¡ãß0¦ø,ä¥ËÕ*?\u0087ò\u0092\u0015\u0082s:°ÈKz\u0018\u0090ïQlÐá¯°\u000f\b\u00ad\u008b\u001f\u0006\u0085\u008cÿ2é;©\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014§L:À:o°\núúÉ×@(\\ \u0082\u0088«\u00100\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014§L:À:o°\núúÉ×@(\\ \u0082\u0088«\u00100\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000 \u008d>dBCQ¼>Y_Ôà¥\n=-à\"s7\u0000KÌ;7|yê²¬\u0019íÎ]$<W2¤sóPh\u00939\u0000þÖd\u0006Î\bÈ\u0013&Ò\u0013ÔûÃ\u0085%ßkøê»¹\u001b<.a°ÚtFS`sj\u001fH-Ét;â\u009e÷\u0087a\u0014\u0018èCY]\u009e\u001a\u001a¶\u0098¡-ÐvÆ}\u009dL#ª\u000f×\u0091°ñ\bã;÷\u001fEn·RÃ\u0086º\u0007öÐ{\u007f¤Wß\u0001t²\b§¡^ÉD#\u0097n[ÔØ7\u0001Ý_\f  r\u009e8bø\u0002aÈ4\u0099r\u009d9¤\u0090\u000bÍ\u0010\u000f\f(âÏ*\u0083~º#%o_¬\u0090$f#\u000f§Ï}ÆâDD\u009d\u0010\u000fÝ\u0085¾\u0099)Áí|G\u00100ïV\u0006ý\u0005Ç`\u0017¥¯ð\u00952Sh¯\u0001£ ÷\u000fO\r\u0000+E\u0016¨\u009a\u00864ÚÌ\tÍq\u009c6")};
      field_3484 = var6;
      byte[][] var7 = new byte[][]{method_3835("0\u0082\u0003µ0\u0082\u0002\u009d \u0003\u0002\u0001\u0002\u0002\t\u0000å×\u0080\u0017Î\u0083t¡0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u001e\u0017\r140529162639Z\u0017\r411014162639Z0q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000¾¡À\u0091\u009f\u0084W\u009a\u001f¸\f]xw\u0096#T\u0011;\u0089\u0003b\u001aÖrV&-.-\u008a\u008chI°\u0011ÑùK7ký\u0017ü\u007fÞ7¤ÿ\u009a\u0011\u0089+*?/Rn\u000bïæÅÌÃBátÑ2Ã$_{ó\u008d\u0018U\'ï²-µ\u000e¿yËò3\u0087ÝÚ1K\u0004»Íò|è/7\u00875ì$e\\Ô+/5\u0087®J\u009bR\u0083Í¢îtÒ+Û\u0085R\u0013SègZÉ¸ýR®\u0019ªªo^ë_Ùºs³b \u0085&\u0080©h\u009c\u008cÔÂ\u009bnW\'f\u000fp®A\u0019/v;=pUV1*ý\u001f\n`Öþ\u0011úR¦\u0012: Î3A$ý\u009cÆ\n~*z6yÛ£=\u0085ø\"\u009b´\u0007mÊº»\u0090«\u0084ÎÛ\u001c\u0090&Ë\u0001ëÏÂ\u0013fð\u001b0\u000e\u009aµ\u0097HÊñ\u0005xÆ\u0088\r:kihR\\x<\u0003Ý\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Â¸ç\u0001\u0090Að\nà\u000b\\\u0006?Mnú\u0007p¦\u00880\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014Â¸ç\u0001\u0090Að\nà\u000b\\\u0006?Mnú\u0007p¦\u00880\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u008dH\u0088¡LÏsf¦\u0005ó\u009dS\u0003,P\u0010$Ze%\u0090\u0085\u0010Å)@\u0086ìÛ¾_Ü} Ý4\u0080\u00ad\u0082Ò\u001b\u0099\u0094ÏVðÂ-Ã9þI\u0013:\u008bûÐÂ!£í_\u009arEå!9¼\u0090\u0012Vwò\u0085\u009eI2\u007fí3\u008b4\u008b·|«\u00ad\u0015F\u0012\u0091tN¼\u0018Ý&Cóc#UHÌ^Á?JqxP?\u009cc÷\u000f6C@ùc7\u0086]ÈÉ=úzO\'Â\u009f\u0099ØZîý¬¢¹Ï\u009c\u000b\u009eq¤\rrþAÌ\u0004d¯,1\bì\u0092|\u008d\u0006\u007f\u0089Uõ«Ò\u0083«¢\u0091UáÍY\"³v·Kº\u001b\u0085\u0005[Ç×\u0083¶ó\'\u0094 §Òõ ¼\u0003çµn+Û\'¦ð\u0088\u009f)qG\u0015$ éÑDÀþåÎ¢\u0088)ß\b-ù\u009b\u009c\u00107p\u0000uî<èÀÎ\\\u0003¹5Óý\u0015v\u0005Fl"), method_3835("0\u0082\u0003µ0\u0082\u0002\u009d \u0003\u0002\u0001\u0002\u0002\t\u0000åo\u009c\t\u001b\u0092\u0084\u001f0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u001e\u0017\r140529162612Z\u0017\r411014162612Z0q1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\r0\u000b\u0006\u0003U\u0004\u0003\f\u0004nova0\u0082\u0001\"0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\u000f\u00000\u0082\u0001\n\u0002\u0082\u0001\u0001\u0000Ä\u0092_Uº4\\\u0096Ñ\u009b@_IÚÏ96Ör\u000fË6áMÚÿ\u0000ß[\u0089rÂÑN\u00adÌd\u0096ÑþÈ/ðLÂ®Ö\u009aæ\u0086¤ÑKc\u001fØÖ\u0018]à\u0010A\u0014\u001ew\tUñq\u00ad«*\u00adÉV94O+úzQ×\u007fëÜ.\u0084Îñh~¶\u0082\u001e\u0001À\u009fñI?\u0003Tj\u001a\u00ad\u00ad$\\÷22\u0083ZÿZ·À\u009d\u0092\u001b\u0085\t\u0001a~\u0012\u001e\u0015»Æ{(WiËZ6+6¦2s§\u0001\u009ey ë@QÅ¦\u009b@\u009dùvTOo\u0015Á\u0094»\u008c\u0087À\\®r&.t#2¡ßK°ð;àU·6TÛ\u0092?óú\u0093)°ÔÍ\u009aZË=§Äø~j\u0094ü\u001bYy\t·\u0015Å\"e\u009d\u007fÖÃ\u0093\u0081\u0099h,æ\u0015E\u0082\u00adê)\u0087å\u00adÎçWà¯\u0083\u0002õx\r©\u0018\u009eZ9\u0018-\u0085#G\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014à»øÁWûã»ùfÉä;¤Ü\u0004\'\nõH0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0080\u0014à»øÁWûã»ùfÉä;¤Ü\u0004\'\nõH0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u008d\u0080îÅ\u0080ô/jêâ\u009c6\u001dðÇÕ\bQér\u0016eàF\u0000Å\u0081ø\u0096Ì×^\u009d64Ì\u009c õÅÓ\u00992»gÖà\u00ad\u0015k\u0087\u0003oímÒ[\u001eh¿\u00937åiå[vN\f\u0092\u0019\u0017¾\u001dÏ¿|\t\u000eQ¿\u0090¯\u0006\u0004¬\u0019Ï\u0098\u0098×@\u0090åøväj\'\u009c½ü¾¦·®\u001e Up\u001d\"0\u0005ì ½Àþz\u0011\u0092a¤Û}Ñ\u0017ë\u0014\u008bth\u008c¾\u009bØ(¬JbåîW·5Â\u0012¿ò^tòIJ\n\u008eZÖ8Y\u008f½\f\u0083eóÍÒDN±*\u0014Å\u0097¸\u008f\n\u0092*Ý×{\u0006\u008bÓqÌ·Î¢«S:\u001fz[(S4é\u0010 ó\u008b²EÜkÊ¦\u009f\u0091\u0086Ä,Ë(;ìá/1Û\u0014t%KPIÙ\u0017yÍ#}ò\u0099¦*b£\b\u009aÜ?Ñ7\u009f$\u0080gÍ`q")};
      field_3485 = var7;
      byte[][][] var8 = new byte[][][]{field_3478, field_3479, field_3480, field_3481, field_3482, field_3483, field_3484, field_3485};
      field_3486 = method_3834(var8);
      byte[][] var9 = new byte[][]{field_3478[0], field_3479[0], field_3481[0], field_3482[0], field_3483[0], field_3484[0], field_3485[0]};
      field_3487 = var9;
      field_3488 = false;
      field_3489 = false;
      field_3490 = -1;
      field_3491 = new Object();
   }

   // $FF: renamed from: Z (int) android.content.Intent
   public static Intent method_3829(int var0) {
      switch(var0) {
      case 1:
      case 2:
         return class_353.method_2238("com.google.android.gms");
      case 3:
         return class_353.method_2236("com.google.android.gms");
      case 12:
         return class_353.method_2239();
      default:
         return null;
      }
   }

   // $FF: renamed from: a (int, android.app.Activity, android.support.v4.app.Fragment, int, android.content.DialogInterface.OnCancelListener) android.app.Dialog
   private static Dialog method_3830(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      Builder var7;
      label43: {
         if(class_275.method_1853()) {
            TypedValue var5 = new TypedValue();
            var1.getTheme().resolveAttribute(16843529, var5, true);
            if("Theme.Dialog.Alert".equals(var1.getResources().getResourceEntryName(var5.resourceId))) {
               var7 = new Builder(var1, 5);
               break label43;
            }
         }

         var7 = null;
      }

      if(var7 == null) {
         var7 = new Builder(var1);
      }

      var7.setMessage(method_3842(var1, var0));
      if(var4 != null) {
         var7.setOnCancelListener(var4);
      }

      Intent var9 = method_3840(var1, var0);
      class_351 var10;
      if(var2 == null) {
         var10 = new class_351(var1, var9, var3);
      } else {
         var10 = new class_351(var2, var9, var3);
      }

      String var11 = method_3843(var1, var0);
      if(var11 != null) {
         var7.setPositiveButton(var11, var10);
      }

      switch(var0) {
      case 0:
         return null;
      case 1:
         return var7.setTitle(class_443.string.common_google_play_services_install_title).create();
      case 2:
         return var7.setTitle(class_443.string.common_google_play_services_update_title).create();
      case 3:
         return var7.setTitle(class_443.string.common_google_play_services_enable_title).create();
      case 4:
      case 6:
         return var7.create();
      case 5:
         Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
         return var7.setTitle(class_443.string.common_google_play_services_invalid_account_title).create();
      case 7:
         Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
         return var7.setTitle(class_443.string.common_google_play_services_network_error_title).create();
      case 8:
         Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
         return var7.create();
      case 9:
         Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
         return var7.setTitle(class_443.string.common_google_play_services_unsupported_title).create();
      case 10:
         Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
         return var7.create();
      case 11:
         Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
         return var7.create();
      case 12:
         Log.e("GooglePlayServicesUtil", "The date of the device is not valid.");
         return var7.setTitle(class_443.string.common_google_play_services_unsupported_title).create();
      default:
         Log.e("GooglePlayServicesUtil", "Unexpected error code " + var0);
         return var7.create();
      }
   }

   // $FF: renamed from: a (android.content.pm.PackageManager, android.content.pm.PackageInfo) boolean
   public static boolean method_3831(PackageManager var0, PackageInfo var1) {
      boolean var2 = true;
      boolean var3 = false;
      if(var1 != null) {
         if(method_3841(var0)) {
            if(method_3833(var1, field_3486) == null) {
               var2 = false;
            }

            return var2;
         }

         byte[] var4 = method_3833(var1, field_3487);
         var3 = false;
         if(var4 != null) {
            var3 = var2;
         }

         if(!var3 && method_3833(var1, field_3486) != null) {
            Log.w("GooglePlayServicesUtil", "Test-keys aren\'t accepted on this build.");
            return var3;
         }
      }

      return var3;
   }

   // $FF: renamed from: a (android.content.res.Resources) boolean
   public static boolean method_3832(Resources var0) {
      if(var0 != null) {
         boolean var1;
         if((15 & var0.getConfiguration().screenLayout) > 3) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(class_275.method_1850() && var1 || method_3839(var0)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (android.content.pm.PackageInfo, byte[][]) byte[]
   private static byte[] method_3833(PackageInfo var0, byte[]... var1) {
      CertificateFactory var4;
      try {
         var4 = CertificateFactory.getInstance("X509");
      } catch (CertificateException var20) {
         Log.w("GooglePlayServicesUtil", "Could not get certificate instance.");
         return null;
      }

      if(var0.signatures.length != 1) {
         Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
         return null;
      } else {
         byte[] var5 = var0.signatures[0].toByteArray();
         ByteArrayInputStream var6 = new ByteArrayInputStream(var5);

         X509Certificate var9;
         try {
            var9 = (X509Certificate)var4.generateCertificate(var6);
         } catch (CertificateException var19) {
            Log.w("GooglePlayServicesUtil", "Could not generate certificate.");
            return null;
         }

         try {
            var9.checkValidity();
         } catch (CertificateExpiredException var17) {
            Log.w("GooglePlayServicesUtil", "Certificate has expired.");
            return null;
         } catch (CertificateNotYetValidException var18) {
            Log.w("GooglePlayServicesUtil", "Certificate is not yet valid.");
            return null;
         }

         for(int var14 = 0; var14 < var1.length; ++var14) {
            byte[] var16 = var1[var14];
            if(Arrays.equals(var16, var5)) {
               return var16;
            }
         }

         if(Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(var5, 0));
         }

         return null;
      }
   }

   // $FF: renamed from: a (byte[][][]) byte[][]
   private static byte[][] method_3834(byte[][]... var0) {
      int var1 = var0.length;
      int var2 = 0;

      int var3;
      for(var3 = 0; var2 < var1; ++var2) {
         var3 += var0[var2].length;
      }

      byte[][] var4 = new byte[var3][];
      int var5 = var0.length;
      int var6 = 0;

      int var9;
      for(int var7 = 0; var6 < var5; var7 = var9) {
         byte[][] var8 = var0[var6];
         var9 = var7;

         int var11;
         for(int var10 = 0; var10 < var8.length; var9 = var11) {
            var11 = var9 + 1;
            var4[var9] = var8[var10];
            ++var10;
         }

         ++var6;
      }

      return var4;
   }

   // $FF: renamed from: au (java.lang.String) byte[]
   private static byte[] method_3835(String var0) {
      try {
         byte[] var2 = var0.getBytes("ISO-8859-1");
         return var2;
      } catch (UnsupportedEncodingException var3) {
         throw new AssertionError(var3);
      }
   }

   // $FF: renamed from: b (int, android.app.Activity, android.support.v4.app.Fragment, int, android.content.DialogInterface.OnCancelListener) boolean
   public static boolean method_3836(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      Dialog var5 = method_3830(var0, var1, var2, var3, var4);
      if(var5 == null) {
         return false;
      } else {
         boolean var7;
         try {
            var7 = var1 instanceof FragmentActivity;
         } catch (NoClassDefFoundError var10) {
            var7 = false;
         }

         if(var7) {
            FragmentManager var9 = ((FragmentActivity)var1).getSupportFragmentManager();
            SupportErrorDialogFragment.newInstance(var5, var4).show(var9, "GooglePlayServicesErrorDialog");
         } else {
            if(!class_275.method_1850()) {
               throw new RuntimeException("This Activity does not support Fragments.");
            }

            android.app.FragmentManager var8 = var1.getFragmentManager();
            ErrorDialogFragment.newInstance(var5, var4).show(var8, "GooglePlayServicesErrorDialog");
         }

         return true;
      }
   }

   // $FF: renamed from: b (android.content.pm.PackageManager) boolean
   public static boolean method_3837(PackageManager param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.pm.PackageManager, java.lang.String) boolean
   public static boolean method_3838(PackageManager var0, String var1) {
      PackageInfo var4;
      try {
         var4 = var0.getPackageInfo(var1, 64);
      } catch (NameNotFoundException var5) {
         if(Log.isLoggable("GooglePlayServicesUtil", 3)) {
            Log.d("GooglePlayServicesUtil", "Package manager can\'t find package " + var1 + ", defaulting to false");
         }

         return false;
      }

      return method_3831(var0, var4);
   }

   // $FF: renamed from: b (android.content.res.Resources) boolean
   private static boolean method_3839(Resources var0) {
      Configuration var1 = var0.getConfiguration();
      boolean var2 = class_275.method_1852();
      boolean var3 = false;
      if(var2) {
         int var4 = 15 & var1.screenLayout;
         var3 = false;
         if(var4 <= 3) {
            int var5 = var1.smallestScreenWidthDp;
            var3 = false;
            if(var5 >= 600) {
               var3 = true;
            }
         }
      }

      return var3;
   }

   // $FF: renamed from: c (android.content.Context, int) android.content.Intent
   @Deprecated
   public static Intent method_3840(Context var0, int var1) {
      return method_3829(var1);
   }

   // $FF: renamed from: c (android.content.pm.PackageManager) boolean
   public static boolean method_3841(PackageManager var0) {
      return method_3837(var0) || !method_3844();
   }

   // $FF: renamed from: d (android.content.Context, int) java.lang.String
   public static String method_3842(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         if(method_3832(var0.getResources())) {
            return var2.getString(class_443.string.common_google_play_services_install_text_tablet);
         }

         return var2.getString(class_443.string.common_google_play_services_install_text_phone);
      case 2:
         return var2.getString(class_443.string.common_google_play_services_update_text);
      case 3:
         return var2.getString(class_443.string.common_google_play_services_enable_text);
      case 4:
      case 6:
      case 8:
      case 10:
      case 11:
      default:
         return var2.getString(class_443.string.common_google_play_services_unknown_issue);
      case 5:
         return var2.getString(class_443.string.common_google_play_services_invalid_account_text);
      case 7:
         return var2.getString(class_443.string.common_google_play_services_network_error_text);
      case 9:
         return var2.getString(class_443.string.common_google_play_services_unsupported_text);
      case 12:
         return var2.getString(class_443.string.common_google_play_services_unsupported_date_text);
      }
   }

   // $FF: renamed from: e (android.content.Context, int) java.lang.String
   public static String method_3843(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         return var2.getString(class_443.string.common_google_play_services_install_button);
      case 2:
         return var2.getString(class_443.string.common_google_play_services_update_button);
      case 3:
         return var2.getString(class_443.string.common_google_play_services_enable_button);
      default:
         return var2.getString(17039370);
      }
   }

   // $FF: renamed from: et () boolean
   public static boolean method_3844() {
      return field_3488?field_3489:"user".equals(Build.TYPE);
   }

   // $FF: renamed from: f (android.content.Context, int) java.lang.String
   public static String method_3845(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         return var2.getString(class_443.string.common_google_play_services_notification_needs_installation_title);
      case 2:
         return var2.getString(class_443.string.common_google_play_services_notification_needs_update_title);
      case 3:
         return var2.getString(class_443.string.common_google_play_services_needs_enabling_title);
      case 4:
      case 6:
      case 8:
      case 10:
      case 11:
      default:
         return var2.getString(class_443.string.common_google_play_services_unknown_issue);
      case 5:
         return var2.getString(class_443.string.common_google_play_services_invalid_account_text);
      case 7:
         return var2.getString(class_443.string.common_google_play_services_network_error_text);
      case 9:
         return var2.getString(class_443.string.common_google_play_services_unsupported_text);
      case 12:
         return var2.getString(class_443.string.common_google_play_services_unsupported_date_text);
      }
   }

   public static Dialog getErrorDialog(int var0, Activity var1, int var2) {
      return getErrorDialog(var0, var1, var2, (OnCancelListener)null);
   }

   public static Dialog getErrorDialog(int var0, Activity var1, int var2, OnCancelListener var3) {
      return method_3830(var0, var1, (Fragment)null, var2, var3);
   }

   public static PendingIntent getErrorPendingIntent(int var0, Context var1, int var2) {
      Intent var3 = method_3840(var1, var0);
      return var3 == null?null:PendingIntent.getActivity(var1, var2, var3, 268435456);
   }

   public static String getErrorString(int var0) {
      switch(var0) {
      case 0:
         return "SUCCESS";
      case 1:
         return "SERVICE_MISSING";
      case 2:
         return "SERVICE_VERSION_UPDATE_REQUIRED";
      case 3:
         return "SERVICE_DISABLED";
      case 4:
         return "SIGN_IN_REQUIRED";
      case 5:
         return "INVALID_ACCOUNT";
      case 6:
         return "RESOLUTION_REQUIRED";
      case 7:
         return "NETWORK_ERROR";
      case 8:
         return "INTERNAL_ERROR";
      case 9:
         return "SERVICE_INVALID";
      case 10:
         return "DEVELOPER_ERROR";
      case 11:
         return "LICENSE_CHECK_FAILED";
      case 12:
         return "DATE_INVALID";
      default:
         return "UNKNOWN_ERROR_CODE";
      }
   }

   public static String getOpenSourceSoftwareLicenseInfo(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static Context getRemoteContext(Context var0) {
      try {
         Context var2 = var0.createPackageContext("com.google.android.gms", 3);
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   public static Resources getRemoteResource(Context var0) {
      try {
         Resources var2 = var0.getPackageManager().getResourcesForApplication("com.google.android.gms");
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   public static int isGooglePlayServicesAvailable(Context var0) {
      PackageManager var1 = var0.getPackageManager();

      try {
         var0.getResources().getString(class_443.string.common_google_play_services_unknown_issue);
      } catch (Throwable var32) {
         Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      }

      if(System.currentTimeMillis() < 1227312000288L) {
         return 12;
      } else {
         method_3847(var0);

         PackageInfo var6;
         try {
            var6 = var1.getPackageInfo("com.google.android.gms", 64);
         } catch (NameNotFoundException var31) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
         }

         if(class_282.method_1872(var6.versionCode)) {
            PackageInfo var21;
            try {
               var21 = var1.getPackageInfo(var0.getPackageName(), 64);
            } catch (NameNotFoundException var30) {
               Log.w("GooglePlayServicesUtil", "Calling package info missing.");
               return 9;
            }

            if(!method_3844()) {
               byte[][] var26 = new byte[][]{field_3478[1], field_3483[1]};
               if(method_3833(var6, var26) == null) {
                  Log.w("GooglePlayServicesUtil", "Google Play services signature (test key) invalid on Glass.");
                  return 9;
               }

               byte[][] var27 = new byte[][]{field_3478[1], field_3483[1]};
               if(method_3833(var21, var27) == null) {
                  Log.w("GooglePlayServicesUtil", "Calling package " + var21.packageName + " signature (test key) invalid on Glass.");
                  return 9;
               }
            } else {
               byte[][] var22 = new byte[][]{field_3478[0], field_3483[0]};
               if(method_3833(var6, var22) == null) {
                  Log.w("GooglePlayServicesUtil", "Google Play services signature invalid (release key) on Glass.");
                  return 9;
               }

               byte[][] var23 = new byte[][]{field_3483[0]};
               if(method_3833(var21, var23) == null) {
                  Log.w("GooglePlayServicesUtil", "Calling package " + var21.packageName + " signature (release key) invalid on Glass.");
                  return 9;
               }
            }
         } else if(class_282.method_1869(var0)) {
            if(method_3833(var6, field_3478) == null) {
               Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
               return 9;
            }
         } else {
            PackageInfo var9;
            try {
               var9 = var1.getPackageInfo("com.android.vending", 64);
            } catch (NameNotFoundException var29) {
               Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
               return 9;
            }

            byte[] var10 = method_3833(var9, field_3478);
            if(var10 == null) {
               Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
               return 9;
            }

            if(method_3833(var6, new byte[][]{var10}) == null) {
               Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
               return 9;
            }
         }

         int var11 = class_282.method_1870(5077000);
         if(class_282.method_1870(var6.versionCode) < var11) {
            Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 5077000 but found " + var6.versionCode);
            return 2;
         } else {
            ApplicationInfo var14;
            try {
               var14 = var1.getApplicationInfo("com.google.android.gms", 0);
            } catch (NameNotFoundException var28) {
               Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
               var28.printStackTrace();
               return 1;
            }

            return !var14.enabled?3:0;
         }
      }
   }

   public static boolean isUserRecoverableError(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
      case 9:
      case 12:
         return true;
      default:
         return false;
      }
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, int var2) {
      return showErrorDialogFragment(var0, var1, var2, (OnCancelListener)null);
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, int var2, OnCancelListener var3) {
      return method_3836(var0, var1, (Fragment)null, var2, var3);
   }

   public static void showErrorNotification(int var0, Context var1) {
      Resources var2 = var1.getResources();
      Notification var3 = new Notification(17301642, var2.getString(class_443.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
      var3.flags |= 16;
      String var4 = method_3845(var1, var0);
      String var5 = method_3848(var1);
      var3.setLatestEventInfo(var1, var4, var2.getString(class_443.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{var5}), getErrorPendingIntent(var0, var1, 0));
      ((NotificationManager)var1.getSystemService("notification")).notify('魭', var3);
   }

   // $FF: renamed from: w (android.content.Context) void
   public static void method_3846(Context var0) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
      int var1 = isGooglePlayServicesAvailable(var0);
      if(var1 != 0) {
         Intent var2 = method_3840(var0, var1);
         Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + var1);
         if(var2 == null) {
            throw new GooglePlayServicesNotAvailableException(var1);
         } else {
            throw new GooglePlayServicesRepairableException(var1, "Google Play Services not available", var2);
         }
      }
   }

   // $FF: renamed from: x (android.content.Context) void
   private static void method_3847(Context var0) {
      ApplicationInfo var3;
      label20: {
         ApplicationInfo var6;
         try {
            var6 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
         } catch (NameNotFoundException var7) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", var7);
            var3 = null;
            break label20;
         }

         var3 = var6;
      }

      Bundle var4 = var3.metaData;
      if(var4 != null) {
         int var5 = var4.getInt("com.google.android.gms.version");
         if(var5 != 5077000) {
            throw new IllegalStateException("The meta-data tag in your app\'s AndroidManifest.xml does not have the right value.  Expected 5077000 but found " + var5 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
         }
      } else {
         throw new IllegalStateException("A required meta-data tag in your app\'s AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
   }

   // $FF: renamed from: y (android.content.Context) java.lang.String
   private static String method_3848(Context var0) {
      String var1 = var0.getApplicationInfo().name;
      if(TextUtils.isEmpty(var1)) {
         var1 = var0.getPackageName();
         PackageManager var2 = var0.getApplicationContext().getPackageManager();

         ApplicationInfo var4;
         label17: {
            ApplicationInfo var5;
            try {
               var5 = var2.getApplicationInfo(var0.getPackageName(), 0);
            } catch (NameNotFoundException var6) {
               var4 = null;
               break label17;
            }

            var4 = var5;
         }

         if(var4 != null) {
            var1 = var2.getApplicationLabel(var4).toString();
         }
      }

      return var1;
   }
}
