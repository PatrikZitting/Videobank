package sof3as.Videobank;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sof3as.Videobank.web.VideoController;
import sof3as.Videobank.web.CategoryController;
import sof3as.Videobank.web.UserDetailServiceImpl;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private VideoController Vcontroller;
	
	@Autowired
	private CategoryController Ccontroller;
	
	@Autowired
	private UserDetailServiceImpl Udsi;

	@Test
	void contextLoads() throws Exception{
		assertThat(Vcontroller).isNotNull();
		assertThat(Ccontroller).isNotNull();
		assertThat(Udsi).isNotNull();
	}

}
