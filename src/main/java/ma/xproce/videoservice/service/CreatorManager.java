package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dtos.CreatorDto;

public interface CreatorManager {
    CreatorDto creatorById(Long id);
    CreatorDto saveCreator(CreatorDto creatorDto);
}
