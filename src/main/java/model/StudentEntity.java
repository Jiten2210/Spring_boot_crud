package model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "branch")
    private String branch;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "email_id", nullable = false, length = 100)
    private String emailId;

    @Override
    public String toString() {
        return "StudentEntity [id=" + id + ", firstName=" + firstName + ", branch=\" + branch +\", lastName=" + lastName
                + ", emailId=" + emailId + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
