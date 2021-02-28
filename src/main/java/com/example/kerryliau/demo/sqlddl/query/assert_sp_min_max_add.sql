DO $$
DECLARE
	int_a INTEGER = 10;
	int_b INTEGER = 5;
	int_result INTEGER = 0;
BEGIN
	CALL grand_sages_demo.sp_min(int_a, int_b, int_result);
	RAISE NOTICE 'result should be 5, assert: %', int_result = 5;
END $$;

DO $$
DECLARE
	int_a INTEGER = 10;
	int_b INTEGER = 5;
	int_result INTEGER = 0;
BEGIN
	CALL grand_sages_demo.sp_max(int_a, int_b, int_result);
	RAISE NOTICE 'result should be 10, assert: %', int_result = 10;
END $$;

DO $$
DECLARE
	int_a INTEGER = 10;
	int_b INTEGER = 5;
	int_result INTEGER = 0;
BEGIN
	CALL grand_sages_demo.sp_add(int_a, int_b, int_result);
	RAISE NOTICE 'result should be 15, assert: %', int_result = 15;
END $$;








