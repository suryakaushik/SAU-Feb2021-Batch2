import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import books from "../Data.js";

function Book(props) {
  let { id } = useParams();
  id = parseInt(id);
  const [book, setBook] = useState(null);
  const getDetails = () => {
    const t = books.filter((book) => {
      return book.id === id;
    });
    setBook(t[0]);
  };

  useEffect(() => {
    getDetails();
  }, []);
  return (
    book != null && (
      <div>
        
        <div className="btn-container">
            <Link to={`/`} className="navigate-btn" style={{color: "white",fontSize:"30px"}}>
            Home
            </Link>
        </div>
        <div className="bookHeading" style={{color:"white",align:"center"}}>
          <div className="nameandauth">
            <h5 style={{color: "white",fontSize:"50px"}}>{book.name}</h5>
            <p style={{color: "white",fontSize:"50px"}}>{book.author}</p>
          </div>
          <div className="bookrating">
            <p style={{color: "white",fontSize:"50px"}}>Rating</p>
            <p style={{color: "white",fontSize:"50px"}}>{book.rating}</p>
          </div>
        </div>
        
        <div className="img-container">
          <img className="book-img" src={book.img} alt={book.name} style={{width:"500px",height:"500px"}}/>
          <span style={{color: "white",fontSize:"50px"}}>{book.desc}</span>
        </div>

        <div className="book-footer">
          <div>
            <p style={{color: "white",fontSize:"30px"}}>Price</p>
            <p style={{color: "white",fontSize:"30px"}}>{book.price}</p>
          </div>
          <div>
            <p style={{color: "white",fontSize:"30px"}}>Page count</p>
            <p style={{color: "white",fontSize:"30px"}}>{book.pages_count}</p>
          </div>
          <div>
            <p style={{color: "white",fontSize:"30px"}}>Languages</p>
            <p style={{color: "white",fontSize:"28px"}}>
              {book.languages.map((lan, index) => {
                if (index === book.languages.length - 1) return `${lan}`;
                else return `${lan}, `;
              })}
            </p>
          </div>
        </div>
      </div>
    )
  );
}

export default Book;