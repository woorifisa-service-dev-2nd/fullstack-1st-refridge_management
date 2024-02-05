package com.fisa.refridge.refridgemanagement.controller;

import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.service.RefridgeManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 각자 메서드 구현
* 필요한 DTO 클래스 작성
*
* 조회: GET
* 수정: PATCH
* 추가: POST
* 삭제: DELETE
*
* */
@RequestMapping("/api/groceries")
@RestController
@RequiredArgsConstructor
public class RefridgeManagementController {

    private final RefridgeManagementService refridgeManagementService;

    @PostMapping
    public PurchaseHistory addPurchaseHistory (@RequestBody PurchaseHistory purchaseHistory) {
        System.out.println("purchaseHistory = " + purchaseHistory);

        refridgeManagementService.save(purchaseHistory);
        return purchaseHistory;
    }


}
