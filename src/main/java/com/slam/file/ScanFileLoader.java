package com.slam.file;

import java.io.InputStream;
import java.util.List;

public interface ScanFileLoader {
    List<String> loadScan(InputStream inputStream);
}
