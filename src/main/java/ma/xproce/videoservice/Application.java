package ma.xproce.videoservice;

import ma.xproce.videoservice.entities.Creator;
import ma.xproce.videoservice.entities.Video;
import ma.xproce.videoservice.mappers.ModelMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.xproce.videoservice.repositories.CreatorRepository;
import ma.xproce.videoservice.repositories.VideoRepository;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	  CreatorRepository creatorRepository;
	@Autowired
	 VideoRepository videoRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Creator creator1 = new Creator();
		creator1.setName("John Doe");
		creator1.setEmail("john.doe@example.com");
		creatorRepository.save(creator1);

		Video video1 = new Video();
		video1.setName("Introduction to Spring Boot");
		video1.setUrl("https://example.com/spring-boot");
		video1.setDescription("A brief overview of Spring Boot");
		video1.setDatePublication(new Date());
		video1.setCreator(creator1);
		videoRepository.save(video1);
	}

}
