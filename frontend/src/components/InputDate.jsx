import React, { useEffect, useState } from "react";

export default function InputDate({
  calcDate,
  setDate,
  label,
  dateTime,
  disabled,
}) {
  const date = new Date(dateTime || Date.now());
  date.setDate(date.getDate() + (calcDate || 0));

  const [nowDate, _] = useState(date.toISOString().split("T")[0]);

  useEffect(() => {
    setDate(nowDate);
  }, []);

  return (
    <>
      <div className="flex flex-col gap-2 m-2 items-start text-md">
        <label className="" htmlFor="">
          {label}
        </label>
        <input
          type="date"
          defaultValue={nowDate}
          onChange={(e) => setDate && setDate(e.target.value)}
          className="mb-4"
          disabled={disabled || false}
        />
      </div>
    </>
  );
}
