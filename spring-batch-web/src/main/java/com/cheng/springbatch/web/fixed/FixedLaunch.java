/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.springbatch.web.fixed;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengchenrui
 * @version Id: FixedLaunch.java, v 0.1 2017.2.28 17:24 chengchenrui Exp $$
 */
public class FixedLaunch {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("fixedLengthJob");

        try {
            JobExecution result = launcher.run(job,
                new JobParametersBuilder()
                    .addString("inputFilePath", "D:\\fixedLengthInputFile.txt")
                    .addString("outputFilePath", "D:\\fixedLengthOutputFile.txt")
                    .toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
