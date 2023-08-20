package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class FileNameSorting {

    public static void main(String[] args) {

//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
//        String[] files = {"abcd123.zip", "abcd123.png", "a12312341234.zip", "aaa-12312", "aaaaa-1231233"};
//        String[] files = {"abab1", "abab123", "abab123123123123123", "abab123123"};
//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        String[] result = solution(files);

        System.out.println(Arrays.toString(result));
    }

    static String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String file1, String file2) {
                String head1, head2;        // HEAD는 최소 한 글자
                head1 = substringHead(file1);
                head2 = substringHead(file2);
//                System.out.println(">> " + file1);
//                System.out.println(">> " + file2);
//                System.out.println("head1: " + head1);
//                System.out.println("head2: " + head2);
                if (!head1.equals(head2)) {     // HEAD가 같지 않다면 NUMBER 비교 불필요
                    return head1.compareTo(head2);
                }

                String remain1 = file1.substring(head1.length());
                String remain2 = file2.substring(head2.length());
                String number1 = substringNumber(remain1);
                String number2 = substringNumber(remain2);

//                System.out.println("number1: " + number1);
//                System.out.println("number2: " + number2);

                if (Integer.parseInt(number1) != Integer.parseInt(number2)) {       // NUMBER가 같지 않다면 비교 필요
                    return Integer.parseInt(number1) - Integer.parseInt(number2);
                }

                return 0;
            }
        });

        return files;
    }

    static String substringHead(String file) {
        int index = -1;
        for (int i = 0; i < file.length(); i++) {
            if (file.charAt(i) > 47 && file.charAt(i) < 58) {
                index = i;
                break;
            }
        }

        return file.substring(0, index).toLowerCase();
    }

    static String substringNumber(String remain) {
        int index = -1;
        for (int i = 0; i < remain.length() && i < 5; i++) {
            if (remain.charAt(i) < 48 || remain.charAt(i) > 57) {
                index = i;
                break;
            }
            if (i == 4) {
                index = 5;
            }
        }
        if (index < 0) {
            return remain;
        }
        return remain.substring(0, index);
    }
}
