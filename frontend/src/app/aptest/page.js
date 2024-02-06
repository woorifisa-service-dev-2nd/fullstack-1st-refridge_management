"use client";
import React, { useEffect, useState } from "react";
import InputDate from "../../components/InputDate";
import InputSelect from "../../components/InputSelect";
import InputCustom from "@/components/InputCustom";
import { addRefridge } from "@/api/refridge";

export default function page() {
  const [itemName, setName] = useState();
  const [quantity, setQuantity] = useState();
  const [expirationDate, setExpirationDate] = useState();
  const [purchaseDate, setPurchaseDate] = useState();
  const [select, setSelect] = useState("");

  const categories = [
    {
      name: "snack",
      expiration: 0,
    },
    {
      name: "vegetable",
      expiration: 7,
    },
    {
      name: "meat_seafood",
      expiration: 3,
    },
    {
      name: "beverage",
      expiration: 0,
    },
    {
      name: "dairy_product",
      expiration: 0,
    },
  ];

  useEffect(() => {
    console.log(expirationDate);
  }, [expirationDate]);

  useEffect(() => {
    console.log(select);
  }, [select]);

  const onCreate = async () => {
    console.log({
      itemName,
      unitId: 2,
      quantity,
      expirationDate,
      purchaseDate,
      select,
    });

    const res = await addRefridge({
      categoryId: select,
      unitId: 2,
      expirationDate,
      itemName,
      purchaseDate,
      quantity,
    });

    console.log(res);
  };

  return (
    <>
      <InputCustom title={"제품 명"} setInputData={setName} />
      <InputSelect
        items={categories}
        setSelect={setSelect}
        title={"제품 종류를 선택 하세요"}
      />
      <InputCustom title={"수량"} setInputData={setQuantity} />
      <InputDate
        label={"구매 일자"}
        setDate={setExpirationDate}
        dateTime={new Date("2024-02-28")}
        calcDate={3}
      />
      {select !== "" && (
        <InputDate
          key={select}
          label={"유통 기한"}
          setDate={setPurchaseDate}
          dateTime={expirationDate}
          calcDate={categories[+select].expiration || 0}
        />
      )}
      <button onClick={onCreate}>추가</button>
    </>
  );
}
// 이름
// 분류
// 수량
// 유통 기한
// 구매일자
// 단위

// 아이디 (item_id)
// 이름 (item_name)
// 카테고리 ( category)
// 수량(quantity)
// 단위(unit)
// 유통기한(expiration_date)
// 구매일자(purchase_date)

// 장 본 아이템 추가(수동 입력)
// 유통기한 임박한 재료 알려주기(1일 이내로 남은 음식 자동 알림)
// 카테고리 별 유통기한 남은 재료 유통기한 짧은 순으로 조회
// + 재료 이름 검색해서 유통기한 짧은 순으로 조회
// 재료 사용량 입력하면 남은 수량 수정 후 (자동)조회
// 재료 삭제
