package com.cheng.springbatch.fixed;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chengchenrui
 * @version Id: FixedLengthProcessor.java, v 0.1 2017.2.28 17:21 chengchenrui Exp $$
 */
@Component("fixedLengthProcessor")
public class FixedLengthProcessor implements ItemProcessor<Student, Student> {

    public Student process(Student item) throws Exception {
        item.setName(item.getID() + "--" + item.getName());
        item.setAge(item.getAge() + 2);
        item.setScore(item.getScore() + 10);
        return item;
    }
}
