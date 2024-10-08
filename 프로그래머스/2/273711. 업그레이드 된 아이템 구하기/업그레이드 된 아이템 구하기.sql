SELECT DISTINCT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT DISTINCT IT.ITEM_ID
FROM ITEM_TREE AS IT
JOIN (
    SELECT ITEM_ID, ITEM_NAME, RARITY
    FROM ITEM_INFO
    WHERE RARITY = 'RARE'
) AS RI
ON IT.PARENT_ITEM_ID = RI.ITEM_ID
)
ORDER BY ITEM_ID DESC
