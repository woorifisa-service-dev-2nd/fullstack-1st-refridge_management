"use client";
import React, { useEffect, useState } from "react";
import { getCategories, getExpirationByCategory } from "@/api/refridge";
import InputCustom from "@/components/InputCustom";
import InputSelect from "@/components/InputSelect";
import InputDate from "@/components/InputDate";
import UserCard from "@/components/UserCard";

export default function page() {
  const [itemName, setName] = useState();
  const [quantity, setQuantity] = useState();
  const [expirationDate, setExpirationDate] = useState();
  const [purchaseDate, setPurchaseDate] = useState();
  const [select, setSelect] = useState("");
  const [selected, setSelected] = useState([]);
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    getCategories().then(res => setCategories(res));
  }, []);

  const onCreate = async () => {
    console.log({
      itemName,
      unitId: 2,
      quantity,
      expirationDate,
      purchaseDate,
      select,
    });

    const res = await getExpirationByCategory(categories[+select].category);
    setSelected(res);
    console.log(res);
  };

  useEffect(() => {
    console.log(select);
  }, [select]);

  return (
    <>
      <br></br>
      <InputSelect
        items={categories}
        setSelect={setSelect}
        title={"제품 종류를 선택 하세요"}
        selectValue={"category"}
      />
      <button onClick={onCreate}>검색</button>
      <div>
        
          {selected.map((data, i) => <UserCard key={i} {...data}/>)}
        
      </div>
    </>
  );
}
