package org.springframework.samples.imagedb;
// Generated 2014-7-8 21:31:01 by Hibernate Tools 4.3.1



/**
 * Imagedb generated by hbm2java
 */
public class Imagedb  implements java.io.Serializable {


     private String imageName;
     private byte[] content;
     private String description;

    public Imagedb() {
    }

	
    public Imagedb(String imageName) {
        this.imageName = imageName;
    }
    public Imagedb(String imageName, byte[] content, String description) {
       this.imageName = imageName;
       this.content = content;
       this.description = description;
    }
   
    public String getImageName() {
        return this.imageName;
    }
    
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public byte[] getContent() {
        return this.content;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


