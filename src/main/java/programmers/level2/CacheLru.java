package programmers.level2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CacheLru {

    /**
     * 계속 프로그래머스 제출 했을 시에 90점이 나왔다.
     * 대체 뭐가 문제일까 싶어서 찾아보니,
     * cacheSize가 0일 때, cache miss 처리가 제대로 되고 있지 않았다.
     * 앞으로 이와 비슷한 문제를 풀 때 예외를 처리하는 부분에서
     * 크기가 0으로 주어질 때를 잘 생각해봐야겠다.
     */
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cacheSize = 0;
        String[] cities = {"la", "la"};

        int result = solution(cacheSize, cities);

        bw.write(Integer.toString(result));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static int solution(int cacheSize, String[] cities) {

        int result = 0;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        List<String> cache = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            if (!checkCacheHitOrMiss(cache, city)) {        // cache miss
                result += 5;
                addCityWhenCacheMiss(cache, city, cacheSize);
                continue;
            }
            // cache hit
            result += 1;
            addCityWhenCacheHit(cache, city);
        }

        return result;
    }

    public static void addCityWhenCacheHit(List<String> cache, String city) {
        int index = cache.indexOf(city);
        cache.remove(index);
        cache.add(city);
    }

    public static void addCityWhenCacheMiss(List<String> cache, String city, int cacheSize) {
        if (cache.isEmpty()) {
            if (cacheSize == 0) {
                return;
            }
            cache.add(city);
            return;
        }
        if (cache.size() < cacheSize) {
            cache.add(city);
            return;
        }
        cache.remove(0);
        cache.add(city);
    }

    public static boolean checkCacheHitOrMiss(List<String> cache, String city) {
        if (!cache.contains(city)) {
            return false;
        }
        return true;
    }
}
