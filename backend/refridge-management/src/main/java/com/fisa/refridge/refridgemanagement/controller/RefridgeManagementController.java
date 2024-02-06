package com.fisa.refridge.refridgemanagement.controller;

import com.fisa.refridge.refridgemanagement.dto.CategoryResponse;
import com.fisa.refridge.refridgemanagement.dto.PurchaseHistoryResponse;
import com.fisa.refridge.refridgemanagement.model.Category;
import com.fisa.refridge.refridgemanagement.model.PurchaseHistory;
import com.fisa.refridge.refridgemanagement.service.RefridgeManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import java.util.Map;


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

    private final RefridgeManagementService refridgeManagementService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> findCategory() {
        List<CategoryResponse> categories = refridgeManagementService.findCategories()
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(params = "item")
    public ResponseEntity<List<PurchaseHistoryResponse>> findGroceriesByName(@RequestParam String item) {
        List<PurchaseHistoryResponse> groceries = refridgeManagementService.findByItemName(item)
                .stream()
                .map(PurchaseHistoryResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(groceries);
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<PurchaseHistoryResponse>> findGroceriesByCategory(@RequestParam String category) {
        List<PurchaseHistoryResponse> groceries = refridgeManagementService.findByCategory(category)
                .stream()
                .map(PurchaseHistoryResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(groceries);
    }
     @PostMapping
    public ResponseEntity<PurchaseHistory> addPurchaseHistory (@RequestBody PurchaseHistory purchaseHistory) {

         refridgeManagementService.save(purchaseHistory);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(purchaseHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){

        try{
            refridgeManagementService.delete(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }

    }
    @PatchMapping("/{id}")
    public void updatePurchaseHistory(@PathVariable Long id, @RequestBody Map<String, String> usedQuantityMap) {
        Long usedQuantityL = Long.parseLong(usedQuantityMap.get("usedQuantity"));
        PurchaseHistory ph = refridgeManagementService.findById(id);

//         냉장고에 있는 재료가 사용하려는 재료보다 적으면 재료가 부족하다는 메시지 출력
        if(ph.getQuantity() < usedQuantityL) {
            System.out.println("재료가 부족합니다. 재료를 주문하세요.");
        } else {
            ph.setQuantity(ph.getQuantity() - usedQuantityL);
        }

        refridgeManagementService.update(ph);
        return;
    }

    @GetMapping("/items")
    public  ResponseEntity<List<PurchaseHistoryResponse>> getItems(){
        List<PurchaseHistoryResponse> groceries = new ArrayList<>();
        refridgeManagementService.findAll().forEach(purchaseHistory -> groceries.add(new PurchaseHistoryResponse(purchaseHistory)));
//

        return ResponseEntity.ok().body(groceries);
    }

}
