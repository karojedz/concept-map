
export interface TagType {
    id: number;
    name: string;
}

const Tag = ( tag: TagType ): JSX.Element => {

    return (
        <p>{tag.name}</p>
    )
}

export default Tag;