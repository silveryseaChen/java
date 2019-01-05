package com.chy.io;

import com.sun.nio.file.ExtendedCopyOption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by chy on 2018/12/28.
 */
public class NIOTest {

    public static void main(String[] args) throws IOException {
        copy("/data/1.txt", "/data/copy/1.txt");
    }

    /**
     * copy 文件
     * @param source
     * @param target
     * @throws IOException
     */
    public static void copy(String source, String target) throws IOException {

        Path s = Paths.get(source);
        if(Files.notExists(s)){
            System.out.println(String.format("%s文件不存在", s));
            return;
        }
        Path t = Paths.get(target);
        Path tDir = t.getParent();
        if(Files.notExists(tDir)){
            Files.createDirectories(tDir);
            System.out.println(String.format("创建目录-->%s", tDir));
        }
        // REPLACE_EXISTING 替换已存在文件
        Files.copy(s, t, StandardCopyOption.REPLACE_EXISTING, ExtendedCopyOption.INTERRUPTIBLE);
    }

}
