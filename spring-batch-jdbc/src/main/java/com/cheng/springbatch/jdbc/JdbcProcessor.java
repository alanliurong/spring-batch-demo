package com.cheng.springbatch.jdbc;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chengchenrui
 * @version Id: JdbcProcessor.java, v 0.1 2017.3.8 15:00 chengchenrui Exp $$
 */
@Component("jdbcProcessor")
public class JdbcProcessor implements ItemProcessor<User,User>{

    public User process(User item) throws Exception {

        item.setUpdateTime(new Date());
        item.setUpdateUser("ADMIN");

        return item;
    }
}
