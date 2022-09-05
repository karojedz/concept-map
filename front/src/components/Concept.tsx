import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { TagType } from "./Tag";
import {reportError} from "../errors/report";

export interface ConceptType {
    id: number;
    title: string;
    text: string;
    previous: Array<number>;
    tags: Array<TagType>;
}

const Concept = (): JSX.Element => {
    const { id } = useParams();
    const [concept, setConcept] = useState<ConceptType>({ id: 0, title: "", text: "", previous: [], tags: [] });

    useEffect(() => {
        if (id) {
            fetchConcept(parseInt(id)).catch(reportError);
        } else {
            getRandomConcept().catch(reportError);
        }
    }, [id]);

    const fetchConcept = async (id: number) => {
        const res = await fetch(`http://localhost:8080/concepts/${id}`);
        const fetchedConcept = await res.json();
        setConcept(fetchedConcept);
    }

    const getRandomConcept = async () => {
        const res = await fetch('http://localhost:8080/concepts/random');
        const randomConcept = await res.json();
        setConcept(randomConcept);
    }

    return (
        <div className='container'>
            <h2>Concept</h2>
            <h4>{concept.title}</h4>
            <p>{concept.text}</p>
        </div>
    )
}

export default Concept;