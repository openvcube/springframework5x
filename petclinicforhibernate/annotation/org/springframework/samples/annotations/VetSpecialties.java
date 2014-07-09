package org.springframework.samples.annotations;
// Generated 2014-7-9 23:01:38 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VetSpecialties generated by hbm2java
 */
@Entity
@Table(name="VET_SPECIALTIES"
)
public class VetSpecialties  implements java.io.Serializable {


     private VetSpecialtiesId id;
     private Specialties specialties;
     private Vets vets;

    public VetSpecialties() {
    }

    public VetSpecialties(VetSpecialtiesId id, Specialties specialties, Vets vets) {
       this.id = id;
       this.specialties = specialties;
       this.vets = vets;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vetId", column=@Column(name="VET_ID", nullable=false) ), 
        @AttributeOverride(name="specialtyId", column=@Column(name="SPECIALTY_ID", nullable=false) ) } )
    public VetSpecialtiesId getId() {
        return this.id;
    }
    
    public void setId(VetSpecialtiesId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SPECIALTY_ID", nullable=false, insertable=false, updatable=false)
    public Specialties getSpecialties() {
        return this.specialties;
    }
    
    public void setSpecialties(Specialties specialties) {
        this.specialties = specialties;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="VET_ID", nullable=false, insertable=false, updatable=false)
    public Vets getVets() {
        return this.vets;
    }
    
    public void setVets(Vets vets) {
        this.vets = vets;
    }




}

