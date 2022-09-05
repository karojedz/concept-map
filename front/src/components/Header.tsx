import { Link } from 'react-router-dom'

const Header = () => {
    return (
        <div>
            <Link to="/" className='link'>Start with random</Link>
            <Link to="/concepts/random" className='link'>Concept</Link>
            <Link to="/quotes/random" className='link'>Quote</Link>
            <Link to="/tags" className='link'>Tags</Link>
        </div>
    )
}

export default Header;