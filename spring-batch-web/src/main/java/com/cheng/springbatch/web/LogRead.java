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

    public static final Long             HOURS_1    = 3600000L;

    public static void main(String[] args) throws Exception {
        String path = "D:\\logTest.log";
        List logList = readeLog(path);
        Collections.sort(logList, Collections.reverseOrder());
        for (int i = 0, len = logList.size() - 1; i < len; i++) {
            Long timeDifference = (Long) logList.get(i) - (Long) logList.get(i + 1);
            if (timeDifference > MINUTES_30 && timeDifference < HOURS_1) {
                Date dateStart = new Date((Long) logList.get(i + 1));
                Date dateEnd = new Date((Long) logList.get(i));
                String resultStart = FORMAT.format(dateStart);
                String resultEnd = FORMAT.format(dateEnd);
                System.out.println(resultStart + "      " + resultEnd + "     " + timeDifference);
            }
        }

    }

    private static List readeLog(String path) {
        File file = new File(path);
        BufferedReader bufr = null;
        FileReader fileReader = null;
        List logList = new ArrayList();
        try {
            fileReader = new FileReader(file);
            bufr = new BufferedReader(fileReader);
            String tempString;
            while ((tempString = bufr.readLine()) != null) {
                String listString[] = tempString.split("- - \\u005B");
                Long time = FORMAT.parse(listString[1]).getTime();
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
