/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Denise Furaque
 */
@Entity
@Table(name = "PART_NUMBER_DATA", catalog = "", schema = "Admin01")
@NamedQueries({
    @NamedQuery(name = "PartNumberData.findAll", query = "SELECT p FROM PartNumberData p")
    , @NamedQuery(name = "PartNumberData.findByPartNumber", query = "SELECT p FROM PartNumberData p WHERE p.partNumber = :partNumber")
    , @NamedQuery(name = "PartNumberData.findByCategory", query = "SELECT p FROM PartNumberData p WHERE p.category = :category")
    , @NamedQuery(name = "PartNumberData.findByDescription", query = "SELECT p FROM PartNumberData p WHERE p.description = :description")})
public class PartNumberData implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PART_NUMBER")
    private String partNumber;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "DESCRIPTION")
    private String description;

    public PartNumberData() {
    }

    public PartNumberData(String partNumber) {
        this.partNumber = partNumber;
    }

    public PartNumberData(String partNumber, String category) {
        this.partNumber = partNumber;
        this.category = category;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        String oldPartNumber = this.partNumber;
        this.partNumber = partNumber;
        changeSupport.firePropertyChange("partNumber", oldPartNumber, partNumber);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        String oldCategory = this.category;
        this.category = category;
        changeSupport.firePropertyChange("category", oldCategory, category);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partNumber != null ? partNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartNumberData)) {
            return false;
        }
        PartNumberData other = (PartNumberData) object;
        if ((this.partNumber == null && other.partNumber != null) || (this.partNumber != null && !this.partNumber.equals(other.partNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "partNumbering_generator.PartNumberData[ partNumber=" + partNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
