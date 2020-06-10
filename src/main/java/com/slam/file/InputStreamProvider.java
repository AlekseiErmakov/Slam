package com.slam.file;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamProvider {

    @SneakyThrows
    public InputStream getFileInputStream(String filename){
        File file = new File(filename);
        InputStream stream = new FileInputStream(file);
        return stream;
    }
}
