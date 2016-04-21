package com.google.tagmanager;

interface Cache<K, V> {
    V get(K var1);

    void put(K var1, V var2);
}
