-- 코드를 입력하세요
SELECT animal_Type, count(animal_type) as count from animal_ins group by animal_type order by animal_type asc;