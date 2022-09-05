import {Link} from "react-router-dom";
import {ConceptType} from "./Concept";

const ConceptShort = ( concept: ConceptType ): JSX.Element => {
    const { id, title, text } = concept;

    return (
        <div className='container'>
            <h4><Link to={`/concepts/${id}`}>{title.slice(0, 50)}</Link></h4>
            <p>{text.slice(0, 100)}</p>
            <br /><br />
        </div>
    )
}

export default ConceptShort;