
package com.cheng.springbatch.web.xml;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengchenrui
 * @version Id: XMLLaunch.java, v 0.1 2017.2.28 10:45 chengchenrui Exp $$
 */
public class XMLLaunch {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("xmlFileReadAndWriterJob");

        try {
            // JOB实行
            JobExecution result = launcher.run(job,
                new JobParametersBuilder().addString("inputFilePath", "D:\\input.xml")
                    .addString("outputFilePath", "D:\\output.xml").toJobParameters());
            // 运行结果输出
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
