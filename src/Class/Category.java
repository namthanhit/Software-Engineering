package Class;

public class Category {
    private String id;
    private String categoryName;
    private String description;

    public Category() {
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addCategory() {
        // Thêm danh mục
    }

    public void updateCategory() {
        // Cập nhật danh mục
    }

    public void searchCategory() {
        // Tìm kiếm danh mục
    }
}
