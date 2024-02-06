"use client";
import React, { useEffect, useState } from "react";
import { addRefridge } from "@/api/refridge";
import InputCustom from "@/components/InputCustom";
import InputSelect from "@/components/InputSelect";
import InputDate from "@/components/InputDate";

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
  const onCreate = async () => {
    console.log({
      itemName,
      unitId: 2,
      quantity,
      expirationDate,
      purchaseDate,
      select,
    });

    // ######## 카테고리 id 수정
    const res = await addRefridge({
      category: {
        categoryId: select,
      },
      unit: {
        unitId: 2,
      },
      expirationDate,
      itemName,
      purchaseDate,
      quantity,
    });

    console.log(res);
  };

  useEffect(() => {
    console.log(select);
  }, [select]);

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
          calcDate={categories[+select]?.expiration || 0}
        />
      )}
      <button onClick={onCreate}>추가</button>
    </>
  );
}
