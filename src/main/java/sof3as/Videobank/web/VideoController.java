package sof3as.Videobank.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sof3as.Videobank.domain.Video;
import sof3as.Videobank.domain.VideoRepository;
import sof3as.Videobank.domain.CategoryRepository;


@Controller

public class VideoController {
	@RequestMapping("/index")
	public String indexMessage() {
		return "index";
	}
	
	@Autowired
	private VideoRepository vrepository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/videobank")
	public String videoList(Model model) {
		model.addAttribute("videos", vrepository.findAll());
		return "videobank";
	}
	
    @RequestMapping(value="/videos", method = RequestMethod.GET)
    public @ResponseBody List<Video> videoListRest() {	
        return (List<Video>) vrepository.findAll();
    }    

    @RequestMapping(value="/videos/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Video> findVideoRest(@PathVariable("id") Long videoId) {	
    	return vrepository.findById(videoId);
    }      
    
    @RequestMapping(value="/videos", method = RequestMethod.POST)
    public @ResponseBody Video saveVideoRest(@RequestBody Video video) {	
    	return vrepository.save(video);
    }
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
    public String deleteVideo(@PathVariable("id") Long videoId, Model model) {
    	vrepository.deleteById(videoId);
        return "redirect:../videobank";
    }
	
	@RequestMapping(value = "/add")
	@PreAuthorize("hasAuthority('ADMIN')")
    public String addVideo(Model model){
    	model.addAttribute("video", new Video());
    	model.addAttribute("categories", crepository.findAll());
        return "addVideo";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
    public String saveVideo(Video video){
        vrepository.save(video);
        return "redirect:videobank";
    }

	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
    public String editVideo(@PathVariable("id") Long videoId, Model model) {
	model.addAttribute("video", vrepository.findById(videoId).orElse(null));
	model.addAttribute("categories", crepository.findAll());
    return "editVideo";
    }
	
	@RequestMapping(value= "/video")
	public String showVideo(@RequestParam String videoLink, Model model) {
	    model.addAttribute("videoLink", videoLink);
	    return "video";
	}
}