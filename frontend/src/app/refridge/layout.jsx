import Link from "next/link";
import React from "react";

export default function layout({ children }) {
  return (
    <>
      <nav className="border-b-2 pb-2">
        <Link href="/refridge/add"> 재료 추가</Link> |
        <Link href="/refridge/update"> 재료 사용</Link> |
        <Link href="/refridge/expiration/name"> 조회 ( 아이템 이름 )</Link> |
        <Link href="/refridge/expiration/category"> 조회 ( 카테고리별 )</Link> |
        <Link href="/refridge/delete"> 삭제</Link> |
      </nav>
      <br />
      <div>refridge layout</div>
      <br />
      <div>{children}</div>
    </>
  );
}
