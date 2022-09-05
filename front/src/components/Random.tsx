import ConceptList from "./ConceptList";
import QuoteList from "./QuoteList";
import TagList from "./TagList";
import {ConceptType} from "./Concept";
import {QuoteType} from "./Quote";
import {TagType} from "./Tag";


export interface ConceptQuoteTagListType {
    concepts: Array<ConceptType>;
    quotes: Array<QuoteType>;
    tags: Array<TagType>;
}

const Random = ( { concepts, quotes, tags }: ConceptQuoteTagListType ): JSX.Element => {

    return (
        <>
            <ConceptList concepts={concepts}/>
            <QuoteList quotes={quotes}/>
            <TagList tags={tags}/>
        </>
    )
}

export default Random;