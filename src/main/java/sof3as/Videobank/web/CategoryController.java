package sof3as.Videobank.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sof3as.Videobank.domain.Category;
import sof3as.Videobank.domain.CategoryRepository;



@Controller

public class CategoryController {
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcategory")
    public String addCategory(Model model){
    	model.addAttribute("category", new Category());
        return "addCategory";
    }
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category){
        crepository.save(category);
        return "redirect:categorylist";
    }
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
    public @ResponseBody List<Category> categoryListRest() {	
        return (List<Category>) crepository.findAll();
    }    

    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {	
    	return crepository.findById(categoryId);
    }      
    
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {	
    	return crepository.save(category);
    }
}