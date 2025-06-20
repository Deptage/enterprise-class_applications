import React, { useEffect, useState } from 'react';
import ProductItem from './ProductItem';

const ProductList = ({}) =>{
    const [products, setProducts] =useState([]);
        useEffect(() => {
        setProducts([
            {id: 1, title: "iPhone 14", brand: "Apple"},
            {id: 2, title: "iPad Air", brand: "Apple"},
            {id: 3, title: "Galaxy A51", brand: "Samsung"}
        ]);
    }, []);

    return (
        <div>
            <h1>List of Products</h1>
            <ul>
                {products.map(product => (
                    <ProductItem
                        key={product.id}
                        id={product.id}
                        title={product.title}
                        brand={product.brand}
                    />
                ))}
            </ul>
        </div>
    );
}

export default ProductList;