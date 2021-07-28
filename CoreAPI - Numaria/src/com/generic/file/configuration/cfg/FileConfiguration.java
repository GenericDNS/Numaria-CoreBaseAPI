package com.generic.file.configuration.cfg;

import com.generic.Numaria;
import com.generic.file.configuration.DefaultMap;
import com.generic.file.configuration.components.Options;
import com.generic.file.configuration.components.SQLComponent;
import com.generic.file.configuration.components.Section;
import com.generic.file.configuration.components.suffold.SQLOptions;
import com.generic.types.Color;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileConfiguration implements GenericConfiguration, SQLOptions {

    private String name;

    private File file;

    private SQLComponent sqlComponent;

    private String tableHeader;

    private List<DefaultMap<String, Object>> defaultMaps = new ArrayList<>();

    public FileConfiguration(String name) {
        this.name = name;
        this.file = new File( name + ".yml");
    }

    public SQLComponent sqlComponent() {
        return new SQLComponent() {

            private final ExecutorService executorService = Executors.newCachedThreadPool();

            @Override
            public void connectFile() {

                Numaria.getInstance().getExecuteService().execute(new Runnable() {
                    @Override
                    public void run() {

                        List<String> pathList = new ArrayList<>();
                        List<String> valueList = new ArrayList<>();
                        for (DefaultMap defaultMaps : defaultMaps) {
                            pathList.add(defaultMaps.getPath());
                            valueList.add(defaultMaps.getValue().toString());
                        }

                        executorService.execute(() -> {
                            Numaria.getInstance().getAdapter().addMoreInTable(tableHeader, pathList, valueList);
                        });

                    }
                });

            }

            @Override
            public String getTableHeader() {
                return tableHeader;
            }
        };
    }

    public static void loadInFileConfiguration(File file) {
    }

    public FileConfiguration(File file) {
        this.file = file;
    }

    @Override
    public void addDefault(String path, Object o) {
        DefaultMap<String, Object> defaultMap = new DefaultMap<>();
        defaultMap.put(path, o);
        this.defaultMaps.add(defaultMap);
        try {
            String line = read();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            if (line == null){ bw.write(path + ": " + o); return;}
            bw.write(line + "\n" + path + ": " + o);
            bw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void setDefault(String path, Object o) {
    }

    @Override
    public void createConfiguration() {
        try {
            this.file.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Options options() {
        return new Options() {
            @Override
            public boolean exists() {
                return file.exists();
            }

            @Override
            public File getFile() {
                return file;
            }
        };
    }

    @Override
    public String read() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
            bufferedReader.lines().forEach(line -> stringBuilder.append(line + "\n"));
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException exception) {
            exception.printStackTrace();
        } return null;
    }

    @Override
    public Section section() {
        return new Section() {
            @Override
            public String getString(String path) {
                String line = read();
                for (String element : line.split("\n")) {
                    String[] keyAndValue = element.split(": ",2);
                    if (keyAndValue.length == 2 && keyAndValue[0].equals(path)) {
                        return keyAndValue[1];
                    }
                } return "";
            }

            @Override
            public int getInt(String path) {
                String line = read();
                for (String element : line.split("\n")) {
                    String[] keyAndValue = element.split(": ",2);
                    if (keyAndValue.length == 2 && keyAndValue[0].equals(path)) {
                        return Integer.parseInt(keyAndValue[1]);
                    }
                } return -1;
            }

            @Override
            public Object getObject(String path) {
                String line = read();
                for (String element : line.split("\n")) {
                    String[] keyAndValue = element.split(": ",2);
                    if (keyAndValue.length == 2 && keyAndValue[0].equals(path)) {
                        return keyAndValue[1];
                    }
                } return "";
            }
        };
    }

    @Override
    public void setTableHeader(String name) {
        this.tableHeader = tableHeader;
    }

    @Override
    public void setEntryFormat(String format) {

    }
}
