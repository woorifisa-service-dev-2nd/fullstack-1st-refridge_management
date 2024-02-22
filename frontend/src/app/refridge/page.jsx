"use client";

import InputSelect from "@/components/InputSelect";
import React, { useState } from "react";

export default function page({ children }) {
  const [purchaseDate, setPurchaseDate] = useState();
  const categories = [
    {
      name: "유제퓸",
      expiration: 0,
    },
    {
      name: "고기류",
      expiration: 7,
    },
    {
      name: "채소류",
      expiration: 3,
    },
    {
      name: "과자류",
      expiration: 0,
    },
    {
      name: "음료",
      expiration: 0,
    },
  ];

  return <></>;
}
