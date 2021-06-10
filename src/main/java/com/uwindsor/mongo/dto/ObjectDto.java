package com.uwindsor.mongo.dto;

import com.uwindsor.mongo.common.ErrorMessage;
import com.uwindsor.mongo.entity.ObjectActivity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ObjectDto {

    private String id;

    @NotEmpty(message = ErrorMessage.VALIDATION_INVALID_INPUT_EMPTY)
    private String value;

    @NotNull(message = ErrorMessage.VALIDATION_INVALID_INPUT_EMPTY)
    private ObjectActivity activity;

    private Instant createdAt;
}
