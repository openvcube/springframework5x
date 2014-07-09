package org.springframework.samples.annotations;
// Generated 2014-7-9 23:01:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Specialties generated by hbm2java
 */
@Entity
@Table(name="SPECIALTIES"
)
public class Specialties  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<VetSpecialties> vetSpecialtieses = new HashSet<VetSpecialties>(0);

    public Specialties() {
    }

    public Specialties(String name, Set<VetSpecialties> vetSpecialtieses) {
       this.name = name;
       this.vetSpecialtieses = vetSpecialtieses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="NAME", length=80)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="specialties")
    public Set<VetSpecialties> getVetSpecialtieses() {
        return this.vetSpecialtieses;
    }
    
    public void setVetSpecialtieses(Set<VetSpecialties> vetSpecialtieses) {
        this.vetSpecialtieses = vetSpecialtieses;
    }




}


