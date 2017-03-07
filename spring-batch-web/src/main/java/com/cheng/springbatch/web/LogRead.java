/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.springbatch.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author chengchenrui
 * @version Id: LogRead.java, v 0.1 2017.3.3 9:18 chengchenrui Exp $$
 */
public class LogRead {

    public static final SimpleDateFormat FORMAT     = new SimpleDateFormat("d/MMM/yyyy:HH:mm:ss",
        Locale.ENGLISH);
    public static final Long             MINUTES_30 = 1800000L;

    public static void main(String[] args) throws Exception {
        String path = "E:\\code\\spring-batch-demo\\spring-batch-web\\src\\logTest.log";
        List<Long> logList = readeLog(path);
        Collections.sort(logList);
        List<Integer> index = new ArrayList<Integer>();
        for (int i = 0, len = logList.size() - 1; i < len; i++) {
            //Date date = new Date(logList.get(i));
            //System.out.println(FORMAT.format(date));

            Long timeDifference = Math.abs(logList.get(i) - logList.get(i + 1));
            if (timeDifference < MINUTES_30) {
                index.add(i);
            }
            if (timeDifference >= MINUTES_30 && !index.isEmpty()) {
                Date dateStart = new Date(logList.get(index.get(0)));
                Date dateEnd = new Date(logList.get(i));
                String resultStart = FORMAT.format(dateStart);
                String resultEnd = FORMAT.format(dateEnd);
                Long timeResult = logList.get(i) - logList.get(index.get(0));
                index.clear();
                System.out.println(resultStart + "      " + resultEnd + "     " + timeResult);
            }
        }

    }

    private static List<Long> readeLog(String path) {
        File file = new File(path);
        BufferedReader bufr = null;
        FileReader fileReader = null;
        List<Long> logList = new ArrayList<Long>();

        try {
            fileReader = new FileReader(file);
            bufr = new BufferedReader(fileReader);
            String tempString;
            while ((tempString = bufr.readLine()) != null) {
                final int first = tempString.indexOf("[");
                final int last = tempString.indexOf("+0800]");
                Long time = FORMAT.parse(tempString.substring(first + 1, last).trim()).getTime();
                logList.add(time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufr != null) {
                try {
                    bufr.close();
                } catch (IOException e1) {

                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e1) {

                }
            }
            return logList;
        }
    }
}
