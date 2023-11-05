package ru.ivanyakovlev.stringarranger.service;

import org.junit.jupiter.api.Test;
import ru.ivanyakovlev.stringarranger.dto.StringArrangerDto;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class StringArrangerServiceTest {

    private final static String TEST_STRING = "Test of arranging string 123123 342 = - + @ /.";

    private final StringArrangerService service = new StringArrangerService();

    @Test
    void checkStringWithSpacesAndWithCaseSense() {
        StringArrangerDto dto = new StringArrangerDto(TEST_STRING, true, true);

        Map<Character, Long> actual = service.arrangeString(dto);
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put(' ', 10L);
        expected.put('g', 3L);
        expected.put('n', 3L);
        expected.put('r', 3L);
        expected.put('2', 3L);
        expected.put('3', 3L);
        expected.put('a', 2L);
        expected.put('i', 2L);
        expected.put('1', 2L);
        expected.put('s', 2L);
        expected.put('t', 2L);
        expected.put('@', 1L);
        expected.put('e', 1L);
        expected.put('f', 1L);
        expected.put('+', 1L);
        expected.put('-', 1L);
        expected.put('.', 1L);
        expected.put('o', 1L);
        expected.put('/', 1L);
        expected.put('T', 1L);
        expected.put('4', 1L);
        expected.put('=', 1L);

        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual).isEqualTo(expected);
        asserThatOrderIsRight(actual);
    }

    @Test
    void checkStringWithSpacesAndWithoutCaseSense() {
        StringArrangerDto dto = new StringArrangerDto(TEST_STRING, true, false);

        Map<Character, Long> actual = service.arrangeString(dto);
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put(' ', 10L);
        expected.put('g', 3L);
        expected.put('n', 3L);
        expected.put('r', 3L);
        expected.put('t', 3L);
        expected.put('2', 3L);
        expected.put('3', 3L);
        expected.put('a', 2L);
        expected.put('i', 2L);
        expected.put('1', 2L);
        expected.put('s', 2L);
        expected.put('@', 1L);
        expected.put('e', 1L);
        expected.put('f', 1L);
        expected.put('+', 1L);
        expected.put('-', 1L);
        expected.put('.', 1L);
        expected.put('o', 1L);
        expected.put('/', 1L);
        expected.put('4', 1L);
        expected.put('=', 1L);

        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual).isEqualTo(expected);
        asserThatOrderIsRight(actual);
    }

    @Test
    void checkStringWithoutSpacesAndWithCaseSense() {
        StringArrangerDto dto = new StringArrangerDto(TEST_STRING, false, true);

        Map<Character, Long> actual = service.arrangeString(dto);
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('g', 3L);
        expected.put('n', 3L);
        expected.put('r', 3L);
        expected.put('2', 3L);
        expected.put('3', 3L);
        expected.put('a', 2L);
        expected.put('i', 2L);
        expected.put('1', 2L);
        expected.put('s', 2L);
        expected.put('t', 2L);
        expected.put('@', 1L);
        expected.put('e', 1L);
        expected.put('f', 1L);
        expected.put('+', 1L);
        expected.put('-', 1L);
        expected.put('.', 1L);
        expected.put('o', 1L);
        expected.put('/', 1L);
        expected.put('T', 1L);
        expected.put('4', 1L);
        expected.put('=', 1L);

        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual).isEqualTo(expected);
        asserThatOrderIsRight(actual);
    }

    @Test
    void checkStringWithoutSpacesAndWithoutCaseSense() {

        StringArrangerDto dto = new StringArrangerDto("Test of arranging string 123123 342 = - + @ /.", false, false);

        Map<Character, Long> actual = service.arrangeString(dto);
        Map<Character, Long> expected = new LinkedHashMap<>();
        expected.put('g', 3L);
        expected.put('n', 3L);
        expected.put('r', 3L);
        expected.put('t', 3L);
        expected.put('2', 3L);
        expected.put('3', 3L);
        expected.put('a', 2L);
        expected.put('i', 2L);
        expected.put('1', 2L);
        expected.put('s', 2L);
        expected.put('@', 1L);
        expected.put('e', 1L);
        expected.put('f', 1L);
        expected.put('+', 1L);
        expected.put('-', 1L);
        expected.put('.', 1L);
        expected.put('o', 1L);
        expected.put('/', 1L);
        expected.put('4', 1L);
        expected.put('=', 1L);

        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual).isEqualTo(expected);
        asserThatOrderIsRight(actual);
    }

    private void asserThatOrderIsRight(Map<Character, Long> actual) {
        Iterator<Map.Entry<Character, Long>> iterator = actual.entrySet().iterator();
        Long previous = null;
        while (iterator.hasNext()) {
            Long current = iterator.next().getValue();
            if (previous != null) {
                assertThat(previous).isGreaterThanOrEqualTo(current);
            }
            previous = current;
        }
    }
}
