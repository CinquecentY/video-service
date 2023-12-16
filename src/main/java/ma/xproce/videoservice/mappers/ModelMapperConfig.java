package ma.xproce.videoservice.mappers;

import ma.xproce.videoservice.dtos.CreatorDto;
import ma.xproce.videoservice.dtos.VideoDto;
import ma.xproce.videoservice.entities.Creator;
import ma.xproce.videoservice.entities.Video;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
    private final ModelMapper modelMapper=new ModelMapper();
    public CreatorDto fromCreator(Creator creator){
        return this.modelMapper.map(creator,CreatorDto.class);
    }
    public Creator fromCreatorDto(CreatorDto creatorDto){
        return this.modelMapper.map(creatorDto,Creator.class);
    }
    public VideoDto fromVideo(Video video){
        return this.modelMapper.map(video,VideoDto.class);
    }
    public Video fromVideoDto(VideoDto videoDto){
        return this.modelMapper.map(videoDto,Video.class);
    }
}
