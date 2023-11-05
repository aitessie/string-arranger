package ru.ivanyakovlev.stringarranger.service;

import org.springframework.stereotype.Service;
import ru.ivanyakovlev.stringarranger.dto.StringArrangerDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StringArrangerService {

    public Map<Character, Long> arrangeString(StringArrangerDto dto) {
        String targetString = dto.getInputString();

        if (!dto.getIsCountSpace()) {
            targetString = targetString.replace(" ", "");
        }
        if (!dto.getIsCaseSense()) {
            targetString = targetString.toLowerCase();
        }

        Map<Character, Long> chars = new HashMap<>();
        for (char ch : targetString.toCharArray()) {
            if (chars.containsKey(ch)) {
                chars.put(ch, chars.get(ch) + 1);
            } else {
                chars.put(ch, 1L);
            }
        }
        return chars.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (entry1, entry2) -> {
                            throw new RuntimeException();
                        },
                        LinkedHashMap::new
                ));
    }
}
