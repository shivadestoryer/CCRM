package main.java.com.sor.CCRM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String complainantName;

    @Column(nullable = false)
    private String complainantContact;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime dateFiled;

    @Column
    private String assignedOfficer;

    public Complaint() {
    }

    private Complaint(Builder builder) {
        this.complainantName = builder.complainantName;
        this.complainantContact = builder.complainantContact;
        this.description = builder.description;
        this.status = builder.status;
        this.dateFiled = builder.dateFiled;
        this.assignedOfficer = builder.assignedOfficer;
    }

    public Long getId() {
        return id;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public String getComplainantContact() {
        return complainantContact;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDateFiled() {
        return dateFiled;
    }

    public String getAssignedOfficer() {
        return assignedOfficer;
    }

    public static class Builder {
        private String complainantName;
        private String complainantContact;
        private String description;
        private String status;
        private LocalDateTime dateFiled;
        private String assignedOfficer;

        public Builder complainantName(String complainantName) {
            this.complainantName = complainantName;
            return this;
        }

        public Builder complainantContact(String complainantContact) {
            this.complainantContact = complainantContact;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder dateFiled(LocalDateTime dateFiled) {
            this.dateFiled = dateFiled;
            return this;
        }

        public Builder assignedOfficer(String assignedOfficer) {
            this.assignedOfficer = assignedOfficer;
            return this;
        }

        public Complaint build() {
            return new Complaint(this);
        }
    }
}