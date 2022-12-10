package com.example.checklist.mapper.response;

import com.example.checklist.model.Checklist;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChecklistResponse {

    @JsonProperty("checklist_id")
    private Long checklistId;

    @JsonProperty("name")
    private String name;

    public ChecklistResponse(Checklist checklist) {
        this.checklistId = checklist.getChecklistId();
        this.name = checklist.getName();
    }
}
