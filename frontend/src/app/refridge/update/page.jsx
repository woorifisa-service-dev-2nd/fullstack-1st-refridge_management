"use client";
import { getAllItems } from "@/api/refridge";
import InputSelect from "@/components/InputSelect";
import UserCard from "@/components/UserCard";
import React, { useEffect, useState } from "react";

export default function page() {
  const [items, setItems] = useState([]);
  const [select, setSelect] = useState(0);
  useEffect(() => {
    getAllItems().then((res) => setItems(res));
  }, []);

  const onUpdate = () => {
    console.log(items[+select]);
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
        <button onClick={onUpdate}>수정</button>
      </div>
    </>
  );
}
