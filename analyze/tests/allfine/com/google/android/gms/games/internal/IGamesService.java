package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public interface IGamesService extends IInterface {
    // $FF: renamed from: N (boolean) void
    void method_441(boolean var1) throws RemoteException;

    // $FF: renamed from: O (boolean) void
    void method_442(boolean var1) throws RemoteException;

    // $FF: renamed from: P (boolean) void
    void method_443(boolean var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, byte[], java.lang.String, java.lang.String) int
    int method_444(IGamesCallbacks var1, byte[] var2, String var3, String var4) throws RemoteException;

    // $FF: renamed from: a (int, int, boolean) android.content.Intent
    Intent method_445(int var1, int var2, boolean var3) throws RemoteException;

    // $FF: renamed from: a (int, byte[], int, java.lang.String) android.content.Intent
    Intent method_446(int var1, byte[] var2, int var3, String var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.achievement.AchievementEntity) android.content.Intent
    Intent method_447(AchievementEntity var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, java.lang.String, java.lang.String) android.content.Intent
    Intent method_448(ZInvitationCluster var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, java.lang.String) android.content.Intent
    Intent method_449(GameRequestCluster var1, String var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, int) android.content.Intent
    Intent method_450(RoomEntity var1, int var2) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
    Intent method_451(String var1, boolean var2, boolean var3, int var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri) android.content.Intent
    Intent method_452(ParticipantEntity[] var1, String var2, String var3, Uri var4, Uri var5) throws RemoteException;

    // $FF: renamed from: a (long, java.lang.String) void
    void method_453(long var1, String var3) throws RemoteException;

    // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
    void method_454(IBinder var1, Bundle var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.drive.Contents) void
    void method_455(Contents var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_456(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int) void
    void method_457(IGamesCallbacks var1, int var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, int) void
    void method_458(IGamesCallbacks var1, int var2, int var3, int var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, boolean, boolean) void
    void method_459(IGamesCallbacks var1, int var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, java.lang.String[], android.os.Bundle) void
    void method_460(IGamesCallbacks var1, int var2, int var3, String[] var4, Bundle var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
    void method_461(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int[]) void
    void method_462(IGamesCallbacks var1, int var2, int[] var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long) void
    void method_463(IGamesCallbacks var1, long var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
    void method_464(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.Bundle, int, int) void
    void method_465(IGamesCallbacks var1, Bundle var2, int var3, int var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, int, java.lang.String[], android.os.Bundle, boolean, long) void
    void method_466(IGamesCallbacks var1, IBinder var2, int var3, String[] var4, Bundle var5, boolean var6, long var7) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, java.lang.String, boolean, long) void
    void method_467(IGamesCallbacks var1, IBinder var2, String var3, boolean var4, long var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_468(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
    void method_469(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
    void method_470(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
    void method_471(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
    void method_472(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
    void method_473(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean, boolean, boolean) void
    void method_474(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int[]) void
    void method_475(IGamesCallbacks var1, String var2, int var3, int[] var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long) void
    void method_476(IGamesCallbacks var1, String var2, long var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long, java.lang.String) void
    void method_477(IGamesCallbacks var1, String var2, long var3, String var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
    void method_478(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
    void method_479(IGamesCallbacks var1, String var2, SnapshotMetadataChange var3, Contents var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
    void method_480(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int) void
    void method_481(IGamesCallbacks var1, String var2, String var3, int var4, int var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int) void
    void method_482(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
    void method_483(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
    void method_484(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
    void method_485(IGamesCallbacks var1, String var2, String var3, SnapshotMetadataChange var4, Contents var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
    void method_486(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int[], int, boolean) void
    void method_487(IGamesCallbacks var1, String var2, String var3, int[] var4, int var5, boolean var6) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
    void method_488(IGamesCallbacks var1, String var2, String var3, String[] var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[], boolean) void
    void method_489(IGamesCallbacks var1, String var2, String var3, String[] var4, boolean var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
    void method_490(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
    void method_491(IGamesCallbacks var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
    void method_492(IGamesCallbacks var1, String var2, byte[] var3, ParticipantResult[] var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int[]) void
    void method_493(IGamesCallbacks var1, String var2, int[] var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String[], int, byte[], int) void
    void method_494(IGamesCallbacks var1, String var2, String[] var3, int var4, byte[] var5, int var6) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_495(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, android.os.Bundle) void
    void method_496(IGamesCallbacks var1, boolean var2, Bundle var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, java.lang.String[]) void
    void method_497(IGamesCallbacks var1, boolean var2, String[] var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[]) void
    void method_498(IGamesCallbacks var1, int[] var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[], int, boolean) void
    void method_499(IGamesCallbacks var1, int[] var2, int var3, boolean var4) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
    void method_500(IGamesCallbacks var1, String[] var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[], boolean) void
    void method_501(IGamesCallbacks var1, String[] var2, boolean var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, android.os.IBinder, android.os.Bundle) void
    void method_502(String var1, IBinder var2, Bundle var3) throws RemoteException;

    // $FF: renamed from: b (byte[], java.lang.String, java.lang.String[]) int
    int method_503(byte[] var1, String var2, String[] var3) throws RemoteException;

    // $FF: renamed from: b (int, int, boolean) android.content.Intent
    Intent method_504(int var1, int var2, boolean var3) throws RemoteException;

    // $FF: renamed from: b (int[]) android.content.Intent
    Intent method_505(int[] var1) throws RemoteException;

    // $FF: renamed from: b (long, java.lang.String) void
    void method_506(long var1, String var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_507(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
    void method_508(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long) void
    void method_509(IGamesCallbacks var1, long var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
    void method_510(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_511(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
    void method_512(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
    void method_513(IGamesCallbacks var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
    void method_514(IGamesCallbacks var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
    void method_515(IGamesCallbacks var1, String var2, int var3, boolean var4) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
    void method_516(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
    void method_517(IGamesCallbacks var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
    void method_518(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
    void method_519(IGamesCallbacks var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
    void method_520(IGamesCallbacks var1, String var2, String var3, int var4, boolean var5, boolean var6) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
    void method_521(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
    void method_522(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_523(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
    void method_524(IGamesCallbacks var1, String[] var2) throws RemoteException;

    // $FF: renamed from: b (java.lang.String, java.lang.String, int) void
    void method_525(String var1, String var2, int var3) throws RemoteException;

    // $FF: renamed from: bC (java.lang.String) android.content.Intent
    Intent method_526(String var1) throws RemoteException;

    // $FF: renamed from: bE (java.lang.String) java.lang.String
    String method_527(String var1) throws RemoteException;

    // $FF: renamed from: bF (java.lang.String) java.lang.String
    String method_528(String var1) throws RemoteException;

    // $FF: renamed from: bG (java.lang.String) void
    void method_529(String var1) throws RemoteException;

    // $FF: renamed from: bH (java.lang.String) int
    int method_530(String var1) throws RemoteException;

    // $FF: renamed from: bI (java.lang.String) android.net.Uri
    Uri method_531(String var1) throws RemoteException;

    // $FF: renamed from: bJ (java.lang.String) void
    void method_532(String var1) throws RemoteException;

    // $FF: renamed from: bK (java.lang.String) android.os.ParcelFileDescriptor
    ParcelFileDescriptor method_533(String var1) throws RemoteException;

    // $FF: renamed from: bx (java.lang.String) android.content.Intent
    Intent method_534(String var1) throws RemoteException;

    // $FF: renamed from: c (long, java.lang.String) void
    void method_535(long var1, String var3) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_536(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
    void method_537(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long) void
    void method_538(IGamesCallbacks var1, long var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
    void method_539(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_540(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
    void method_541(IGamesCallbacks var1, String var2, int var3) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
    void method_542(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
    void method_543(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
    void method_544(IGamesCallbacks var1, String var2, String var3, boolean var4) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
    void method_545(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_546(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
    void method_547(IGamesCallbacks var1, String[] var2) throws RemoteException;

    // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
    void method_548(String var1, String var2, int var3) throws RemoteException;

    // $FF: renamed from: d (long, java.lang.String) void
    void method_549(long var1, String var3) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_550(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
    void method_551(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long) void
    void method_552(IGamesCallbacks var1, long var2) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
    void method_553(IGamesCallbacks var1, long var2, String var4) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_554(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
    void method_555(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
    void method_556(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
    void method_557(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_558(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: dC (int) void
    void method_559(int var1) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_560(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
    void method_561(IGamesCallbacks var1, int var2, boolean var3, boolean var4) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_562(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
    void method_563(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
    void method_564(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
    void method_565(IGamesCallbacks var1, String var2, boolean var3) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_566(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_567(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_568(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
    void method_569(IGamesCallbacks var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
    void method_570(IGamesCallbacks var1, String var2, String var3) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_571(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: fC () android.os.Bundle
    Bundle method_572() throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_573(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_574(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_575(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: h (android.net.Uri) android.os.ParcelFileDescriptor
    ParcelFileDescriptor method_576(Uri var1) throws RemoteException;

    // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RoomEntity
    RoomEntity method_577(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_578(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
    void method_579(IGamesCallbacks var1, boolean var2) throws RemoteException;

    // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_580(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_581(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks) void
    void method_582(IGamesCallbacks var1) throws RemoteException;

    // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_583(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: k (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_584(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: kA () boolean
    boolean method_585() throws RemoteException;

    // $FF: renamed from: kB () com.google.android.gms.common.data.DataHolder
    DataHolder method_586() throws RemoteException;

    // $FF: renamed from: kC () void
    void method_587() throws RemoteException;

    // $FF: renamed from: kD () android.content.Intent
    Intent method_588() throws RemoteException;

    // $FF: renamed from: kE () void
    void method_589() throws RemoteException;

    // $FF: renamed from: kF () boolean
    boolean method_590() throws RemoteException;

    // $FF: renamed from: ka () java.lang.String
    String method_591() throws RemoteException;

    // $FF: renamed from: kb () java.lang.String
    String method_592() throws RemoteException;

    // $FF: renamed from: ke () android.content.Intent
    Intent method_593() throws RemoteException;

    // $FF: renamed from: kf () android.content.Intent
    Intent method_594() throws RemoteException;

    // $FF: renamed from: kg () android.content.Intent
    Intent method_595() throws RemoteException;

    // $FF: renamed from: kh () android.content.Intent
    Intent method_596() throws RemoteException;

    // $FF: renamed from: km () android.content.Intent
    Intent method_597() throws RemoteException;

    // $FF: renamed from: kn () android.content.Intent
    Intent method_598() throws RemoteException;

    // $FF: renamed from: ko () int
    int method_599() throws RemoteException;

    // $FF: renamed from: kp () java.lang.String
    String method_600() throws RemoteException;

    // $FF: renamed from: kq () int
    int method_601() throws RemoteException;

    // $FF: renamed from: kr () android.content.Intent
    Intent method_602() throws RemoteException;

    // $FF: renamed from: ks () int
    int method_603() throws RemoteException;

    // $FF: renamed from: kt () int
    int method_604() throws RemoteException;

    // $FF: renamed from: ku () int
    int method_605() throws RemoteException;

    // $FF: renamed from: kv () int
    int method_606() throws RemoteException;

    // $FF: renamed from: kx () void
    void method_607() throws RemoteException;

    // $FF: renamed from: kz () com.google.android.gms.common.data.DataHolder
    DataHolder method_608() throws RemoteException;

    // $FF: renamed from: l (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_609(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: m (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_610(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: n (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_611(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: n (java.lang.String, int) void
    void method_612(String var1, int var2) throws RemoteException;

    // $FF: renamed from: o (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_613(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: o (java.lang.String, int) void
    void method_614(String var1, int var2) throws RemoteException;

    // $FF: renamed from: p (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_615(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: p (java.lang.String, int) void
    void method_616(String var1, int var2) throws RemoteException;

    // $FF: renamed from: q (long) void
    void method_617(long var1) throws RemoteException;

    // $FF: renamed from: q (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_618(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: r (long) void
    void method_619(long var1) throws RemoteException;

    // $FF: renamed from: r (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_620(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: r (java.lang.String, int) void
    void method_621(String var1, int var2) throws RemoteException;

    // $FF: renamed from: s (long) void
    void method_622(long var1) throws RemoteException;

    // $FF: renamed from: s (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_623(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: s (java.lang.String, int) void
    void method_624(String var1, int var2) throws RemoteException;

    // $FF: renamed from: t (long) void
    void method_625(long var1) throws RemoteException;

    // $FF: renamed from: t (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_626(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: u (long) void
    void method_627(long var1) throws RemoteException;

    // $FF: renamed from: u (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
    void method_628(IGamesCallbacks var1, String var2) throws RemoteException;

    // $FF: renamed from: u (java.lang.String, java.lang.String) void
    void method_629(String var1, String var2) throws RemoteException;

    // $FF: renamed from: v (java.lang.String, java.lang.String) void
    void method_630(String var1, String var2) throws RemoteException;

    public abstract static class Stub extends Binder implements IGamesService {
        public Stub() {
            this.attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        // $FF: renamed from: aB (android.os.IBinder) com.google.android.gms.games.internal.IGamesService
        public static IGamesService method_5204(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
                return (IGamesService)(var1 != null && var1 instanceof IGamesService?(IGamesService)var1:new IGamesService.Proxy(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 5001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.q(var2.readLong());
                    var3.writeNoException();
                    return true;
                case 5002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var337 = this.kp();
                    var3.writeNoException();
                    var3.writeString(var337);
                    return true;
                case 5004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Bundle var336 = this.fC();
                    var3.writeNoException();
                    if(var336 != null) {
                        var3.writeInt(1);
                        var336.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 5005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IBinder var334 = var2.readStrongBinder();
                    Bundle var335;
                    if(var2.readInt() != 0) {
                        var335 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var335 = null;
                    }

                    this.a(var334, var335);
                    var3.writeNoException();
                    return true;
                case 5006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.kx();
                    var3.writeNoException();
                    return true;
                case 5007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var333 = this.ka();
                    var3.writeNoException();
                    var3.writeString(var333);
                    return true;
                case 5012:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var331 = this.kb();
                    var3.writeNoException();
                    var3.writeString(var331);
                    return true;
                case 5013:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    DataHolder var330 = this.kz();
                    var3.writeNoException();
                    if(var330 != null) {
                        var3.writeInt(1);
                        var330.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 5014:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5015:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var325 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var326 = var2.readInt();
                    boolean var327;
                    if(var2.readInt() != 0) {
                        var327 = true;
                    } else {
                        var327 = false;
                    }

                    int var328 = var2.readInt();
                    boolean var329 = false;
                    if(var328 != 0) {
                        var329 = true;
                    }

                    this.a(var325, var326, var327, var329);
                    var3.writeNoException();
                    return true;
                case 5016:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readLong());
                    var3.writeNoException();
                    return true;
                case 5017:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5018:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5019:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var319 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var320 = var2.readString();
                    int var321 = var2.readInt();
                    int var322 = var2.readInt();
                    int var323 = var2.readInt();
                    boolean var324;
                    if(var2.readInt() != 0) {
                        var324 = true;
                    } else {
                        var324 = false;
                    }

                    this.a(var319, var320, var321, var322, var323, var324);
                    var3.writeNoException();
                    return true;
                case 5020:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var313 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var314 = var2.readString();
                    int var315 = var2.readInt();
                    int var316 = var2.readInt();
                    int var317 = var2.readInt();
                    boolean var318;
                    if(var2.readInt() != 0) {
                        var318 = true;
                    } else {
                        var318 = false;
                    }

                    this.b(var313, var314, var315, var316, var317, var318);
                    var3.writeNoException();
                    return true;
                case 5021:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var311 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    Bundle var312;
                    if(var2.readInt() != 0) {
                        var312 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var312 = null;
                    }

                    this.a(var311, var312, var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5022:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5023:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var307 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var308 = var2.readString();
                    IBinder var309 = var2.readStrongBinder();
                    Bundle var310;
                    if(var2.readInt() != 0) {
                        var310 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var310 = null;
                    }

                    this.a(var307, var308, var309, var310);
                    var3.writeNoException();
                    return true;
                case 5024:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var303 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var304 = var2.readString();
                    IBinder var305 = var2.readStrongBinder();
                    Bundle var306;
                    if(var2.readInt() != 0) {
                        var306 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var306 = null;
                    }

                    this.b(var303, var304, var305, var306);
                    var3.writeNoException();
                    return true;
                case 5025:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var297 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var298 = var2.readString();
                    int var299 = var2.readInt();
                    IBinder var300 = var2.readStrongBinder();
                    int var301 = var2.readInt();
                    Bundle var302 = null;
                    if(var301 != 0) {
                        var302 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    this.a(var297, var298, var299, var300, var302);
                    var3.writeNoException();
                    return true;
                case 5026:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5027:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.e(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5028:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.p(var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5029:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.o(var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5030:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var290 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    IBinder var291 = var2.readStrongBinder();
                    int var292 = var2.readInt();
                    String[] var293 = var2.createStringArray();
                    int var294 = var2.readInt();
                    Bundle var295 = null;
                    if(var294 != 0) {
                        var295 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    boolean var296;
                    if(var2.readInt() != 0) {
                        var296 = true;
                    } else {
                        var296 = false;
                    }

                    this.a(var290, var291, var292, var293, var295, var296, var2.readLong());
                    var3.writeNoException();
                    return true;
                case 5031:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var286 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    IBinder var287 = var2.readStrongBinder();
                    String var288 = var2.readString();
                    boolean var289;
                    if(var2.readInt() != 0) {
                        var289 = true;
                    } else {
                        var289 = false;
                    }

                    this.a(var286, var287, var288, var289, var2.readLong());
                    var3.writeNoException();
                    return true;
                case 5032:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5033:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var285 = this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.createByteArray(), var2.readString(), var2.readString());
                    var3.writeNoException();
                    var3.writeInt(var285);
                    return true;
                case 5034:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var284 = this.b(var2.createByteArray(), var2.readString(), var2.createStringArray());
                    var3.writeNoException();
                    var3.writeInt(var284);
                    return true;
                case 5035:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var283 = this.bF(var2.readString());
                    var3.writeNoException();
                    var3.writeString(var283);
                    return true;
                case 5036:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.dC(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5037:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5038:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5039:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var275 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var276 = var2.readString();
                    String var277 = var2.readString();
                    int var278 = var2.readInt();
                    int var279 = var2.readInt();
                    int var280 = var2.readInt();
                    int var281 = var2.readInt();
                    boolean var282 = false;
                    if(var281 != 0) {
                        var282 = true;
                    }

                    this.a(var275, var276, var277, var278, var279, var280, var282);
                    var3.writeNoException();
                    return true;
                case 5040:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var267 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var268 = var2.readString();
                    String var269 = var2.readString();
                    int var270 = var2.readInt();
                    int var271 = var2.readInt();
                    int var272 = var2.readInt();
                    int var273 = var2.readInt();
                    boolean var274 = false;
                    if(var273 != 0) {
                        var274 = true;
                    }

                    this.b(var267, var268, var269, var270, var271, var272, var274);
                    var3.writeNoException();
                    return true;
                case 5041:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5042:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.e(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5043:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5044:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var262 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var263 = var2.readInt();
                    int var264 = var2.readInt();
                    boolean var265;
                    if(var2.readInt() != 0) {
                        var265 = true;
                    } else {
                        var265 = false;
                    }

                    boolean var266;
                    if(var2.readInt() != 0) {
                        var266 = true;
                    } else {
                        var266 = false;
                    }

                    this.a(var262, var263, var264, var265, var266);
                    var3.writeNoException();
                    return true;
                case 5045:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var257 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var258 = var2.readString();
                    int var259 = var2.readInt();
                    boolean var260;
                    if(var2.readInt() != 0) {
                        var260 = true;
                    } else {
                        var260 = false;
                    }

                    boolean var261;
                    if(var2.readInt() != 0) {
                        var261 = true;
                    } else {
                        var261 = false;
                    }

                    this.a(var257, var258, var259, var260, var261);
                    var3.writeNoException();
                    return true;
                case 5046:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var252 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var253 = var2.readInt();
                    boolean var254;
                    if(var2.readInt() != 0) {
                        var254 = true;
                    } else {
                        var254 = false;
                    }

                    int var255 = var2.readInt();
                    boolean var256 = false;
                    if(var255 != 0) {
                        var256 = true;
                    }

                    this.b(var252, var253, var254, var256);
                    var3.writeNoException();
                    return true;
                case 5047:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5048:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var247 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var248 = var2.readInt();
                    boolean var249;
                    if(var2.readInt() != 0) {
                        var249 = true;
                    } else {
                        var249 = false;
                    }

                    int var250 = var2.readInt();
                    boolean var251 = false;
                    if(var250 != 0) {
                        var251 = true;
                    }

                    this.c(var247, var248, var249, var251);
                    var3.writeNoException();
                    return true;
                case 5049:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.g(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5050:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.bG(var2.readString());
                    var3.writeNoException();
                    return true;
                case 5051:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(var2.readString(), var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5052:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.g(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5053:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity var246 = this.h(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    if(var246 != null) {
                        var3.writeInt(1);
                        var246.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 5054:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var241 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var242 = var2.readString();
                    int var243 = var2.readInt();
                    boolean var244 = false;
                    if(var243 != 0) {
                        var244 = true;
                    }

                    this.a(var241, var242, var244);
                    var3.writeNoException();
                    return true;
                case 5055:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.r(var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 5056:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.h(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5057:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.j(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5058:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong());
                    var3.writeNoException();
                    return true;
                case 5059:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.r(var2.readLong());
                    var3.writeNoException();
                    return true;
                case 5060:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var245 = this.bH(var2.readString());
                    var3.writeNoException();
                    var3.writeInt(var245);
                    return true;
                case 5061:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.i(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5062:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.i(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5063:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var233 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var234 = var2.readInt();
                    boolean var235 = false;
                    if(var234 != 0) {
                        var235 = true;
                    }

                    Bundle var236;
                    if(var2.readInt() != 0) {
                        var236 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var236 = null;
                    }

                    this.a(var233, var235, var236);
                    var3.writeNoException();
                    return true;
                case 5064:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var332 = this.bE(var2.readString());
                    var3.writeNoException();
                    var3.writeString(var332);
                    return true;
                case 5065:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.u(var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 5066:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri var232 = this.bI(var2.readString());
                    var3.writeNoException();
                    if(var232 != null) {
                        var3.writeInt(1);
                        var232.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 5067:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    boolean var239 = this.kA();
                    var3.writeNoException();
                    byte var240 = 0;
                    if(var239) {
                        var240 = 1;
                    }

                    var3.writeInt(var240);
                    return true;
                case 5068:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var237 = var2.readInt();
                    boolean var238 = false;
                    if(var237 != 0) {
                        var238 = true;
                    }

                    this.N(var238);
                    var3.writeNoException();
                    return true;
                case 5501:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var227 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var228 = var2.readString();
                    int var229 = var2.readInt();
                    boolean var230;
                    if(var2.readInt() != 0) {
                        var230 = true;
                    } else {
                        var230 = false;
                    }

                    boolean var231;
                    if(var2.readInt() != 0) {
                        var231 = true;
                    } else {
                        var231 = false;
                    }

                    this.b(var227, var228, var229, var230, var231);
                    var3.writeNoException();
                    return true;
                case 5502:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    DataHolder var226 = this.kB();
                    var3.writeNoException();
                    if(var226 != null) {
                        var3.writeInt(1);
                        var226.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 6001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var223 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var224 = var2.readInt();
                    boolean var225 = false;
                    if(var224 != 0) {
                        var225 = true;
                    }

                    this.a(var223, var225);
                    var3.writeNoException();
                    return true;
                case 6002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var218 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var219 = var2.readString();
                    String var220 = var2.readString();
                    int var221 = var2.readInt();
                    boolean var222 = false;
                    if(var221 != 0) {
                        var222 = true;
                    }

                    this.a(var218, var219, var220, var222);
                    var3.writeNoException();
                    return true;
                case 6003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var213 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var214 = var2.readInt();
                    boolean var215;
                    if(var2.readInt() != 0) {
                        var215 = true;
                    } else {
                        var215 = false;
                    }

                    int var216 = var2.readInt();
                    boolean var217 = false;
                    if(var216 != 0) {
                        var217 = true;
                    }

                    this.d(var213, var214, var215, var217);
                    var3.writeNoException();
                    return true;
                case 6004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var208 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var209 = var2.readInt();
                    boolean var210;
                    if(var2.readInt() != 0) {
                        var210 = true;
                    } else {
                        var210 = false;
                    }

                    int var211 = var2.readInt();
                    boolean var212 = false;
                    if(var211 != 0) {
                        var212 = true;
                    }

                    this.e(var208, var209, var210, var212);
                    var3.writeNoException();
                    return true;
                case 6501:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var200 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var201 = var2.readString();
                    int var202 = var2.readInt();
                    boolean var203;
                    if(var2.readInt() != 0) {
                        var203 = true;
                    } else {
                        var203 = false;
                    }

                    boolean var204;
                    if(var2.readInt() != 0) {
                        var204 = true;
                    } else {
                        var204 = false;
                    }

                    boolean var205;
                    if(var2.readInt() != 0) {
                        var205 = true;
                    } else {
                        var205 = false;
                    }

                    int var206 = var2.readInt();
                    boolean var207 = false;
                    if(var206 != 0) {
                        var207 = true;
                    }

                    this.a(var200, var201, var202, var203, var204, var205, var207);
                    var3.writeNoException();
                    return true;
                case 6502:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var196 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var197 = var2.readString();
                    int var198 = var2.readInt();
                    boolean var199 = false;
                    if(var198 != 0) {
                        var199 = true;
                    }

                    this.b(var196, var197, var199);
                    var3.writeNoException();
                    return true;
                case 6503:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var193 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var194 = var2.readInt();
                    boolean var195 = false;
                    if(var194 != 0) {
                        var195 = true;
                    }

                    this.b(var193, var195);
                    var3.writeNoException();
                    return true;
                case 6504:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var189 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var190 = var2.readString();
                    int var191 = var2.readInt();
                    boolean var192 = false;
                    if(var191 != 0) {
                        var192 = true;
                    }

                    this.c(var189, var190, var192);
                    var3.writeNoException();
                    return true;
                case 6505:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var185 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var186 = var2.readString();
                    int var187 = var2.readInt();
                    boolean var188 = false;
                    if(var187 != 0) {
                        var188 = true;
                    }

                    this.d(var185, var186, var188);
                    var3.writeNoException();
                    return true;
                case 6506:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var180 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var181 = var2.readString();
                    String var182 = var2.readString();
                    int var183 = var2.readInt();
                    boolean var184 = false;
                    if(var183 != 0) {
                        var184 = true;
                    }

                    this.b(var180, var181, var182, var184);
                    var3.writeNoException();
                    return true;
                case 6507:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri var178;
                    if(var2.readInt() != 0) {
                        var178 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    } else {
                        var178 = null;
                    }

                    ParcelFileDescriptor var179 = this.h(var178);
                    var3.writeNoException();
                    if(var179 != null) {
                        var3.writeInt(1);
                        var179.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 7001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.k(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 7002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 7003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var172 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var173 = var2.readString();
                    int var174 = var2.readInt();
                    IBinder var175 = var2.readStrongBinder();
                    int var176 = var2.readInt();
                    Bundle var177 = null;
                    if(var176 != 0) {
                        var177 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    this.b(var172, var173, var174, var175, var177);
                    var3.writeNoException();
                    return true;
                case 8001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 8002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.bJ(var2.readString());
                    var3.writeNoException();
                    return true;
                case 8003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.createIntArray());
                    var3.writeNoException();
                    return true;
                case 8004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var166 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var167 = var2.readInt();
                    int var168 = var2.readInt();
                    String[] var169 = var2.createStringArray();
                    int var170 = var2.readInt();
                    Bundle var171 = null;
                    if(var170 != 0) {
                        var171 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    this.a(var166, var167, var168, var169, var171);
                    var3.writeNoException();
                    return true;
                case 8005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.l(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.m(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), var2.readString(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
                    var3.writeNoException();
                    return true;
                case 8008:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.createByteArray(), (ParticipantResult[])var2.createTypedArray(ParticipantResult.CREATOR));
                    var3.writeNoException();
                    return true;
                case 8009:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.n(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8010:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.o(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8011:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8012:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong());
                    var3.writeNoException();
                    return true;
                case 8013:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.s(var2.readLong());
                    var3.writeNoException();
                    return true;
                case 8014:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.p(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8015:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8016:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.e(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8017:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.createIntArray());
                    var3.writeNoException();
                    return true;
                case 8018:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8019:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8020:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8021:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8022:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.kC();
                    var3.writeNoException();
                    return true;
                case 8023:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var160 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var161 = var2.readString();
                    int var162 = var2.readInt();
                    int var163 = var2.readInt();
                    boolean var164 = false;
                    if(var163 != 0) {
                        var164 = true;
                    }

                    this.a(var160, var161, var162, var164);
                    var3.writeNoException();
                    return true;
                case 8024:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var165 = this.kq();
                    var3.writeNoException();
                    var3.writeInt(var165);
                    return true;
                case 8025:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.v(var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 8026:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(var2.readString(), var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 8027:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var157 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var158 = var2.readInt();
                    boolean var159 = false;
                    if(var158 != 0) {
                        var159 = true;
                    }

                    this.c(var157, var159);
                    var3.writeNoException();
                    return true;
                case 9001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var152 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var153 = var2.readString();
                    int var154 = var2.readInt();
                    boolean var155;
                    if(var2.readInt() != 0) {
                        var155 = true;
                    } else {
                        var155 = false;
                    }

                    boolean var156;
                    if(var2.readInt() != 0) {
                        var156 = true;
                    } else {
                        var156 = false;
                    }

                    this.c(var152, var153, var154, var155, var156);
                    var3.writeNoException();
                    return true;
                case 9002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.q(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 9003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var151 = this.ke();
                    var3.writeNoException();
                    if(var151 != null) {
                        var3.writeInt(1);
                        var151.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var150 = this.bx(var2.readString());
                    var3.writeNoException();
                    if(var150 != null) {
                        var3.writeInt(1);
                        var150.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var149 = this.kf();
                    var3.writeNoException();
                    if(var149 != null) {
                        var3.writeInt(1);
                        var149.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var148 = this.kg();
                    var3.writeNoException();
                    if(var148 != null) {
                        var3.writeInt(1);
                        var148.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var147 = this.kh();
                    var3.writeNoException();
                    if(var147 != null) {
                        var3.writeInt(1);
                        var147.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9008:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var143 = var2.readInt();
                    int var144 = var2.readInt();
                    boolean var145;
                    if(var2.readInt() != 0) {
                        var145 = true;
                    } else {
                        var145 = false;
                    }

                    Intent var146 = this.a(var143, var144, var145);
                    var3.writeNoException();
                    if(var146 != null) {
                        var3.writeInt(1);
                        var146.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9009:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var139 = var2.readInt();
                    int var140 = var2.readInt();
                    boolean var141;
                    if(var2.readInt() != 0) {
                        var141 = true;
                    } else {
                        var141 = false;
                    }

                    Intent var142 = this.b(var139, var140, var141);
                    var3.writeNoException();
                    if(var142 != null) {
                        var3.writeInt(1);
                        var142.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9010:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var138 = this.km();
                    var3.writeNoException();
                    if(var138 != null) {
                        var3.writeInt(1);
                        var138.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9011:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity var136;
                    if(var2.readInt() != 0) {
                        var136 = (RoomEntity)RoomEntity.CREATOR.createFromParcel(var2);
                    } else {
                        var136 = null;
                    }

                    Intent var137 = this.a(var136, var2.readInt());
                    var3.writeNoException();
                    if(var137 != null) {
                        var3.writeInt(1);
                        var137.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9012:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var135 = this.kn();
                    var3.writeNoException();
                    if(var135 != null) {
                        var3.writeInt(1);
                        var135.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9013:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var134 = this.kD();
                    var3.writeNoException();
                    if(var134 != null) {
                        var3.writeInt(1);
                        var134.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9019:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var126 = this.ko();
                    var3.writeNoException();
                    var3.writeInt(var126);
                    return true;
                case 9020:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var121 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var122 = var2.readString();
                    int var123 = var2.readInt();
                    boolean var124;
                    if(var2.readInt() != 0) {
                        var124 = true;
                    } else {
                        var124 = false;
                    }

                    boolean var125;
                    if(var2.readInt() != 0) {
                        var125 = true;
                    } else {
                        var125 = false;
                    }

                    this.d(var121, var122, var123, var124, var125);
                    var3.writeNoException();
                    return true;
                case 9028:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var115 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var116 = var2.readString();
                    String var117 = var2.readString();
                    int var118 = var2.readInt();
                    boolean var119;
                    if(var2.readInt() != 0) {
                        var119 = true;
                    } else {
                        var119 = false;
                    }

                    boolean var120;
                    if(var2.readInt() != 0) {
                        var120 = true;
                    } else {
                        var120 = false;
                    }

                    this.a(var115, var116, var117, var118, var119, var120);
                    var3.writeNoException();
                    return true;
                case 9030:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParcelFileDescriptor var114 = this.bK(var2.readString());
                    var3.writeNoException();
                    if(var114 != null) {
                        var3.writeInt(1);
                        var114.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 9031:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParticipantEntity[] var127 = (ParticipantEntity[])var2.createTypedArray(ParticipantEntity.CREATOR);
                    String var128 = var2.readString();
                    String var129 = var2.readString();
                    Uri var130;
                    if(var2.readInt() != 0) {
                        var130 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    } else {
                        var130 = null;
                    }

                    int var131 = var2.readInt();
                    Uri var132 = null;
                    if(var131 != 0) {
                        var132 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    }

                    Intent var133 = this.a(var127, var128, var129, var130, var132);
                    var3.writeNoException();
                    if(var133 != null) {
                        var3.writeInt(1);
                        var133.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 10001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong());
                    var3.writeNoException();
                    return true;
                case 10002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.t(var2.readLong());
                    var3.writeNoException();
                    return true;
                case 10003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 10004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 10005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.createStringArray(), var2.readInt(), var2.createByteArray(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 10007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 10008:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 10009:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10010:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readInt(), var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10011:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10012:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var113 = this.a(var2.readInt(), var2.createByteArray(), var2.readInt(), var2.readString());
                    var3.writeNoException();
                    if(var113 != null) {
                        var3.writeInt(1);
                        var113.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 10013:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var112 = this.ks();
                    var3.writeNoException();
                    var3.writeInt(var112);
                    return true;
                case 10014:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.s(var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10015:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var110 = this.kr();
                    var3.writeNoException();
                    if(var110 != null) {
                        var3.writeInt(1);
                        var110.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 10016:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10017:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var102 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var103 = var2.readString();
                    int var104 = var2.readInt();
                    int var105 = var2.readInt();
                    boolean var106 = false;
                    if(var105 != 0) {
                        var106 = true;
                    }

                    this.b(var102, var103, var104, var106);
                    var3.writeNoException();
                    return true;
                case 10018:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readInt(), var2.createIntArray());
                    var3.writeNoException();
                    return true;
                case 10019:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readInt(), var2.createIntArray());
                    var3.writeNoException();
                    return true;
                case 10020:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 10021:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var99 = var2.readInt();
                    ZInvitationCluster var100 = null;
                    if(var99 != 0) {
                        var100 = ZInvitationCluster.CREATOR.method_4914(var2);
                    }

                    Intent var101 = this.a(var100, var2.readString(), var2.readString());
                    var3.writeNoException();
                    if(var101 != null) {
                        var3.writeInt(1);
                        var101.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 10022:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var107 = var2.readInt();
                    GameRequestCluster var108 = null;
                    if(var107 != 0) {
                        var108 = GameRequestCluster.CREATOR.method_5631(var2);
                    }

                    Intent var109 = this.a(var108, var2.readString());
                    var3.writeNoException();
                    if(var109 != null) {
                        var3.writeInt(1);
                        var109.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 10023:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var111 = this.kt();
                    var3.writeNoException();
                    var3.writeInt(var111);
                    return true;
                case 11001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.j(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 11002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.kE();
                    var3.writeNoException();
                    return true;
                case 12001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var95 = var2.readString();
                    boolean var96;
                    if(var2.readInt() != 0) {
                        var96 = true;
                    } else {
                        var96 = false;
                    }

                    boolean var97;
                    if(var2.readInt() != 0) {
                        var97 = true;
                    } else {
                        var97 = false;
                    }

                    Intent var98 = this.a(var95, var96, var97, var2.readInt());
                    var3.writeNoException();
                    if(var98 != null) {
                        var3.writeInt(1);
                        var98.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 12002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var92 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var93 = var2.readInt();
                    boolean var94 = false;
                    if(var93 != 0) {
                        var94 = true;
                    }

                    this.d(var92, var94);
                    var3.writeNoException();
                    return true;
                case 12003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var87 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var88 = var2.readString();
                    String var89 = var2.readString();
                    int var90 = var2.readInt();
                    boolean var91 = false;
                    if(var90 != 0) {
                        var91 = true;
                    }

                    this.c(var87, var88, var89, var91);
                    var3.writeNoException();
                    return true;
                case 12005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.s(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12006:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var83 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var84 = var2.readString();
                    int var85 = var2.readInt();
                    boolean var86 = false;
                    if(var85 != 0) {
                        var86 = true;
                    }

                    this.e(var83, var84, var86);
                    var3.writeNoException();
                    return true;
                case 12007:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var79 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var80 = var2.readString();
                    SnapshotMetadataChange var81;
                    if(var2.readInt() != 0) {
                        var81 = SnapshotMetadataChange.CREATOR.createFromParcel(var2);
                    } else {
                        var81 = null;
                    }

                    Contents var82;
                    if(var2.readInt() != 0) {
                        var82 = (Contents)Contents.CREATOR.createFromParcel(var2);
                    } else {
                        var82 = null;
                    }

                    this.a(var79, var80, var81, var82);
                    var3.writeNoException();
                    return true;
                case 12008:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.u(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12009:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12010:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var42 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int[] var43 = var2.createIntArray();
                    int var44 = var2.readInt();
                    int var45 = var2.readInt();
                    boolean var46 = false;
                    if(var45 != 0) {
                        var46 = true;
                    }

                    this.a(var42, var43, var44, var46);
                    var3.writeNoException();
                    return true;
                case 12011:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong());
                    var3.writeNoException();
                    return true;
                case 12012:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.u(var2.readLong());
                    var3.writeNoException();
                    return true;
                case 12013:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12014:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(var2.readLong(), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12015:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var32 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var33 = var2.readString();
                    String var34 = var2.readString();
                    int[] var35 = var2.createIntArray();
                    int var36 = var2.readInt();
                    boolean var37;
                    if(var2.readInt() != 0) {
                        var37 = true;
                    } else {
                        var37 = false;
                    }

                    this.a(var32, var33, var34, var35, var36, var37);
                    var3.writeNoException();
                    return true;
                case 12016:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var50 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var51 = var2.readInt();
                    boolean var52 = false;
                    if(var51 != 0) {
                        var52 = true;
                    }

                    this.f(var50, var52);
                    var3.writeNoException();
                    return true;
                case 12017:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.n(var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 12018:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var19 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var20 = var2.readString();
                    String var21 = var2.readString();
                    int var22 = var2.readInt();
                    boolean var23;
                    if(var2.readInt() != 0) {
                        var23 = true;
                    } else {
                        var23 = false;
                    }

                    boolean var24;
                    if(var2.readInt() != 0) {
                        var24 = true;
                    } else {
                        var24 = false;
                    }

                    this.b(var19, var20, var21, var22, var23, var24);
                    var3.writeNoException();
                    return true;
                case 12019:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Contents var78;
                    if(var2.readInt() != 0) {
                        var78 = (Contents)Contents.CREATOR.createFromParcel(var2);
                    } else {
                        var78 = null;
                    }

                    this.a(var78);
                    var3.writeNoException();
                    return true;
                case 12020:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.r(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12021:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var65 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var66 = var2.readString();
                    int var67 = var2.readInt();
                    boolean var68;
                    if(var2.readInt() != 0) {
                        var68 = true;
                    } else {
                        var68 = false;
                    }

                    boolean var69;
                    if(var2.readInt() != 0) {
                        var69 = true;
                    } else {
                        var69 = false;
                    }

                    this.e(var65, var66, var67, var68, var69);
                    var3.writeNoException();
                    return true;
                case 12022:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var60 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var61 = var2.readString();
                    int var62 = var2.readInt();
                    boolean var63;
                    if(var2.readInt() != 0) {
                        var63 = true;
                    } else {
                        var63 = false;
                    }

                    boolean var64;
                    if(var2.readInt() != 0) {
                        var64 = true;
                    } else {
                        var64 = false;
                    }

                    this.f(var60, var61, var62, var63, var64);
                    var3.writeNoException();
                    return true;
                case 12023:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 12024:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 12025:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    boolean var58 = this.kF();
                    var3.writeNoException();
                    byte var59 = 0;
                    if(var58) {
                        var59 = 1;
                    }

                    var3.writeInt(var59);
                    return true;
                case 12026:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var56 = var2.readInt();
                    boolean var57 = false;
                    if(var56 != 0) {
                        var57 = true;
                    }

                    this.O(var57);
                    var3.writeNoException();
                    return true;
                case 12027:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.t(IGamesCallbacks.Stub.method_2364(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 12028:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var27 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var28 = var2.readString();
                    String var29 = var2.readString();
                    String[] var30 = var2.createStringArray();
                    boolean var31;
                    if(var2.readInt() != 0) {
                        var31 = true;
                    } else {
                        var31 = false;
                    }

                    this.a(var27, var28, var29, var30, var31);
                    var3.writeNoException();
                    return true;
                case 12029:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var38 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String[] var39 = var2.createStringArray();
                    int var40 = var2.readInt();
                    boolean var41 = false;
                    if(var40 != 0) {
                        var41 = true;
                    }

                    this.a(var38, var39, var41);
                    var3.writeNoException();
                    return true;
                case 12030:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var26 = this.b(var2.createIntArray());
                    var3.writeNoException();
                    if(var26 != null) {
                        var3.writeInt(1);
                        var26.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 12031:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var47 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var48 = var2.readInt();
                    boolean var49 = false;
                    if(var48 != 0) {
                        var49 = true;
                    }

                    this.a(var47, var49, var2.createStringArray());
                    var3.writeNoException();
                    return true;
                case 12032:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var53 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var54 = var2.readInt();
                    boolean var55 = false;
                    if(var54 != 0) {
                        var55 = true;
                    }

                    this.e(var53, var55);
                    var3.writeNoException();
                    return true;
                case 12033:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var72 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    String var73 = var2.readString();
                    String var74 = var2.readString();
                    SnapshotMetadataChange var75;
                    if(var2.readInt() != 0) {
                        var75 = SnapshotMetadataChange.CREATOR.createFromParcel(var2);
                    } else {
                        var75 = null;
                    }

                    int var76 = var2.readInt();
                    Contents var77 = null;
                    if(var76 != 0) {
                        var77 = (Contents)Contents.CREATOR.createFromParcel(var2);
                    }

                    this.a(var72, var73, var74, var75, var77);
                    var3.writeNoException();
                    return true;
                case 12034:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent var25 = this.bC(var2.readString());
                    var3.writeNoException();
                    if(var25 != null) {
                        var3.writeInt(1);
                        var25.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 12035:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var71 = this.ku();
                    var3.writeNoException();
                    var3.writeInt(var71);
                    return true;
                case 12036:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var70 = this.kv();
                    var3.writeNoException();
                    var3.writeInt(var70);
                    return true;
                case 13001:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var17 = var2.readInt();
                    boolean var18 = false;
                    if(var17 != 0) {
                        var18 = true;
                    }

                    this.P(var18);
                    var3.writeNoException();
                    return true;
                case 13002:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String var14 = var2.readString();
                    IBinder var15 = var2.readStrongBinder();
                    Bundle var16;
                    if(var2.readInt() != 0) {
                        var16 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var16 = null;
                    }

                    this.a(var14, var15, var16);
                    var3.writeNoException();
                    return true;
                case 13003:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var11 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var12 = var2.readInt();
                    boolean var13 = false;
                    if(var12 != 0) {
                        var13 = true;
                    }

                    this.g(var11, var13);
                    var3.writeNoException();
                    return true;
                case 13004:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    IGamesCallbacks var8 = IGamesCallbacks.Stub.method_2364(var2.readStrongBinder());
                    int var9 = var2.readInt();
                    boolean var10 = false;
                    if(var9 != 0) {
                        var10 = true;
                    }

                    this.h(var8, var10);
                    var3.writeNoException();
                    return true;
                case 13005:
                    var2.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int var5 = var2.readInt();
                    AchievementEntity var6 = null;
                    if(var5 != 0) {
                        var6 = AchievementEntity.CREATOR.createFromParcel(var2);
                    }

                    Intent var7 = this.a(var6);
                    var3.writeNoException();
                    if(var7 != null) {
                        var3.writeInt(1);
                        var7.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class Proxy implements IGamesService {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4890;

        Proxy(IBinder var1) {
            this.field_4890 = var1;
        }

        // $FF: renamed from: N (boolean) void
        public void method_441(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: O (boolean) void
        public void method_442(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: P (boolean) void
        public void method_443(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, byte[], java.lang.String, java.lang.String) int
        public int method_444(IGamesCallbacks param1, byte[] param2, String param3, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (int, int, boolean) android.content.Intent
        public Intent method_445(int param1, int param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (int, byte[], int, java.lang.String) android.content.Intent
        public Intent method_446(int var1, byte[] var2, int var3, String var4) throws RemoteException {
            Parcel var5 = Parcel.obtain();
            Parcel var6 = Parcel.obtain();
            boolean var11 = false;

            Intent var9;
            label36: {
                try {
                    var11 = true;
                    var5.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    var5.writeInt(var1);
                    var5.writeByteArray(var2);
                    var5.writeInt(var3);
                    var5.writeString(var4);
                    this.field_4890.transact(10012, var5, var6, 0);
                    var6.readException();
                    if(var6.readInt() != 0) {
                        var9 = (Intent)Intent.CREATOR.createFromParcel(var6);
                        var11 = false;
                        break label36;
                    }

                    var11 = false;
                } finally {
                    if(var11) {
                        var6.recycle();
                        var5.recycle();
                    }
                }

                var9 = null;
            }

            var6.recycle();
            var5.recycle();
            return var9;
        }

        // $FF: renamed from: a (com.google.android.gms.games.achievement.AchievementEntity) android.content.Intent
        public Intent method_447(AchievementEntity param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.multiplayer.ZInvitationCluster, java.lang.String, java.lang.String) android.content.Intent
        public Intent method_448(ZInvitationCluster param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, java.lang.String) android.content.Intent
        public Intent method_449(GameRequestCluster param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, int) android.content.Intent
        public Intent method_450(RoomEntity param1, int param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
        public Intent method_451(String param1, boolean param2, boolean param3, int param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity[], java.lang.String, java.lang.String, android.net.Uri, android.net.Uri) android.content.Intent
        public Intent method_452(ParticipantEntity[] param1, String param2, String param3, Uri param4, Uri param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (long, java.lang.String) void
        public void method_453(long var1, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeLong(var1);
                var4.writeString(var3);
                this.field_4890.transact(8019, var4, var5, 0);
                var5.readException();
            } finally {
                var5.recycle();
                var4.recycle();
            }

        }

        // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
        public void method_454(IBinder param1, Bundle param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.drive.Contents) void
        public void method_455(Contents param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_456(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int) void
        public void method_457(IGamesCallbacks param1, int param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, int) void
        public void method_458(IGamesCallbacks param1, int param2, int param3, int param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, boolean, boolean) void
        public void method_459(IGamesCallbacks param1, int param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int, java.lang.String[], android.os.Bundle) void
        public void method_460(IGamesCallbacks param1, int param2, int param3, String[] param4, Bundle param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
        public void method_461(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int, int[]) void
        public void method_462(IGamesCallbacks param1, int param2, int[] param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long) void
        public void method_463(IGamesCallbacks param1, long param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
        public void method_464(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.Bundle, int, int) void
        public void method_465(IGamesCallbacks param1, Bundle param2, int param3, int param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, int, java.lang.String[], android.os.Bundle, boolean, long) void
        public void method_466(IGamesCallbacks param1, IBinder param2, int param3, String[] param4, Bundle param5, boolean param6, long param7) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, android.os.IBinder, java.lang.String, boolean, long) void
        public void method_467(IGamesCallbacks param1, IBinder param2, String param3, boolean param4, long param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_468(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
        public void method_469(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
        public void method_470(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
        public void method_471(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
        public void method_472(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
        public void method_473(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean, boolean, boolean) void
        public void method_474(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5, boolean param6, boolean param7) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int[]) void
        public void method_475(IGamesCallbacks param1, String param2, int param3, int[] param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long) void
        public void method_476(IGamesCallbacks param1, String param2, long param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, long, java.lang.String) void
        public void method_477(IGamesCallbacks param1, String param2, long param3, String param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
        public void method_478(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
        public void method_479(IGamesCallbacks param1, String param2, SnapshotMetadataChange param3, Contents param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
        public void method_480(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int) void
        public void method_481(IGamesCallbacks param1, String param2, String param3, int param4, int param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int) void
        public void method_482(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
        public void method_483(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
        public void method_484(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
        public void method_485(IGamesCallbacks param1, String param2, String param3, SnapshotMetadataChange param4, Contents param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
        public void method_486(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int[], int, boolean) void
        public void method_487(IGamesCallbacks param1, String param2, String param3, int[] param4, int param5, boolean param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[]) void
        public void method_488(IGamesCallbacks param1, String param2, String param3, String[] param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, java.lang.String[], boolean) void
        public void method_489(IGamesCallbacks param1, String param2, String param3, String[] param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
        public void method_490(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
        public void method_491(IGamesCallbacks param1, String param2, byte[] param3, String param4, ParticipantResult[] param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
        public void method_492(IGamesCallbacks param1, String param2, byte[] param3, ParticipantResult[] param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int[]) void
        public void method_493(IGamesCallbacks param1, String param2, int[] param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String[], int, byte[], int) void
        public void method_494(IGamesCallbacks param1, String param2, String[] param3, int param4, byte[] param5, int param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_495(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, android.os.Bundle) void
        public void method_496(IGamesCallbacks param1, boolean param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, boolean, java.lang.String[]) void
        public void method_497(IGamesCallbacks param1, boolean param2, String[] param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[]) void
        public void method_498(IGamesCallbacks param1, int[] param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, int[], int, boolean) void
        public void method_499(IGamesCallbacks param1, int[] param2, int param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
        public void method_500(IGamesCallbacks param1, String[] param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[], boolean) void
        public void method_501(IGamesCallbacks param1, String[] param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, android.os.IBinder, android.os.Bundle) void
        public void method_502(String param1, IBinder param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4890;
        }

        // $FF: renamed from: b (byte[], java.lang.String, java.lang.String[]) int
        public int method_503(byte[] var1, String var2, String[] var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            int var8;
            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeByteArray(var1);
                var4.writeString(var2);
                var4.writeStringArray(var3);
                this.field_4890.transact(5034, var4, var5, 0);
                var5.readException();
                var8 = var5.readInt();
            } finally {
                var5.recycle();
                var4.recycle();
            }

            return var8;
        }

        // $FF: renamed from: b (int, int, boolean) android.content.Intent
        public Intent method_504(int param1, int param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (int[]) android.content.Intent
        public Intent method_505(int[] var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            Intent var6;
            label36: {
                try {
                    var8 = true;
                    var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    var2.writeIntArray(var1);
                    this.field_4890.transact(12030, var2, var3, 0);
                    var3.readException();
                    if(var3.readInt() != 0) {
                        var6 = (Intent)Intent.CREATOR.createFromParcel(var3);
                        var8 = false;
                        break label36;
                    }

                    var8 = false;
                } finally {
                    if(var8) {
                        var3.recycle();
                        var2.recycle();
                    }
                }

                var6 = null;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: b (long, java.lang.String) void
        public void method_506(long var1, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeLong(var1);
                var4.writeString(var3);
                this.field_4890.transact(8021, var4, var5, 0);
                var5.readException();
            } finally {
                var5.recycle();
                var4.recycle();
            }

        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_507(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
        public void method_508(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long) void
        public void method_509(IGamesCallbacks param1, long param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
        public void method_510(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_511(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
        public void method_512(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, int, int, boolean) void
        public void method_513(IGamesCallbacks param1, String param2, int param3, int param4, int param5, boolean param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, android.os.IBinder, android.os.Bundle) void
        public void method_514(IGamesCallbacks param1, String param2, int param3, IBinder param4, Bundle param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean) void
        public void method_515(IGamesCallbacks param1, String param2, int param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
        public void method_516(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, android.os.IBinder, android.os.Bundle) void
        public void method_517(IGamesCallbacks param1, String param2, IBinder param3, Bundle param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
        public void method_518(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, int, int, boolean) void
        public void method_519(IGamesCallbacks param1, String param2, String param3, int param4, int param5, int param6, boolean param7) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, int, boolean, boolean) void
        public void method_520(IGamesCallbacks param1, String param2, String param3, int param4, boolean param5, boolean param6) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
        public void method_521(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
        public void method_522(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_523(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
        public void method_524(IGamesCallbacks param1, String[] param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (java.lang.String, java.lang.String, int) void
        public void method_525(String var1, String var2, int var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeString(var1);
                var4.writeString(var2);
                var4.writeInt(var3);
                this.field_4890.transact(5051, var4, var5, 0);
                var5.readException();
            } finally {
                var5.recycle();
                var4.recycle();
            }

        }

        // $FF: renamed from: bC (java.lang.String) android.content.Intent
        public Intent method_526(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            Intent var6;
            label36: {
                try {
                    var8 = true;
                    var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    var2.writeString(var1);
                    this.field_4890.transact(12034, var2, var3, 0);
                    var3.readException();
                    if(var3.readInt() != 0) {
                        var6 = (Intent)Intent.CREATOR.createFromParcel(var3);
                        var8 = false;
                        break label36;
                    }

                    var8 = false;
                } finally {
                    if(var8) {
                        var3.recycle();
                        var2.recycle();
                    }
                }

                var6 = null;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: bE (java.lang.String) java.lang.String
        public String method_527(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            String var6;
            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var2.writeString(var1);
                this.field_4890.transact(5064, var2, var3, 0);
                var3.readException();
                var6 = var3.readString();
            } finally {
                var3.recycle();
                var2.recycle();
            }

            return var6;
        }

        // $FF: renamed from: bF (java.lang.String) java.lang.String
        public String method_528(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            String var6;
            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var2.writeString(var1);
                this.field_4890.transact(5035, var2, var3, 0);
                var3.readException();
                var6 = var3.readString();
            } finally {
                var3.recycle();
                var2.recycle();
            }

            return var6;
        }

        // $FF: renamed from: bG (java.lang.String) void
        public void method_529(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var2.writeString(var1);
                this.field_4890.transact(5050, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        // $FF: renamed from: bH (java.lang.String) int
        public int method_530(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            int var6;
            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var2.writeString(var1);
                this.field_4890.transact(5060, var2, var3, 0);
                var3.readException();
                var6 = var3.readInt();
            } finally {
                var3.recycle();
                var2.recycle();
            }

            return var6;
        }

        // $FF: renamed from: bI (java.lang.String) android.net.Uri
        public Uri method_531(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            Uri var6;
            label36: {
                try {
                    var8 = true;
                    var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    var2.writeString(var1);
                    this.field_4890.transact(5066, var2, var3, 0);
                    var3.readException();
                    if(var3.readInt() != 0) {
                        var6 = (Uri)Uri.CREATOR.createFromParcel(var3);
                        var8 = false;
                        break label36;
                    }

                    var8 = false;
                } finally {
                    if(var8) {
                        var3.recycle();
                        var2.recycle();
                    }
                }

                var6 = null;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: bJ (java.lang.String) void
        public void method_532(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var2.writeString(var1);
                this.field_4890.transact(8002, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        // $FF: renamed from: bK (java.lang.String) android.os.ParcelFileDescriptor
        public ParcelFileDescriptor method_533(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            ParcelFileDescriptor var6;
            label36: {
                try {
                    var8 = true;
                    var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    var2.writeString(var1);
                    this.field_4890.transact(9030, var2, var3, 0);
                    var3.readException();
                    if(var3.readInt() != 0) {
                        var6 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var3);
                        var8 = false;
                        break label36;
                    }

                    var8 = false;
                } finally {
                    if(var8) {
                        var3.recycle();
                        var2.recycle();
                    }
                }

                var6 = null;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: bx (java.lang.String) android.content.Intent
        public Intent method_534(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            Intent var6;
            label36: {
                try {
                    var8 = true;
                    var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    var2.writeString(var1);
                    this.field_4890.transact(9004, var2, var3, 0);
                    var3.readException();
                    if(var3.readInt() != 0) {
                        var6 = (Intent)Intent.CREATOR.createFromParcel(var3);
                        var8 = false;
                        break label36;
                    }

                    var8 = false;
                } finally {
                    if(var8) {
                        var3.recycle();
                        var2.recycle();
                    }
                }

                var6 = null;
            }

            var3.recycle();
            var2.recycle();
            return var6;
        }

        // $FF: renamed from: c (long, java.lang.String) void
        public void method_535(long var1, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeLong(var1);
                var4.writeString(var3);
                this.field_4890.transact(10004, var4, var5, 0);
                var5.readException();
            } finally {
                var5.recycle();
                var4.recycle();
            }

        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_536(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
        public void method_537(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long) void
        public void method_538(IGamesCallbacks param1, long param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
        public void method_539(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_540(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int) void
        public void method_541(IGamesCallbacks param1, String param2, int param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
        public void method_542(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
        public void method_543(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String, boolean) void
        public void method_544(IGamesCallbacks param1, String param2, String param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
        public void method_545(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_546(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String[]) void
        public void method_547(IGamesCallbacks param1, String[] param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
        public void method_548(String var1, String var2, int var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeString(var1);
                var4.writeString(var2);
                var4.writeInt(var3);
                this.field_4890.transact(8026, var4, var5, 0);
                var5.readException();
            } finally {
                var5.recycle();
                var4.recycle();
            }

        }

        // $FF: renamed from: d (long, java.lang.String) void
        public void method_549(long var1, String var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();

            try {
                var4.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var4.writeLong(var1);
                var4.writeString(var3);
                this.field_4890.transact(12014, var4, var5, 0);
                var5.readException();
            } finally {
                var5.recycle();
                var4.recycle();
            }

        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_550(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
        public void method_551(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long) void
        public void method_552(IGamesCallbacks param1, long param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, long, java.lang.String) void
        public void method_553(IGamesCallbacks param1, long param2, String param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_554(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
        public void method_555(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
        public void method_556(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
        public void method_557(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_558(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: dC (int) void
        public void method_559(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var2.writeInt(var1);
                this.field_4890.transact(5036, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_560(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, int, boolean, boolean) void
        public void method_561(IGamesCallbacks param1, int param2, boolean param3, boolean param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_562(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
        public void method_563(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
        public void method_564(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, boolean) void
        public void method_565(IGamesCallbacks param1, String param2, boolean param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_566(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_567(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_568(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, int, boolean, boolean) void
        public void method_569(IGamesCallbacks param1, String param2, int param3, boolean param4, boolean param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String, java.lang.String) void
        public void method_570(IGamesCallbacks param1, String param2, String param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_571(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: fC () android.os.Bundle
        public Bundle method_572() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Bundle var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(5004, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_573(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_574(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: g (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_575(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: h (android.net.Uri) android.os.ParcelFileDescriptor
        public ParcelFileDescriptor method_576(Uri param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RoomEntity
        public RoomEntity method_577(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_578(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: h (com.google.android.gms.games.internal.IGamesCallbacks, boolean) void
        public void method_579(IGamesCallbacks param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_580(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: i (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_581(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks) void
        public void method_582(IGamesCallbacks param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: j (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_583(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: k (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_584(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: kA () boolean
        public boolean method_585() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(5067, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
                var8 = false;
            } finally {
                if(var8) {
                    var2.recycle();
                    var1.recycle();
                }
            }

            boolean var6 = false;
            if(var5 != 0) {
                var6 = true;
            }

            var2.recycle();
            var1.recycle();
            return var6;
        }

        // $FF: renamed from: kB () com.google.android.gms.common.data.DataHolder
        public DataHolder method_586() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            DataHolder var5;
            label42: {
                DataHolder var6;
                label41: {
                    try {
                        var8 = true;
                        var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                        this.field_4890.transact(5502, var1, var2, 0);
                        var2.readException();
                        if(var2.readInt() != 0) {
                            var6 = DataHolder.CREATOR.method_5521(var2);
                            var8 = false;
                            break label41;
                        }

                        var8 = false;
                    } finally {
                        if(var8) {
                            var2.recycle();
                            var1.recycle();
                        }
                    }

                    var5 = null;
                    break label42;
                }

                var5 = var6;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: kC () void
        public void method_587() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(8022, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        // $FF: renamed from: kD () android.content.Intent
        public Intent method_588() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9013, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: kE () void
        public void method_589() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(11002, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        // $FF: renamed from: kF () boolean
        public boolean method_590() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(12025, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
                var8 = false;
            } finally {
                if(var8) {
                    var2.recycle();
                    var1.recycle();
                }
            }

            boolean var6 = false;
            if(var5 != 0) {
                var6 = true;
            }

            var2.recycle();
            var1.recycle();
            return var6;
        }

        // $FF: renamed from: ka () java.lang.String
        public String method_591() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(5007, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kb () java.lang.String
        public String method_592() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(5012, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: ke () android.content.Intent
        public Intent method_593() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9003, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: kf () android.content.Intent
        public Intent method_594() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9005, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: kg () android.content.Intent
        public Intent method_595() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9006, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: kh () android.content.Intent
        public Intent method_596() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9007, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: km () android.content.Intent
        public Intent method_597() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9010, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: kn () android.content.Intent
        public Intent method_598() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(9012, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: ko () int
        public int method_599() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(9019, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kp () java.lang.String
        public String method_600() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(5003, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kq () int
        public int method_601() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(8024, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kr () android.content.Intent
        public Intent method_602() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Intent var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.field_4890.transact(10015, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: ks () int
        public int method_603() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(10013, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kt () int
        public int method_604() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(10023, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: ku () int
        public int method_605() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(12035, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kv () int
        public int method_606() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(12036, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: kx () void
        public void method_607() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                this.field_4890.transact(5006, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        // $FF: renamed from: kz () com.google.android.gms.common.data.DataHolder
        public DataHolder method_608() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            DataHolder var5;
            label42: {
                DataHolder var6;
                label41: {
                    try {
                        var8 = true;
                        var1.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                        this.field_4890.transact(5013, var1, var2, 0);
                        var2.readException();
                        if(var2.readInt() != 0) {
                            var6 = DataHolder.CREATOR.method_5521(var2);
                            var8 = false;
                            break label41;
                        }

                        var8 = false;
                    } finally {
                        if(var8) {
                            var2.recycle();
                            var1.recycle();
                        }
                    }

                    var5 = null;
                    break label42;
                }

                var5 = var6;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: l (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_609(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: m (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_610(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: n (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_611(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: n (java.lang.String, int) void
        public void method_612(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_4890.transact(12017, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: o (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_613(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: o (java.lang.String, int) void
        public void method_614(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_4890.transact(5029, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: p (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_615(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: p (java.lang.String, int) void
        public void method_616(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_4890.transact(5028, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: q (long) void
        public void method_617(long var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeLong(var1);
                this.field_4890.transact(5001, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: q (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_618(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: r (long) void
        public void method_619(long var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeLong(var1);
                this.field_4890.transact(5059, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: r (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_620(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: r (java.lang.String, int) void
        public void method_621(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_4890.transact(5055, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: s (long) void
        public void method_622(long var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeLong(var1);
                this.field_4890.transact(8013, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: s (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_623(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: s (java.lang.String, int) void
        public void method_624(String var1, int var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeInt(var2);
                this.field_4890.transact(10014, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: t (long) void
        public void method_625(long var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeLong(var1);
                this.field_4890.transact(10002, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: t (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_626(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: u (long) void
        public void method_627(long var1) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeLong(var1);
                this.field_4890.transact(12012, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: u (com.google.android.gms.games.internal.IGamesCallbacks, java.lang.String) void
        public void method_628(IGamesCallbacks param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: u (java.lang.String, java.lang.String) void
        public void method_629(String var1, String var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeString(var2);
                this.field_4890.transact(5065, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }

        // $FF: renamed from: v (java.lang.String, java.lang.String) void
        public void method_630(String var1, String var2) throws RemoteException {
            Parcel var3 = Parcel.obtain();
            Parcel var4 = Parcel.obtain();

            try {
                var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                var3.writeString(var1);
                var3.writeString(var2);
                this.field_4890.transact(8025, var3, var4, 0);
                var4.readException();
            } finally {
                var4.recycle();
                var3.recycle();
            }

        }
    }
}
