package com.example.checklist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "checklist_item")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChecklistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_item_id")
    @JsonProperty("checklist_item_id")
    private Long checklistItemId;

    @Column(name = "item_name")
    @JsonProperty("item_name")
    private String itemName;

//    @ToString.Exclude
//    @ManyToOne
//    @JoinColumn(name = "checklist_id", referencedColumnName = "checklist_id")
    @Column(name = "checklist_id")
    @JsonProperty("checklist_id")
    private Long checklistId;
}
