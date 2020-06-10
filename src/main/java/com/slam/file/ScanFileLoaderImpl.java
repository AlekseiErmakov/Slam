package com.slam.file;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ScanFileLoaderImpl implements ScanFileLoader {

    @Override
    @SneakyThrows
    public List<String> loadScan(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> data = new ArrayList<>();
        while (reader.ready()) {
            data.add(reader.readLine());
        }
        return data;
    }
}
