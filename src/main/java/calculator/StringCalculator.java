package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public Integer add(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String realText = matcher.group(2);
            String[] tokens = realText.split(delimiter + "|,|:");
            int result = 0;
            for (String token : tokens) {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new RuntimeException("음수는 불가능합니다");
                }
                result += number;
            }
            return result;
        }
        int result = 0;
        String[] tokens = text.split(",|:");
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
