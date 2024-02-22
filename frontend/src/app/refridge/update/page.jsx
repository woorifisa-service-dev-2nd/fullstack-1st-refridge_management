"use client";

import { findAllItems, useRefridge } from "@/api/refridge";
import InputCustom from "@/components/InputCustom";

import InputSelect from "@/components/InputSelect";
import UserCard from "@/components/UserCard";
import React, { useEffect, useRef, useState } from "react";


export default function page() {
  const [items, setItems] = useState([]);
  const [select, setSelect] = useState(0);
  const [quantity, setQuantity] = useState(0);
  const inputRef = useRef();
  useEffect(() => {

    // inputRef.current.focus();
    findAllItems().then((res) => setItems(res));

  }, []);

  const onUpdate = () => {
    useRefridge({
      id : items[+select].itemId,
      quantity
    })
    console.log(items[+select].itemId, quantity);
  };
  return (
    <>
      <div className="flex flex-col gap-2 justify-center max-w-[668px] mx-auto">
        <div>사용량 업데이트 페이지</div>

        <InputSelect
          items={items}
          setSelect={setSelect}
          title={"제품 종류를 선택 하세요"}
          selectValue={"itemName"}
        />

        {items.length > 0 && <UserCard {...items[+select]} key={+select} />}

        {/* <h1> 사용할 양을 아래에 입력하세요.</h1> */}
        {/* <input
          className="border border-blue-600"
          type="text"
          ref={inputRef}
        /> */}
        <InputCustom  setInputData={setQuantity} title={"사용할 양을 적으세요"}/>

        <button onClick={onUpdate}>수정</button>
      </div>
    </>
  );
}
