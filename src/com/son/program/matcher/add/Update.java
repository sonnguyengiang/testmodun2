package com.son.program.matcher.add;

import com.son.display.DanhBa;

import java.util.ArrayList;
import java.util.Scanner;

import com.son.display.GmailMatcher;
import com.son.display.PhoneNumberMatcher;

public class Update {
    Add add = new Add();
    ArrayList<DanhBa> list = add.list;
    Scanner scanner = new Scanner(System.in);
    ArrayList<DanhBa> temp = new ArrayList<>();

    public DanhBa update123(){
        String name = getName();
        String phonenumber = getPhoneNumber();
        String address = getAddress();
        String gmail = getGmail();
        return new DanhBa(name,phonenumber,address,gmail);
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
                } else if (temp.get(0).getPhonenumber().equals(phonenumber)){
                    return phonenumber;
                }
                else {
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
                }  else if (temp.get(0).getGmail().equals(gmail)){
                    return gmail;
                }
                else {
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
