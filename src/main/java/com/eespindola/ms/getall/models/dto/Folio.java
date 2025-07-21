package com.eespindola.ms.getall.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Folio {

    @JsonProperty("folioRequest")
    private String folioRequest;

}
