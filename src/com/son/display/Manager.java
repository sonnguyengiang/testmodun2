package com.son.display;

import com.son.program.matcher.add.Add;

import java.util.Scanner;

public class Manager {
    public void Menu() {
        Add add = new Add();
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("------Menu------");
                System.out.println("1. Hiện thị thông tin");
                System.out.println("2. Thêm danh bạ mới");
                System.out.println("3. Cập nhập danh bạ");
                System.out.println("4. Xóa danh bạ");
                System.out.println("5. Tìm kiêm");
                System.out.println("6. Đọc File");
                System.out.println("7. Ghi File");
                System.out.println("0. Exit");
                System.out.print("Nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        add.show();
                        break;
                    case 2:
                        add.adddanhba();
                        break;
                    case 3:
                        add.update();
                        break;
                    case 4:
                        add.remove();
                        break;
                    case 5:
                        add.find();
                        break;
                    case 6:
                        add.docFile();
                        break;
                    case 7:
                        add.ghiFile();
                        break;
                    case 0:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }
}

