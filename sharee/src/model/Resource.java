package model;

public class Resource {
    private Integer id;
    private String name;
    private String category;
    private String descn;
    private String code;
    private String img;
    private String date;
    private String uploader;
    private String level;

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", descn='" + descn + '\'' +
                ", code='" + code + '\'' +
                ", img='" + img + '\'' +
                ", date='" + date + '\'' +
                ", uploader='" + uploader + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public Resource() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Resource(Integer id, String name, String category, String descn, String code, String img, String date, String uploader, String level) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.descn = descn;
        this.code = code;
        this.img = img;
        this.date = date;
        this.uploader = uploader;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
