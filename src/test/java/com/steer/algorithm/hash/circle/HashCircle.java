package com.steer.algorithm.hash.circle;

import com.steer.algorithm.hash.util.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * hash环
 */
public class HashCircle {
    private static Logger log = LoggerFactory.getLogger(HashCircle.class);

    /**
     * 集群地址
     */
    private static String[] groups = {"192.168.2.1:111","192.168.2.2:111","192.168.2.3:111","192.168.2.4:111","192.168.2.5:111"};

    /**
     * 用于保存hash环上的节点
     */
    private static SortedMap<Integer,String> sortedMap = new TreeMap<>();

    static {
        for (String group: groups) {
            int hash = HashUtil.getHash(group);
            log.info("group[{}] launched @ {}",group,hash);
            sortedMap.put(hash,group);
        }
    }

    /**
     * 计算对应的widget加载在哪个group上
     * @param widgetKey
     * @return
     */
    private static String getServer(String widgetKey){
        int hash = HashUtil.getHash(widgetKey);
        //取出大于该hash值的map部分
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if (subMap == null || subMap.isEmpty()){
            //应该映射到第一个group
            return sortedMap.get(sortedMap.firstKey());
        }
        //应该映射到取出map的第一个group上
        return subMap.get(subMap.firstKey());
    }

    /**
     * 缺点:容易发生数据倾斜，环上节点不均匀
     * @param args
     */
    public static void main(String[] args) {
        /**
         * key为server,value为落在该Server的节点个数
         */
        Map<String,Integer> resMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            //
            Integer widgetId = (int) (Math.random() * 10000);
            String server = getServer(widgetId.toString());
            if (resMap.containsKey(server)){
                resMap.put(server, resMap.get(server)+1);
            }else {
                resMap.put(server, 1);
            }
        }

        resMap.forEach(
            (k, v)->{
                log.info("group {}: {} ({}%)",k,v,v/1000.0D);
            }
        );

    }
}
