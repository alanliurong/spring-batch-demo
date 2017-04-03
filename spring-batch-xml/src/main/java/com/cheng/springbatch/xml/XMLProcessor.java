package com.cheng.springbatch.xml;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chengchenrui
 * @version Id: XMLProcessor.java, v 0.1 2017.2.28 10:37 chengchenrui Exp $$
 */
@Component("xMLProcessor")
public class XMLProcessor implements ItemProcessor<Goods, Goods> {

    public Goods process(Goods item) throws Exception {
        // 购入日期变更
        item.setBuyDay(new Date());
        // 顾客信息变更
        item.setCustomer(item.getCustomer() + "顾客!");
        // ISIN变更
        item.setIsin(item.getIsin() + "IsIn");
        // 价格变更
        item.setPrice(item.getPrice() + 1000.112);
        // 数量变更
        item.setQuantity(item.getQuantity() + 100);
        // 处理后的数据返回
        return item;
    }
}
