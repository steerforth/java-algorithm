package com.steer.algorithm.stream;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileTest {

    @Test
    public void test(){
        String inPath = "C:\\Users\\1\\Desktop\\a.txt";
        String outPath = "C:\\Users\\1\\Desktop\\b.txt";
        try (FileInputStream in = new FileInputStream(inPath);
             FileOutputStream out = new FileOutputStream(outPath);){
            byte [] buffer = new byte[1024];
            int byteRead = -1;
            while ((byteRead = in.read(buffer)) != -1){
                out.write(buffer,0,byteRead);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2(){
        String inPath = "C:\\Users\\1\\Desktop\\a.txt";
        String outPath = "C:\\Users\\1\\Desktop\\b.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(inPath));
             BufferedWriter out = new BufferedWriter(new FileWriter(outPath));){
             String line = null;
             while ((line = in.readLine()) != null){
                 out.write(line+"\n");
             }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
