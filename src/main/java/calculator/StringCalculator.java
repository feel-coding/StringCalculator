package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public Integer add(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        String delimiter = ",|:";
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }
        int result = 0;
        String[] tokens = text.split(delimiter);
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수는 불가능합니다");
            }
            result += number;
        }
        return result;
    }

}
