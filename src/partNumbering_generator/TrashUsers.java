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
@Table(name = "TRASH_USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrashUsers.findAll", query = "SELECT t FROM TrashUsers t")
    , @NamedQuery(name = "TrashUsers.findByUsername", query = "SELECT t FROM TrashUsers t WHERE t.username = :username")
    , @NamedQuery(name = "TrashUsers.findByPassword", query = "SELECT t FROM TrashUsers t WHERE t.password = :password")
    , @NamedQuery(name = "TrashUsers.findByFirstName", query = "SELECT t FROM TrashUsers t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TrashUsers.findByLastName", query = "SELECT t FROM TrashUsers t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "TrashUsers.findByJobTitle", query = "SELECT t FROM TrashUsers t WHERE t.jobTitle = :jobTitle")
    , @NamedQuery(name = "TrashUsers.findById", query = "SELECT t FROM TrashUsers t WHERE t.id = :id")})
public class TrashUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public TrashUsers() {
    }

    public TrashUsers(Integer id) {
        this.id = id;
    }

    public TrashUsers(Integer id, String username, String password, String firstName, String lastName, String jobTitle) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof TrashUsers)) {
            return false;
        }
        TrashUsers other = (TrashUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "partNumbering_generator.TrashUsers[ id=" + id + " ]";
    }
    
}
