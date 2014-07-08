package org.springframework.samples;
// Generated 2014-7-9 0:10:44 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Owners generated by hbm2java
 */
public class Owners  implements java.io.Serializable {


     private Integer id;
     private String firstName;
     private String lastName;
     private String address;
     private String city;
     private String telephone;
     private Set petses = new HashSet(0);

    public Owners() {
    }

    public Owners(String firstName, String lastName, String address, String city, String telephone, Set petses) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.address = address;
       this.city = city;
       this.telephone = telephone;
       this.petses = petses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Set getPetses() {
        return this.petses;
    }
    
    public void setPetses(Set petses) {
        this.petses = petses;
    }




}


