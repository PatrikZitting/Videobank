package sof3as.Videobank.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private Long id;
	@Size(min=1, max=30)
	@NotBlank
	private String videoname;
	@Size(min=1, max=15)
	@NotBlank
	private String link;
	
	@ManyToOne
	@JsonIgnoreProperties ("videos")
    @JoinColumn(name = "categoryid")
    private Category category;

	public Video() {}

	public Video(String videoname, String link, Category category) {
		super();
		this.videoname = videoname;
		this.link = link;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Video [id=" + id + ", videoname=" + videoname + ", link=" + link + "]";
		else
		return "Video [id=" + id + ", videoname=" + videoname + ", link=" + link + " category =" + this.getCategory() + "]";
	}
	
}