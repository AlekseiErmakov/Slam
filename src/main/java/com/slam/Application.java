package com.slam;

import com.slam.application.SlamCli;

public class Application {
    public static void main(String[] args) {
        SlamCli slamCli = new SlamCli(args);
        slamCli.start();
    }
}
