package com.generic.file.configuration;

public class DefaultMap<S extends String, V> {

    S path;
    V value;

    public DefaultMap() {
    }

    public void put(S path, V value) {
        this.path = path;
        this.value = value;
    }

    public S getPath() {
        return path;
    }

    public void setPath(S path) {
        this.path = path;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
