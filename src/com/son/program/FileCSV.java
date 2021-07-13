package com.son.program;

import com.son.DanhBa;

import java.io.*;
import java.util.ArrayList;

public class FileCSV {
    static File file = new File("danhba.csv");
    public static ArrayList<DanhBa> docFile(){
        ArrayList<DanhBa> list1 = new ArrayList<>();
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 4) {
                    list1.add(new DanhBa(str[0],str[1], str[2], str[3]));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list1;
    }

    public static void ghiFile(ArrayList<DanhBa> list){
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (DanhBa a: list) {
                bw.write(a.ghi());
                bw.newLine();
            }
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
