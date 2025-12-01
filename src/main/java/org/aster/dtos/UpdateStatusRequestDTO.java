package org.aster.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusRequestDTO {
    private Long id;
    private String newStatus;
}
