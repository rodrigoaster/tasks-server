package org.aster.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTaskRequestDTO {
    private Long id;
    private String taskName;
}
