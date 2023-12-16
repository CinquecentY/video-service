package ma.xproce.videoservice.dtos;

import lombok.Setter;

@Setter
public class VideoDto {
    private Long id;
    private String name;
    private String url;
    private String description;
    private String datePublication;
    private CreatorDto creator;
}
