package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dtos.CreatorDto;
import ma.xproce.videoservice.dtos.VideoDto;
import ma.xproce.videoservice.entities.Creator;

import java.util.List;

public interface VideoManager {
    List<VideoDto> videotList();
VideoDto videoById(Long id);
VideoDto updateVideo(VideoDto videoDto);
    VideoDto saveVideo(VideoDto videoDto);
}
