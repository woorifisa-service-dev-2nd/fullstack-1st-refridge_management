"use client";
import { deleteRefridge, getAllItems } from "@/api/refridge";
import InputCustom from "@/components/InputCustom";
import InputSelect from "@/components/InputSelect";
import UserCard from "@/components/UserCard";
import React, { useEffect, useState } from "react";

export default function page() {
  const [items, setItems] = useState([]);
  const [select, setSelect] = useState(0);
  useEffect(() => {
    getAllItems().then((res) => setItems(res));
  }, []);

  const onDelete = async () => {
    if (confirm(items[+select].itemName + " 을(를) 정말 삭제하시 겠습니까?")) {
      const id = items[+select].itemId;
      const res = await deleteRefridge({ id });

      setItems((pv) => pv.filter((v) => v.itemId !== id));

      alert(JSON.parse(res) ? "삭제되었습니다." : "없는 아이디 입니다.");
    }
  };

  return (
    <>
      <br />
      <InputSelect
        items={items}
        setSelect={setSelect}
        title={"삭제할 제품을 고르세요"}
        selectValue={"itemName"}
      />

      {items.length > 0 && <UserCard {...items[+select]} key={+select} />}

      {/* <InputCustom title={"삭제할 아이디를 적어주세요"} setInputData={setId} /> */}
      <button onClick={onDelete}>삭제</button>
    </>
  );
}
