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
@Table(name = "PART_NUMBER_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartNumberData.findAll", query = "SELECT p FROM PartNumberData p")
    , @NamedQuery(name = "PartNumberData.findByPartNumber", query = "SELECT p FROM PartNumberData p WHERE p.partNumber = :partNumber")
    , @NamedQuery(name = "PartNumberData.findByCategory", query = "SELECT p FROM PartNumberData p WHERE p.category = :category")
    , @NamedQuery(name = "PartNumberData.findByDescription", query = "SELECT p FROM PartNumberData p WHERE p.description = :description")
    , @NamedQuery(name = "PartNumberData.findByGeneratedDate", query = "SELECT p FROM PartNumberData p WHERE p.generatedDate = :generatedDate")
    , @NamedQuery(name = "PartNumberData.findByAuthor", query = "SELECT p FROM PartNumberData p WHERE p.author = :author")
    , @NamedQuery(name = "PartNumberData.findByConfiguration", query = "SELECT p FROM PartNumberData p WHERE p.configuration = :configuration")
    , @NamedQuery(name = "PartNumberData.findByManufacturer", query = "SELECT p FROM PartNumberData p WHERE p.manufacturer = :manufacturer")
    , @NamedQuery(name = "PartNumberData.findByMpn", query = "SELECT p FROM PartNumberData p WHERE p.mpn = :mpn")
    , @NamedQuery(name = "PartNumberData.findByWhereUsed", query = "SELECT p FROM PartNumberData p WHERE p.whereUsed = :whereUsed")})
public class PartNumberData implements Serializable {

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
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name = "MPN")
    private String mpn;
    @Column(name = "WHERE_USED")
    private String whereUsed;

    public PartNumberData() {
    }

    public PartNumberData(String partNumber) {
        this.partNumber = partNumber;
    }

    public PartNumberData(String partNumber, String category, Date generatedDate, String author, String configuration) {
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
    
}
