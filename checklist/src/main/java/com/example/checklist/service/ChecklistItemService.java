package com.example.checklist.service;

import com.example.checklist.mapper.response.ChecklistResponse;
import com.example.checklist.model.Checklist;
import com.example.checklist.repository.ChecklistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChecklistItemService {

    @Autowired
    private ChecklistItemRepository checklistItemRepository;

//    public List<ChecklistResponse> getAllChecklistItemByChecklistId() {
//        Iterable<Checklist> list = checklistRepository.findAll();
//        List<ChecklistResponse> responseList = new ArrayList<>();
//        for (Checklist checklist : list) {
//            responseList.add(new ChecklistResponse(checklist));
//        }
//        return responseList;
//    }

}
