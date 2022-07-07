package util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static String toString(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static <T> List<T> convert(T... arr) {
        int len = arr == null ? 0 : arr.length;
        List<T> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
