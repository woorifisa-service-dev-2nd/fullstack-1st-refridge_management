"use client";
import { deleteRefridge } from "@/api/refridge";
import InputCustom from "@/components/InputCustom";
import React, { useState } from "react";

export default function page() {
  const [id, setId] = useState();

  const onDelete = async () => {
    const res = await deleteRefridge({ id });

    alert(JSON.parse(res) ? "삭제되었습니다." : "없는 아이디 입니다.");
  };

  return (
    <>
      <InputCustom title={"삭제할 아이디를 적어주세요"} setInputData={setId} />
      <button onClick={onDelete}>삭제</button>
    </>
  );
}
