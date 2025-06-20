import React, {useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";

const ProductDetails = ({ products }) => {
    const { id } = useParams();
    const filteredProducts = products.filter(product => product.id === parseInt(id));
    
    if (filteredProducts.length === 0) {
        return null;
    }
    const product = filteredProducts[0];

    return (
        <div>
            <h1>{product.title}</h1>
            <p>Category: {product.category}</p>
            <p>Brand: {product.brand}</p>
            <p>Description: {product.description}</p>
            <p>Price: ${product.price}</p>
            <img src={product.thumbnail} alt={product.title} width="200" />
            <br/>
            <Link to="/">Return to product list</Link>
        </div>
    );
};

export default ProductDetails;