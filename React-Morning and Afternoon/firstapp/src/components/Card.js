import React from "react";
import { Link } from "react-router-dom";
import { FaRupeeSign } from 'react-icons/fa';
import { AiFillStar } from "react-icons/ai";

function Card(props) {
  const { book } = props;
  return (
    <div className="card">
      <img src={book.img} alt={book.name} />
      <p style={{color:"white",align:"center",fontSize:"30px"}}>{book.name}</p>
      <p className="card-author" style={{color:"white",align:"center"}}>{book.author}</p>
      <div className="card-footer">
      <span><AiFillStar size={20} color={"green"}/>{book.rating}</span><span><FaRupeeSign size={20} />{book.price}</span>
      </div>
      <div className="card-btn">
        <Link to={`/book/${book.id}`} className="details-btn" style={{color:"white",align:"center"}}>
          Click Here to Know More
        </Link>
      </div>
      <div className="card-btn">
        <a href={book.buylink} className="buy-btn" style={{color:"white",align:"center"}}>Buy from Here</a>

      </div>
      
    </div>
  );
}

export default Card;