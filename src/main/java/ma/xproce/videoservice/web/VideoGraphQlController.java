package ma.xproce.videoservice.web;

import ma.xproce.videoservice.dtos.CreatorDto;
import ma.xproce.videoservice.dtos.VideoDto;
import ma.xproce.videoservice.entities.Creator;
import ma.xproce.videoservice.entities.Video;
import ma.xproce.videoservice.repositories.CreatorRepository;
import ma.xproce.videoservice.repositories.VideoRepository;
import ma.xproce.videoservice.service.CreatorManager;
import ma.xproce.videoservice.service.VideoManager;
import ma.xproce.videoservice.service.VideoManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Controller
public class VideoGraphQlController {
    @Autowired
    VideoManager videoManager;
    @Autowired
    CreatorManager creatorManager;

    @QueryMapping
    public List<VideoDto> videotList() {
        return videoManager.videotList();
    }

    @QueryMapping
    public CreatorDto creatorById(@Argument Long id) {
        return creatorManager.creatorById(id);
    }

    @MutationMapping
    public CreatorDto saveCreator(@Argument CreatorDto creatorDto) {
        return creatorManager.saveCreator(creatorDto);
    }

    @MutationMapping
    public VideoDto saveVideo(@Argument VideoDto videoDto) {
        return videoManager.saveVideo(videoDto);
    }
    @SubscriptionMapping("notifyVideoChange")
    public Flux<VideoDto> notifyVideoChange() {
        return Flux.fromStream(
                Stream.generate(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Random random = new Random();
                    CreatorDto creatorDTO = CreatorDto.builder().name("x" +
                                    random.nextInt())
                            .email("x@gmail.com").build();
                    CreatorDto creatorDTO1 = creatorManager.saveCreator(creatorDTO);
                    VideoDto videoDTO= videoManager.videoById(1L);
                    videoDTO.setCreator(creatorDTO1);
                    return videoManager.updateVideo(videoDTO);
                }));
    }
}
