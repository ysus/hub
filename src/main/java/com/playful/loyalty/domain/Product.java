package com.playful.loyalty.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	private String imagePath;
	private String urlExtern;
	@Column(name = "i_order", nullable = false)
	private int order;
	private boolean slider;
	private boolean sliderTop;
	private String typePromotion;
	private int current;
	private int previous;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPrevious() {
		return previous;
	}
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getUrlExtern() {
		return urlExtern;
	}
	public void setUrlExtern(String urlExtern) {
		this.urlExtern = urlExtern;
	}

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public boolean isSlider() {
		return slider;
	}
	public void setSlider(boolean slider) {
		this.slider = slider;
	}
	
	public boolean isSliderTop() {
		return sliderTop;
	}
	public void setSliderTop(boolean sliderTop) {
		this.sliderTop = sliderTop;
	}
	public String getTypePromotion() {
		return typePromotion;
	}
	public void setTypePromotion(String typePromotion) {
		this.typePromotion = typePromotion;
	}
	


	
}

	
