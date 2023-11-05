package ru.ivanyakovlev.stringarranger.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanyakovlev.stringarranger.dto.StringArrangerDto;
import ru.ivanyakovlev.stringarranger.service.StringArrangerService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StringArrangerController {

    private final StringArrangerService service;

    @PostMapping("/string-arranger")
    public Map<Character, Long> arrangeString(@RequestBody @Valid StringArrangerDto dto) {
        return service.arrangeString(dto);
    }
}
