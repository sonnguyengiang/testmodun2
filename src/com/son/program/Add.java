package com.son.program;

import com.son.DanhBa;

import com.son.program.matcher.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Add{
    private Scanner scanner = new Scanner(System.in);
    public ArrayList<DanhBa> list = new ArrayList<>();

    public void show(){
        for (DanhBa a: list) {
            System.out.println(a);
        }
    }

    public void update(){
        Update update = new Update();
        System.out.print("Nhập số điện thoại: ");
        String phonenumber = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhonenumber().equals(phonenumber)){
                list.set(i,update.update123());
                break;
            }
        }
    }

    public void find(){
        System.out.print("Nhập số điện thoại: ");
        String phonenumber = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(phonenumber)){
                System.out.println(list.get(i));
                break;
            }
        }
    }

    public void adddanhba(){
        list.add(creat());
    }

    private DanhBa creat(){
        String name = getName();
        String phonenumber = getPhoneNumber();
        String address = getAddress();
        String gmail = getGmail();
        return new DanhBa(name,phonenumber,address,gmail);
    }

    public void remove(){
        System.out.print("Nhập số điện thoại: ");
        String phonenumber = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhonenumber().equals(phonenumber)){
                list.remove(i);
                break;
            }
        }
    }

    public void ghiFile(){
        FileCSV.ghiFile(list);
    }
    public void docFile(){
        list = FileCSV.docFile();
    }

    private String getName(){
        System.out.print("Nhập tên: ");
        return scanner.nextLine();
    }

    private String getPhoneNumber() {
        while (true) {
            int check = -1;
            PhoneNumberMatcher phoneNumberMatcher = new PhoneNumberMatcher();
            System.out.print("Nhập số điện thoại(0XXXXXXXXXX): ");
            String phonenumber = scanner.nextLine();
            if (phoneNumberMatcher.validate(phonenumber) == true) {
                if (list.size()==0){
                    return phonenumber;
                }else {
                    for (DanhBa a : list) {
                        if (a.getPhonenumber().equals(phonenumber)) {
                            check = -1;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0){
                        return phonenumber;
                    } else {
                        System.out.println("số điện thoại bị trùng");
                    }

                }
            } else {
                System.out.println("Số điện thoại đang bị thừa hoặc thiếu!");
            }
        }
    }

    private String getAddress(){
        System.out.print("Nhập địa chỉ: ");
        return scanner.nextLine();
    }

    private String getGmail() {
        while (true) {
            int check = -1;
            GmailMatcher gmailMatcher = new GmailMatcher();
            System.out.print("Nhập gmail: ");
            String gmail = scanner.nextLine();
            if (gmailMatcher.validate(gmail) == true) {
                if (list.size() == 0){
                    return gmail;
                } else {
                    for (DanhBa a : list) {
                        if (a.getGmail().equals(gmail)) {
                            check = -1;
                            break;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0) {
                        return gmail;
                    } else {
                        System.out.println("gmail bị trùng");
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Nhập lại");
            }
        }
    }
}
