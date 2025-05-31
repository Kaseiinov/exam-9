package kg.attractor.exam9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean enabled;
    private String avatar;
}
