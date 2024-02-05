package com.fisa.refridge.refridgemanagement.controller;

import com.fisa.refridge.refridgemanagement.dto.GroceryResponse;
import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.service.GroceryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/groceries")
public class RefridgeManagementController {

    private final GroceryService groceryService;

    @GetMapping("/name/{itemName}")
    public ResponseEntity<List<GroceryResponse>> findAllGroceriesByName(@PathVariable String itemName) {
        List<GroceryResponse> groceries = groceryService.findByItemName(itemName)
                .stream()
                .map(GroceryResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(groceries);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<GroceryResponse>> findByCategory(@PathVariable Long categoryId) {
        List<GroceryResponse> groceries = groceryService.findByCategoryId(categoryId)
                .stream()
                .map(GroceryResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(groceries);
    }
}
