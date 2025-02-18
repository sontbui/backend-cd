package com.demo.DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.demo.entities.Artist;
import com.demo.entities.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CDDTO {
	private Integer id;
	private String title;
	private BigDecimal price;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date releaseDate;
	private Integer stock;
	private String description;
	private Boolean status;
	private String poster;
	private int artistID;
	private String artistName;
	private String sound;
	private int genreID;
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public int getArtistID() {
		return artistID;
	}
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getGenreID() {
		return genreID;
	}
	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}
	
}
