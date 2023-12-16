package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dtos.CreatorDto;
import ma.xproce.videoservice.dtos.VideoDto;
import ma.xproce.videoservice.entities.Creator;
import ma.xproce.videoservice.entities.Video;
import ma.xproce.videoservice.mappers.ModelMapperConfig;
import ma.xproce.videoservice.repositories.CreatorRepository;
import ma.xproce.videoservice.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class VideoManagerImplementation implements VideoManager {
    @Autowired
    ModelMapperConfig modelMapperConfig;
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<VideoDto> videotList() {
        List<VideoDto> videoDtoList = new ArrayList<VideoDto>();
        List<Video> videoList = videoRepository.findAll();
        for (Video video :
                videoList) {
            videoDtoList.add(modelMapperConfig.fromVideo(video));
        }
        return  videoDtoList;
    }

    @Override
    public VideoDto videoById(Long id) {
        return modelMapperConfig.fromVideo(videoRepository.findById(id).get());
    }

    @Override
    public VideoDto updateVideo(VideoDto videoDto) {
        return modelMapperConfig.fromVideo(videoRepository.save(modelMapperConfig.fromVideoDto(videoDto)));
    }

    @Override
    public VideoDto saveVideo(VideoDto videoDto) {
        return modelMapperConfig.fromVideo(videoRepository.save(modelMapperConfig.fromVideoDto(videoDto)));
    }
}
