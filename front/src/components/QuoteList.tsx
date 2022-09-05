import QuoteShort from "./QuoteShort";
import { QuoteType } from "./Quote";

const QuoteList = ( {quotes}: {quotes: QuoteType[]} ): JSX.Element => {

    return (
        <>
            <h2>Quotes</h2>
            {quotes.map(quote => {return <QuoteShort key={quote.id} {...quote}/>})}
        </>
    )
}

export default QuoteList;