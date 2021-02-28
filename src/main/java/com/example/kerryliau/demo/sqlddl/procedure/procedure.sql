CREATE OR REPLACE PROCEDURE grand_sages_demo.sp_add(
 	int_a INTEGER,
 	int_b INTEGER,
 	INOUT int_result INTEGER
)
LANGUAGE 'plpgsql'
AS $$
BEGIN
 	int_result = int_a + int_b;
END $$;
COMMENT ON PROCEDURE grand_sages_demo.sp_add(INTEGER, INTEGER, INTEGER) 
IS '取兩數的合';

CREATE OR REPLACE PROCEDURE grand_sages_demo.sp_max(
	int_a INTEGER, int_b INTEGER, INOUT int_result INTEGER
)
LANGUAGE 'plpgsql'
AS $$
BEGIN
	IF int_a > int_b THEN
		int_result = int_a;
	ELSE
		int_result = int_b;
	END IF;
END $$;
COMMENT ON PROCEDURE grand_sages_demo.sp_max(INTEGER, INTEGER, INTEGER)
IS '兩數中取較大的數';

CREATE OR REPLACE PROCEDURE grand_sages_demo.sp_min(
	int_a INTEGER, int_b INTEGER, INOUT int_result INTEGER
) 
LANGUAGE 'plpgsql'
AS $$
BEGIN
	IF int_a < int_b THEN
		int_result = int_a;
	ELSE
		int_result = int_b;
	END IF;
END
$$;
COMMENT ON PROCEDURE grand_sages_demo.sp_min(INTEGER, INTEGER, INTEGER) 
IS '兩數中取較小的數';



