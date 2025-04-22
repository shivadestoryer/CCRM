package com.sor.CCRM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.sor.CCRM.model.Complaint;
import com.sor.CCRM.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    // Create or Save a new Complaint
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    // Retrieve all Complaints
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // Retrieve a Complaint by ID
    public Optional<Complaint> getComplaintById(Long id) {
        return complaintRepository.findById(id);
    }

    // Update an existing Complaint
    public Complaint updateComplaint(Long id, Complaint updatedComplaint) {
        return complaintRepository.findById(id).map(existingComplaint -> {
            existingComplaint.setComplainantName(updatedComplaint.getComplainantName());
            existingComplaint.setComplainantContact(updatedComplaint.getComplainantContact());
            existingComplaint.setDescription(updatedComplaint.getDescription());
            existingComplaint.setStatus(updatedComplaint.getStatus());
            existingComplaint.setFiledDate(updatedComplaint.getFiledDate());
            return complaintRepository.save(existingComplaint);
        }).orElseThrow(() -> new RuntimeException("Complaint not found with id " + id));
    }

    // Delete a Complaint by ID
    public void deleteComplaint(Long id) {
        complaintRepository.deleteById(id);
    }
}