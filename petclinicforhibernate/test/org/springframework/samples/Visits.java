package org.springframework.samples;
// Generated 2014-7-9 0:10:44 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Visits generated by hbm2java
 */
public class Visits  implements java.io.Serializable {


     private Integer id;
     private Pets pets;
     private Date visitDate;
     private String description;

    public Visits() {
    }

	
    public Visits(Pets pets) {
        this.pets = pets;
    }
    public Visits(Pets pets, Date visitDate, String description) {
       this.pets = pets;
       this.visitDate = visitDate;
       this.description = description;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Pets getPets() {
        return this.pets;
    }
    
    public void setPets(Pets pets) {
        this.pets = pets;
    }
    public Date getVisitDate() {
        return this.visitDate;
    }
    
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


