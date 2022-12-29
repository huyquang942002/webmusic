package model;

public class Music {

    private int id;
    private String name;
    private String path;
    private String image;
    private String singer;

    public Music() {
    }

    public Music(int id, String name, String path, String image, String singer) {
	this.id = id;
	this.name = name;
	this.path = path;
	this.image = image;
	this.singer = singer;
    }

    public Music(String name, String path, String image, String singer) {
	this.name = name;
	this.path = path;
	this.image = image;
	this.singer = singer;
    }
    
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

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public String getSinger() {
	return singer;
    }

    public void setSinger(String singer) {
	this.singer = singer;
    }

    @Override
    public String toString() {
	return "Music{" + "id=" + id + ", name=" + name + ", path=" + path + ", image=" + image + ", singer=" + singer + '}';
    }
}
