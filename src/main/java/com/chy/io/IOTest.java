package com.chy.io;

import java.io.*;

/**
 * Created by chy on 2019/1/5.
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        copy("/data/2.txt", "/data/copy/1.txt");
    }

    public static void copy(String source, String target) throws IOException {

        File s = new File(source);
        if(!s.exists()){
            System.out.println(String.format("%s文件不存在", s));
            return;
        }
        File t = new File(target);
        File tDir = t.getParentFile();
        if(!tDir.exists()){
            tDir.mkdirs();
            System.out.println(String.format("创建目录-->%s", tDir));
        }
//        FileUtils.copyFile(s, t);       //commons-io.jar 2.6版本使用了 channel

        try(FileInputStream reader = new FileInputStream(s);
            FileOutputStream writer = new FileOutputStream(t)) {

            byte[] buffer = new byte[1024];
            while (reader.read(buffer) > 0) {
                writer.write(buffer);
            }
            writer.flush();
        }

    }

}
