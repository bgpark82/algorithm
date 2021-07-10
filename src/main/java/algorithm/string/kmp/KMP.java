package algorithm.string.kmp;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    
    public static void main(String[] args) {
        List<Integer> ans = search("egbabcabcwerabc", "abcabc");
        ans.forEach(System.out::println);
    }

    static int[] kmpr(String ptn) {
        int size = ptn.length();
        int[] arr = new int[size+1];
        arr[0] = -1;
        arr[1] = 0;
        
        // 패턴의 1번 인덱스 부터 끝까지 검색 (1~끝)
        int index = 1;
        // 만약 검색 도중 같은 문자가 있으면 다음 인덱스로 이동 (0)
        int count = 0;

        while(index < size) {
            if(ptn.charAt(index) == ptn.charAt(count)) {
                arr[index] = count;
                index++; count++;
            } else {
                index++;
                arr[index] = 0;
            }   
        }

        return arr;
    }

    static int[] kmp(String pattern) {
        int p = pattern.length();

        int[] arr = new int[p+1];
        arr[0] = -1;
        arr[1] = 0;

        int count = 0;
        int i = 1;

        while(i < p) {
            // countfix의 길이 지점의 문자와 패턴의 문자가 같은 경우
            if(pattern.charAt(count) == pattern.charAt(i)) {
                arr[i] = count;
                count++; i++;
            // 같은 패턴이 있는 경우
            } else if(count > 0) {
                count = arr[count];
            // 매칭이 안될 경우 유효한 범위라면 0으로 초기화 
            } else {
                i++;
                arr[i] = 0;
            }
        }

        return arr;
    }

    static List<Integer> search(String txt, String pattern) {
        int t = 0;
        int p = 0;

        int tlen = txt.length();
        int plen = pattern.length();

        List<Integer> matches = new ArrayList<>();

        int[] arr = kmp(pattern);

        while(t < tlen) {
            // pattern과 txt의 각 문자 비교
            if(pattern.charAt(p) == txt.charAt(t)) {
                p++;
                t++;

                if(p == plen) {
                    matches.add(t - p);
                    p = arr[p];
                }
            } else {
                p = arr[p];
                if(p < 0) {
                    t++;
                    p++;
                }
            }
        }

        return matches;
    }    


}
