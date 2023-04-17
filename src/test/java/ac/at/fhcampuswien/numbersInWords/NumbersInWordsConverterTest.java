package ac.at.fhcampuswien.numbersInWords;

import ac.at.fhcampuswien.numbersInWords.exceptions.NumberConversionException;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class NumbersInWordsConverterTest {

    NumbersInWordsConverter numbersInWordsConverter = new NumbersInWordsConverter();

    @Test
    void should_create_class() {
        // Assert
        Assertions.assertNotNull(numbersInWordsConverter);
    }

    @Test
    void should_convert_one() {
        // Arrange
        int toConvert = 1;
        String expected = "one";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void should_not_convert_negative_one() {
        // Arrange
        int toConvert = -1;
        // Act
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    numbersInWordsConverter.convert(toConvert);
                },
                "Excepted convert() to throw exception, but it didn't"
        );
        Assertions.assertEquals("Number is not in the valid range (> 0 and < 999 999 999)", exception.getMessage());
    }

    @Test
    void should_not_convert_over_max() {
        // Arrange
        int toConvert = 1000000000;
        // Act + Assert
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    numbersInWordsConverter.convert(toConvert);
                },
                "Excepted convert() to throw exception, but it didn't"
        );
        Assertions.assertEquals("Number is not in the valid range (> 0 and < 999 999 999)", exception.getMessage());
    }

    @Test
    void should_convert_tenth_number() {
        // Arrange
        int toConvert = 10;
        String expected = "ten";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void should_convert_complex_tenth_number() {
        // Arrange
        int toConvert = 22;
        String expected = "twenty two";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void should_convert_hundredth_number() {
        // Arrange
        int toConvert = 200;
        String expected = "two hundred";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void should_convert_complex_hundredth_number() {
        // Arrange
        int toConvert = 275;
        String expected = "two hundred and seventy five";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void should_convert_complex_millionth_number() {
        // Arrange
        int toConvert = 1253126;
        String expected = "one million two hundred and fifty three thousand one hundred and twenty six";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void should_convert_max_number() {
        // Arrange
        int toConvert = 999999999;
        String expected = "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine";
        // Act
        String result = numbersInWordsConverter.convert(toConvert);
        // Assert
        Assertions.assertEquals(expected, result);
    }
}
