package model.bean;

import java.sql.Timestamp;

public class Song {
	
		private int id;
		private String name;
		private String description;
		private String detail;
		private Timestamp dateCreate;
		private String picture;
		private int counter;
		private int catId;
		private Category objCat;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public Timestamp getDateCreate() {
			return dateCreate;
		}
		public void setDateCreate(Timestamp dateCreate) {
			this.dateCreate = dateCreate;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public int getCounter() {
			return counter;
		}
		public void setCounter(int counter) {
			this.counter = counter;
		}
		public int getCatId() {
			return catId;
		}
		public void setCatId(int catId) {
			this.catId = catId;
		}
		public Category getObjCat() {
			return objCat;
		}
		public void setObjCat(Category objCat) {
			this.objCat = objCat;
		}
		
		
		public Song() {
			// TODO Auto-generated constructor stub
		}
		public Song(int id, String name, String description, String detail, Timestamp dateCreate, String picture,
				int counter, int catId, Category objCat) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.detail = detail;
			this.dateCreate = dateCreate;
			this.picture = picture;
			this.counter = counter;
			this.catId = catId;
			this.objCat = objCat;
		}
		@Override
		public String toString() {
			return "Song [id=" + id + ", name=" + name + ", description=" + description + ", detail=" + detail
					+ ", dateCreate=" + dateCreate + ", picture=" + picture + ", counter=" + counter + ", catId="
					+ catId + ", objCat=" + objCat + "]";
		}
		
}
