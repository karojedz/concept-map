import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import Header from './components/Header';
import Quote, {QuoteType} from "./components/Quote";
import Concept, {ConceptType} from "./components/Concept";
import TagList from "./components/TagList";
import {TagType} from "./components/Tag";
import {reportError} from "./errors/report";
import Random from "./components/Random";

function App(): JSX.Element {
    const [concepts, setConcepts] = useState<Array<ConceptType>>([{id: 0, title: '', text: '', tags: [], previous: []}]);
    const [quotes, setQuotes] = useState<Array<QuoteType>>([{id: 0, title: '', text: '', author: '', tags: [], whereFrom: ''}]);
    const [tags, setTags] = useState<Array<TagType>>([{id: 0, name: ''}]);

    useEffect(() => {
        const fetchData = async () => {
            await fetchAndSetConcepts().catch(reportError);
            await fetchAndSetQuotes().catch(reportError);
            await fetchAndSetTags().catch(reportError);
        };

        fetchData().catch();
        // eslint-disable-next-line
    }, []);

    const fetchAndSetConcepts = async () => {
        const res = await fetch('http://localhost:8080/concepts');
        const fetchedConcepts = await res.json();
        setConcepts(fetchedConcepts);
    }

    const fetchAndSetQuotes = async () => {
        const res = await fetch('http://localhost:8080/quotes');
        const fetchedQuotes = await res.json();
        setQuotes(fetchedQuotes);
    }

    const fetchAndSetTags = async () => {
        const res = await fetch('http://localhost:8080/tags');
        const fetchedTags = await res.json();
        setTags(fetchedTags);
    }

    return (
        <BrowserRouter>
            <Header />
            <Routes>
                <Route path="/"
                       element={<>
                           <Random concepts={concepts} quotes={quotes} tags={tags}  />
                       </>}
                />
                <Route path="/tags"
                       element={<>
                           <TagList tags={tags}/>
                           <Link to="/">Return Home</Link>
                       </>}
                />
                <Route path='/concepts/random'
                       element={<>
                           <Concept />
                       </>}
                />
                <Route path='/quotes/random'
                       element={<>
                           <Quote />
                       </>}
                />
                <Route path='/concepts/:id'
                       element={<>
                           <Concept />
                           <Link to="/">Return Home</Link>
                       </>}
                />
                <Route path='/quotes/:id'
                       element={<>
                           <Quote />
                           <Link to="/">Return Home</Link>
                       </>}
                />
            </Routes>
        </BrowserRouter>
    )
}

export default App;