package com.steer.algorithm.hash.circle;

import com.steer.algorithm.hash.util.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * hash环带虚拟节点
 */
public class HashCircleWithVirtualNode {
    private static Logger log = LoggerFactory.getLogger(HashCircleWithVirtualNode.class);

    /**
     * 集群地址
     */
    private static String[] groups = {"192.168.2.1:111","192.168.2.2:111","192.168.2.3:111","192.168.2.4:111","192.168.2.5:111"};
    /**
     * 真实集群列表
     */
    private static List<String> realGroups = new LinkedList<>();

    /**
     * 虚拟节点映射关系
     */
    private static SortedMap<Integer,String> virtualNodes = new TreeMap<>();
    /**
     * 每个server映射的虚拟节点个数
     */
    private static final int VIRTUAL_NODE_NUM = 1000;

    static {
        realGroups.addAll(Arrays.asList(groups));
        //虚拟节点映射到hash环上
        for (String realGroup: realGroups) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                String virtualNodeName = getVirtualNodeName(realGroup, i);
                int hash = HashUtil.getHash(virtualNodeName);
//                log.info("[{}] launched @ {}",virtualNodeName,hash);
                virtualNodes.put(hash,virtualNodeName);
            }
        }
    }

    private static String getVirtualNodeName(String realName,int num){
        return realName+"&&VN"+String.valueOf(num);
    }

    private static String getRealNodeName(String virtualName){
        return virtualName.split("&&")[0];
    }

    private static String getServer(String widgetKey){
        int hash = HashUtil.getHash(widgetKey);
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String virualNodeName;
        if (subMap == null || subMap.isEmpty()){
            virualNodeName = virtualNodes.get(virtualNodes.firstKey());
        }else{
            virualNodeName = subMap.get(subMap.firstKey());
        }
        return getRealNodeName(virualNodeName);
    }

    public static void printServerDistribution(List<Integer> widgetIds){
        /**
         * key为server,value为落在该Server的节点个数
         */
        Map<String,Integer> resMap = new HashMap<>();
        for (Integer widgetId:widgetIds) {
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


    public static void refreshHashCircle(){
        virtualNodes.clear();
        for (String realGroup:realGroups) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                String virtualNodeName = getVirtualNodeName(realGroup, i);
                int hash = HashUtil.getHash(virtualNodeName);
//                log.info("[{}] launched @ {}",virtualNodeName,hash);
                virtualNodes.put(hash,virtualNodeName);
            }
        }
    }

    private static void addGroup(String server){
        realGroups.add(server);
        refreshHashCircle();
    }

    private static void removeGroup(String server){
        int i = 0;
        Iterator<String> iterator = realGroups.iterator();
        while (iterator.hasNext()){
            String group = iterator.next();
            if (group.equals(server)){
                iterator.remove();
            }
            i++;
        }
        refreshHashCircle();
    }

    /**
     * 优点: 扩容缩容期间不会产生大面积的缓存失效
     *      缩容扩容之后都能使数据分布比较均匀
     * 缺点:
     * @param args
     */
    public static void main(String[] args) {


        //存储的数据集合
        List<Integer> list = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            Integer widgetId = (int) (Math.random() * 10000);
            list.add(widgetId);
        }

        printServerDistribution(list);
        //扩容缩容后每个server节点均衡的增加或减少了数据,压力转移很均匀
        log.info("==============集群扩容===============");
        addGroup("192.168.2.6:111");
        printServerDistribution(list);

        log.info("==============集群缩容===============");
        removeGroup("192.168.2.1:111");
        printServerDistribution(list);
    }

}
