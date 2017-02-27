/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.demo.springbatch.csv;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chengchenrui
 * @version Id: CsvItemProcessor.java, v 0.1 2017.2.27 15:43 chengchenrui Exp $$
 */
@Component("csvItemProcessor")
public class CsvItemProcessor implements ItemProcessor<Student, Student> {

    /**
     * 对数据进行转换
     * @param item
     * @return
     * @throws Exception
     */
    public Student process(Student item) throws Exception {

        item.setName(item.getID() + "--" + item.getName());
        item.setAge(item.getAge() + 2);
        item.setScore(item.getScore() + 10);

        return item;
    }
}
