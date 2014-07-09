package org.springframework.samples.annotations;
// Generated 2014-7-9 23:01:38 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pets generated by hbm2java
 */
@Entity
@Table(name="PETS"
)
public class Pets  implements java.io.Serializable {


     private Integer id;
     private Owners owners;
     private Types types;
     private String name;
     private Date birthDate;
     private Set<Visits> visitses = new HashSet<Visits>(0);

    public Pets() {
    }

	
    public Pets(Owners owners, Types types) {
        this.owners = owners;
        this.types = types;
    }
    public Pets(Owners owners, Types types, String name, Date birthDate, Set<Visits> visitses) {
       this.owners = owners;
       this.types = types;
       this.name = name;
       this.birthDate = birthDate;
       this.visitses = visitses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID", nullable=false)
    public Owners getOwners() {
        return this.owners;
    }
    
    public void setOwners(Owners owners) {
        this.owners = owners;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TYPE_ID", nullable=false)
    public Types getTypes() {
        return this.types;
    }
    
    public void setTypes(Types types) {
        this.types = types;
    }

    
    @Column(name="NAME", length=30)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE", length=0)
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pets")
    public Set<Visits> getVisitses() {
        return this.visitses;
    }
    
    public void setVisitses(Set<Visits> visitses) {
        this.visitses = visitses;
    }




}


