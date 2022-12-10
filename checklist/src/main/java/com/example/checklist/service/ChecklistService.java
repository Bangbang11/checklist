package com.example.checklist.service;

import com.example.checklist.exception.ChecklistException;
import com.example.checklist.mapper.request.ChecklistRequest;
import com.example.checklist.mapper.response.ChecklistResponse;
import com.example.checklist.model.Checklist;
import com.example.checklist.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public List<ChecklistResponse> getAllChecklist() {
        Iterable<Checklist> list = checklistRepository.findAll();
        List<ChecklistResponse> responseList = new ArrayList<>();
        for (Checklist checklist : list) {
            responseList.add(new ChecklistResponse(checklist));
        }
        return responseList;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ChecklistResponse createNewChecklist(ChecklistRequest checklistRequest) throws ChecklistException {
        if (checklistRequest.getName().equals("")) {
            throw new ChecklistException("Name required");
        }

        Checklist checklist = new Checklist();
        checklist.setName(checklistRequest.getName());
        checklist = checklistRepository.save(checklist);

        return new ChecklistResponse(checklist);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteChecklistById(Long id) throws ChecklistException {
        Checklist checklist = checklistRepository.findById(id).orElse(null);
        if (checklist == null) {
            throw new ChecklistException("Checklist not found");
        }

        checklistRepository.deleteById(id);
    }
}
