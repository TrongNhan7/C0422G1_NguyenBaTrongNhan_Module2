package case_study.util;

import case_study.common.AgeCheckingExeption;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_STR = "^[A-Z][a-z]+";
    private static final String REGEX_VILLA = "^(SVVL)-\\d{4}$";
    private static final String REGEX_HOUSE = "^(SVHO)-\\d{4}$";
    private static final String REGEX_ROOM = "^(SVRO)-\\d{4}$";
    private static final String REGEX_AREA = "^([3-9][0-9]\\.*\\d*|\\d{3,}\\.*\\d*)$";
    private static final String REGEX_RENTALCOSTS = "^\\d+\\.*\\d*$";
    private static final String REGEX_MAXPEOPLE = "^([1-9]|1[0-9])$";
    private static final String REGEX_FLOORS = "^\\d+$";
    private static final String REGEX_NUMBER = "^\\d+$";
    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]|3[0|1])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
    private static final String REGEX_GMAIL = "^\\w+@(\\w+\\.)+\\w+$";

    public static final String REGEX_PHONE = "^\\d{10}$";
    public static final String REGEX_IDCARD = "^([A-Z0-9]{9}|[A-Z0-9]{12})$";
    private static final String REGEX_NAME = "^[A-Z][a-z]{0,10}(\\s[A-Z][a-z]{0,10}){0,5}$";

    public static String regexStr(String temp, String regex, String error) {
        boolean flag = true;
        do {
            if (temp.matches(regex)) {
                flag = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (flag);
        return temp;
    }


    public static String regexBirthday(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                        break;
                    } else {
                        throw new AgeCheckingExeption("Tu???i ph???i l???n h??n 18 v?? b?? h??n 100");
                    }
                } else {
                    throw new AgeCheckingExeption("?????nh d???ng nh???p v??o kh??ng ????ng");
                }
            } catch (AgeCheckingExeption e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }


    public static String inputNameService() {
        System.out.println("Nh???p t??n d???ch v???: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_NAME, "B???n ???? nh???p sai t??n d???ch v???, t??n ko v?????t qu?? 20 k?? t???!");
    }
    public static String inputName() {
        System.out.println("Nh???p t??n d???ch v???: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_NAME, "B???n ???? nh???p sai t??n ?????nh d???ng, t??n ko v?????t qu?? 20 k?? t???!");
    }
    public static String inputIdVilla() {
        System.out.println("Nh???p m?? d???ch v???: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_VILLA, "B???n ???? nh???p sai m?? d???ch v???, Villa l?? SVVL-XXXX!");
    }

    public static String inputIdHouse() {
        System.out.println("Nh???p m?? d???ch v???: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_HOUSE, "B???n ???? nh???p sai m?? d???ch v???!,House l?? SVHO-XXXX!");
    }

    public static String inputIdRoom() {
        System.out.println("Nh???p m?? d???ch v???: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_ROOM, "B???n ???? nh???p sai m?? d???ch v???!,Room l?? SVRO-XXXX!");
    }

    public static String inputArea() {
        System.out.println("Nh???p di???n t??ch d???ch v???: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_AREA, "B???n ???? nh???p sai di???n t??ch d???ch v???!, di???n t??ch l???n h??n 30m2");
    }

    public static String inputRentalCosts() {
        System.out.println("Nh???p m?? gi?? thu??: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_RENTALCOSTS, "B???n ???? nh???p sai gi?? thu??!, ph???i l?? s??? d????ng");
    }

    public static String inputPepple() {
        System.out.println("Nh???p s??? ng?????i thu??: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_MAXPEOPLE, "B???n ???? v?????t qu?? s??? ng?????i dc thu??!, s??? ng?????i dc thu?? < 20");
    }

    public static String inputRentalType() {
        System.out.println("Nh???p ki???u thu??");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, ki???u thu?? ph???i vi???t hoa ch??? c??i ?????u");
    }

    public static String inputStandard() {
        System.out.println("Nh???p ti??u chu???n");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, ti??u chu???n ph???i vi???t hoa ch??? c??i ?????u");
    }

    public static String inputPool() {
        System.out.println("Nh???p di???n t??ch h??? b??i: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_AREA, "B???n ???? nh???p sai di???n t??ch h??? b??i!,di???n t??ch l???n h??n 30m2");
    }

    public static String inputFloors() {
        System.out.println("Nh???p s??? t???ng: ");
        return Regex.regexStr(scanner.nextLine(), REGEX_FLOORS, "B???n ???? nh???p sai s??? t???ng!");
    }

    public static String inputServiceFree() {
        System.out.println("Nh???p d???ch v??? mi???n ph??:");
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, ti??u chu???n ph???i vi???t hoa ch??? c??i ?????u");
    }

    public static String inputNumber() {
        return Regex.regexStr(scanner.nextLine(), REGEX_NUMBER, "B???n ???? nh???p sai, xin h??y nh???p s???!");
    }

    public static String inputNumberDouble() {
        return Regex.regexStr(scanner.nextLine(), REGEX_RENTALCOSTS, "B???n ???? nh???p sai, xin h??y nh???p s???!");
    }

    public static String inputBirthday() {
        System.out.println("Nh???p ng??y th??ng n??m sinh:");
        return Regex.regexBirthday(scanner.nextLine(), REGEX_BIRTHDAY);
    }

    public static String inputServiceType() {
        return Regex.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, ki???u d???ch v??? ph???i vi???t hoa ch??? c??i ?????u");
    }

    public static String inputMail() {
        System.out.println("Nh???p mail:");
        return Regex.regexStr(scanner.nextLine(), REGEX_GMAIL, "B???n ???? nh???p sai ?????nh d???ng");
    }

    public static String inputPhone() {
        System.out.println("Nh???p so Phone:");
        return Regex.regexStr(scanner.nextLine(), REGEX_PHONE, "B???n ???? nh???p sai ?????nh d???ng");
    }

    public static String inputIdCard() {
        System.out.println("Nh???p ch???ng minh:");
        return Regex.regexStr(scanner.nextLine(), REGEX_IDCARD, "B???n ???? nh???p sai ?????nh d???ng");
    }

}
