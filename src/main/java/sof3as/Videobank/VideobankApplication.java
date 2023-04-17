package sof3as.Videobank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sof3as.Videobank.domain.Video;
import sof3as.Videobank.domain.VideoRepository;
import sof3as.Videobank.domain.Category;
import sof3as.Videobank.domain.CategoryRepository;
import sof3as.Videobank.domain.User;
import sof3as.Videobank.domain.UserRepository;

@SpringBootApplication
public class VideobankApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideobankApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(VideoRepository vrepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			Category c1 = new Category("Music");
			Category c2 = new Category("Cats");
			Category c3 = new Category("Memes");
			Category c4 = new Category("Trailers");
			Category c5 = new Category("Games");
			Category c6 = new Category("Vlogs");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			crepository.save(c4);
			crepository.save(c5);
			crepository.save(c6);
			
			
			Video v1 = new Video("Pink Floyd - Money", "-0kcet4aPpQ", c1);
			Video v2 = new Video("Talking Cat", "kkwiQmGWK4c", c2);
			Video v3 = new Video("Joe Rogan Alien", "20fOd35l3Pg", c3);
			Video v4 = new Video("ONCE UPON A TIME IN HOLLYWOOD", "ELeMaP8EPAA", c4);
			Video v5 = new Video("MW2 Trickshot", "auAvDJlMOQ8", c5);
			Video v6 = new Video("Pewdiepie vlog", "BQ35bZAPUnk", c6);
			
			vrepository.save(v1);
			vrepository.save(v2);
			vrepository.save(v3);
			vrepository.save(v4);
			vrepository.save(v5);
			vrepository.save(v6);
			
			
			User user1 = new User("user", "$2a$10$vdgjR9rUhGc2dZLsxsaTQ.ipBWFE9r.IA5YMD0aw23XsDeNH.8CtK", "user@videobank.com", "USER");
			User user2 = new User("admin", "$2a$10$735FGLX3Rq7/Up.7v3yUcOaAwprD1RDfxKwK8U/7Pp8G3VvVlOLxi", "admin@videobank.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}