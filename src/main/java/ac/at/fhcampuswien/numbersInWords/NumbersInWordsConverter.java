package ac.at.fhcampuswien.numbersInWords;

public class NumbersInWordsConverter {
    private final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public String convert(int number) {
        // 0 to 999 999 999 999

        if (number < 0 || number > 999999999) {
            throw new IllegalArgumentException("Number is not in the valid range (> 0 and < 999 999 999)");
        }

        String result = "";
        if (number == 0) {
            result = "zero";
        } else if (number < 20) {
            result = units[number];
        } else if (number < 100) {
            result = tens[number / 10] + " " + units[number % 10];
        } else if (number < 1000) {
            result = units[number / 100] + " hundred";
            if (number % 100 != 0) {
                result += " and " + convert(number % 100);
            }
        } else if (number < 1000000) {
            result = convert(number / 1000) + " thousand";
            if (number % 1000 != 0) {
                if (number % 1000 < 100) {
                    result += " and";
                }
                result += " " + convert(number % 1000);
            }
        } else {
            result = convert(number / 1000000) + " million";
            if (number % 1000000 != 0) {
                if (number % 1000000 < 100) {
                    result += " and";
                }
                result += " " + convert(number % 1000000);
            }
        }
        return result;
    }
}
