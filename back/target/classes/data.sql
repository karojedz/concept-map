INSERT INTO concept (id, text, title)
VALUES (1, 'Basil is a culinary herb.', 'plant'),
       (2, 'Cats are cute and purrfect', 'cats'),
       (3, 'Whatever, shit happens', 'sth'),
       (4, 'You need to exercise or everything will hurt', 'needs');

INSERT INTO concept_previous (concept_id, previous_id)
VALUES (4, 3), (3, 1);

INSERT INTO tag (id, name)
VALUES (1, 'plants'),
       (2, 'animals'),
       (3, 'uncategorized'),
       (4, 'exercise'),
       (5, 'yoga'),
       (6, 'negotiation'),
       (7, 'programming');

INSERT INTO concept_tags (concept_id, tags_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (4, 5);

INSERT INTO quote (id, text, title, author, where_from)
VALUES (1, 'Ultimately your own definition of yourself as an individual being was the only thing which really mattered in the end.',
        'Self', 'samvelg', 'The historical importance of runic war warding in the British Isles'),
    (2, 'I used to think you were smart.', 'Disappointment', 'Lomonaaeren', 'His darkest devotion'),
    (3, 'It isn''t enough for your negotiating counterpart to say yes. He has to say HOW he''s going to carry out his agreement.',
     'negotiation', 'Christopher Voss', 'Never split the difference'),
    (4, 'If debugging is the process of removing software bugs, then programming must be the process of putting them in.',
     'Bugs in code', 'Edsger Dijkstra', ''),
    (5, 'Unikaj dokonywania wyborów. Zmień fakty.', 'Adecyzyjność', 'kpt. Jack Sparrow', 'Pirates of the Caribbean');

INSERT INTO quote_tags (quote_id, tags_id)
VALUES (1, 3), (3, 6), (4, 7);
