package com.h3xstream.retirejs.repo.dl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DefaultDownloader implements Downloader {


    @Override
    public void downloadUrlToFile(String url, File file) throws IOException {
        URL remoteRepo = new URL(url);
        URLConnection conn = remoteRepo.openConnection();
        conn.connect();
        InputStream in = conn.getInputStream();

        FileOutputStream out = new FileOutputStream(file);
        byte data[] = new byte[1024];
        int count;
        while((count = in.read(data,0,1024)) != -1)
        {
            out.write(data, 0, count);
            out.flush();
        }
        out.close();
    }
}
