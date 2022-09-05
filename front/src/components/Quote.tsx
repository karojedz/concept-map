import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {TagType} from "./Tag";

export interface QuoteType {
    id: number;
    title: string;
    text: string;
    author: string;
    whereFrom: string;
    tags: Array<TagType>;
}

const Quote = (): JSX.Element => {
    const { id } = useParams();
    const [quote, setQuote] = useState<QuoteType>({id: 0, title: '', text: '', whereFrom: '', author: '', tags: []});

    useEffect(() => {
        if (id) {
            fetchQuote(parseInt(id)).catch(reportError);
        } else {
            getRandomQuote().catch(reportError);
        }
    }, [id]);

    const fetchQuote = async (id: number) => {
        const res = await fetch(`http://localhost:8080/quotes/${id}`);
        const fetchedQuote = await res.json();
        setQuote(fetchedQuote);
    }

    const getRandomQuote = async () => {
        const res = await fetch('http://localhost:8080/quotes/random');
        const randomQuote = await res.json();
        setQuote(randomQuote);
    }

    return (
        <div className='container'>
            <h2>Quote</h2>
            <h4>{quote.title}</h4>
            <p>{quote.text}</p>
            <p className='p-centered'>{quote.author}</p>
            <p className='p-centered'><i>{quote.whereFrom}</i></p>
        </div>
    )
}

export default Quote;