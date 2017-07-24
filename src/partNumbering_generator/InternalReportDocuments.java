/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partNumbering_generator;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ojt
 */
@Entity
@Table(name = "INTERNAL_REPORT_DOCUMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InternalReportDocuments.findAll", query = "SELECT i FROM InternalReportDocuments i")
    , @NamedQuery(name = "InternalReportDocuments.findByCommodityCode", query = "SELECT i FROM InternalReportDocuments i WHERE i.commodityCode = :commodityCode")
    , @NamedQuery(name = "InternalReportDocuments.findByCommodityName", query = "SELECT i FROM InternalReportDocuments i WHERE i.commodityName = :commodityName")
    , @NamedQuery(name = "InternalReportDocuments.findByDescription", query = "SELECT i FROM InternalReportDocuments i WHERE i.description = :description")})
public class InternalReportDocuments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COMMODITY_CODE")
    private String commodityCode;
    @Basic(optional = false)
    @Column(name = "COMMODITY_NAME")
    private String commodityName;
    @Column(name = "DESCRIPTION")
    private String description;

    public InternalReportDocuments() {
    }

    public InternalReportDocuments(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public InternalReportDocuments(String commodityCode, String commodityName) {
        this.commodityCode = commodityCode;
        this.commodityName = commodityName;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commodityCode != null ? commodityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InternalReportDocuments)) {
            return false;
        }
        InternalReportDocuments other = (InternalReportDocuments) object;
        if ((this.commodityCode == null && other.commodityCode != null) || (this.commodityCode != null && !this.commodityCode.equals(other.commodityCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_classes.InternalReportDocuments[ commodityCode=" + commodityCode + " ]";
    }
    
}
