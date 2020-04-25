package com.steer.algorithm.interview;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * cat /home/admin/logs/webx.log | grep "Login" | uniq -c | sort -nr
 * 翻译:
 * 过滤每行  然后统计含Login相同行的个数  然后倒序输出
 *
 */
public class TestA {
    public static void main(String[] args) {
        File file = new File("/Users/steer/Desktop/test.txt");
        final String searchStr = "Login";
        Map<String, Integer> container = new HashMap<>(16);
        try (BufferedReader fr = new BufferedReader(new FileReader(file))){
            for (;;){
                String line = fr.readLine();
                if (line == null){
                    break;
                }
                grepAndCount(line,searchStr,container);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        desSortAndPrint(container);
    }

    private static void grepAndCount(String line, String searchStr, Map<String, Integer> container) {
        if (line != null){
            if (line.indexOf(searchStr) >=0){
                if (container.containsKey(line)){
                    container.put(line,container.get(line) + 1);
                }else {
                    container.put(line,1);
                }
            }
        }
    }

    private static void desSortAndPrint(Map<String, Integer> container) {
        container.entrySet().stream().sorted((a,b)->{
            if (a.getValue() == b.getValue()){
                return b.getKey().compareTo(a.getKey());
            }else{
                return b.getValue().compareTo(a.getValue());
            }
        }).forEach(e ->System.out.println(e.getValue()+ " " + e.getKey()));
    }
}
