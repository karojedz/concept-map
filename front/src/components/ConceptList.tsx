import { ConceptType } from "./Concept";
import ConceptShort from "./ConceptShort";

const ConceptList = ( {concepts}: {concepts: Array<ConceptType>} ): JSX.Element => {

    return (
        <>
            <h2>Concepts</h2>
            {concepts.map(concept => {return <ConceptShort key={concept.id} {...concept} />})}
        </>
    )
}

export default ConceptList;