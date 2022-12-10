package com.example.checklist.repository;

import com.example.checklist.model.Checklist;
import org.springframework.data.repository.CrudRepository;

public interface ChecklistRepository extends CrudRepository <Checklist, Long> {
}
