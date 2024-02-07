"use client";
import React from "react";

export default function ItemList({
  itemName,
  quantity,
  unit,
  category,
  expirationDate,
  purchaseDate,
}) {
  return (


    <tbody className="divide-y divide-gray-200 text-center">
      <tr>
        <td className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">{itemName}</td>
        <td className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">{category}</td>
        <td className="whitespace-nowrap px-4 py-2 font-medium text-gray-900">{quantity}{unit}</td>
        <td className="whitespace-nowrap px-4 py-2 text-gray-700">{purchaseDate}</td>
        <td className="whitespace-nowrap px-4 py-2 text-gray-700">{expirationDate}</td>
      </tr>

    </tbody>
  );
}