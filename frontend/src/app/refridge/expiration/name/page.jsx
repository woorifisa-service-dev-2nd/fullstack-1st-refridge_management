"use client";
import React, { useEffect, useState } from "react";
import { getPurchaseSortingShortExpiration } from "@/api/refridge";
import UserCard from "@/components/UserCard";
import InputCustom from "@/components/InputCustom";
import ItemList from "@/components/ItemList";

export default function page({}) {
  const [itemName, setName] = useState("");
  const [items, setItems] = useState([]);

  const onClick = () => {
    getPurchaseSortingShortExpiration({itemName})
    .then(data => {
      console.log(data);
      setItems(data);
      
    })
    .catch(error => {
      console.error('데이터를 정상적으로 받아오지 못했습니다');
    });
  };

  return (
    <>
      {/* <h2>이름 별 검색</h2> */}
      <InputCustom title={"제품명"} setInputData={setName} />

      <span className="inline-flex -space-x-px overflow-hidden rounded-md border bg-white shadow-sm">
  <button
    className="inline-block px-4 py-2 text-sm font-medium text-gray-700 hover:bg-gray-50 focus:relative"
    onClick={onClick}>검색
  </button>

</span>

      <div className="overflow-x-auto">
  <table className="min-w-full divide-y-2 divide-gray-200 bg-white text-sm">
    <thead className="ltr:text-left rtl:text-right">
      <tr>
        <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">제품명</th>
        <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">카테고리</th>
        <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">재고</th>
        <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">구매날짜</th>
        <th className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">유통기한</th>
      </tr>
    </thead>
    {items && 
      items.slice()
          .sort((a, b) => new Date(a.expirationDate) - new Date(b.expirationDate))
          .map((item, i) => (
        <ItemList 
          {...item} 
          key={i}
         />
         ))}

    </table>
    </div>

    
      {/* {items && 
      items.slice()
          .sort((a, b) => new Date(a.expirationDate) - new Date(b.expirationDate))
          .map((item, i) => (
        <ItemList 
          {...item} 
          key={i}
          isFirstItem={i === 0? true : false}
         />
        // <UserCard {...item} key={i} />
      ))} */}

      {/* {items.map((item, i) => (
      <UserCard
        itemName={item.itemName}
        quantity={item.quantity}
        unit={item.unit}
        category={item.category}
        expirationDate={item.expirationDate}
        purchaseDate={item.purchaseDate}
        key={i}
      />
    ))} */}
    </>
  );
}
