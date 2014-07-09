package org.springframework.samples.annotations;
// Generated 2014-7-9 23:01:38 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VetSpecialtiesId generated by hbm2java
 */
@Embeddable
public class VetSpecialtiesId  implements java.io.Serializable {


     private int vetId;
     private int specialtyId;

    public VetSpecialtiesId() {
    }

    public VetSpecialtiesId(int vetId, int specialtyId) {
       this.vetId = vetId;
       this.specialtyId = specialtyId;
    }
   


    @Column(name="VET_ID", nullable=false)
    public int getVetId() {
        return this.vetId;
    }
    
    public void setVetId(int vetId) {
        this.vetId = vetId;
    }


    @Column(name="SPECIALTY_ID", nullable=false)
    public int getSpecialtyId() {
        return this.specialtyId;
    }
    
    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VetSpecialtiesId) ) return false;
		 VetSpecialtiesId castOther = ( VetSpecialtiesId ) other; 
         
		 return (this.getVetId()==castOther.getVetId())
 && (this.getSpecialtyId()==castOther.getSpecialtyId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVetId();
         result = 37 * result + this.getSpecialtyId();
         return result;
   }   


}

