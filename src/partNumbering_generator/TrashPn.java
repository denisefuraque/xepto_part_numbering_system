/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ojt
 */
@Entity
@Table(name = "TRASH_PN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrashPn.findAll", query = "SELECT t FROM TrashPn t")
    , @NamedQuery(name = "TrashPn.findByPartNumber", query = "SELECT t FROM TrashPn t WHERE t.partNumber = :partNumber")
    , @NamedQuery(name = "TrashPn.findByCategory", query = "SELECT t FROM TrashPn t WHERE t.category = :category")
    , @NamedQuery(name = "TrashPn.findByDescription", query = "SELECT t FROM TrashPn t WHERE t.description = :description")
    , @NamedQuery(name = "TrashPn.findByGeneratedDate", query = "SELECT t FROM TrashPn t WHERE t.generatedDate = :generatedDate")
    , @NamedQuery(name = "TrashPn.findByAuthor", query = "SELECT t FROM TrashPn t WHERE t.author = :author")
    , @NamedQuery(name = "TrashPn.findByConfiguration", query = "SELECT t FROM TrashPn t WHERE t.configuration = :configuration")
    , @NamedQuery(name = "TrashPn.findById", query = "SELECT t FROM TrashPn t WHERE t.id = :id")
    , @NamedQuery(name = "TrashPn.findByManufacturer", query = "SELECT t FROM TrashPn t WHERE t.manufacturer = :manufacturer")
    , @NamedQuery(name = "TrashPn.findByMpn", query = "SELECT t FROM TrashPn t WHERE t.mpn = :mpn")
    , @NamedQuery(name = "TrashPn.findByWhereUsed", query = "SELECT t FROM TrashPn t WHERE t.whereUsed = :whereUsed")})
public class TrashPn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PART_NUMBER")
    private String partNumber;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "GENERATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date generatedDate;
    @Basic(optional = false)
    @Column(name = "AUTHOR")
    private String author;
    @Basic(optional = false)
    @Column(name = "CONFIGURATION")
    private String configuration;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name = "MPN")
    private String mpn;
    @Column(name = "WHERE_USED")
    private String whereUsed;

    public TrashPn() {
    }

    public TrashPn(Integer id) {
        this.id = id;
    }

    public TrashPn(Integer id, String partNumber, String category, Date generatedDate, String author, String configuration) {
        this.id = id;
        this.partNumber = partNumber;
        this.category = category;
        this.generatedDate = generatedDate;
        this.author = author;
        this.configuration = configuration;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public String getWhereUsed() {
        return whereUsed;
    }

    public void setWhereUsed(String whereUsed) {
        this.whereUsed = whereUsed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrashPn)) {
            return false;
        }
        TrashPn other = (TrashPn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "partNumbering_generator.TrashPn[ id=" + id + " ]";
    }
    
}
