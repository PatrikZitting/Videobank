package sof3as.Videobank;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sof3as.Videobank.domain.CategoryRepository;
import sof3as.Videobank.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
 @Autowired
 private CategoryRepository crepository;
 
 @Test
 public void findByNameShouldReturnCategory() {
	 List<Category> categories = crepository.findByName("Cats");
	 assertThat(categories).hasSize(1);
 }
 
 @Test
 public void findByNameShouldNotReturnCategory() {
	 List<Category> categories = crepository.findByName("This category doesn't exist");
	 assertThat(categories).hasSize(0);
 }

 @Test
 public void createNewCategory() {
	 Category category = new Category("TestName");
	 crepository.save(category);
	 assertThat(category.getCategoryid()).isNotNull();
 }
}