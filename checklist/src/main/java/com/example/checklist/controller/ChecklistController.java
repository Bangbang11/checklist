package com.example.checklist.controller;

import com.example.checklist._enum.StatusCodeEnum;
import com.example.checklist.exception.ChecklistException;
import com.example.checklist.mapper.request.ChecklistRequest;
import com.example.checklist.mapper.response.BaseErrorMessage;
import com.example.checklist.mapper.response.BaseResponse;
import com.example.checklist.mapper.response.ChecklistResponse;
import com.example.checklist.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/checklist")
    public ResponseEntity getAllChecklist() {
        BaseResponse<List<ChecklistResponse>> baseResponseMessage = new BaseResponse<>();
        String errorMessage = StatusCodeEnum.ERROR.getDescription();
        try {
            List<ChecklistResponse> list = checklistService.getAllChecklist();
            baseResponseMessage.setStatusCodeByEnum(StatusCodeEnum.OK);
            baseResponseMessage.setData(list);
            return ResponseEntity.status(HttpStatus.OK).body(baseResponseMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        baseResponseMessage.setStatusCodeByEnum(StatusCodeEnum.BAD_REQUEST);
        baseResponseMessage.getErrorMessages()
                .add(BaseErrorMessage.builder().field("All Checklist").message(errorMessage).build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseResponseMessage);

    }

    @PostMapping("/checklist")
    public ResponseEntity createNewChecklist(@RequestBody ChecklistRequest checklistRequest) {
        BaseResponse<ChecklistResponse> baseResponseMessage = new BaseResponse<>();
        String errorMessage = StatusCodeEnum.ERROR.getDescription();
        try {
            ChecklistResponse result = checklistService.createNewChecklist(checklistRequest);
            baseResponseMessage.setStatusCodeByEnum(StatusCodeEnum.OK);
            baseResponseMessage.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(baseResponseMessage);
        } catch (ChecklistException e) {
            errorMessage = e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResponseMessage.setStatusCodeByEnum(StatusCodeEnum.BAD_REQUEST);
        baseResponseMessage.getErrorMessages()
                .add(BaseErrorMessage.builder().field("create checklist").message(errorMessage).build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseResponseMessage);
    }

    @DeleteMapping("/checklist/{id}")
    public ResponseEntity deleteChecklistById(@PathVariable Long id) {
        BaseResponse<ChecklistResponse> baseResponseMessage = new BaseResponse<>();
        String errorMessage = StatusCodeEnum.ERROR.getDescription();
        try {
            checklistService.deleteChecklistById(id);
            baseResponseMessage.setStatusCodeByEnum(StatusCodeEnum.OK);
            return ResponseEntity.status(HttpStatus.OK).body(baseResponseMessage);
        } catch (ChecklistException e) {
            errorMessage = e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResponseMessage.setStatusCodeByEnum(StatusCodeEnum.BAD_REQUEST);
        baseResponseMessage.getErrorMessages()
                .add(BaseErrorMessage.builder().field("delete checklist").message(errorMessage).build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseResponseMessage);
    }
}
