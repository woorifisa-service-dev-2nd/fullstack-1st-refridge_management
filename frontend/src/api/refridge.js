// 장 본 아이템 추가(수동 입력)
export const addRefridge = ({
  category,
  unit,
  itemName,
  quantity,
  expirationDate,
  purchaseDate,
}) => {
  return fetch(`/api`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      category,
      unit,
      itemName,
      quantity,
      expirationDate,
      purchaseDate,
    }),
  }).then((res) => res.json());
};

// 유통기한 임박한 재료 알려주기(1일 이내로 남은 음식 자동 알림)
export const getExpirationDdayOne = () => {};

// 카테고리 별 유통기한 남은 재료 유통기한 짧은 순으로 조회
export const getExpirationByCategory = (category) => {
  return fetch(`/api?category=${category}`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
    },
  }).then((res) => res.json());
};

// + 재료 이름 검색해서 유통기한 짧은 순으로 조회
export const getPurchaseSortingShortExpiration = ({ itemName }) => {
  return fetch(`/api?item=${itemName}`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
    },
  }).then((res) => res.json());
};

// 재료 사용량 입력하면 남은 수량 수정 후 (자동)조회
export const useRefridge = ({ id, quantity }) => {
  return fetch(`/api/${id}`, { 
    method: "PATCH",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      "usedQuantity" : quantity
    }),
  }).then((res) => res.json());
};


// 재료 삭제
export const deleteRefridge = ({ id }) => {
  return fetch(`/api/${id}`, {
    method: "delete",
  }).then((res) => res.text());
};

export const findAllItems = () => {
  return fetch("/api/items", {
    method: "GET",
  }).then((res) => res.json());
};

export const getCategories = () => {
  return fetch("/api/categories", {
    method: "GET",
  }).then((res) => res.json());
}