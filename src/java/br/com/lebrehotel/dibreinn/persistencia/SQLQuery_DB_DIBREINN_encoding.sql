select data_type, character_set_catalog, character_set_schema, character_set_name, collation_catalog, collation_schema, collation_name, count(*) count
from information_schema.columns
group by data_type, character_set_catalog, character_set_schema, character_set_name, collation_catalog, collation_schema, collation_name;