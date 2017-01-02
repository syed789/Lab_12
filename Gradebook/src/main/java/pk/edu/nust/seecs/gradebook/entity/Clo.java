package pk.edu.nust.seecs.gradebook.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class Clo implements java.io.Serializable {
    @Id
    @GeneratedValue
    @Column(name = "clo_id")
    private Integer cloId;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String plo;
    @Column
    private String btLevel;
    
    public Clo(String name, String description, String plo, String btLevel) {
        this.name = name;
        this.description = description;
        this.plo = plo;
        this.btLevel = btLevel;
    }
    
    public Clo() {
    }
    
    public Clo(String name) {
        this.name = name;
    }
    
    public Integer getCloId() {
        return cloId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlo() {
        return plo;
    }

    public void setPlo(String plo) {
        this.plo = plo;
    }

    public String getBtLevel() {
        return btLevel;
    }

    public void setBtLevel(String btLevel) {
        this.btLevel = btLevel;
    }

    @Override
    public String toString() {
        return "Clo {" + " cloId = " + cloId + ", name = " + name + ", description = " + description + ", plo = " + plo + ", btLevel = " + btLevel + " }";
    }
}