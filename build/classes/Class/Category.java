/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author THANH DUONG
 */
public class Category {
    private String id;
    private String username;
    private String description;

    public Category(String id, String username, String description) {
        this.id = id;
        this.username = username;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public void addCategory(){
        
    }
    public void updateCategory(){
        
    }
    public void searchCategory(){
        
    }
}
