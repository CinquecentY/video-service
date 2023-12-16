package ma.xproce.videoservice.dtos;

import lombok.Builder;

@Builder
public class CreatorDto {
    private Long id;
    private String name;
    private String email;
}
