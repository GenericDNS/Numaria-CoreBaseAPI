package com.generic.file.configuration.components;

public interface Section {

    public String getString(String path);

    public int getInt(String path);

    public Object getObject(String path);

}
