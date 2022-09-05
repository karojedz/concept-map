import Tag, { TagType } from "./Tag";

const TagList = ( {tags}: {tags: TagType[]}): JSX.Element => {

    return (
        <>
            <h2>Tags</h2>
            {tags.map(tag => {return <Tag key={tag.id} {...tag}/>})}
        </>
    )
}

export default TagList;