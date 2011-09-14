USE qin;

SELECT 	d.puntaje, 
	COUNT(*) 
FROM 	dictamen d
		INNER JOIN qin.resolucion r ON (r.id = d.resolucion_id)
		INNER JOIN qin.trabajo_practico tp ON (tp.id = r.trabajo_practico_id)
WHERE 	tp.materia_id = 1 
GROUP BY d.puntaje 
ORDER BY d.puntaje ASC;

SELECT * FROM qin.materia;
SELECT * FROM qin.dictamen;
SELECT * FROM qin.resolucion;
SELECT * FROM qin.trabajo_practico;

INSERT INTO qin.trabajo_practico (id, titulo, materia_id) VALUES (3, 'TP 3', '1');
INSERT INTO qin.trabajo_practico (id, titulo, materia_id) VALUES (4, 'TP 4', '1');
INSERT INTO qin.trabajo_practico (id, titulo, materia_id) VALUES (5, 'TP 5', '1');
INSERT INTO qin.trabajo_practico (id, titulo, materia_id) VALUES (6, 'TP 6', '1');
        
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (1, 1);
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (2, 2);
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (3, 3);
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (4, 4);
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (5, 5);
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (6, 6);

INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 2, 1);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 2, 2);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 2, 3);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 3, 4);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 10, 5);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 9.65, 6);

INSERT INTO qin.trabajo_practico (id, titulo, materia_id) VALUES (7, 'TP 7', '1');
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (7, 7);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 3, 7);

INSERT INTO qin.trabajo_practico (id, titulo, materia_id) VALUES (8, 'TP 8', '1');
INSERT INTO qin.resolucion (id, trabajo_practico_id) VALUES (8, 8);
INSERT INTO qin.dictamen (id, dictamen, puntaje, resolucion_id) VALUES (NULL, 'Todo Ok', 10, 8);