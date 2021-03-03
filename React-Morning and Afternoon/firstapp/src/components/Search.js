import React from "react";

function Search(props) {
    const {search}=props;
  return (
        <div className="search-container">
            <input type="text" placeholder="Search Here for a book" onChange={(event)=>{
                search(event.target.value);
            }} />
        </div>
    );
}

export default Search;