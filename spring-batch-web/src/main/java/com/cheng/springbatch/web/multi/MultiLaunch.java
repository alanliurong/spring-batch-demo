package com.cheng.springbatch.web.multi;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chengchenrui
 * @version Id: multi.java, v 0.1 2017.3.3 16:25 chengchenrui Exp $$
 */
public class MultiLaunch {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("multiTypeSingleFileJob");

        try {
            // JOB实行
            JobExecution result = launcher.run(job,
                new JobParametersBuilder()
                    .addString("inputFilePath", "D:\\testData\\multiTypesInput.txt")
                    .addString("outputFilePathStudent", "D:\\testData\\student.txt")
                    .addString("outputFilePathGoods", "D:\\testData\\goods.csv").toJobParameters());
            // 运行结果输出
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
