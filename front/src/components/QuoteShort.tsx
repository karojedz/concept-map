import {Link} from "react-router-dom";
import {QuoteType} from "./Quote";

const QuoteShort = (quote: QuoteType): JSX.Element => {
    const { id, title, text, author } = quote;

    return (
        <div className='container'>
            <h4><Link to={`/quotes/${id}`}>{title}</Link></h4>
            <p>{text.slice(0, 100)}</p>
            <i>{author}</i>
            <br /><br />
        </div>
    )
}

export default QuoteShort;