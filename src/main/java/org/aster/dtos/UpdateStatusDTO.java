package org.aster.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusDTO {
    public Long id;
    public String newStatus;
}
