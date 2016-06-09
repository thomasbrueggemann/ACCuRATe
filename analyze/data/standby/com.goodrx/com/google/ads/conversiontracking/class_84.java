package com.google.ads.conversiontracking;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.google.ads.conversiontracking.class_78;
import com.google.ads.conversiontracking.class_80;
import com.google.ads.conversiontracking.class_83;
import com.google.ads.conversiontracking.class_86;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

// $FF: renamed from: com.google.ads.conversiontracking.l
public final class class_84 {
   // $FF: renamed from: a byte[][]
   static final byte[][] field_592;
   // $FF: renamed from: b byte[][]
   static final byte[][] field_593;
   // $FF: renamed from: c byte[][]
   static final byte[][] field_594;
   // $FF: renamed from: d byte[][]
   static final byte[][] field_595;
   // $FF: renamed from: e byte[][]
   static final byte[][] field_596;
   // $FF: renamed from: f boolean
   public static boolean field_597;
   // $FF: renamed from: g boolean
   public static boolean field_598;
   // $FF: renamed from: h boolean
   static boolean field_599;
   // $FF: renamed from: i byte[][]
   private static final byte[][] field_600;
   // $FF: renamed from: j byte[][]
   private static final byte[][] field_601;
   // $FF: renamed from: k int
   private static int field_602;
   // $FF: renamed from: l java.lang.Object
   private static final Object field_603;

   static {
      byte[][] var0 = new byte[][]{method_555("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u001e\u0017\r080821231334Z\u0017\r360107231334Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000«V.\u0000Ø;¢\b®\n\u0096o\u0012N)Ú\u0011ò«VÐ\u008fXâÌ©\u0013\u0003é·TÓrö@§\u001b\u001dË\u0013\tgbNFV§wj\u0092\u0019=²å¿·$©\u001ew\u0018\u008b\u000ejG¤;3Ù`\u009bw\u00181EÌß{.XftÉáV[\u001fLjYU¿òQ¦=«ùÅ\\\'\"\"Rèuäø\u0015Jd_\u0089qhÀ±¿Æ\u0012ê¿xWi»4ªy\u0084Ü~.¢vL®\u0083\u0007ØÁqT×î_d¥\u001aD¦\u0002ÂI\u0005AWÜ\u0002Í_\\\u000eUûï\u0085\u0019ûã\'ð±Q\u0016\u0092Å o\u0019Ñ\u0083\u0085õÄÛÂÖ¹?hÌ)yÇ\u000e\u0018«\u0093\u0086k;ÕÛ\u0089\u0099U*\u000e;L\u0099ßXû\u0091\u008bíÁ\u0082º5à\u0003Á´±\rÒD¨î$ÿý38r«R!\u0098^Ú°ü\r\u000b\u0014[j¡\u0092\u0085\u008ey\u0002\u0001\u0003£\u0081Ù0\u0081Ö0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Ç}\u008cÂ!\u0017V%\u009a\u007fÓ\u0082ßkã\u0098ä×\u0086¥0\u0081¦\u0006\u0003U\u001d#\u0004\u0081\u009e0\u0081\u009b\u0080\u0014Ç}\u008cÂ!\u0017V%\u009a\u007fÓ\u0082ßkã\u0098ä×\u0086¥¡x¤v0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android\u0082\t\u0000Âà\u0087FdJ0\u008d0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0082\u0001\u0001\u0000mÒRÎï\u00850,6\nªÎ\u0093\u009bÏòÌ©\u0004»]z\u0016aø®F²\u0099B\u0004ÐÿJhÇí\u001aS\u001eÄYZb<æ\u0007c±g)zzãW\u0012Ä\u0007ò\bðË\u0010\u0094)\u0012M{\u0010b\u0019À\u0084Ê>³ù\u00ad_¸qï\u0092&\u009a\u008bâ\u008bñmDÈÙ \u008el²ð\u0005»?âË\u0096D~\u0086\u008es\u0010v\u00adE³?`\tê\u0019Áaæ&Aª\u0099\'\u001dýR(ÅÅ\u0087\u0087]Û\u007fE\'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\u000b\u0010q§Ä@ðþ\u009e \u001c¶\'ÊgCiÐ\u0084½/Ù\u0011ÿ\u0006Í¿,ú\u0010Ü\u000f\u0089:ãWb\u0091\u0090HÇïÆLqD\u0017\u0083B÷\u0005\u0081ÉÞW:õ[9\r×ý¹A\u00861\u0089]_u\u009f0\u0011&\u0087ÿb\u0014\u0010Ài0\u008a"), method_555("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u00000\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r080415233656Z\u0017\r350901233656Z0\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000ÖÎ.\b\n¿â1MÑ\u008d³ÏÓ\u0018\\´=3ú\ftá½¶ÑÛ\u0089\u0013ö,\\9ßVøF\u0081=e¾ÀóÊBk\u0007Å¨íZ9\u0090ÁgçkÉ\u0099¹\'\u0089K\u008f\u000b\"\u0000\u0019\u0094©)\u0015årÅm*0\u001b£oÅü\u0011:ÖË\u009et5¡m#«}úîáeäß\u001f\n\u008d½§\n\u0086\u009dQlN\u009d\u0005\u0011\u0096Ê|\fU\u007f\u0017[ÃuùHÅj®\u0086\b\u009b¤O\u008a¦¤Ý\u009a}¿,\n5\"\u0082\u00ad\u0006¸Ì\u0018^±Uyîøm\b\u000b\u001da\u0089Àù¯\u0098±ÂëÑ\u0007êE«Ûh£Ç\u0083\u008a^T\u0088ÇlSÔ\u000b\u0012\u001dç»Ó\u000eb\f\u0018\u008aáªaÛ¼\u0087Ý<d_/UóÔÃuì@p©?qQØ6pÁj\u0097\u001a¾^òÑ\u0018\u0090á¸®ó)\u008cðf¿\u009eláD¬\u009aèm\u001c\u001b\u000f\u0002\u0001\u0003£\u0081ü0\u0081ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u008d\u001cÅ¾\u0095LC<a\u0086:\u0015°L¼\u0003òOà²0\u0081É\u0006\u0003U\u001d#\u0004\u0081Á0\u0081¾\u0080\u0014\u008d\u001cÅ¾\u0095LC<a\u0086:\u0015°L¼\u0003òOà²¡\u0081\u009a¤\u0081\u00970\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com\u0082\t\u0000Õ\u0085¸l}ÓNõ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0082\u0001\u0001\u0000\u0019Ó\fñ\u0005ûx\u0092?L\r}Ò##=@\u0096zÏÎ\u0000\b\u001d[×ÆéÖí k\u000e\u0011 \u0095\u0006Al¢D\u0093\u0099\u0013ÒkJ àõ$ÊÒ»\\nL¡\u0001j\u0015\u0091n¡ì]ÉZ^:\u0001\u00006ô\u0092HÕ\u0010\u009b¿.\u001ea\u0081\u0086g:;åm¯\u000bw±Â)ãÂUãèL\u0090]#\u0087ïº\tËñ; +NZ\"É2cHJ#Òü)ú\u009f\u00199u\u00973¯Øª\u0016\u000fB\u0096ÂÐ\u0016>\u0081\u0082\u0085\u009cfCéÁ\u0096/ Á\u008333[À\u0090ÿ\u009ak\"ÞÑ\u00adDB)¥9©Nï\u00ad«ÐeÎÒK>QåÝ{fx{ï\u0012þ\u0097û¤\u0084Ä#ûOøÌIL\u0002ðõ\u0005\u0016\u0012ÿe)9>\u008eFêÅ»!òwÁQª_*¦\'Ñè\u009d§\n¶\u00035iÞ;\u0098\u0097¿ÿ|©Ú>\u0012Cö\u000b")};
      field_592 = var0;
      byte[][] var1 = new byte[][]{method_555("0\u0082\u0002R0\u0082\u0001»\u0002\u0004I4\u0098~0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u00000p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown0\u001e\u0017\r081202020758Z\u0017\r360419020758Z0p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown0\u0081\u009f0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0081\u008d\u00000\u0081\u0089\u0002\u0081\u0081\u0000\u009fH\u0003\u0019\u0090ù±G&8N\u0004SÑ\u008f\u008c\u000b¿\u008dÇ{%\u0004¤± |LlDº¼\u0000\u00adÆa\u000f¦¶«-¨\u000e3òîñk&£ö¸[\u009aúÊ\u0090\u009fû¾³ôÉO~\u0081\"§\u0098àë§\\í=Ò)úseô\u0015\u0016AZ©Áa}Õ\u0083Î\u0019ºè »Ø\u0085ü\u0017©´½&@\u0080Q!ªÛ\u0093wÞ´\u0000\u00138\u0014\u0018\u0088.Å\"\u0082üX\r\u0002\u0003\u0001\u0000\u00010\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0081\u0081\u0000@\u0086f\u009eÖ1ÚC\u0084ÝÐaÒ&às¹\u008cÄ¹\u009døµä¾\u009e<¾\u0097P\u001e\u0083ß\u001co©YÀÎ`\\OÒ¬m\u001c\u0084ÎÞ Glº±\u009bèò :ÿw\u0017\u00ade-\u008fÌ\u0089\u0007\bÑ!m¨DWY&IàéÓÄ»Lõ\u008d¡\u009d±ÔüA¼¹XOdæ_A\r\u0005)ý[h\u0083\u008c\u0014\u001d\n\u009bÑÛ\u0011\u0091Ë*\r÷\u0090ê\f±-³¤"), method_555("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000\u0084~OòÖµÞ\u008e0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r100120010135Z\u0017\r370607010135Z0\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000Ø(q|6Ñ\u0017\u000fÔM\n{\u000f\u0007\u0011&è[¿ß3°4`\u0000Z\u0094Ìûe¥Û ²Cß`±\u0091¿\u009d\u0006ß\u001d\u008a\\\n3âÑcõ\u0013ß\u001d\"SAê<3y\"è\\\u0002ì4ÎÙL¸\u0007#¦#ÿK¯û´åïæw;>¢¾¸¼²\u0002gÏç\u0085Q\u001f\u0083.ù\u0087«u\u0094þ\u001e)Ï¼M\b:\u001f\u0012R\u0000ws\u0096ò\u0016[i{\u0000£ Á:Ì0\u008a\u0093ò!cÁn\u009c=J²\u0014\u009f6LEÀC\u00142p9ñÚ\t`\u0093ñ³ü\u0018¶V\u0010\u0095Æ\"_Ç\u0010+\u0098|o\u0013¤]$ãàÅN\u0085\u009dgã[g\b\'\u0013ÒÖðWÝ4WÑ\u009fÄþ\u008dÝì\u008c:O?\u0097#\u0005\u0019§\n(64¬5\u0081£J½¡}\u0084Z\n\t\u0085ûø\u0006\u000b\u0003j\'x`\u0081cú\f7¹çò¡\u000ev¼w\u0002\u0001\u0003£\u0081ü0\u0081ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u009b\u001770\u0081É\u0006\u0003U\u001d#\u0004\u0081Á0\u0081¾\u0080\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u009b\u00177¡\u0081\u009a¤\u0081\u00970\u0081\u00941\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*\u0086H\u0086÷\r\u0001\t\u0001\u0016\u0013android@android.com\u0082\t\u0000\u0084~OòÖµÞ\u008e0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000L>§e}&æ»×\u0011\f\u008f\u0019ß\u001f\u008d¡\t}3\u0086\u000fiÞ¿ÊÛF£~\u0087å³\u000f»4{\u001cuU¼»<\u0099T\u0014\u0080F\u0096_\u009cy*\u0002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\u0006.@nÎ\u0018\u0006\f`I\u008dü6\u009f\'\u0011q\u0098åoË¡Ræ\u0005\u008dÎ\u0094ÎY\u001fÄô©\u0098+3ºØ\u0019mwoU·Ð\u001aÏ1Ý×\fì·\u0089xv\u0006e\u0010ùI¥RJ11³ËeAÏ\u008b5B\u000e¼ÄR%Y\u0096?Bfi\u0005rfbO³\u0098ÏÛR\u0017\u0088\u001d\u0011\u001cn\u0003F\u0016øQ!\u0018Ð¢¦\u009d\u0013×\u0092ðÍ\u0011ÛÕ\u008e#\u0083ZT¥JÂQçÒ,Dj?î\u0014\u0012\u0010éDGK@c\u0007»&\u0084+OkÓU\u0082\u001cs\u0096Qÿ¢`[\u0005â$\u0095×\u0015Øz\u0091ö")};
      field_593 = var1;
      byte[][] var2 = new byte[][]{method_555("0\u0082\u0002§0\u0082\u0002e \u0003\u0002\u0001\u0002\u0002\u0004P\u0005|B0\u000b\u0006\u0007*\u0086HÎ8\u0004\u0003\u0005\u0000071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u001e\u0017\r120717145250Z\u0017\r220715145250Z071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u0082\u0001·0\u0082\u0001,\u0006\u0007*\u0086HÎ8\u0004\u00010\u0082\u0001\u001f\u0002\u0081\u0081\u0000ý\u007fS\u0081\u001du\u0012)RßJ\u009c.ìäçö\u0011·R<ïD\u0000Ã\u001e?\u0080¶Q&iE]@\"QûY=\u008dXú¿Åõº0öË\u009bUl×\u0081;\u0080\u001d4oòf`·k\u0099P¥¤\u009f\u009fè\u0004{\u0010\"ÂO»©×þ·Æ\u001bø;WçÆ¨¦\u0015\u000f\u0004û\u0083öÓÅ\u001eÃ\u00025T\u0013Z\u0016\u00912öuó®+a×*ïò\"\u0003\u0019\u009dÑH\u0001Ç\u0002\u0015\u0000\u0097`P\u008f\u0015#\u000bÌ²\u0092¹\u0082¢ë\u0084\u000bðX\u001cõ\u0002\u0081\u0081\u0000÷á \u0085Ö\u009b=ÞË¼«\\6¸W¹y\u0094¯»ú:ê\u0082ùWL\u000b=\u0007\u0082gQYW\u008eºÔYOæq\u0007\u0010\u0081\u0080´I\u0016q#èL(\u0016\u0013·Ï\t2\u008cÈ¦á<\u0016z\u008bT|\u008d(à£®\u001e+³¦u\u0091n£\u007f\u000bú!5bñûbz\u0001$;Ì¤ñ¾¨Q\u0090\u0089¨\u0083ßáZå\u009f\u0006\u0092\u008bf^\u0080{U%d\u0001L;þÏI*\u0003\u0081\u0084\u0000\u0002\u0081\u0080jÑ\u001b×ÕfÒzô9À.Ah¬ýE´¾\u0085¼\u0099\u008c{\u009b\u008e\u001cwTi?\u008c\rB\u008a¤üá\u0010\u0084\u00818BO¦\u008cÑ0RNïöñ78c\u0082/¦7)\u008bþMF ¸feîðA\u00179\u0001\u0003[\u001c\u0080j£\u0018\u0018\r0:¨Ì\u009eY#àjo«úuh<E;²\u0007w|òýçÏ±\u009b\u001408\u0014ª\u001d÷´=[\"+W\u0006´\u008b\u00940\u000b\u0006\u0007*\u0086HÎ8\u0004\u0003\u0005\u0000\u0003/\u00000,\u0002\u0014\tÒÑ°G\u0002)µ¾Ò\u0090&aÑ\u0012òpÅæ\u001d\u0002\u0014gP\u0002\u0006§\u0080Pºx®Ç\u0017O\u0016\u0004\u007f\u0084ê¢÷")};
      field_594 = var2;
      byte[][] var3 = new byte[][]{method_555("0\u0082\u0004L0\u0082\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000¨Í\u0017É=¥Ù\u00900\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010653Z\u0017\r380809010653Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000Ã\u000f\u0088\u00adÙ´\u0092\tj,XjZ\u009a\u00805kú\u0002iXøÿ\f]úõ\u009fI&\u008aØpÞè!¥>\u001f[\u0017\u000fÉbE£É\u0082§ËE\'\u0005;ã^4ó\u0096ÒK\"\u0091ì\fR\u008dn&\u0092teàhuêb\u001f\u007fù\u008c@ã4[ I\u0007Ì\u0093Tt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/\u008fàb\u001f\u0091\u008d\u001f5¨$\u0089%,o¦¶3\u0092§hk>Ha-\u0006©ÏoI¿ñ\u001d]\u0096(\u009c\u009dþ\u0014¬WbC\u0096\u0097Ý)êý¹\u0081\rã&5\u0013©\u0005¬\u008e\u008e¯ \u0090~Fu\nZ·¿\u009aw&/G°?Z<nm{Q4?iÇ÷%÷\u000bÌ\u001bJÕ\u0092%\u000bpZ\u0086æè>â®7þW\u0001¼½²oîýÿö\u000fj[ßµ¶G\u0093\u0002\u0001\u0003£\u0081Ü0\u0081Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\frà\u008cÉm0\u0081©\u0006\u0003U\u001d#\u0004\u0081¡0\u0081\u009e\u0080\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\frà\u008cÉm¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\u0082\t\u0000¨Í\u0017É=¥Ù\u00900\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u0000¤pÇ(áÓ\u001b\u0006Ù¯jçhµe\u0004lW\u0080k\u0098CrI1×]L¡\f2\u0015 Ó<Ïí*¦Tb#L\u009eù¶ù\u0010Ìgk\u0099Ë\u007f\u0098\u0095ÖÀgcWO»x3\u0012uÜ\\ó\u008fº©\u0018×\u0093\u008c\u0005\u001fû¢\u00adèó\u0003ÍèÙæ\u008a\u0004\u008d\u001fÛ\u009e|\u009f*I²\"Æ\u008fÿB+ñUi¸^îí°J£\bsÛæK\u009c\u009etøòÂöÄ\u0001$ª¨Ñx\r\u0018Q+T\nÝ(³éX\u0019q¤\u0017\rØhÏ_1äG\u0012²Â;µ\u00107×ï\u009f\u0087¦å½³^,ëk°\"cl\u0017¥j\u0096¼zP%\u008c\u000bÒí{1UZ\u0018E.\u00172\u001a\rR\u0083\u008c\u0082ö?t-tÿyXj\\»\u007f¯q\u0098¨KÏtC\u0010éé\'Y\u007f\u0000¢=Ð\u0006`\u0080\f\"8Ù\u000b/³rßÛºu½\u0085."), method_555("0\u0082\u0004L0\u0082\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000Þv\u0095\u0004\u001dvPÀ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010324Z\u0017\r380809010324Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0082\u0001 0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0082\u0001\r\u00000\u0082\u0001\b\u0002\u0082\u0001\u0001\u0000æÿ=ïé*¡\rqë\u000f¦@\u008bÀ6·âCîíh¦¤v=Ç¥*1u|ÚÆ\u001få\u0010»sÇ\u0016ä\u0000\u0001\u0004&[4\u007fÎÎôÄ+ñá7\u009dÐ¨vð(\"\u007f»Áù½Õ×\u0013²ö©5£yÒË©Éo\u0092ÒÐx|\u0011ñë\u0019T\u0080\b¦ r³K\u0091\u0083lú\ná\'g\u0080é\u0000u0\u0016i\u0086¡\u001c\u009cïFÎ÷Ç\u0004\u0080mÞ\u00941û`(M\u0012\n°çÞ\u001dc?\u0007h}F\u008cQ\u0013\u009aÿýÆ¼\u009a |©\u0004¸¾\u001d ª{N\u0097uoC`d\u0088¾\\®<hè»yBÍõ\u0016\u0007É0¢üÚe[uÐu\u009cº\u0089\u00ad\u0006ç9½\u000b¢\u009b\u001f@B\u0096ÂÀ¨Z\u0084\u007fZ°ÐgÆÃì\u009cI! B¬c§å;Tle´`\u0080´ãæ\u0080â>\u001fwÏçöÞtK\u001ae\u0002\u0001\u0003£\u0081Ü0\u0081Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014¢è\u0090d°]\b\u0086\\4Û\u0093\n\u009d\u0084\u0000P\u0011zì0\u0081©\u0006\u0003U\u001d#\u0004\u0081¡0\u0081\u009e\u0080\u0014¢è\u0090d°]\b\u0086\\4Û\u0093\n\u009d\u0084\u0000P\u0011zì¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\u0082\t\u0000Þv\u0095\u0004\u001dvPÀ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0082\u0001\u0001\u00007q\u0087\fè|<Rê\u0084\u0089\u00920ÆébÙKM_\u0012\u0093Â]\u0088&\u0015Aý\u0090µU]\u0012\u0085Îó¸1,?]ö\u0091¨ªàL¹\u0081³\u0005ä\'ý\u001d-\u009e\u0019\u0087áÒ\u0090xñ<\u0084R\u0099\u000f\u0018!\u0098\u0002cØÔ½6Q\u0093HØØº&Ø¹\u009f¿\tõý>»\u000e£ÂðÉ7o\u001e\u001fÊvó¦¤\u0005B\u009d\b\u001bu*z\u0090·Vé«DÚA«Èáèø\u008aÂu\u008d§CûsæPq\u009aW\u0084\fËkzÝ!¹\u009fÆ\u0081äVá\u0087,\"=\\\u0007JßUö«Ú&\u008c-\u008bdê\n\u0088EîÍ\u0096\u008f\u0092´\u0093\u0012~uÇSÃÿ0ËÆxµ\u001c\u009fR\u0096\u0014rñ}¢\n\rÆ\'J¢F44Á©¶\u0014ßi}\u008fõÊ\u0081\u0001ç¢\\}³û\u0005]eV\u009c\u0004°\u001d8\u009c«ºW³¡p>ÂçJ\u0088Ó4")};
      field_595 = var3;
      byte[][][] var4 = new byte[][][]{field_592, field_593, field_594, field_595};
      field_600 = method_556(var4);
      byte[][] var5 = new byte[][]{field_592[0], field_593[0], field_595[0]};
      field_601 = var5;
      byte[][] var6 = new byte[][]{method_555("0\u0082\u0002_0\u0082\u0001È \u0003\u0002\u0001\u0002\u0002\u0004K\u0019±\u009d0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Unknown1\u000f0\r\u0006\u0003U\u0004\u0003\u0013\u0006Bazaar0\u001e\u0017\r091205010429Z\u0017\r370422010429Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Unknown1\u000f0\r\u0006\u0003U\u0004\u0003\u0013\u0006Bazaar0\u0081\u009f0\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0081\u008d\u00000\u0081\u0089\u0002\u0081\u0081\u0000©\b\u0088Þ\u0096ã54w\tÝK%\u001ez)¨G7k.\\º[[Õ\u0004>\u0083\u0088\u0001\u0002\u0098\u0019\u0014\u0094\u0013ú3ªåD;\u0003SJÎJ\u00adoP\u0097\u0012IÙ\u008ev£\u009a~LÌá×\u001b§¾>ugMµñ\u0007Z\u0098sp\u0001FH§Îp<-Ç\u00884\u0089\u0005\u0092\u0012¯\u009cl[(«ÕO\u0083d\u0011È1¢\u009fP\u000f(\u0002ÑlæÑ\u0085o\u0086pªü¢eA\u0083{9\u0002\u0003\u0001\u0000\u00010\r\u0006\t*\u0086H\u0086÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0081\u0081\u0000I\u0084ÆóAG\u0001#b:\'Oéá7=u1Ì\rüé§jæ\u007fûp[@L½\u001bÁ\u0016\u008c«\u0018»\u0011Ãx\u0095¿´ólÁLì\u001d,ÅQj\u000eÎÔ\u0007Nµh\u0082\u0089Pd\u0000¯øÜÈïT\u0004\u0012\u0002ýïñý\u0082àó#\u0010rýÌÞJ6\u008bàÆÃù¸³ª\rh<:¿Ú\u009a·»\u00882é¾^6\u0019º\u0092Ý:Ì\u0003j\u00adµ¦\u0019¯P")};
      field_596 = var6;
      field_597 = false;
      field_598 = false;
      field_599 = false;
      field_602 = -1;
      field_603 = new Object();
   }

   // $FF: renamed from: a (android.content.Context) int
   public static int method_550(Context var0) {
      PackageManager var1 = var0.getPackageManager();

      try {
         var0.getResources().getString(class_80.class_99.field_126);
      } catch (Throwable var17) {
         Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      }

      if(System.currentTimeMillis() < 1227312000288L) {
         return 12;
      } else {
         method_559(var0);

         PackageInfo var6;
         try {
            var6 = var1.getPackageInfo("com.google.android.gms", 64);
         } catch (NameNotFoundException var16) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
         }

         PackageInfo var9;
         try {
            var9 = var1.getPackageInfo("com.android.vending", 64);
         } catch (NameNotFoundException var15) {
            Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
            return 9;
         }

         byte[] var10 = method_554(var9, field_592);
         if(var10 == null) {
            Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
            return 9;
         } else if(method_554(var6, new byte[][]{var10}) == null) {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
            return 9;
         } else if(var6.versionCode < 4323000) {
            Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 4323000 but found " + var6.versionCode);
            return 2;
         } else {
            ApplicationInfo var13;
            try {
               var13 = var1.getApplicationInfo("com.google.android.gms", 0);
            } catch (NameNotFoundException var14) {
               Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
               var14.printStackTrace();
               return 1;
            }

            return !var13.enabled?3:0;
         }
      }
   }

   // $FF: renamed from: a (android.content.Context, int, int) android.content.Intent
   public static Intent method_551(Context var0, int var1, int var2) {
      switch(var1) {
      case 1:
      case 2:
         if(method_553(var2)) {
            if(method_560(var0)) {
               return class_86.method_565("com.google.android.gms");
            }

            return class_86.method_564("com.google.android.apps.bazaar");
         }

         return class_86.method_564("com.google.android.gms");
      case 3:
         return class_86.method_563("com.google.android.gms");
      case 12:
         return class_86.method_562();
      default:
         return null;
      }
   }

   // $FF: renamed from: a () boolean
   public static boolean method_552() {
      return field_597?field_598:"user".equals(Build.TYPE);
   }

   // $FF: renamed from: a (int) boolean
   static boolean method_553(int var0) {
      boolean var1 = true;
      switch(method_557(var0)) {
      case 0:
         if(method_552()) {
            return false;
         }
      case 1:
         break;
      case 2:
         return false;
      default:
         var1 = false;
      }

      return var1;
   }

   // $FF: renamed from: a (android.content.pm.PackageInfo, byte[][]) byte[]
   private static byte[] method_554(PackageInfo var0, byte[]... var1) {
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
         ByteArrayInputStream var5 = new ByteArrayInputStream(var0.signatures[0].toByteArray());

         X509Certificate var8;
         try {
            var8 = (X509Certificate)var4.generateCertificate(var5);
         } catch (CertificateException var19) {
            Log.w("GooglePlayServicesUtil", "Could not generate certificate.");
            return null;
         }

         try {
            var8.checkValidity();
         } catch (CertificateExpiredException var17) {
            Log.w("GooglePlayServicesUtil", "Certificate has expired.");
            return null;
         } catch (CertificateNotYetValidException var18) {
            Log.w("GooglePlayServicesUtil", "Certificate is not yet valid.");
            return null;
         }

         byte[] var13 = var0.signatures[0].toByteArray();

         for(int var14 = 0; var14 < var1.length; ++var14) {
            byte[] var16 = var1[var14];
            if(Arrays.equals(var16, var13)) {
               return var16;
            }
         }

         if(Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(var13, 0));
         }

         return null;
      }
   }

   // $FF: renamed from: a (java.lang.String) byte[]
   private static byte[] method_555(String var0) {
      try {
         byte[] var2 = var0.getBytes("ISO-8859-1");
         return var2;
      } catch (UnsupportedEncodingException var3) {
         throw new AssertionError(var3);
      }
   }

   // $FF: renamed from: a (byte[][][]) byte[][]
   private static byte[][] method_556(byte[][]... var0) {
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

   // $FF: renamed from: b (int) int
   private static int method_557(int var0) {
      if(var0 == -1) {
         var0 = 2;
      }

      return var0;
   }

   // $FF: renamed from: b (android.content.Context) void
   public static void method_558(Context var0) throws class_83, class_78 {
      int var1 = method_550(var0);
      if(var1 != 0) {
         Intent var2 = method_551(var0, var1, -1);
         Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + var1);
         if(var2 == null) {
            throw new class_78(var1);
         } else {
            throw new class_83(var1, "Google Play Services not available", var2);
         }
      }
   }

   // $FF: renamed from: c (android.content.Context) void
   private static void method_559(Context var0) {
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
         if(var5 != 4323000) {
            throw new IllegalStateException("The meta-data tag in your app\'s AndroidManifest.xml does not have the right value.  Expected 4323000 but found " + var5 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
         }
      } else {
         throw new IllegalStateException("A required meta-data tag in your app\'s AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
   }

   // $FF: renamed from: d (android.content.Context) boolean
   private static boolean method_560(Context var0) {
      boolean var3;
      if(field_597) {
         var3 = field_599;
      } else {
         byte[] var2;
         try {
            var2 = method_554(var0.getPackageManager().getPackageInfo("com.google.android.apps.bazaar", 64), field_596);
         } catch (NameNotFoundException var4) {
            return false;
         }

         var3 = false;
         if(var2 != null) {
            return true;
         }
      }

      return var3;
   }
}
