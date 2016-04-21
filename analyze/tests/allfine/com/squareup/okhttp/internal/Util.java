package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

public final class Util {
    private static final char[] DIGITS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private static AtomicReference<byte[]> skipBuffer = new AtomicReference();

    private static String bytesToHexString(byte[] var0) {
        char[] var1 = DIGITS;
        char[] var2 = new char[2 * var0.length];
        int var3 = var0.length;
        int var4 = 0;

        for(int var5 = 0; var4 < var3; ++var4) {
            byte var6 = var0[var4];
            int var7 = var5 + 1;
            var2[var5] = var1[15 & var6 >> 4];
            var5 = var7 + 1;
            var2[var7] = var1[var6 & 15];
        }

        return new String(var2);
    }

    public static void checkOffsetAndCount(int var0, int var1, int var2) {
        if((var1 | var2) < 0 || var1 > var0 || var0 - var1 < var2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeAll(Closeable var0, Closeable var1) throws IOException {
        Throwable var2 = null;

        try {
            var0.close();
        } catch (Throwable var5) {
            var2 = var5;
        }

        try {
            var1.close();
        } catch (Throwable var6) {
            if(var2 == null) {
                var2 = var6;
            }
        }

        if(var2 != null) {
            if(var2 instanceof IOException) {
                throw (IOException)var2;
            } else if(var2 instanceof RuntimeException) {
                throw (RuntimeException)var2;
            } else if(var2 instanceof Error) {
                throw (Error)var2;
            } else {
                throw new AssertionError(var2);
            }
        }
    }

    public static void closeQuietly(Closeable var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (RuntimeException var3) {
                throw var3;
            } catch (Exception var4) {
                return;
            }
        }

    }

    public static void closeQuietly(ServerSocket var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (RuntimeException var3) {
                throw var3;
            } catch (Exception var4) {
                return;
            }
        }

    }

    public static void closeQuietly(Socket var0) {
        if(var0 != null) {
            try {
                var0.close();
            } catch (RuntimeException var3) {
                throw var3;
            } catch (Exception var4) {
                return;
            }
        }

    }

    public static int copy(InputStream var0, OutputStream var1) throws IOException {
        int var2 = 0;
        byte[] var3 = new byte[8192];

        while(true) {
            int var4 = var0.read(var3);
            if(var4 == -1) {
                return var2;
            }

            var2 += var4;
            var1.write(var3, 0, var4);
        }
    }

    public static ThreadFactory daemonThreadFactory(final String var0) {
        return new ThreadFactory() {
            public Thread newThread(Runnable var1) {
                Thread var2 = new Thread(var1, var0);
                var2.setDaemon(true);
                return var2;
            }
        };
    }

    public static void deleteContents(File var0) throws IOException {
        File[] var1 = var0.listFiles();
        if(var1 == null) {
            throw new IOException("not a readable directory: " + var0);
        } else {
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                File var4 = var1[var3];
                if(var4.isDirectory()) {
                    deleteContents(var4);
                }

                if(!var4.delete()) {
                    throw new IOException("failed to delete file: " + var4);
                }
            }

        }
    }

    public static boolean equal(Object var0, Object var1) {
        return var0 == var1 || var0 != null && var0.equals(var1);
    }

    public static int getDefaultPort(String var0) {
        return "http".equalsIgnoreCase(var0)?80:("https".equalsIgnoreCase(var0)?443:-1);
    }

    private static int getEffectivePort(String var0, int var1) {
        return var1 != -1?var1:getDefaultPort(var0);
    }

    public static int getEffectivePort(URI var0) {
        return getEffectivePort(var0.getScheme(), var0.getPort());
    }

    public static int getEffectivePort(URL var0) {
        return getEffectivePort(var0.getProtocol(), var0.getPort());
    }

    public static String hash(String var0) {
        try {
            String var3 = bytesToHexString(MessageDigest.getInstance("MD5").digest(var0.getBytes("UTF-8")));
            return var3;
        } catch (NoSuchAlgorithmException var4) {
            throw new AssertionError(var4);
        } catch (UnsupportedEncodingException var5) {
            throw new AssertionError(var5);
        }
    }

    public static <T> List<T> immutableList(List<T> var0) {
        return Collections.unmodifiableList(new ArrayList(var0));
    }

    public static void pokeInt(byte[] var0, int var1, int var2, ByteOrder var3) {
        if(var3 == ByteOrder.BIG_ENDIAN) {
            int var7 = var1 + 1;
            var0[var1] = (byte)(255 & var2 >> 24);
            int var8 = var7 + 1;
            var0[var7] = (byte)(255 & var2 >> 16);
            int var9 = var8 + 1;
            var0[var8] = (byte)(255 & var2 >> 8);
            var0[var9] = (byte)(255 & var2 >> 0);
        } else {
            int var4 = var1 + 1;
            var0[var1] = (byte)(255 & var2 >> 0);
            int var5 = var4 + 1;
            var0[var4] = (byte)(255 & var2 >> 8);
            int var6 = var5 + 1;
            var0[var5] = (byte)(255 & var2 >> 16);
            var0[var6] = (byte)(255 & var2 >> 24);
        }
    }

    public static String readAsciiLine(InputStream var0) throws IOException {
        StringBuilder var1 = new StringBuilder(80);

        while(true) {
            int var2 = var0.read();
            if(var2 == -1) {
                throw new EOFException();
            }

            if(var2 == 10) {
                int var4 = var1.length();
                if(var4 > 0 && var1.charAt(var4 - 1) == 13) {
                    var1.setLength(var4 - 1);
                }

                return var1.toString();
            }

            var1.append((char)var2);
        }
    }

    public static String readFully(Reader param0) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public static void readFully(InputStream var0, byte[] var1) throws IOException {
        readFully(var0, var1, 0, var1.length);
    }

    public static void readFully(InputStream var0, byte[] var1, int var2, int var3) throws IOException {
        if(var3 != 0) {
            if(var0 == null) {
                throw new NullPointerException("in == null");
            }

            if(var1 == null) {
                throw new NullPointerException("dst == null");
            }

            checkOffsetAndCount(var1.length, var2, var3);

            while(var3 > 0) {
                int var4 = var0.read(var1, var2, var3);
                if(var4 < 0) {
                    throw new EOFException();
                }

                var2 += var4;
                var3 -= var4;
            }
        }

    }

    public static int readSingleByte(InputStream var0) throws IOException {
        int var1 = -1;
        byte[] var2 = new byte[1];
        if(var0.read(var2, 0, 1) != var1) {
            var1 = 255 & var2[0];
        }

        return var1;
    }

    public static void skipAll(InputStream var0) throws IOException {
        do {
            var0.skip(Long.MAX_VALUE);
        } while(var0.read() != -1);

    }

    public static long skipByReading(InputStream var0, long var1) throws IOException {
        if(var1 == 0L) {
            return 0L;
        } else {
            byte[] var3 = (byte[])skipBuffer.getAndSet((Object)null);
            if(var3 == null) {
                var3 = new byte[4096];
            }

            long var4 = 0L;

            while(var4 < var1) {
                int var6 = (int)Math.min(var1 - var4, (long)var3.length);
                int var7 = var0.read(var3, 0, var6);
                if(var7 == -1) {
                    break;
                }

                var4 += (long)var7;
                if(var7 < var6) {
                    break;
                }
            }

            skipBuffer.set(var3);
            return var4;
        }
    }

    public static void writeSingleByte(OutputStream var0, int var1) throws IOException {
        byte[] var2 = new byte[] {(byte)(var1 & 255)};
        var0.write(var2);
    }
}
