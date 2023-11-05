package ru.ivanyakovlev.stringarranger.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StringArrangerDto {

    @NotNull
    private String inputString;

    private Boolean isCountSpace = true;

    private Boolean isCaseSense = true;
}
