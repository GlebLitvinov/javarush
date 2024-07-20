package com.home.whatever;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    public static Stream<Arguments> dupicates() {
        return Stream.of(
                Arguments.arguments(new String[]{"Hello", "Hello", "World", "Java", "Tasks", "World"},
                        new String[]{null, null, null, "Java", "Tasks", null}),
                Arguments.arguments(new String[]{"Hello", "Hello", "Hello"},
                        new String[]{null, null, null})
        );
    }

    public static Stream<Arguments> countElements() {
        return Stream.of(
                Arguments.arguments("Hello", new String[]{"Hello", "Hello", "World", "Java", "Tasks", "World"}, 2),
                Arguments.arguments("Sisya", new String[]{"Hello", "Hello", "Hello"}, 0),
                Arguments.arguments("Sisya", new String[]{"Hello", "Hello", null}, 0),
                Arguments.arguments(null, new String[]{"Hello", "Hello", "Hello"}, 0),
                Arguments.arguments("Hello", new String[]{"Hello", "Hello", "Hello"}, 3)
        );
    }

    public static Stream<Arguments> nullReplaces() {
        return Stream.of(
                Arguments.arguments("World", new String[]{"Hello", "Hello", "World", "Java", "Tasks", "World"},
                        new String[]{"Hello", "Hello",null, "Java", "Tasks", null}),
                Arguments.arguments("Hello", new String[]{"Hello", "Hello", "Hello"},
                        new String[]{null, null, null}),
                Arguments.arguments("Sisya", new String[]{"Hello", "Hello", "Hello"},
                        new String[]{"Hello", "Hello", "Hello"}),
                Arguments.arguments(null, new String[]{"Hello", "Hello", "Hello"},
                        new String[]{"Hello", "Hello", "Hello"})
        );
    }

    @ParameterizedTest
    @MethodSource("dupicates")
    void testRemoveDuplicates(String[] input, String[] output) {
        var result = solution.removeDuplicates(input);
        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @MethodSource("dupicates")
    void testRemoveDuplicatesShort(String[] input, String[] output) {
        var result = solution.removeDuplicatesShort(input);
        assertThat(result).isEqualTo(output);
    }


    @ParameterizedTest
    @MethodSource("countElements")
    void testCountElementsInArrayEqualToString(String element, String[] array, int expectedCount) {
        var result = solution.countElementsInArrayEqualToString(element, array);
        assertThat(result).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @MethodSource("nullReplaces")
    void testReplaceElementWithNull(String element, String[] inputArray, String[] expectedArray) {
        solution.replaceElementWithNull(element, inputArray);
        assertThat(inputArray).isEqualTo(expectedArray);
    }
}