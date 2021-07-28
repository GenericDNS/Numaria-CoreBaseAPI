package com.generic.execute;

import com.generic.Numaria;
import com.generic.protocol.ServerData;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public abstract class ExecuteService<C extends Class<?>> {

    Timer timer;

    C clazz;

    private UUID uniqueID;

    private boolean timed;

    public ExecuteService() {
        timed = false;
    }

    public void cancel() {
        if (timed) timer.cancel();
        ServerData.executeServices.add(this);
    }

    public void executeLog(Runnable runTask) {
        runTask.run();
    }

    public static ExecuteService get(UUID uniqueID) {
        for (ExecuteService executeServices : ServerData.executeServices) {
            if (executeServices.uniqueID == uniqueID) return executeServices;
        } return new ExecuteService() {
        };
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public void executeDownload(File remoteFile, String url) {
        try {
            URL URL = new URL(url);
            HttpURLConnection http = (HttpURLConnection) URL.openConnection();
            double fileSize = (double) http.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(http.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(remoteFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownloaded = 0.00;
            while ((read = bufferedInputStream.read(buffer, 0, 1024)) >- 0) {
                bufferedOutputStream.write(buffer, 0, read);
                downloaded += read;
                percentDownloaded = (downloaded*100)/fileSize;
                String percent = String.format("%.4f", percentDownloaded);
                Bukkit.getConsoleSender().sendMessage(Numaria.getInstance().getServerData().getConsolePrefix() + "process is | " + "§b" + percent);
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
            Bukkit.getConsoleSender().sendMessage(Numaria.getInstance().getServerData().getConsolePrefix() + "Download complete");
        } catch (IOException ioException) {
        }
    }

    public void executeNewScheduleTask(Runnable runTask, int d, int l) {
        timed = true;
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {

                runTask.run();

            }
        }, d, l);
    }

    public void executeData(String fileName) {
        String cmd = "java -jar " + fileName;
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void executeNewScheduleTask(Runnable runTask, int d) {
        timed = true;
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {

                runTask.run();

            }
        }, d);
    }

}
