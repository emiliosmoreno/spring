package com.emiliosmoreno.springboot.command.core;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamConsumer extends Thread {

    private InputStream is;

    public InputStreamConsumer(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {

        try {
            int value = -1;
            while ((value = is.read()) != -1) {
                System.out.print((char)value);
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }

    }

}
