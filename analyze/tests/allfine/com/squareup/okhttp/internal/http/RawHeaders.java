package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public final class RawHeaders {
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator() {
        public int compare(String var1, String var2) {
            return var1 == var2?0:(var1 == null?-1:(var2 == null?1:String.CASE_INSENSITIVE_ORDER.compare(var1, var2)));
        }
    };
    private int httpMinorVersion = 1;
    private final List<String> namesAndValues = new ArrayList(20);
    private String requestLine;
    private int responseCode = -1;
    private String responseMessage;
    private String statusLine;

    public RawHeaders() {
    }

    public RawHeaders(RawHeaders var1) {
        this.namesAndValues.addAll(var1.namesAndValues);
        this.requestLine = var1.requestLine;
        this.statusLine = var1.statusLine;
        this.httpMinorVersion = var1.httpMinorVersion;
        this.responseCode = var1.responseCode;
        this.responseMessage = var1.responseMessage;
    }

    private void addLenient(String var1, String var2) {
        this.namesAndValues.add(var1);
        this.namesAndValues.add(var2.trim());
    }

    public static RawHeaders fromBytes(InputStream var0) throws IOException {
        RawHeaders var1;
        do {
            var1 = new RawHeaders();
            var1.setStatusLine(Util.readAsciiLine(var0));
            readHeaders(var0, var1);
        } while(var1.getResponseCode() == 100);

        return var1;
    }

    public static RawHeaders fromMultimap(Map<String, List<String>> var0, boolean var1) throws IOException {
        if(!var1) {
            throw new UnsupportedOperationException();
        } else {
            RawHeaders var2 = new RawHeaders();
            Iterator var3 = var0.entrySet().iterator();

            while(true) {
                while(var3.hasNext()) {
                    Entry var4 = (Entry)var3.next();
                    String var5 = (String)var4.getKey();
                    List var6 = (List)var4.getValue();
                    if(var5 != null) {
                        Iterator var7 = var6.iterator();

                        while(var7.hasNext()) {
                            var2.addLenient(var5, (String)var7.next());
                        }
                    } else if(!var6.isEmpty()) {
                        var2.setStatusLine((String)var6.get(-1 + var6.size()));
                    }
                }

                return var2;
            }
        }
    }

    public static RawHeaders fromNameValueBlock(List<String> var0) throws IOException {
        if(var0.size() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected name value block: " + var0);
        } else {
            String var1 = null;
            String var2 = null;
            RawHeaders var3 = new RawHeaders();

            for(int var4 = 0; var4 < var0.size(); var4 += 2) {
                String var5 = (String)var0.get(var4);
                String var6 = (String)var0.get(var4 + 1);

                int var8;
                for(int var7 = 0; var7 < var6.length(); var7 = var8 + 1) {
                    var8 = var6.indexOf(0, var7);
                    if(var8 == -1) {
                        var8 = var6.length();
                    }

                    String var9 = var6.substring(var7, var8);
                    if(":status".equals(var5)) {
                        var1 = var9;
                    } else if(":version".equals(var5)) {
                        var2 = var9;
                    } else {
                        var3.namesAndValues.add(var5);
                        var3.namesAndValues.add(var9);
                    }
                }
            }

            if(var1 == null) {
                throw new ProtocolException("Expected \':status\' header not present");
            } else if(var2 == null) {
                throw new ProtocolException("Expected \':version\' header not present");
            } else {
                var3.setStatusLine(var2 + " " + var1);
                return var3;
            }
        }
    }

    public static void readHeaders(InputStream var0, RawHeaders var1) throws IOException {
        while(true) {
            String var2 = Util.readAsciiLine(var0);
            if(var2.length() == 0) {
                return;
            }

            var1.addLine(var2);
        }
    }

    public void add(String var1, String var2) {
        if(var1 == null) {
            throw new IllegalArgumentException("fieldname == null");
        } else if(var2 == null) {
            throw new IllegalArgumentException("value == null");
        } else if(var1.length() != 0 && var1.indexOf(0) == -1 && var2.indexOf(0) == -1) {
            this.addLenient(var1, var2);
        } else {
            throw new IllegalArgumentException("Unexpected header: " + var1 + ": " + var2);
        }
    }

    public void addAll(String var1, List<String> var2) {
        Iterator var3 = var2.iterator();

        while(var3.hasNext()) {
            this.add(var1, (String)var3.next());
        }

    }

    public void addLine(String var1) {
        int var2 = var1.indexOf(":", 1);
        if(var2 != -1) {
            this.addLenient(var1.substring(0, var2), var1.substring(var2 + 1));
        } else if(var1.startsWith(":")) {
            this.addLenient("", var1.substring(1));
        } else {
            this.addLenient("", var1);
        }
    }

    public void addSpdyRequestHeaders(String var1, String var2, String var3, String var4, String var5) {
        this.add(":method", var1);
        this.add(":scheme", var5);
        this.add(":path", var2);
        this.add(":version", var3);
        this.add(":host", var4);
    }

    public String get(String var1) {
        for(int var2 = -2 + this.namesAndValues.size(); var2 >= 0; var2 -= 2) {
            if(var1.equalsIgnoreCase((String)this.namesAndValues.get(var2))) {
                return (String)this.namesAndValues.get(var2 + 1);
            }
        }

        return null;
    }

    public RawHeaders getAll(Set<String> var1) {
        RawHeaders var2 = new RawHeaders();

        for(int var3 = 0; var3 < this.namesAndValues.size(); var3 += 2) {
            String var4 = (String)this.namesAndValues.get(var3);
            if(var1.contains(var4)) {
                var2.add(var4, (String)this.namesAndValues.get(var3 + 1));
            }
        }

        return var2;
    }

    public String getFieldName(int var1) {
        int var2 = var1 * 2;
        return var2 >= 0 && var2 < this.namesAndValues.size()?(String)this.namesAndValues.get(var2):null;
    }

    public int getHttpMinorVersion() {
        return this.httpMinorVersion != -1?this.httpMinorVersion:1;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getStatusLine() {
        return this.statusLine;
    }

    public String getValue(int var1) {
        int var2 = 1 + var1 * 2;
        return var2 >= 0 && var2 < this.namesAndValues.size()?(String)this.namesAndValues.get(var2):null;
    }

    public int length() {
        return this.namesAndValues.size() / 2;
    }

    public Set<String> names() {
        TreeSet var1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);

        for(int var2 = 0; var2 < this.length(); ++var2) {
            var1.add(this.getFieldName(var2));
        }

        return Collections.unmodifiableSet(var1);
    }

    public void removeAll(String var1) {
        for(int var2 = 0; var2 < this.namesAndValues.size(); var2 += 2) {
            if(var1.equalsIgnoreCase((String)this.namesAndValues.get(var2))) {
                this.namesAndValues.remove(var2);
                this.namesAndValues.remove(var2);
            }
        }

    }

    public void set(String var1, String var2) {
        this.removeAll(var1);
        this.add(var1, var2);
    }

    public void setRequestLine(String var1) {
        this.requestLine = var1.trim();
    }

    public void setStatusLine(String var1) throws IOException {
        if(this.responseMessage != null) {
            throw new IllegalStateException("statusLine is already set");
        } else {
            boolean var2;
            if(var1.length() > 13) {
                var2 = true;
            } else {
                var2 = false;
            }

            if(!var1.startsWith("HTTP/1.") || var1.length() < 12 || var1.charAt(8) != 32 || var2 && var1.charAt(12) != 32) {
                throw new ProtocolException("Unexpected status line: " + var1);
            } else {
                int var3 = -48 + var1.charAt(7);
                if(var3 >= 0 && var3 <= 9) {
                    int var5;
                    try {
                        var5 = Integer.parseInt(var1.substring(9, 12));
                    } catch (NumberFormatException var7) {
                        throw new ProtocolException("Unexpected status line: " + var1);
                    }

                    String var6;
                    if(var2) {
                        var6 = var1.substring(13);
                    } else {
                        var6 = "";
                    }

                    this.responseMessage = var6;
                    this.responseCode = var5;
                    this.statusLine = var1;
                    this.httpMinorVersion = var3;
                } else {
                    throw new ProtocolException("Unexpected status line: " + var1);
                }
            }
        }
    }

    public byte[] toBytes() throws UnsupportedEncodingException {
        StringBuilder var1 = new StringBuilder(256);
        var1.append(this.requestLine).append("\r\n");

        for(int var3 = 0; var3 < this.namesAndValues.size(); var3 += 2) {
            var1.append((String)this.namesAndValues.get(var3)).append(": ").append((String)this.namesAndValues.get(var3 + 1)).append("\r\n");
        }

        var1.append("\r\n");
        return var1.toString().getBytes("ISO-8859-1");
    }

    public Map<String, List<String>> toMultimap(boolean var1) {
        TreeMap var2 = new TreeMap(FIELD_NAME_COMPARATOR);

        for(int var3 = 0; var3 < this.namesAndValues.size(); var3 += 2) {
            String var6 = (String)this.namesAndValues.get(var3);
            String var7 = (String)this.namesAndValues.get(var3 + 1);
            ArrayList var8 = new ArrayList();
            List var9 = (List)var2.get(var6);
            if(var9 != null) {
                var8.addAll(var9);
            }

            var8.add(var7);
            var2.put(var6, Collections.unmodifiableList(var8));
        }

        if(var1 && this.statusLine != null) {
            var2.put((Object)null, Collections.unmodifiableList(Collections.singletonList(this.statusLine)));
        } else if(this.requestLine != null) {
            var2.put((Object)null, Collections.unmodifiableList(Collections.singletonList(this.requestLine)));
        }

        return Collections.unmodifiableMap(var2);
    }

    public List<String> toNameValueBlock() {
        HashSet var1 = new HashSet();
        ArrayList var2 = new ArrayList();

        for(int var3 = 0; var3 < this.namesAndValues.size(); var3 += 2) {
            String var4 = ((String)this.namesAndValues.get(var3)).toLowerCase(Locale.US);
            String var5 = (String)this.namesAndValues.get(var3 + 1);
            if(!var4.equals("connection") && !var4.equals("host") && !var4.equals("keep-alive") && !var4.equals("proxy-connection") && !var4.equals("transfer-encoding")) {
                if(var1.add(var4)) {
                    var2.add(var4);
                    var2.add(var5);
                } else {
                    for(int var6 = 0; var6 < var2.size(); var6 += 2) {
                        if(var4.equals(var2.get(var6))) {
                            var2.set(var6 + 1, (String)var2.get(var6 + 1) + "\u0000" + var5);
                            break;
                        }
                    }
                }
            }
        }

        return var2;
    }

    public List<String> values(String var1) {
        ArrayList var2 = null;

        for(int var3 = 0; var3 < this.length(); ++var3) {
            if(var1.equalsIgnoreCase(this.getFieldName(var3))) {
                if(var2 == null) {
                    var2 = new ArrayList(2);
                }

                var2.add(this.getValue(var3));
            }
        }

        if(var2 != null) {
            return Collections.unmodifiableList(var2);
        } else {
            return Collections.emptyList();
        }
    }
}
