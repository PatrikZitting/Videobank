package sof3as.Videobank.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {

	List<Video> findByVideoname(String string);
	
}
