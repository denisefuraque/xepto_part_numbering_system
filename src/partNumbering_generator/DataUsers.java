/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Denise Furaque
 */
@Entity
@Table(name = "DATA_USERS", catalog = "", schema = "Admin01")
@NamedQueries({
    @NamedQuery(name = "DataUsers.findAll", query = "SELECT d FROM DataUsers d")
    , @NamedQuery(name = "DataUsers.findByPartNumber", query = "SELECT d FROM DataUsers d WHERE d.partNumber = :partNumber")
    , @NamedQuery(name = "DataUsers.findByCategory", query = "SELECT d FROM DataUsers d WHERE d.category = :category")
    , @NamedQuery(name = "DataUsers.findByDescription", query = "SELECT d FROM DataUsers d WHERE d.description = :description")})
public class DataUsers implements Serializable {

    @Basic(optional = false)
    @Column(name = "GENERATED_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date generatedDate;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String author;
    @Basic(optional = false)
    @Column(nullable = false, length = 6)
    private String configuration;

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

    public DataUsers() {
    }

    public DataUsers(String partNumber) {
        this.partNumber = partNumber;
    }

    public DataUsers(String partNumber, String category) {
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
        if (!(object instanceof DataUsers)) {
            return false;
        }
        DataUsers other = (DataUsers) object;
        if ((this.partNumber == null && other.partNumber != null) || (this.partNumber != null && !this.partNumber.equals(other.partNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "partNumbering_generator.DataUsers[ partNumber=" + partNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        Date oldGeneratedDate = this.generatedDate;
        this.generatedDate = generatedDate;
        changeSupport.firePropertyChange("generatedDate", oldGeneratedDate, generatedDate);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String oldAuthor = this.author;
        this.author = author;
        changeSupport.firePropertyChange("author", oldAuthor, author);
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        String oldConfiguration = this.configuration;
        this.configuration = configuration;
        changeSupport.firePropertyChange("configuration", oldConfiguration, configuration);
    }
    
}
