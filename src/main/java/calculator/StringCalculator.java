package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        String[] tokens = toStringArray(text);
        int[] numbers = toIntArray(tokens);

        return sum(numbers);
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }


    private String[] toStringArray(String text) {
        String delimiter = ",|:";
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }
        return text.split(delimiter);
    }

    private int[] toIntArray(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            if (num < 0) {
                throw new RuntimeException("음수는 불가능합니다.");
            }
            total += num;
        }
        return total;
    }

}
