package com.generic.file.configuration.cfg;

import com.generic.file.configuration.components.Options;
import com.generic.file.configuration.components.Section;

public interface GenericConfiguration {

    public void addDefault(String path, Object o);

    public void setDefault(String path, Object o);

    public void createConfiguration();

    public Options options();

    public Section section();

    public String read();

}
