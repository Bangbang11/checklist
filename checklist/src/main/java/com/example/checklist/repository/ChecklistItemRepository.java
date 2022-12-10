package com.example.checklist.repository;

import com.example.checklist.model.ChecklistItem;
import org.springframework.data.repository.CrudRepository;

public interface ChecklistItemRepository extends CrudRepository <ChecklistItem, Long> {
}
