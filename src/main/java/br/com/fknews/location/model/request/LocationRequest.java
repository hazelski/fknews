package br.com.fknews.location.model.request;

import br.com.fknews.location.model.dto.LocationTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {

    @NotBlank
    private String name;
    @NotNull
    private Long typeId;

}
