package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dtos.CreatorDto;
import ma.xproce.videoservice.mappers.ModelMapperConfig;
import ma.xproce.videoservice.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatorManagerImplementation implements CreatorManager {
    @Autowired
    ModelMapperConfig modelMapperConfig;
    @Autowired
    private CreatorRepository creatorRepository;
    @Override
    public CreatorDto creatorById(Long id) {
        return modelMapperConfig.fromCreator(creatorRepository.findById(id).get());
    }

    @Override
    public CreatorDto saveCreator(CreatorDto creatorDto) {
        return modelMapperConfig.fromCreator(creatorRepository.save(modelMapperConfig.fromCreatorDto(creatorDto)));
    }
}
