CREATE OR REPLACE FUNCTION get_route_by_id(route_id int)
    RETURNS TABLE
            (
                id                   int,
                departure_station_id int,
                arrival_station_id   int
            )
    LANGUAGE sql
AS
$$
SELECT id, departure_station_id, arrival_station_id
FROM route
WHERE id = route_id;
$$;