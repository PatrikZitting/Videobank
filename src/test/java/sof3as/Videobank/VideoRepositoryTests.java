package sof3as.Videobank;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sof3as.Videobank.domain.Video;
import sof3as.Videobank.domain.VideoRepository;
import sof3as.Videobank.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VideoRepositoryTests {
 @Autowired
 private VideoRepository vrepository;
 
 @Test
 public void findByVideonameShouldReturnVideo() {
	 List<Video> videos = vrepository.findByVideoname("Talking Cat");
	 assertThat(videos).hasSize(1);
	 assertThat(videos.get(0).getLink()).isEqualTo("kkwiQmGWK4c");
 }
 
 @Test
 public void findByVideonameShouldNotReturnVideo() {
	 List<Video> videos = vrepository.findByVideoname("This video doesn't exist");
	 assertThat(videos).hasSize(0);
 }

 @Test
 public void createNewVideo() {
	 Video video = new Video("TestName", "TestLink.com", new Category("TestCategory"));
	 vrepository.save(video);
	 assertThat(video.getId()).isNotNull();
 }
}